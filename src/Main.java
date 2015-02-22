import java.util.List;

/**
 * @author Sébastiaan Versteeg // s4459636
 * @author Giel Besouw // s4483898
 */
public class Main {

    /**
     * Invoked at start
     * @param args
     */
    public static void main(String[] args) {
        Board b = new Board(6); // Change the integer to change the board size
        Knight k = new Knight(new Position(0, 0)); // Change the position x/y to change the knight's start position
        List<Position> result = k.solveBoard(b, false); // Change the boolean to solve until a closed path is found (true) or not (false)
        if(result == null) {
            System.out.println("Could not solve board");
            return;
        }
        System.out.println("Moves: " + k.getAmountMoves());
        b.outputAllMoves(result);
    }

}
