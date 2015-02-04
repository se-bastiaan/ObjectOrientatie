/**
 * @author Sébastiaan Versteeg // s4459636
 * @author Giel Besouw // s4483898
 */

/**
 * Groep.java
 * <p/>
 * Class to represent a group of students
 */
public class Groep {

    private Student[] studenten = new Student[0];
    private int currentIndex = 0;

    /**
     * Constructor for the Group class.
     *
     * Initialises the studenten field, value becomes a {@link Student} array with length {@param aantal}
     */
    public Groep(int aantal) {
        this.studenten  = new Student[aantal];
    }

    /**
     * Adds {@link Student} to the studenten array field.
     *
     * @param student {@link Student}
     * @return {@code true} if the student was successfully added, {@code false} if not
     */
    public boolean voegToe(Student student) {
        if(currentIndex < studenten.length) {
            studenten[currentIndex] = student;
            currentIndex++;
            return true;
        }
        return false;
    }

    /**
     * Get {@link Student} from the studenten array field.
     *
     * @param index Index of the student that should be returned
     * @return {@link Student}
     */
    public Student getStudent(int index) {
        if(currentIndex - 1 < index) return null;
        return studenten[index];
    }

}
