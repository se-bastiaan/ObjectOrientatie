import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Giel Besouw - s4483898
 * @author Sébastiaan Versteeg - s???????
 */
public class Galg {
    private int currentErrors = 0;
    private String currentWord;
    private String toGuessWord;
    private ArrayList<Character> letterList = new ArrayList<Character>();

    /**
     * De standaard constructor
     */
    public Galg() {
        try {
            String path = new File(".").getCanonicalPath();
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WoordLezer wl = new WoordLezer("galg.txt");
        this.toGuessWord = wl.geefWoord();
        currentWord = toGuessWord;
    }

    /**
     * De constructor met een parameter om het woord in te stellen.
     *
     * @param toGuessWord Het woord dat geraden moet worden door de gebruiker.
     */
    public Galg(String toGuessWord) {
        this.toGuessWord = toGuessWord;
    }

    /**
     * Geeft het te raden woord
     *
     * @return
     */
    public String getToGuessWord() {
        return toGuessWord;
    }

    /**
     * Geeft de voortgang van de galg van de gebruiker
     *
     * @return
     */
    public String getCurrentWord() {
        return currentWord;
    }

    /**
     * Geeft het aantal fouten terug
     *
     * @return
     */
    public int getErrors() {
        return currentErrors;
    }

    /**
     * Geeft een waarde terug die de status van de galg aangeeft
     *
     * @return status
     */
    public int getStatus() {
        int maxErrors = 10;
        if (checkWord()) {
            return 1;
        } else if (currentErrors < maxErrors) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Kijkt of het woord geraden is
     *
     * @return
     */
    private boolean checkWord() {
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) != 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * Vervangt karakter in String
     * @param inputChar Karakter dat vervangen moet worden.
     */
    public void replaceCharacter(char inputChar) {
        StringBuilder sb = new StringBuilder(currentWord);
        boolean mistake = true;

        int index = currentWord.indexOf(inputChar);
        while(index > -1) {
            sb.setCharAt(index, 'Q');
            mistake = false;
            index = currentWord.indexOf(inputChar, index + 1);
        }
        currentWord = sb.toString();

        if (mistake) {
            currentErrors++;
        }
    }

}
