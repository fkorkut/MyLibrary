package egitim.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;


public class AdminForm extends VerticalLayout {

    private Header header;

    public AdminForm(Header header) {
        this.header = header;

        setWidth(100,Unit.PERCENTAGE);

        Content content = new Content();

        AdminMenu menu = new AdminMenu(header,content);
        addComponent(menu);

        addComponent(content);
    }
}