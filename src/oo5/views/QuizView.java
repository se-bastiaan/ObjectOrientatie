package oo5.views;

/**
 * @author Sébastiaan Versteeg // s4459636
 */

import oo5.interfaces.QuestionPrinter;

import java.util.Scanner;

/**
 * QuizView.java
 * <p/>
 * A class where questions and answer are printed. This implements the {@link oo5.interfaces.QuestionPrinter} interface.
 */
public class QuizView implements QuestionPrinter {

    private Scanner scanner;

    public QuizView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void printQuestion(String string) {
        System.out.println(string);
    }

    @Override
    public void printAnswer(boolean correct, String answer) {
        if(correct) {
            System.out.println("That's correct!");
        } else {
            System.out.println("Uhoh. That is not the correct answer.");
            System.out.println("The correct answer is: " + answer + ".");
        }
        System.out.print("\n");
    }

    @Override
    public void presentScore(int score, int totalScore) {
        System.out.println("That was the quiz! Thank you for participating.");
        System.out.println("Your score was " + score + " out of " + totalScore);
    }

    @Override
    public boolean hasAnswer() {
        return scanner.hasNextLine();
    }

    @Override
    public String getAnswer() {
        return scanner.nextLine();
    }

}
