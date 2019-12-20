package egitim.uniyaz.ui.views;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class Button2Vieww extends VerticalLayout {
    FormLayout formLayout;
    private Table table;
    private IndexedContainer indexedContainer;
    public Button2Vieww() {
        Fill();
    }

    private void Fill() {
        VerticalLayout verticalLayout=new VerticalLayout();
        createTable(verticalLayout);
        createButton(verticalLayout);
        insertTable();
        formLayout.addComponent(verticalLayout);
    }

    private  void createTable(VerticalLayout verticalLayout)
    {
        table=new Table();
        indexedContainer=new IndexedContainer();
        indexedContainer.addContainerProperty("Kolon1",String.class,null);
        indexedContainer.addContainerProperty("Kolon1",String.class,null);

        table.setContainerDataSource(indexedContainer);

        table.setColumnHeaders("Kolon1","Kolon1");
        verticalLayout.addComponent(table);
    }

    private  void createButton(VerticalLayout verticalLayout){
        Button button1=new Button();
        button1.setCaption("Normal");
        button1.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        verticalLayout.addComponent(button1);
    }

    private  void insertTable(){
//        CategoryDao categoryDao = new CategoryDao();
//        List<Category> categoryList = categoryDao.findAllCategory();
//
//        for (Category category : categoryList) {
//            Item item = indexedContainer.addItem(category);
//            item.getItemProperty("id").setValue(category.getId());
//            item.getItemProperty("name").setValue(category.getName());
//        }
    }
}
