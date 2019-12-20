package egitim.uniyaz.ui.components;

import com.vaadin.ui.VerticalLayout;
import egitim.uniyaz.ui.views.KullaniciGirisView;

public class General extends VerticalLayout {
    public General() {
        KullaniciGirisView kullaniciGirisView=new KullaniciGirisView();
        addComponent(kullaniciGirisView);
    //  if (girisYapildimi()){

          Header header=new Header();
          addComponent(header);

          Container container=new Container(header);
          addComponent(container);
//      }
//      else
//          return;
    }
//
//    private boolean girisYapildimi() {
//
//
//        return  false;
//    }
}
