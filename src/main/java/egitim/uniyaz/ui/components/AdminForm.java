package egitim.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;

public class AdminForm extends VerticalLayout {

    public AdminForm() {
        setWidth(100,Unit.PERCENTAGE);

        Content content = new Content();

        AdminMenu menu = new AdminMenu(content);
        addComponent(menu);

        addComponent(content);
    }
}