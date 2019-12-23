package egitim.uniyaz.ui.views;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.ui.*;
import egitim.uniyaz.MyUI;
import egitim.uniyaz.dao.KullaniciDao;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.ui.components.General;

import javax.xml.ws.BindingType;

public class KullaniciGirisView extends VerticalLayout {


    private TextField adTextField;
    private PasswordField  parolaTextField;
    private  Button girisButon;
    public static Kullanici kullanici;
    FormLayout formLayout=new FormLayout();

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

    private void fillLayout()  {

        formLayout.setMargin(true);
        formLayout.addStyleName("outlined");
        formLayout.setSizeFull();


        adTextField = new TextField();
        adTextField.setCaption("Ad");
        adTextField.setWidth(100.0f,Unit.PERCENTAGE);
        formLayout.addComponent(adTextField);

        parolaTextField = new PasswordField();
        parolaTextField.setWidth(100.0f,Unit.PERCENTAGE);
        parolaTextField.setCaption("Şifre");
        formLayout.addComponent(parolaTextField);

        girisButon = new Button();
        girisButon.setCaption("Giriş");
        girisButon.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                kullanici = girisKullanici();

                if (kullanici == null){
                    Notification.show("Kullanıcı Kayıtlı değil !!");

                }else{
                    General general = new General(kullanici);
                    MyUI.getCurrent().setContent(general);
                }
            }

        });
        formLayout.addComponent(girisButon);

        addComponent(formLayout);


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


}
