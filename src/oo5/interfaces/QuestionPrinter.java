package oo5.interfaces;

/**
 * Interface that represents a UI for a quiz
 */
public interface QuestionPrinter {
    /**
     * Invoked when a new question needs to be printed
     * @param string Question
     */
    public void printQuestion(String string);

    /**
     * Invoked when a result of an answer is obtained, gives feedback to the user (correct or not correct) and the correct answer.
     * @param correct
     * @param answer
     */
    public void printAnswer(boolean correct, String answer);

    /**
     * Invoked when the quiz is done. Prints the score and the possible total score.
     * @param score Score
     * @param totalScore Total score
     */
    public void presentScore(int score, int totalScore);

    /**
     * Can be invoked by a controller to know when a new answer is available
     * @return {@code true} if a new answer is availabe, {@code false} if not
     */
    public boolean hasAnswer();

    /**
     * Returns the answer to the invoking parent
     * @return The obtained answer
     */
    public String getAnswer();
}
