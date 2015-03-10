package oo6;

import java.util.Queue;

/**
 * A class that implements a breadth-first search algorithm
 * for finding the Graphs for which the isGoal predicate holds
 *
 * @author Pieter Koopman
 * @author Sjaak Smetsers
 * @author Sébastiaan Versteeg
 * @version 1.4
 * @since 28-02-2013
 */
public class Solver {
    // A queue for maintaining configurations that have not been visited yet.
    Queue<Configuration> toExamine;

    public Solver(Configuration g) {
        // Write your own code here.
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            if (next.isSolution()) {
                return "Succes!";
            } else {
                for (Configuration succ : next.successors()) {
                    toExamine.add(succ);
                }
            }
        }
        return "Failure!";
    }

}
