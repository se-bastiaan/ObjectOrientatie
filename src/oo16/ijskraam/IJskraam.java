package oo16.ijskraam;

import oo16.ijskraam.abstracts.IJsje;
import oo16.ijskraam.ijsjes.YoghurtIJs;
import oo16.ijskraam.toppings.Chocodip;
import oo16.ijskraam.toppings.Slagroom;

public class IJskraam {

    public static void main(String val[]) {
        IJsje iJsje = new Slagroom(new Chocodip(new YoghurtIJs()));
        System.out.println(iJsje);
        System.out.println(String.format("Prijs: %d", iJsje.prijs()));
    }

}
