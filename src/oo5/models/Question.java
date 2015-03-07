package oo5.models;

/**
 * @author Sébastiaan Versteeg // s4459636
 */

/**
 * Question.java
 * <p/>
 * An abstract class representing one question that has weight and a correct answer.
 */
public abstract class Question {

    protected String question = "";
    protected int weight = 3;

    /**
     * Question contructor
     * @param question String question
     * @param weight Question weight
     */
    public Question(String question, int weight) {
        this.question = question;
        this.weight = weight;
    }

    /**
     * @return Get the weight of the question
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return Get the correct answer
     */
    public abstract String getCorrectAnswer();

    /**
     * Check if the given answer is correct
     *
     * @param answer Given answer
     * @return {@code true} if the answer is correct, {@code false} if the answer is not.
     */
    public abstract boolean isCorrect(String answer);

    public Question getDuplicate() {
        return this;
    }

    @Override
    public String toString() {
        return this.question;
    }

}
