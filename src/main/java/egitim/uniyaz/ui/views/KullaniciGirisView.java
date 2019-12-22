package egitim.uniyaz.ui.views;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import egitim.uniyaz.MyUI;
import egitim.uniyaz.dao.KullaniciDao;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.domain.KullaniciState;
import egitim.uniyaz.ui.components.General;

public class KullaniciGirisView extends VerticalLayout {

    private TextField adTextField;
    private TextField parolaTextField;
    private  Button girisButon;
    static Kullanici kullanici;

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    private boolean isAdmin = false;

    public KullaniciGirisView() {
        fillLayout();
    }

    private void fillLayout() {
        adTextField = new TextField();
        adTextField.setDescription("adTextField");
        adTextField.setCaption("Ad");
        adTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        addComponent(adTextField);

        parolaTextField = new TextField();
        parolaTextField.setDescription("sifre");
        parolaTextField.setCaption("sifre");
        parolaTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        addComponent(parolaTextField);

        girisButon=new Button();
        girisButon.setCaption("Giriş");
        girisButon.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
//                KullaniciKontrol kullaniciKontrol=new KullaniciKontrol();
//                kullaniciKontrol.stateKontrol(kullanici);
                kullanici=girisKullanici();
                if (kullanici == null){
                    Notification.show("Kullanıcı Kayıtlı değil !!");
                }else{
                    //stateKontrol();
                    General general = new General(kullanici);
                    MyUI.getCurrent().setContent(general);
                }
            }

        });
        addComponent(girisButon);


    }
    private Kullanici girisKullanici() {
        String email=adTextField.getValue();
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

//    public void stateKontrol() {
//        if (KullaniciState.ADMIN.equals(kullanici.getKullaniciState())){
//           isAdmin = true;
//        }
//        else
//            isAdmin = false;
//    }
//
//    public boolean isAdmin() {
//        return isAdmin;
//    }
}
