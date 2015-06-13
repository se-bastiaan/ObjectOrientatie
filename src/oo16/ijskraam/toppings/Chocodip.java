package oo16.ijskraam.toppings;

import oo16.ijskraam.abstracts.IJsje;
import oo16.ijskraam.abstracts.Topping;

/**
 * Representatie van een slagroom topping
 */
public class Chocodip extends Topping {

    /**
     * Contructor van een topping
     *
     * @param ijsje {@link oo16.ijskraam.abstracts.IJsje}
     */
    public Chocodip(IJsje ijsje) {
        super(ijsje);
        prijs = 30;
        beschrijving = "Chocodip";
    }

}
