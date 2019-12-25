package egitim.uniyaz.ui.views;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import egitim.uniyaz.dao.KitapDao;
import egitim.uniyaz.dao.YazarDao;
import egitim.uniyaz.domain.Kitap;
import egitim.uniyaz.domain.Yazar;

import java.util.List;

public class AdminKitapEkleView extends VerticalLayout {

    @PropertyId("id")
    TextField idField;

    @PropertyId("yazar")
    ComboBox yazarCombo;

    @PropertyId("name")
    TextField kitapText;

    List<Yazar> listYazar;
    FormLayout formLayout=new FormLayout();

    private FieldGroup binder;
    private BeanItem<Kitap> item;


    public AdminKitapEkleView() {
        yazarList();
        fillLayout();
        fillViewKitap(new Kitap());
    }

    private void fillViewKitap(Kitap kitap) {
        item = new BeanItem<Kitap>(kitap);
        binder = new FieldGroup(item);
        binder.bindMemberFields(this);
    }

    private void yazarList() {
        YazarDao yazarDao = new YazarDao();
        listYazar = yazarDao.findAllYazar();
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
        try {

            binder.commit();
            Kitap kitap = item.getBean();

            KitapDao kitapDao = new KitapDao();
            kitap = kitapDao.saveKitap(kitap);
            idField.setValue(kitap.getId().toString());

            Notification.show("İşlem Başarılı");

        } catch (FieldGroup.CommitException e) {
            System.out.println(e.getMessage());
        }
    }


}
