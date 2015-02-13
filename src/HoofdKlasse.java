import java.util.Scanner;

/**
 * @author Giel Besouw - s4483898
 * @author Sébastiaan Versteeg - s???????
 */
public class HoofdKlasse {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        welcomeMessage();
        while (true) {
            Galg g = new Galg();
            Scanner s = new Scanner(System.in);
            questionLoop(g);
            System.out.println("Do you want to play another game?");
            if (s.next().charAt(0) == 'n') {
                break;
            }
        }

    }

    /**
     * Toont het welkomstbericht
     */
    private static void welcomeMessage() {
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Welcome to Galgje!");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    /**
     * Deze functie is de body van het spel.
     *
     * @param g De galg waarmee gewerkt wordt.
     */
    private static void questionLoop(Galg g) {
        int characterCount = 0;// Dit is voor het tellen van de characters om te weten hoeveel backspaces er geplaatst moeten worden.
        Scanner reader = new Scanner(System.in);
        while (true) {
            for (int i = 0; i < characterCount; i++) {
                System.out.println('\b');
            }
            System.out.println(constructGalg(g));
            for (int i = 0; i < g.getToGuessWord().length(); i++) {
                if (g.getCurrentWord().charAt(i) == 'Q') {
                    System.out.print(g.getToGuessWord().charAt(i));
                } else {
                    System.out.print('.');
                }
                characterCount++;
            }


            if (g.getStatus() == 1) {
                printSuccessMessage();
                break;
            } else if (g.getStatus() == -1) {
                System.out.println("\nYou failed!");
                break;
            } else {
                System.out.println("\nPlease enter your character");
                char c = reader.next().charAt(0);
                g.replaceCharacter(c);
            }


        }


    }

    private static void printSuccessMessage() {
        System.out.println();
        System.out.println();
        System.out.println("You won, well done!");
    }

    private static String constructGalg(Galg g) {
        switch (g.getErrors()) {
            case 0:
                return "\n                      \n"
                        + "                      \n"
                        + "                      \n"
                        + "                      \n"
                        + "                      \n"
                        + "                      \n"
                        + " _____________________\n"
                        + " |                  | "
                        ;
            case 1:
                return "\n                      \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|_____________________\n"
                        + " |                  | ";
            case 2:
                return "\n________________      \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|_____________________\n"
                        + " |                  | ";
            case 3:
                return "\n________________      \n"
                        + "| /                   \n"
                        + "|/                    \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|_____________________\n"
                        + " |                  | ";
            case 4:
                return "\n________________      \n"
                        + "| /            |      \n"
                        + "|/             O      \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "______________________\n"
                        + " |                  | ";
            case 5:
                return "\n________________      \n"
                        + "| /            |      \n"
                        + "|/             O      \n"
                        + "|              |      \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "|_____________________\n"
                        + " |                  | ";
            case 6:
                return "\n________________      \n"
                        + "| /            |      \n"
                        + "|/             O      \n"
                        + "|             -|      \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "______________________\n"
                        + " |                  | ";
            case 7:
                return "\n________________      \n"
                        + "| /            |      \n"
                        + "|/             O      \n"
                        + "|             -|-     \n"
                        + "|                     \n"
                        + "|                     \n"
                        + "______________________\n"
                        + " |                  | ";
            case 8:
                return "\n________________      \n"
                        + "| /            |      \n"
                        + "|/             O      \n"
                        + "|             -|-     \n"
                        + "|             |       \n"
                        + "|                     \n"
                        + "______________________\n"
                        + " |                  | ";
            case 9:
                return "\n________________      \n"
                        + "| /            |      \n"
                        + "|/             O      \n"
                        + "|             -|-     \n"
                        + "|             | |     \n"
                        + "|                     \n"
                        + "______________________\n"
                        + " |                  | ";
            case 10:
                return "\n________________      \n"
                        + "| /            |      \n"
                        + "|/             O      \n"
                        + "|    DEAD     -|-     \n"
                        + "|             | |     \n"
                        + "|                     \n"
                        + "______________________\n"
                        + " |                  | ";
            default:
                return "An error has occured.";
        }

    }
}
