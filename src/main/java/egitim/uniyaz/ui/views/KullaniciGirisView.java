package egitim.uniyaz.ui.views;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import egitim.uniyaz.dao.KullaniciDao;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.domain.KullaniciState;

import java.util.ArrayList;
import java.util.List;

public class KullaniciGirisView extends VerticalLayout {

    private TextField emailTextField;
    private TextField parolaTextField;
    private  Button girisButon;
    Kullanici kullanici;
    public KullaniciGirisView() {
        fillLayout();
    }

    private void fillLayout() {
        emailTextField = new TextField();
        emailTextField.setDescription("emailTextField");
        emailTextField.setCaption("Ad");
        emailTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        addComponent(emailTextField);

        parolaTextField = new TextField();
        parolaTextField.setDescription("sifre");
        parolaTextField.setCaption("sifre");
        parolaTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        addComponent(parolaTextField);

        girisButon=new Button();
        girisButon.setCaption("Normal");
        girisButon.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                kullanici=girisKullanici();
                kullaniciKontrol(kullanici);
            }

        });
        addComponent(girisButon);


    }

    public boolean kullaniciKontrol(Kullanici kontKullanici) {
        if (kontKullanici.getKullaniciState()== KullaniciState.ADMIN){
            return true;
        }
        else
            return false;

    }

    private Kullanici girisKullanici() {
        String email=emailTextField.getValue();
        String parola=parolaTextField.getValue();

        Kullanici kullanici=new Kullanici();
        kullanici.setName(email);
        kullanici.setKullaniciParola(parola);
        try{
            KullaniciDao kullaniciDao=new KullaniciDao();
            kullanici=kullaniciDao.findKullanici(kullanici);
            return kullanici;
        }catch (Exception e){
            return null;
        }
    }



}
