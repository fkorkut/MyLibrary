package egitim.uniyaz.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import egitim.uniyaz.MyUI;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.ui.views.KullaniciGirisView;
import egitim.uniyaz.ui.views.UyeKitapGuncelle;
import egitim.uniyaz.ui.views.UyeKitapSecView;
import egitim.uniyaz.ui.views.UyeOkunanKitaplar;

public class UyeMenu  extends HorizontalLayout {
    private Content content;

    private MenuButton kitapEkleBtn;
    private MenuButton kitapGuncelleBtn;
    private MenuButton okunanKitaplarBtn;
    private MenuButton kullaniciBtn;

    private Kullanici kullanici = KullaniciGirisView.kullanici;
    public UyeMenu(Content content) {

        setHeight(100, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);
        this.content=content;

        setSpacing(true);
        setMargin(true);
        createButtons();
    }

    private void createButtons() {

        kitapEkleBtn = new MenuButton(FontAwesome.PLUS);
        kitapEkleBtn.setCaption("Kutuphaneme Kitap Ekle");
        kitapEkleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UyeKitapSecView uyeKitapSecView = new UyeKitapSecView();
                content.setContent(uyeKitapSecView);
            }
        });
        addComponent(kitapEkleBtn);

        kitapGuncelleBtn = new MenuButton(FontAwesome.EXCHANGE);
        kitapGuncelleBtn.setCaption("Kitaplarımı Güncelle");
        kitapGuncelleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UyeKitapGuncelle uyeKitapGuncelle = new UyeKitapGuncelle();
                content.setContent(uyeKitapGuncelle);
            }
        });
        addComponent(kitapGuncelleBtn);


        okunanKitaplarBtn = new MenuButton(FontAwesome.LIST);
        okunanKitaplarBtn.setCaption("Okunan Kitaplar");
        okunanKitaplarBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UyeOkunanKitaplar uyeOkunanKitaplar = new UyeOkunanKitaplar();
                content.setContent(uyeOkunanKitaplar);
            }
        });
        addComponent(okunanKitaplarBtn);

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

