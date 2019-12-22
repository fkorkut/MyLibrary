package egitim.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;
import javafx.application.Application;
import javafx.stage.Stage;

public class AdminForm extends VerticalLayout {
    private Header header;
    public AdminForm(Header header) {
        this.header=header;
        setWidth(100,Unit.PERCENTAGE);

        Content content=new Content();

        AdminMenu menu=new AdminMenu(header,content);
        addComponent(menu);

        addComponent(content);

//        setExpandRatio(menu,1f);
//        setExpandRatio(content,9f);
    }
}