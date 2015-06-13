package oo16.webwinkel.betaalwijzen;

import oo16.webwinkel.abstracts.Betalen;

/**
 * Representatie van de betaalwijze iDeal
 */
public class IDeal implements Betalen {

    /**
     * Attributen
     */
    private String bank, rekeningnummer, pincode;

    /**
     * Constructoren
     */
    public IDeal() {}

    public IDeal(String bank, String rekeningnummer, String pincode) {
        this.bank = bank;
        this.rekeningnummer = rekeningnummer;
        this.pincode = pincode;
    }

    /**
     * Stel de bank in
     * @param bank De bank die gebruikt moet worden voor de betaling
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * Stel het rekeningnummer in
     * @param rekeningNr Het rekeningnummer dat gebruikt moet worden voor de betaling
     */
    public void setRekeningNr(String rekeningNr) {
        this.rekeningnummer = rekeningNr;
    }

    /**
     * Stel de pincode in
     * @param pincode De pincode die gebruikt moet worden voor de betaling
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public boolean betaal(double bedrag) {
        if(bank == null) {
            System.out.println("iDeal: Bank incorrect");
        } else if(rekeningnummer == null) {
            System.out.println("iDeal: Rekeningnummer incorrect");
        } else if(pincode == null) {
            System.out.println("iDeal: Pincode incorrect");
        } else {
            System.out.println(String.format("iDeal: Het bedrag van €%.2f is betaald (%s, %s, %s)", bedrag, bank, rekeningnummer, pincode));
            return true;
        }

        return false;
    }

}
