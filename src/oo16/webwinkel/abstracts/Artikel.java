package oo16.webwinkel.abstracts;

/**
 * Abstracte representatie van een artikel in een webwinkel
 */
public abstract class Artikel {
    protected String beschrijving = "onbekend artikel";
    protected double prijs = 0;

    /**
     * Bereken en verkrijg de verzendkosten van een artike
     * @return {@link Double}
     */
    public abstract double verzendkosten();

    /**
     * Verkrijg de prijs
     * @return {@link Double}
     */
    public double getPrijs() {
        return prijs;
    }

    /**
     * Verkrijg beschrijving
     * @return {@link String}
     */
    public String getBeschrijving() {
        return beschrijving;
    }
}
