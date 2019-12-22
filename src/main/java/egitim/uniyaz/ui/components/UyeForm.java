package egitim.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;

public class UyeForm extends VerticalLayout {
    private Header header;
    public UyeForm(Header header) {
        this.header=header;
        setWidth(100,Unit.PERCENTAGE);

        Content content=new Content();

        UyeMenu menu=new UyeMenu(header,content);
        addComponent(menu);

        addComponent(content);

//        setExpandRatio(menu,1f);
//        setExpandRatio(content,9f);
    }
}