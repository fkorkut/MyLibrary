package egitim.uniyaz.ui.components;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import egitim.uniyaz.ui.views.KullaniciGirisView;

public class Menu extends HorizontalLayout {
    private Header header;
    private Content content;

    MenuButton menuButton1;
    MenuButton menuButton2;
    MenuButton menuButton3;
    MenuButton menuButton4;
    MenuButton menuButton5;
    HorizontalLayout buttonsLayout;

    public Menu(Header header,Content content) {
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
        menuButton1.setCaption("Button1");
        menuButton1.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                KullaniciGirisView button1View=new KullaniciGirisView();
                content.setContent(button1View);
            }
        });
        buttonsLayout.addComponent(menuButton1);

        menuButton2=new MenuButton(FontAwesome.PLUS);
        menuButton2.setCaption("Button2");
        menuButton2.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        buttonsLayout.addComponent(menuButton2);


        menuButton3=new MenuButton(FontAwesome.PLUS);
        menuButton3.setCaption("Button3");
        menuButton3.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
        buttonsLayout.addComponent(menuButton3);


        menuButton4=new MenuButton(FontAwesome.PLUS);
        menuButton4.setCaption("Button4");
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
