package egitim.uniyaz.ui.views;

import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.domain.KullaniciState;

public class KullaniciKontrol {
    private boolean isAdmin = false;

    public KullaniciKontrol(Kullanici kullanici) {
        if (KullaniciState.ADMIN.equals(kullanici.getKullaniciState())){
            isAdmin = true;
        }
        else
            isAdmin = false;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

}
