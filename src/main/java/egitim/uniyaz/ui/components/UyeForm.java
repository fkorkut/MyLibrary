package egitim.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;

public class UyeForm extends VerticalLayout {

    public UyeForm() {
        setWidth(100,Unit.PERCENTAGE);

        Content content=new Content();

        UyeMenu menu = new UyeMenu(content);
        addComponent(menu);

        addComponent(content);
    }
}