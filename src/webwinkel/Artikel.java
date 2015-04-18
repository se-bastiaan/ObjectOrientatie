package webwinkel;

import java.io.Serializable;

/**
 * Class representeert een artikel in de winkel
 */
public class Artikel implements Serializable {
    private String naam;
    private String omschrijving;
    private String prijs;
    private String gebruiker;
    private String koper;

    public Artikel(String naam, String omschrijving, String prijs, String gebruiker) {
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.prijs = prijs;
        this.gebruiker = gebruiker;
    }

    /**
     * Verkrijg naam van artikel
     * @return {@link String}
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Verkrijg omschrijving van artikel
     * @return {@link String}
     */
    public String getOmschrijving() {
        return omschrijving;
    }

    /**
     * Verkrijg prijs van artikel
     * @return {@link Integer}
     */
    public String getPrijs() {
        return prijs;
    }

    /**
     * Verkrijg gebruiksnaam van eigenaar artikel
     * @return {@link String}
     */
    public String getGebruiker() {
        return gebruiker;
    }

    /**
     * Verkrijg koper gebruikersnaam
     * @return {@link String}
     */
    public String getKoper() {
        return koper;
    }

    /**
     * Zet koper
     * @param koper {@link String}
     */
    public void setKoper(String koper) {
        this.koper = koper;
    }
}
