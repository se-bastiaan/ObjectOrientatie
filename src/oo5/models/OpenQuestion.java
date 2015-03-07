package oo5.models;

/**
 * @author Sébastiaan Versteeg // s4459636
 */

/**
 * OpenQuestion.java
 * <p/>
 * A class representing one question that has weight and a correct answer. It is a open question, so there are no options for the user.
 */
public class OpenQuestion extends Question {

    private String answer;

    /**
     * Open Question constructor
     * @param question Question as {@link java.lang.String}
     * @param answer Answer as {@link java.lang.String}
     * @param weight Weight of the question as {@link java.lang.Integer}
     */
    public OpenQuestion(String question, String answer, int weight) {
        super(question, weight);
        this.answer = answer;
    }

    /**
     * Second open question constructor, calls the first
     */
    public OpenQuestion(String question, String answer) {
        this(question, answer, 3);
    }

    @Override
    public String getCorrectAnswer() {
        return this.answer;
    }

    @Override
    public boolean isCorrect(String answer) {
        return getCorrectAnswer().equalsIgnoreCase(answer);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
