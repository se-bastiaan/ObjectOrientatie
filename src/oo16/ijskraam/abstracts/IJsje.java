package oo16.ijskraam.abstracts;

/**
 * Abstracte klasse ter representatie van een ijsje
 */
public abstract class IJsje {
    protected String beschrijving = "onbekend ijsje";

    /**
     * Geeft de prijs van een ijsje
     * @return Prijs in centen
     */
    public abstract int prijs();

    /**
     * Geeft de beschrijving van het ijsje
     * @return {@link String}
     */
    public String geefBeschrijving() {
        return beschrijving;
    }

    /**
     * Geeft de beschrijving van het ijsje
     * @return {@link String}
     */
    public String toString() {
        return geefBeschrijving();
    }
}
