package oo5;

/**
 * @author Sébastiaan Versteeg // s4459636
 */

import oo5.controllers.QuizController;
import oo5.models.*;
import oo5.views.QuizView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Application.java
 * <p/>
 * Main application class
 */
public class Application {

    /**
     * Main application method
     *
     * @param args Not used
     */
    public static void main(String[] args) {
        Quiz q = new Quiz(getQuestions());
        QuizView quizView = new QuizView();
        QuizController controller = new QuizController(q, quizView);
        controller.startQuiz();
    }

    /**
     * Generate shuffled question list
     * @return Question list
     */
    private static List<Question> getQuestions() {
        List<Question> questionList = new ArrayList<Question>();
        questionList.add(new OpenQuestion(
                "Wat is de complexiteit van binair zoeken?",
                "O(log N)"
        ));
        questionList.add(new OpenQuestion(
                "Hoe lees je in Java een integer i uit een scanner s?",
                "i = s.nextInt();",
                2
        ));
        questionList.add(new OpenQuestion(
                "Hoeveel constructoren je minstens maken bij een klasse in Java?",
                "0",
                2
        ));

        questionList.add(new MultiChoiceQuestion(
            "Wat is de complexiteit van slim in situ sorteren?",
            new String[]{
                    "O(N^2)",
                    "O(N log N)",
                    "O(N)",
                    "O(log N)"},
            1,
            4
        ));
        questionList.add(new MultiChoiceQuestion(
            "Hoe print je \"Hello world\" op een regel in Java?",
            new String[]{
                    "System.out.print(\"Hello world\");",
                    "System.out.println(\"Hello world\");",
                    "cout << \"Hello world\";"},
            1
        ));
        questionList.add(new MultiChoiceQuestion(
            "Hoe lees je in Java een niet leeg woord uit scanner s?",
            new String[]{
                    "s.nextline()",
                    "s.next(\"\\S+\")",
                    "s.next(\"\\a*\")",
                    "s.next(\"\\S*\")",
                    "s.next(\"\\\\s+\")",
                    "s.next(\"\\s+\")",
                    "s.nextString(\"\\s*\")",
                    "s.next(\"\\\\S+\")",
                    "s.nextString()"},
            7,
            1
        ));

        questionList.add(new SingleChoiceQuestion(
            "Is er verschil tussen een interface en een abstracte klasse?",
            "Ja",
            "Nee",
            0,
            5
        ));
        questionList.add(new SingleChoiceQuestion(
            "Is er een maximum aantal constructoren van een klasse in Java?",
            "Nee",
            "Ja",
            0
        ));

        Collections.shuffle(questionList, new Random());

        return questionList;
    }

}
