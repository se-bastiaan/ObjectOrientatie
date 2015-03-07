package oo5.models;

/**
 * @author Sébastiaan Versteeg // s4459636
 */

import java.util.List;

/**
 * Quiz.java
 * <p/>
 * A class representing an quiz that has questions that can be asked and checked
 */
public class Quiz {

    private List<Question> questions;
    private Question currentQuestion;
    private int totalScore;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Check an answer.
     * @param answer The answer
     * @param readd If {@code true} and when the answer is not correct, then the question will be added to the end of the list.
     * @return {@code true} if correct, {@code false} if not correct
     */
    public boolean checkAnswer(String answer, boolean readd) {
        boolean correct = currentQuestion.isCorrect(answer);

        if(!correct && readd && !questions.get(questions.size() - 1).equals(currentQuestion)) {
            questions.add(currentQuestion);
        } else if(correct) {
            score += currentQuestion.getWeight();
        }

        return correct;
    }

    /**
     * Load the next question
     * @return Question in text
     */
    public String nextQuestion() {
        if(questions.size() <= 0) return null;
        currentQuestion = questions.get(0);
        totalScore += currentQuestion.getWeight();
        questions.remove(0);
        return currentQuestion.toString();
    }

    /**
     * Check if there is a next question.
     * @return {@code true} if there is a next question, {@code false} if not
     */
    public boolean hasNextQuestion() {
        return questions.size() > 0;
    }

    /**
     * @return The correct answer
     */
    public String getCorrectAnswer() {
        return currentQuestion.getCorrectAnswer();
    }

    /**
     * Get total possible score
     * @return Score
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Get score
     * @return Score
     */
    public int getScore() {
        return score;
    }

}
