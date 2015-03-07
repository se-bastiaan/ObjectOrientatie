package oo5.models;
/**
 * @author Sébastiaan Versteeg // s4459636
 */

/**
 * MultiQuestion.java
 * <p/>
 * A class representing one question that has weight and a correct answer. It is a multiple choice question, so there are multiple answers the user can choose from.
 * Extends {@link Question}
 */
public class SingleChoiceQuestion extends MultiChoiceQuestion {

    /**
     * Choice question constructor
     * @param question Question as {@link java.lang.String}
     * @param answer1 Possible answer 1 as {@link java.lang.String}
     * @param answer2 Possible answer 2 as {@link java.lang.String}
     * @param correctAnswer Correct answer in the list (0 or 1)
     * @param weight Weight of the question
     */
    public SingleChoiceQuestion(String question, String answer1, String answer2, int correctAnswer, int weight) {
        super(question, new String[]{answer1, answer2}, correctAnswer, weight);
    }

    /**
     * Second choice question constructor, calls the first
     */
    public SingleChoiceQuestion(String question, String answer1, String answer2, int correctAnswer) {
        this(question, answer1, answer2, correctAnswer, 3);
    }

    @Override
    public String getCorrectAnswer() {
        return possibleAnswers[correctAnswer];
    }

    @Override
    public boolean isCorrect(String answer) {
        return answer.equalsIgnoreCase(possibleAnswers[correctAnswer]);
    }

    @Override
    public Question getDuplicate() {
        return this;
    }

    @Override
    public String toString() {
        return possibleAnswers[0] + " or " + possibleAnswers[1] + ": " + question;
    }

}
