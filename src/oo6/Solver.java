package oo6;

import java.util.*;

/**
 * A class that implements a breadth-first search algorithm
 * for finding the Configuration for which the isSolution predicate holds
 *
 * @author Pieter Koopman
 * @author Sjaak Smetsers
 * @author Sébastiaan Versteeg // s4459636
 * @version 1.4
 * @since 28-02-2013
 */
public class Solver {

    // A queue for maintaining configurations that have not been visited yet.
    Queue<Node<Configuration>> toExamine = new PriorityQueue<Node<Configuration>>();
    // Visited configurations compared on hash
    HashSet<Configuration> visited = new HashSet<Configuration>();

    public Solver(Configuration g) {
        Node<Configuration> startNode = new Node<Configuration>(null, g);
        toExamine.add(startNode);
        visited.add(g);
    }

    /**
     * A skeleton implementation of the solver
     *
     * @return a string representation of the solution
     */
    public String solve() {
        while (!toExamine.isEmpty()) {
            Node<Configuration> next = toExamine.remove();
            Configuration config = next.getItem();
            if (config.isSolution()) {
                return "Success! Solution found. Steps: \n" + next.toString();
            } else {
                for (Configuration successor : config.successors()) {
                    Node<Configuration> newNode = new Node<Configuration>(next, successor);
                    if(visited.add(successor))
                        toExamine.add(newNode);
                }
            }
        }
        return "Failure!";
    }

}
