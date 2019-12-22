package egitim.uniyaz.ui.views;

import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.*;
import egitim.uniyaz.dao.KullaniciDao;
import egitim.uniyaz.domain.Kullanici;

import java.util.ArrayList;
import java.util.List;

public class AdminKisiListele extends VerticalLayout {
    FormLayout formLayout;
    private Table table;
    private IndexedContainer indexedContainer;


    public AdminKisiListele() {
        createTable();
        insertTable();

    }

    private  void createTable(){
        table=new Table();
        indexedContainer=new IndexedContainer();
        indexedContainer.addContainerProperty("id",Long.class,null);
        indexedContainer.addContainerProperty("name",String.class,null);

        table.setContainerDataSource(indexedContainer);

        table.setColumnHeaders("id","id");
        table.setColumnHeaders("name","name");

       addComponent(table);
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
