package oo16.ijskraam.ijsjes;

import oo16.ijskraam.abstracts.IJsje;

/**
 * Representatie van een sorbetijsje
 */
public class SorbetIJs extends IJsje {

    public SorbetIJs() {
        beschrijving = "Sorbetijsje";
    }

    @Override
    public int prijs() {
        return 160;
    }

}
