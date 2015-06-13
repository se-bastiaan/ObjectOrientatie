package oo16.webwinkel.artikelen;

import oo16.webwinkel.abstracts.Artikel;

/**
 * Representatie van een wijnglas artikel
 */
public class Wijnglas extends Artikel {
    public Wijnglas() {
        prijs = 8.5;
    }

    @Override
    public double verzendkosten() {
        return 6.75;
    }
}
