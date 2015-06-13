package oo16.webwinkel.betaalwijzen;

import oo16.webwinkel.abstracts.Betalen;

/**
 * Representatie van de betaalwijze CreditCard
 */
public class CreditCard implements Betalen {

    /**
     * Attributen
     */
    private String kaartnummer, naam, verloopdatum;

    /**
     * Constructoren
     */
    public CreditCard() {}

    public CreditCard(String kaartnummer, String naam, String verloopdatum) {
        this.kaartnummer = kaartnummer;
        this.naam = naam;
        this.verloopdatum = verloopdatum;
    }

    /**
     * Stel het kaartnummer in
     * @param kaartnummer Het kaartnummer dat gebruikt moet worden voor de betaling
     */
    public void setKaartnummer(String kaartnummer) {
        this.kaartnummer = kaartnummer;
    }

    /**
     * Stel de naam in
     * @param naam De naam dat gebruikt moet worden voor de betaling
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * Stel de datum in
     * @param datum De verloopdatum die gebruikt moet worden voor de betaling
     */
    public void setDatum(String datum) {
        this.verloopdatum = datum;
    }

    @Override
    public boolean betaal(double bedrag) {
        if(kaartnummer == null) {
            System.out.println("CreditCard: Kaartnummer incorrect");
        } else if(naam == null) {
            System.out.println("CreditCard: Naam incorrect");
        } else if(verloopdatum == null) {
            System.out.println("CreditCard: Verloopdatum incorrect");
        } else {
            System.out.println(String.format("CreditCard: Het bedrag van €%.2f is betaald (%s, %s, %s)", bedrag, kaartnummer, naam, verloopdatum));
            return true;
        }

        return false;
    }

}
