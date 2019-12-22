package egitim.uniyaz.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import egitim.uniyaz.ui.views.AdminKitapEkleView;
import egitim.uniyaz.ui.views.UyeKitapSecView;

public class UyeMenu  extends HorizontalLayout {
    private Header header;
    private Content content;


    MenuButton menuButton3;
    MenuButton menuButton4;
    MenuButton menuButton5;
    HorizontalLayout buttonsLayout;

    public UyeMenu(Header header,Content content) {
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
        menuButton3=new MenuButton(FontAwesome.PLUS);
        menuButton3.setCaption("Kutuphaneme Kitap Ekle");
        menuButton3.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                UyeKitapSecView uyeKitapSecView=new UyeKitapSecView();
                content.setContent(uyeKitapSecView);
            }
        });
        buttonsLayout.addComponent(menuButton3);

        menuButton4=new MenuButton(FontAwesome.PLUS);
        menuButton4.setCaption("Kitaplarımı Güncelle");
        menuButton4.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        buttonsLayout.addComponent(menuButton4);


        menuButton5=new MenuButton(FontAwesome.PLUS);
        menuButton5.setCaption("Button5");
        menuButton5.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        buttonsLayout.addComponent(menuButton5);

        addComponent(buttonsLayout);

    }

}

