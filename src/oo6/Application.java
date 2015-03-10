package oo6;

/**
 * @author Name 1 // s.......
 * @author Name 2 // s.......
 */
public class Application
{

    public static void main(String[] args) {
        int [] game = {1,2,3, 4,5,6, 7,9,8};

        SlidingGame s = new SlidingGame (game);
        System.out.println(s);

        /*
        oo6.Solver solver = new oo6.Solver(s);
        System.out.println(solver.solve());
        */
    }
}
