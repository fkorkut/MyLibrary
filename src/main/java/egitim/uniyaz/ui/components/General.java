package egitim.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.ui.views.KullaniciGirisView;
import egitim.uniyaz.ui.views.KullaniciKontrol;

public class General extends VerticalLayout {
    boolean isAdmin;


    public General(Kullanici kullanici) {
        Header header = new Header();
        addComponent(header);
        KullaniciKontrol kullaniciKontrol = new KullaniciKontrol(kullanici);
       // isAdmin=kullaniciKontrol.stateKontrol(kullanici);
        if(kullaniciKontrol.isAdmin()) {
            AdminForm adminForm = new AdminForm(header);
            addComponent(adminForm);
        }
        else{
            UyeForm uyeForm = new UyeForm(header);
            addComponent(uyeForm);
        }
    }
}
