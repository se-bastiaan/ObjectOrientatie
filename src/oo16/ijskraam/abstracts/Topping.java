package oo16.ijskraam.abstracts;

public abstract class Topping extends IJsje {

    protected IJsje ijsje;
    protected int prijs = 0;

    /**
     * Contructor van een topping
     * @param ijsje {@link IJsje}
     */
    public Topping(IJsje ijsje) {
        this.ijsje = ijsje;
    }

    /**
     * Bereken prijs van ijsje + deze topping
     * @return {@link Integer}
     */
    @Override
    public int prijs() {
        return ijsje.prijs() + prijs;
    }

    /**
     * Geef beschrijving van het gehele ijsje met toppings
     * @return {@link String}
     */
    @Override
    public String geefBeschrijving() {
        if(ijsje instanceof Topping) {
            return String.format("%s en %s", ijsje.geefBeschrijving(), super.geefBeschrijving());
        } else {
            return String.format("%s met %s", ijsje.geefBeschrijving(), super.geefBeschrijving());
        }
    }
}
