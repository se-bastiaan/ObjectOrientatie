package oo5.models;
/**
 * @author Sébastiaan Versteeg // s4459636
 */

import java.util.Random;

/**
 * MultiQuestion.java
 * <p/>
 * A class representing one question that has weight and a correct answer. It is a multiple choice question, so there are multiple answers the user can choose from.
 * Extends {@link Question}
 */
public class MultiChoiceQuestion extends Question {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    protected String[] possibleAnswers;
    protected int correctAnswer;

    /**
     * Multiple choice question constructor
     * @param question Question as {@link java.lang.String}
     * @param answers Possible answers
     * @param correctAnswer Index of the correct answer in the list
     * @param weight Weight of the question
     */
    public MultiChoiceQuestion(String question, String[] answers, int correctAnswer, int weight) {
        super(question, weight);

        this.possibleAnswers = answers;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Second multiple choice question constructor, calls the first
     */
    public MultiChoiceQuestion(String question, String[] answers, int correctAnswer) {
        this(question, answers, correctAnswer, 3);
    }

    @Override
    public String getCorrectAnswer() {
        return "" + ALPHABET.charAt(correctAnswer);
    }

    @Override
    public boolean isCorrect(String answer) {
        return ALPHABET.indexOf(answer) == correctAnswer;
    }

    @Override
    public Question getDuplicate() {

        Random random = new Random();
        int length = possibleAnswers.length;

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(i + 1);

            if(i == correctAnswer) {
                correctAnswer = index;
            }

            String a = possibleAnswers[index];
            possibleAnswers[index] = possibleAnswers[i];
            possibleAnswers[i] = a;
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + "\n");
        for (int i = 0; i < possibleAnswers.length; i++) {
            sb.append(String.format("%s. %s", ALPHABET.charAt(i), possibleAnswers[i]));
            if(i != possibleAnswers.length - 1) sb.append("\n");
        }
        return sb.toString();
    }

}
