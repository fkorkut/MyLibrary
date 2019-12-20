package egitim.uniyaz.ui.components;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class Container extends VerticalLayout {
    private Header header;
    public Container(Header header) {
        this.header=header;
        setWidth(100,Unit.PERCENTAGE);

        Content content=new Content();

        Menu menu=new Menu(header,content);
        addComponent(menu);

        addComponent(content);

//        setExpandRatio(menu,1f);
//        setExpandRatio(content,9f);
    }
}
