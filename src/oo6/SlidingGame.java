package oo6;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A template implementation of a sliding game also
 * implementing the Configuration interface
 *
 * @author Pieter Koopman
 * @author Sjaak Smetsers
 * @author Sébastiaan Versteeg // s4459636
 * @version 1.2
 * @date 28-02-2013
 */
public class SlidingGame implements Configuration {

    public static int N = 3;
    public static final int SIZE = N * N;
    public static final int HOLE = SIZE;

    /**
     * The bord is represented by a 2-dimensional arrray;
     * the position of the hole is kept in 2 variables holeX and holeY
     */
    private int board[][];
    private int manhattanDistance;
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

        if(start.length != N * N) {
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

        manhattanDistance = calculateManhattanDistance();
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

    /**
     * Check if this is a solution.
     * @return {@code true} if this is a solution.
     */
    @Override
    public boolean isSolution() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[col][row] != ((row * N) + (col + 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Get all successors of a {@link SlidingGame}
     * @return {@link Collection}
     */
    @Override
    public Collection<Configuration> successors() {
        Collection<Configuration> returnColl = new ArrayList<Configuration>();
        for(Direction d : Direction.values()) {
            int newX = holeX + d.getDX();
            int newY = holeY + d.getDY();
            if(newX >= N || newY >= N || newX < 0 || newY < 0) continue;

            int[] gameBoard = new int[SIZE];

            int val = board[newX][newY];
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if(newY == row && newX == col) {
                        gameBoard[row * N + col] = HOLE;
                    } else if(holeY == row && holeX == col) {
                        gameBoard[row * N + col] = val;
                    } else {
                        gameBoard[row * N + col] = board[col][row];
                    }
                }
            }

            returnColl.add(new SlidingGame(gameBoard));
        }
        return returnColl;
    }

    /**
     * Compute manhattan distance of current SlidingGame
     * @return
     */
    private int calculateManhattanDistance() {
        int manhattanDistanceSum = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int value = board[row][col];
                if (value == HOLE) {
                    int targetX = (value - 1) / N;
                    int targetY = (value - 1) % N;
                    int dx = row - targetX;
                    int dy = col - targetY;
                    manhattanDistanceSum += Math.abs(dx) + Math.abs(dy);
                }
            }
        }
        return manhattanDistanceSum;
    }

    /**
     * Getter for the manhattan distance
     * @return manhattan distance
     */
    public int getManhattanDistance() {
        return manhattanDistance;
    }

    /**
     * Compare two configurations
     * @param g Configuration
     * @return -1, 0, 1 depending on < > or ==
     */
    @Override
    public int compareTo(Configuration g) {
        if(g instanceof  SlidingGame) {
            SlidingGame game = (SlidingGame) g;
            return manhattanDistance - game.getManhattanDistance();
        }
        return 1;
    }

    /**
     * Calculate hashCode
     * @return hash code
     */
    @Override
    public int hashCode() {
        int hashCode = 0;
        for (int row = 0; row < N; row++)
            for (int col = 0; col < N; col++)
                hashCode += board[col][row] * Math.pow(31, col + row * N);
        return hashCode;
    }
}
