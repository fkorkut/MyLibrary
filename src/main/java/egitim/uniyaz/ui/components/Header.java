package egitim.uniyaz.ui.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends VerticalLayout {
    public Header() {
        setHeight(100, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);

        Label baslik = new Label("Hoş geldiniz");
        baslik.addStyleName(ValoTheme.LABEL_LARGE);
        baslik.addStyleName(ValoTheme.LABEL_COLORED);
        baslik.addStyleName(ValoTheme.LAYOUT_WELL);

        addComponent(baslik);
    }
}
