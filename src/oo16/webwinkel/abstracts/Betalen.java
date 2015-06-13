package oo16.webwinkel.abstracts;

/**
 * Interface voor de betaalwijzen
 */
public interface Betalen {
    /**
     * Betalen!
     * @param bedrag Het te betalen bedrag
     * @return {@code true} als de betalen geslaagd is
     */
    boolean betaal(double bedrag);
}
