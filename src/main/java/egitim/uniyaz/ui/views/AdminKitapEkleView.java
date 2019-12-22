package egitim.uniyaz.ui.views;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import egitim.uniyaz.dao.KitapDao;
import egitim.uniyaz.dao.YazarDao;
import egitim.uniyaz.domain.Kitap;
import egitim.uniyaz.domain.Yazar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdminKitapEkleView extends VerticalLayout {

    TextField idField;
    ComboBox yazarCombo;
    TextField kitapText;
    List<Yazar> listYazar;
    FormLayout formLayout=new FormLayout();


    public AdminKitapEkleView() {
        YazarDao yazarDao = new YazarDao();
        listYazar = yazarDao.findAllYazar();
        fillLayout();
    }

    private void fillLayout() {
        formLayout=new FormLayout();
        formLayout.setMargin(true);
        formLayout.addStyleName("outlined");
        formLayout.setSizeFull();

        idField = new TextField("Id");
        idField.setEnabled(false);
        formLayout.addComponent(idField);


        yazarCombo = new ComboBox("Yazar",listYazar);
        formLayout.addComponent(yazarCombo);

        kitapText = new TextField();
        kitapText.setDescription("Kitap Adı");
        kitapText.setCaption("Kitap Adı");
        kitapText.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        formLayout.addComponent(kitapText);

        Button ekleBtn = new Button();
        ekleBtn.setCaption("Ekle");
        ekleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                kitapEkle();
            }
        });
        formLayout.addComponent(ekleBtn);

        addComponent(formLayout);

    }

    private void kitapEkle() {

        Long idFieldValue = null;
        if (idField.getValue() != "") {
            idFieldValue = Long.parseLong(idField.getValue());
        }
        //alanlar alınır.
        Yazar yazar = (Yazar) yazarCombo.getValue();
        String kitapAdi = kitapText.getValue();

        Kitap kitap = new Kitap();
        kitap.setName(kitapAdi);
        kitap.setYazar(yazar);

        KitapDao kitapDao = new KitapDao();
        kitap = kitapDao.saveKitap(kitap);
        idField.setValue(kitap.getId().toString());
        Notification.show("İşlem Başarılı");
    }


}
