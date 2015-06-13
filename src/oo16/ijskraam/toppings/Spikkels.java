package oo16.ijskraam.toppings;

import oo16.ijskraam.abstracts.IJsje;
import oo16.ijskraam.abstracts.Topping;

/**
 * Representatie van een slagroom topping
 */
public class Spikkels extends Topping {

    /**
     * Contructor van een topping
     *
     * @param ijsje {@link oo16.ijskraam.abstracts.IJsje}
     */
    public Spikkels(IJsje ijsje) {
        super(ijsje);
        prijs = 0;
        beschrijving = "Spikkels";
    }

}
