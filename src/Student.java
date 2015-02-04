/**
 * @author Sébastiaan Versteeg // s4459636
 * @author Giel Besouw // s4483898
 */

/**
 * Student.java
 * <p/>
 * Class to represent a student with a first name, last name and number
 */
public class Student {

    private String firstName;
    private String lastName;
    private int studentNumber;

    /**
     * Constructor. Gives all fields a value.
     *
     * @param voor   First name of the student
     * @param achter Last name of the student
     * @param nummer Student number
     */
    public Student(String voor, String achter, int nummer) {
        setNaam(voor, achter);
        this.studentNumber = nummer;
    }

    /**
     * Set the values of the firstName and lastName fields.
     *
     * @param voor   First name of the student
     * @param achter Last name of the student
     */
    public void setNaam(String voor, String achter) {
        this.firstName = voor;
        this.lastName = achter;
    }

    /**
     * Create a human readable String with the data from the fields.
     *
     * @return Human readable string in the form '$firstName $lastName s$studentNumber'
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " s" + studentNumber;
    }

}