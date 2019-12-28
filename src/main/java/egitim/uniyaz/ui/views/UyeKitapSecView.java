package egitim.uniyaz.ui.views;

import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.*;
import egitim.uniyaz.dao.KitapDao;
import egitim.uniyaz.dao.UyeKitapDao;
import egitim.uniyaz.domain.Kitap;
import egitim.uniyaz.domain.KitapOkumaState;
import egitim.uniyaz.domain.UyeKitap;

import java.util.List;

public class UyeKitapSecView extends VerticalLayout {

    private TextField idField;

    @PropertyId("kitap")
    private ComboBox kitapCombo;

    private FormLayout formLayout;
    private List<Kitap> listKitap;

    public UyeKitapSecView() {
        fillLayout();
        addComponent(formLayout);
    }

    private void kitapList() {
        KitapDao KitapDao = new KitapDao();
        listKitap = KitapDao.findAllKitap();
    }

    private void fillLayout() {
        formLayout=new FormLayout();
        formLayout.setMargin(true);
        formLayout.addStyleName("outlined");
        formLayout.setSizeFull();

        idField = new TextField("Id");
        idField.setEnabled(false);
        formLayout.addComponent(idField);

        kitapList();
        kitapCombo= new ComboBox("Kitap",listKitap);
        formLayout.addComponent(kitapCombo);

        Button ekleBtn=new Button();
        ekleBtn.setCaption("Ekle");
        ekleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                kitapEkle();
            }
        });
        formLayout.addComponent(ekleBtn);
    }

    private void kitapEkle() {
        //alanlar alınır.
        Kitap kitap = (Kitap) kitapCombo.getValue();
        UyeKitap uyeKitap = new UyeKitap();

        uyeKitap.setKitap(kitap);
        uyeKitap.setKitapOkumaState(KitapOkumaState.Okunacak);
        uyeKitap.setKullanici(KullaniciGirisView.kullanici);

        UyeKitapDao uyeKitapDao = new UyeKitapDao();
        uyeKitap=uyeKitapDao.saveUyeKitap(uyeKitap);

        idField.setValue(uyeKitap.getId().toString());

        Notification.show("İşlem Başarılı");


    }


}
