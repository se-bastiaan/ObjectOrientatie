package oo16.webwinkel;

import oo16.webwinkel.abstracts.Artikel;
import oo16.webwinkel.abstracts.Betalen;
import oo16.webwinkel.betaalwijzen.IDeal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Representatie van een winkelwagen in een webwinkel
 */
public class Winkelwagen {

    private List<Artikel> artikelen = new ArrayList<>();
    private Betalen betaalwijze = new IDeal();

    /**
     * Artikel toevoegen aan wagen
     * @param artikel {@link Artikel}
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Verwijder item uit wagen
     * @param index {@link Integer}
     */
    public void verwijder(int index) {
        artikelen.remove(index);
    }

    /**
     * Bereken de totaalprijs van alle artikelen
     * @return {@link Double}
     */
    public double berekenTotaalprijs() {
        List<Double> sendings = new ArrayList<>();
        double totaalPrijs = 0;
        for (Artikel artikel : artikelen) {
            totaalPrijs += artikel.getPrijs();
            if(!sendings.contains(artikel.verzendkosten())) {
                sendings.add(artikel.verzendkosten());
                totaalPrijs += artikel.verzendkosten();
            }
        }
        return totaalPrijs;
    }

    /**
     * Verander de betaalwijze van de shop
     * @param betaalwijze
     */
    public void veranderBetaalwijze(Betalen betaalwijze) {
        this.betaalwijze = betaalwijze;
    }

    /**
     * Betaal!
     * @return {@code true} wanneer betaling succesvol
     */
    public boolean betaal() {
        return betaalwijze.betaal(berekenTotaalprijs());
    }
}
