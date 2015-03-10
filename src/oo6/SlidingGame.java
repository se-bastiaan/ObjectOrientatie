package oo6;

import java.util.Collection;

/**
 * A template implementation of a sliding game also
 * implementing the Graph interface
 *
 * @author Pieter Koopman
 * @author Sjaak Smetsers
 * @author Sébastiaan Versteeg
 * @version 1.2
 * @date 28-02-2013
 */
public class SlidingGame implements Configuration {

    public static final int N = 3;
    public static final int SIZE = N * N;
    public static final int HOLE = SIZE;

    /**
     * The bord is represented by a 2-dimensional arrray;
     * the position of the hole is kept in 2 variables holeX and holeY
     */
    private int board[][];
    private int holeX;
    private int holeY;

    /**
     * A constructor that initialises the board with the specified array
     *
     * @param start: a one dimensional array containing the intial board.
     *               The elements of start are stored row-wise.
     */
    public SlidingGame(int[] start) {
        board = new int[N][N];

        if(start.length == N * N) {
            System.err.println("The length of specified board is incorrect.");
            return;
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                board[col][row] = start[row * N + col];
                if (board[col][row] == HOLE) {
                    holeX = col;
                    holeY = row;
                }
            }
        }
    }

    /**
     * Converts a bord into a printable representation.
     * The hole is displayed as a space
     *
     * @return the {@link String} representation
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzle = board[col][row];
                buf.append(puzzle == HOLE ? "  " : puzzle + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    /**
     * a standard implementation of equals checking
     * whether 2 boards are filled in exactly the same way
     *
     * @return a {@link boolean} indicating equality
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        } else {
            SlidingGame other_puzzle = (SlidingGame) o;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (board[col][row] != other_puzzle.board[col][row]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @Override
    public boolean isSolution() {
        // Write your own code here.
    }

    @Override
    public Collection<Configuration> successors() {
        // Write your own code here.
    }

    @Override
    public int compareTo(Configuration g) {
        // Write your own code here.
    }

}
