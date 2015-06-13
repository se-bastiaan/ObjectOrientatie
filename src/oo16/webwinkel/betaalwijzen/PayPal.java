package oo16.webwinkel.betaalwijzen;

import oo16.webwinkel.abstracts.Betalen;

/**
 * Representatie van de betaalwijze PayPal
 */
public class PayPal implements Betalen {

    /**
     * Attributen
     */
    private String email, wachtwoord;

    /**
     * Constructoren
     */
    public PayPal() {}

    public PayPal(String email, String wachtwoord) {
        this.email = email;
        this.wachtwoord = wachtwoord;
    }

    /**
     * Stel de email in
     * @param email De email die gebruikt moet worden voor de betaling
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Stel het rekeningnummer in
     * @param wachtwoord Het wachtwoord dat gebruikt moet worden voor de betaling
     */
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    @Override
    public boolean betaal(double bedrag) {
        if(email == null) {
            System.out.println("PayPal: E-mailadres incorrect");
        } else if(wachtwoord == null) {
            System.out.println("PayPal: Wachtwoord incorrect");
        } else {
            System.out.println(String.format("PayPal: Het bedrag van €%.2f is betaald (%s, %s)", bedrag, email, wachtwoord));
            return true;
        }

        return false;
    }

}
