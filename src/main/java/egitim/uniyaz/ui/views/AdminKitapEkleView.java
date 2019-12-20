package egitim.uniyaz.ui.views;

import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;

public class AdminKitapEkleView extends VerticalLayout {

    FormLayout formLayout;

    public AdminKitapEkleView() {
       fillLayout();
    }

    private void fillLayout() {
        formLayout =new FormLayout();
        addComponent(formLayout);

        Label textLabel1 = new Label("Label kısmı");
        textLabel1.addStyleName(ValoTheme.LABEL_BOLD);
        formLayout.addComponent(textLabel1);

        TextField textField2 = new TextField();
        textField2.setDescription("DenemeDesc");
        textField2.setCaption("Deneme");
        textField2.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        formLayout.addComponent(textField2);

        Button button1=new Button();
        button1.setCaption("Normal");
        formLayout.addComponent(button1);

        DateField dateField1=new DateField("Tarih");
        formLayout.addComponent(dateField1);

        List<String> list1=new ArrayList<>();
        list1.add("List1");
        list1.add("List2");
        ComboBox comboBox=new ComboBox("Liste",list1);
        formLayout.addComponent(comboBox);

        CheckBox checkbox1 = new CheckBox("ChechBox");
        formLayout.addComponent(checkbox1);

        addComponent(formLayout);
    }


}
