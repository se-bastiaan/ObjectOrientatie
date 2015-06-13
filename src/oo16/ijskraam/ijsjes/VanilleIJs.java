package oo16.ijskraam.ijsjes;

import oo16.ijskraam.abstracts.IJsje;

/**
 * Representatie van een vanilleijsjes
 */
public class VanilleIJs extends IJsje {

    public VanilleIJs() {
        beschrijving = "Vanilleijsje";
    }

    @Override
    public int prijs() {
        return 150;
    }

}
