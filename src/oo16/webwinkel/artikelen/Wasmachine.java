package oo16.webwinkel.artikelen;

import oo16.webwinkel.abstracts.Artikel;

/**
 * Representatie van een wasmachine artikel
 */
public class Wasmachine extends Artikel {
    public Wasmachine() {
        prijs = 499;
    }

    @Override
    public double verzendkosten() {
        return 30;
    }
}
