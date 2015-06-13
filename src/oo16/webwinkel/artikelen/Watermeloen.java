package oo16.webwinkel.artikelen;

import oo16.webwinkel.abstracts.Artikel;

/**
 * Representatie van een watermeloen artikel
 */
public class Watermeloen extends Artikel {
    public Watermeloen() {
        prijs = 4.5;
    }

    @Override
    public double verzendkosten() {
        return 6.75;
    }
}
