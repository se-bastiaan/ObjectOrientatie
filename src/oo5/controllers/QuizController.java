package oo5.controllers;


/**
 * @author Sébastiaan Versteeg // s4459636
 */

import oo5.models.Quiz;
import oo5.views.QuizView;

/**
 * Quiz.java
 * <p/>
 * A class representing an quiz where users are asked questions.
 */
public class QuizController {

    private Quiz q;
    private QuizView v;

    /**
     * Contructor of the QuizController
     * @param q {@link Quiz}
     * @param v {@link QuizView}
     */
    public QuizController(Quiz q, QuizView v) {
        this.q = q;
        this.v = v;
    }

    /**
     * Run a quiz
     */
    public void startQuiz() {
        while(q.hasNextQuestion()) {
            String question = q.nextQuestion();
            v.printQuestion(question);
            while(!v.hasAnswer()) { }
            String answer = v.getAnswer();
            boolean correct = q.checkAnswer(answer, true);
            v.printAnswer(correct, q.getCorrectAnswer());
        }
        v.presentScore(q.getScore(), q.getTotalScore());
    }

}
