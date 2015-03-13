package oo6;

/**
 * @author Sébastiaan Versteeg // s4459636
 */
public class Application
{

    public static void main(String[] args) {
        int [] game = {2,9,3, 1,5,6, 4,7,8};

        SlidingGame s = new SlidingGame(game);
        System.out.println(s);

        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }

}
