package oo16.ijskraam.ijsjes;

import oo16.ijskraam.abstracts.IJsje;

/**
 * Representatie van een yoghurtijsje
 */
public class YoghurtIJs extends IJsje {

    public YoghurtIJs() {
        beschrijving = "Yoghurtijsje";
    }

    @Override
    public int prijs() {
        return 200;
    }

}
