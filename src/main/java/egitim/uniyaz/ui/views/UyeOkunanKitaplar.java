package egitim.uniyaz.ui.views;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import egitim.uniyaz.dao.UyeKitapDao;
import egitim.uniyaz.domain.Kullanici;
import egitim.uniyaz.domain.UyeKitap;
import java.util.List;

public class UyeOkunanKitaplar extends VerticalLayout {

    private Table table;
    private IndexedContainer indexedContainer;

    private FormLayout formLayout;

    Kullanici kullanici = KullaniciGirisView.kullanici;

    public UyeOkunanKitaplar() {
        createTable();
        fillTable();
        addComponent(formLayout);
    }

    private  void createTable() {
        formLayout = new FormLayout();
        formLayout.setMargin(true);
        formLayout.addStyleName("outlined");
        formLayout.setSizeFull();

        table = new Table();
        table.setSelectable(true);
        indexedContainer = new IndexedContainer();

        indexedContainer.addContainerProperty("Kitap",String.class,null);
        indexedContainer.addContainerProperty("OkumaState",Enum.class,null);
        indexedContainer.addContainerProperty("gun",Long.class,0);

        table.setContainerDataSource(indexedContainer);

        table.setColumnHeaders("Kitap","Okuma Durumu", "Kaç günde okundu");
        table.setPageLength(table.size());
        formLayout.addComponent(table);
    }


    private  void fillTable(){
        UyeKitapDao uyeKitapDao = new UyeKitapDao();
        List<UyeKitap> uyeKitapList = uyeKitapDao.findFinishKitapByKullanici(kullanici);

        for (UyeKitap uyeKitap : uyeKitapList) {
            Item item = indexedContainer.addItem(uyeKitap);

            item.getItemProperty("Kitap").setValue(uyeKitap.getKitap().getName());
            item.getItemProperty("OkumaState").setValue(uyeKitap.getKitapOkumaState());
            item.getItemProperty("gun").setValue(uyeKitap.getGun());

        }
    }
}
