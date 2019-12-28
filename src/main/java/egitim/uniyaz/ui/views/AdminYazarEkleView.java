package egitim.uniyaz.ui.views;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import egitim.uniyaz.dao.YazarDao;
import egitim.uniyaz.domain.Yazar;


public class AdminYazarEkleView extends VerticalLayout {

    @PropertyId("id")
    private TextField idField;

    @PropertyId("name")
    private TextField yazarText;

    private FormLayout formLayout;
    private FieldGroup binder;
    private BeanItem<Yazar> item;

    public AdminYazarEkleView() {

        fillLayout();
        fillViewYazar(new Yazar());
    }

    private void fillViewYazar(Yazar yazar) {
        item = new BeanItem<Yazar>(yazar);
        binder = new FieldGroup(item);
        binder.bindMemberFields(this);
    }

    private void fillLayout() {
        formLayout = new FormLayout();
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
        try {

            binder.commit();
            Yazar yazar = item.getBean();

            YazarDao yazarDao = new YazarDao();
            yazar = yazarDao.saveYazar(yazar);
            idField.setValue(yazar.getId().toString());
            Notification.show("İşlem Başarılı");

        } catch (FieldGroup.CommitException e) {
            System.out.println(e.getMessage());

        }

    }
}
