package egitim.uniyaz.ui.views;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import egitim.uniyaz.MyUI;
import egitim.uniyaz.dao.KullaniciDao;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.ui.components.General;


public class KullaniciGirisView extends VerticalLayout {

    @PropertyId("name")
    private TextField adTextField;

    @PropertyId("kullaniciParola")
    private PasswordField  parolaTextField;

    private Button girisButon;
    private FormLayout formLayout;

    private FieldGroup binder;
    private BeanItem<Kullanici> item;
    public static Kullanici kullanici;

    public KullaniciGirisView() {
        fillLayout();
        fillViewKullanici(new Kullanici());
    }

    private void fillViewKullanici(Kullanici kullanici) {
        item = new BeanItem<Kullanici>(kullanici);
        binder = new FieldGroup(item);
        binder.bindMemberFields(this);
    }

    private void fillLayout()  {
        formLayout = new FormLayout();
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

        try {

            binder.commit();
            Kullanici kullanici = item.getBean();

            KullaniciDao kullaniciDao=new KullaniciDao();
            kullanici = kullaniciDao.findKullanici(kullanici);
            return kullanici;

        } catch (FieldGroup.CommitException e) {
            System.out.println(e.getMessage());
            return  null;
        }
    }
}
