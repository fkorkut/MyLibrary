package egitim.uniyaz.ui.views;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import egitim.uniyaz.dao.YazarDao;
import egitim.uniyaz.domain.Yazar;


public class AdminYazarEkleView extends VerticalLayout {

    TextField idField;
    TextField yazarText;
    FormLayout formLayout=new FormLayout();

    public AdminYazarEkleView() {

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

        yazarText = new TextField();
        yazarText.setDescription("Yazar Adı");
        yazarText.setCaption("Yazar Adı");
        yazarText.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        formLayout.addComponent(yazarText);

        Button ekleBtn = new Button();
        ekleBtn.setCaption("Ekle");
        ekleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                yazarEkle();
            }
        });
        formLayout.addComponent(ekleBtn);

        addComponent( formLayout);

    }

    private void yazarEkle() {

        Long idFieldValue = null;
        if (idField.getValue() != "") {
            idFieldValue = Long.parseLong(idField.getValue());
        }

        Yazar yazar = new Yazar();
        String yazarAdi = yazarText.getValue();
        yazar.setName(yazarAdi);


        YazarDao yazarDao = new YazarDao();
        yazar = yazarDao.saveYazar(yazar);
        idField.setValue(yazar.getId().toString());
        Notification.show("İşlem Başarılı");
    }


}
