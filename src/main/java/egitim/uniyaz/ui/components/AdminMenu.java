package egitim.uniyaz.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import egitim.uniyaz.MyUI;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.ui.views.AdminKisiListele;
import egitim.uniyaz.ui.views.AdminKitapEkleView;
import egitim.uniyaz.ui.views.AdminYazarEkleView;
import egitim.uniyaz.ui.views.KullaniciGirisView;

public class AdminMenu extends HorizontalLayout {

    private Content content;

    MenuButton yazarEkleBtn;
    MenuButton kitapEkleBtn;
    MenuButton kisileriListeleBtn;
    MenuButton kullaniciBtn;

    Kullanici kullanici = KullaniciGirisView.kullanici;

    public AdminMenu(Content content) {
        setHeight(100, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);

        this.content=content;

        setSpacing(true);
        setMargin(true);
        createButtons();
    }

    private void createButtons() {
        yazarEkleBtn = new MenuButton(FontAwesome.PLUS);
        yazarEkleBtn.setCaption("Yazar Ekle");
        yazarEkleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                AdminYazarEkleView adminYazarEkleView = new AdminYazarEkleView();
                content.setContent(adminYazarEkleView);

            }
        });
        addComponent(yazarEkleBtn);

        kitapEkleBtn = new MenuButton(FontAwesome.PLUS);
        kitapEkleBtn.setCaption("Kitap Ekle");
        kitapEkleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                AdminKitapEkleView adminKitapEkleView = new AdminKitapEkleView();
                content.setContent(adminKitapEkleView);
            }
        });
        addComponent(kitapEkleBtn);

        kisileriListeleBtn = new MenuButton(FontAwesome.LIST);
        kisileriListeleBtn.setCaption("Kişileri Listele");
        kisileriListeleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                AdminKisiListele adminKisiListele  = new AdminKisiListele();
                content.setContent(adminKisiListele);
            }
        });
        addComponent(kisileriListeleBtn);

        kullaniciBtn = new MenuButton(FontAwesome.USER);
        kullaniciBtn.setCaption(kullanici.getName() + " " + kullanici.getKullaniciState());
        kullaniciBtn.setDescription("Çıkış yap");
        kullaniciBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                KullaniciGirisView kullaniciGirisView = new KullaniciGirisView();
                MyUI.getCurrent().setContent(kullaniciGirisView);
            }
        });
       addComponent(kullaniciBtn);
    }
}

