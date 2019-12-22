package egitim.uniyaz.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import egitim.uniyaz.ui.views.AdminKisiListele;
import egitim.uniyaz.ui.views.AdminKitapEkleView;

public class AdminMenu extends HorizontalLayout {
    private Header header;
    private Content content;

    MenuButton menuButton1;
    MenuButton menuButton2;
    HorizontalLayout buttonsLayout;

    public AdminMenu(Header header,Content content) {
        setHeight(100, Unit.PIXELS);
        setWidth(100, Unit.PERCENTAGE);
        this.header = header;
        this.content=content;

        setSpacing(true);
        setMargin(true);
        createButtons();
    }

    private void createButtons() {
        buttonsLayout=new HorizontalLayout();
        menuButton1=new MenuButton(FontAwesome.PLUS);
        menuButton1.setCaption("Kitap Ekle");
        menuButton1.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AdminKitapEkleView adminKitapEkleView = new AdminKitapEkleView();
                content.setContent(adminKitapEkleView);
            }
        });
        buttonsLayout.addComponent(menuButton1);

        menuButton2=new MenuButton(FontAwesome.PLUS);
        menuButton2.setCaption("Kişileri Listele");
        menuButton2.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AdminKisiListele adminKisiListele  = new AdminKisiListele();
                content.setContent(adminKisiListele);
            }
        });
        buttonsLayout.addComponent(menuButton2);

        addComponent(buttonsLayout);

    }

}

