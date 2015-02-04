/**
 * @author Sébastiaan Versteeg // s4459636
 * @author Giel Besouw // s4483898
 */

import java.util.Scanner;

/**
 * Application.java
 *
 * This class represents the application.
 */
public class Application {

    private Scanner scanner;
    private Groep group = new Groep(0);
    private int groupSize = 0;

    /**
     * The main method of the application. Is invoked at start.
     * @param args Unused arguments
     */
    public static void main(String[] args) {
        new Application();
    }

    /**
     * Application constructor
     *
     * Initialises scanner and executes methods
     */
    public Application() {
        scanner = new Scanner (System.in);

        System.out.println("Welkom. De student groep applicatie is gestart.");
        createGroup();
        System.out.print('\n');
        getGroupContents();
        System.out.print('\n');
        waitForNewData();
        System.out.println("De student groep applicatie wordt gesloten.");
    }

    /**
     * Ask user for student group size and set the value of the group field to a {@link Groep} of this size
     */
    private void createGroup() {
        System.out.println("Wat moet de grootte van de groep zijn?");
        while(!scanner.hasNextInt()) {
            System.out.println("De waarde die je hebt ingevoerd is niet geldig. Voer a.u.b. een getal in.");
        }

        groupSize = scanner.nextInt();
        group = new Groep(groupSize);
        System.out.println("Gelukt! De groep is aangemaakt.");
    }

    /**
     * Ask the user for the data of every student of the group and add this student to the group
     */
    private void getGroupContents() {
        System.out.println("Voer nu een voor een de gegevens in van de studenten in de groep.");
        for(int i = 0; i < groupSize; i++) {
            System.out.println("Voornaam:");
            scanner.nextLine(); // Skip System.out.println
            String firstName = scanner.nextLine();
            System.out.println("Achternaam:");
            String lastName = scanner.nextLine();
            System.out.println("Studentnummer:");
            while(!scanner.hasNextInt()) {
                System.out.println("De waarde die je hebt ingevoerd is niet geldig. Voer a.u.b. een getal in.");
            }
            int studentNumber = scanner.nextInt();
            System.out.print('\n');

            Student student = new Student(firstName, lastName, studentNumber);
            if(!group.voegToe(student)) {
                break;
            }
        }
        printGroupContents();
    }

    /**
     * Print all contents of the group.
     */
    private void printGroupContents() {
        System.out.println("De groep bevat nu:");
        for(int i = 0; i < groupSize; i++) {
            System.out.println(i + ": " + group.getStudent(i).toString());
        }
    }

    /**
     * Ask user for index
     * If positive and valid: give the possibility to change the student name
     * If negative: break
     */
    private void waitForNewData() {
        while(true) {
            System.out.println("Voor een index in om de gegevens van een student te veranderen.");

            if(!scanner.hasNextInt()) {
                System.out.println("De waarde die je hebt ingevoerd is niet geldig. Voer a.u.b. een getal in.");
                continue;
            }
            int value = scanner.nextInt();
            if(value > groupSize - 1) {
                System.out.println("De waarde die je hebt ingevoerd is niet geldig. Voer a.u.b. een getal onder de " + groupSize + "  in.");
                continue;
            }

            if(value < 0) {
                break;
            }

            System.out.println("Voer nu de nieuwe gegevens in.");
            System.out.println("Voornaam:");
            scanner.nextLine(); // Skip System.out.println
            String firstName = scanner.nextLine();
            System.out.println("Achternaam:");
            String lastName = scanner.nextLine();
            group.getStudent(value).setNaam(firstName, lastName);
            System.out.print('\n');

            printGroupContents();
            System.out.print('\n');
        }
    }

}
