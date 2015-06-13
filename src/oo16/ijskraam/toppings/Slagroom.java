package oo16.ijskraam.toppings;

import oo16.ijskraam.abstracts.IJsje;
import oo16.ijskraam.abstracts.Topping;

/**
 * Representatie van een slagroom topping
 */
public class Slagroom extends Topping {

    /**
     * Contructor van een topping
     *
     * @param ijsje {@link oo16.ijskraam.abstracts.IJsje}
     */
    public Slagroom(IJsje ijsje) {
        super(ijsje);
        prijs = 50;
        beschrijving = "Slagroom";
    }

}
