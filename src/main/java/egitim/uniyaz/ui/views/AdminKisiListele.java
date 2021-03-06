package egitim.uniyaz.ui.views;

import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;
import egitim.uniyaz.dao.KullaniciDao;
import egitim.uniyaz.dao.UyeKitapDao;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.domain.UyeKitap;

import java.util.Date;
import java.util.List;

public class AdminKisiListele extends VerticalLayout {

    @PropertyId("kullanici")
    ComboBox kisiCombo;

    private Table table;

    private IndexedContainer indexedContainer;
    private FormLayout formLayout;
    private List<Kullanici> listKullanici;
    private Kullanici kullanici;

    private FieldGroup binder;
    private BeanItem<UyeKitap> item;

    public AdminKisiListele() {
        fillLayout();
        fillViewKullanici(new UyeKitap());
    }

    private void fillViewKullanici(UyeKitap uyeKitap) {
        item = new BeanItem<UyeKitap>(uyeKitap);
        binder = new FieldGroup(item);
        binder.bindMemberFields(this);
    }

    private void kullaniciList() {
        KullaniciDao kullaniciDao = new KullaniciDao();
        listKullanici = kullaniciDao.findAllUye();
    }

    private void fillLayout() {
        formLayout = new FormLayout();
        formLayout.setMargin(true);
        formLayout.addStyleName("outlined");
        formLayout.setSizeFull();
        addComponent(formLayout);

        kullaniciList();
        kisiCombo = new ComboBox("Uye", listKullanici);
        formLayout.addComponent(kisiCombo);

        Button ekleBtn=new Button();
        ekleBtn.setCaption("Kişi Kitaplarını Listele");
        ekleBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                    kullanici = (Kullanici) kisiCombo.getValue();
                    createTable();
                    fillTable();
            }
        });
        formLayout.addComponent(ekleBtn);
    }

    private  void createTable(){

        table = new Table();

        indexedContainer=new IndexedContainer();
        indexedContainer.addContainerProperty("kitapAdi",String.class,null);
        indexedContainer.addContainerProperty("gun",Long.class,null);
        indexedContainer.addContainerProperty("Baslangic", Date.class,null);

        table.setContainerDataSource(indexedContainer);

        table.setColumnHeaders("Kitap Adı","Kaç günde okudu","Başlangıç Tarihi");

        table.setPageLength(table.size());

       formLayout.addComponent(table);
       addComponent(formLayout);
    }

    private  void fillTable(){

        try {
            binder.commit();
            UyeKitap kitapUye = item.getBean();
            kullanici = kitapUye.getKullanici();
            UyeKitapDao uyeKitapDao = new UyeKitapDao();
            List<UyeKitap> uyeKitapList = uyeKitapDao.findAllKitapByKullanici(kullanici);

            for (UyeKitap uyeKitap : uyeKitapList) {

                Item item = indexedContainer.addItem(uyeKitap);

                item.getItemProperty("kitapAdi").setValue(uyeKitap.getKitap().getName());
                item.getItemProperty("gun").setValue(uyeKitap.getGun());
                item.getItemProperty("Baslangic").setValue(uyeKitap.getBaslangicTarihi());

            }
        } catch (FieldGroup.CommitException e) {
            e.printStackTrace();
        }

    }
}
