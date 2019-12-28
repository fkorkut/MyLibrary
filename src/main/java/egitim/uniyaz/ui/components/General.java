package egitim.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.domain.KullaniciState;

public class General extends VerticalLayout {

    public General(Kullanici kullanici) {

        Header header = new Header();
        addComponent(header);

        if(KullaniciState.ADMIN == kullanici.getKullaniciState()) {
            AdminForm adminForm = new AdminForm();
            addComponent(adminForm);
        }
        else if(KullaniciState.UYE == kullanici.getKullaniciState()){
            UyeForm uyeForm = new UyeForm();
            addComponent(uyeForm);
        }
    }
}
