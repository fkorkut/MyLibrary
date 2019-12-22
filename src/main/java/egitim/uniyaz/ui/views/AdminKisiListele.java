package egitim.uniyaz.ui.views;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;
import egitim.uniyaz.dao.KullaniciDao;
import egitim.uniyaz.domain.Kullanici;

import java.util.ArrayList;
import java.util.List;

public class AdminKisiListele extends VerticalLayout {

    private Table table;
    private IndexedContainer indexedContainer;
    FormLayout formLayout=new FormLayout();


    public AdminKisiListele() {
        createTable();
        insertTable();

    }

    private  void createTable(){
        formLayout=new FormLayout();
        formLayout.setMargin(true);
        formLayout.addStyleName("outlined");
        formLayout.setSizeFull();

        table = new Table();

        indexedContainer=new IndexedContainer();

        indexedContainer.addContainerProperty("id",Long.class,null);
        indexedContainer.addContainerProperty("name",String.class,null);

        table.setContainerDataSource(indexedContainer);

        table.setColumnHeaders("id","id");
        table.setColumnHeaders("name","name");

        table.setPageLength(table.size());

       formLayout.addComponent(table);
       addComponent(formLayout);
    }

    private  void insertTable(){

        KullaniciDao kullaniciDao = new KullaniciDao();

        List<Kullanici> kullaniciList = kullaniciDao.findAllUye();

        for (Kullanici kullanici : kullaniciList) {
            Item item = indexedContainer.addItem(kullanici);

            item.getItemProperty("id").setValue(kullanici.getId());
            item.getItemProperty("name").setValue(kullanici.getName());
        }
    }
}
