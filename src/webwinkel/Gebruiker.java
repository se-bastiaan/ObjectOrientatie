package webwinkel;

import java.io.Serializable;

/**
 * Class representeert een gebruiker in de winkel
 */
public class Gebruiker implements Serializable {
    private String userId;
    private String password;

    public Gebruiker( String userId, String password ) {
        this.userId = userId;
        this.password = password;
    }

    /**
     * Verkrijg gebruikersnaam van gebruiker
     * @return {@link String}
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Verkrijg wachtwoord van gebruiker
     * @return {@link String}
     */
    public String getPassword() {
        return password;
    }
}
