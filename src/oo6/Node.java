package oo6;

import java.util.LinkedList;

/**
 * For maintaining lists of T-elements enabling
 * a structure suited for backwards traversal
 *
 * @author Pieter Koopman
 * @author Sjaak Smetsers
 * @author Sébastiaan Versteeg // s4459636
 * @version 1.2
 * @date 28-02-2013
 */
public class Node<T extends Comparable> implements Comparable<Node<T>> {

    // the data field
    private T item;
    // a reference to the predecessor
    private Node<T> previous;

    /**
     * A constructor that initializes each node
     * with the specified values
     *
     * @param from the node preceding the current node
     * @param item the initial data item
     */
    public Node(Node<T> from, T item) {
        this.previous = from;
        this.item = item;
    }

    /**
     * A getter for the item
     *
     * @return item {@link T}
     */
    public T getItem() {
        return item;
    }

    /**
     * A getter for the previous item
     *
     * @return previous {@link Node<T>}
     */
    public Node<T> getPrevious() {
        return previous;
    }

    /**
     * Determine the length of the current list
     *
     * @return the length as an integer
     */
    public int length() {
        int length = 1;
        Node<T> prev = previous;
        while (prev != null) {
            prev = prev.previous;
            length++;
        }
        return length;
    }

    /**
     * Node to string
     * @return {@link java.lang.String}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        LinkedList<T> config = new LinkedList<T>();
        Node<T> current = this;
        while(current != null) {
            config.addFirst(current.item);
            current = current.previous;
        }

        int size = config.size();
        for(int i = 0; i < size; i++) {
            T item = config.removeFirst();
            sb.append(i);
            sb.append(":\n");
            sb.append(item.toString());
        }

        sb.append('\n');

        return sb.toString();
    }

    /**
     * Compare two nodes, values of the nodes actually.
     * @param o {@link oo6.Node}
     * @return Compare result
     */
    @Override
    public int compareTo(Node<T> o) {
        return item.compareTo(o.getItem());
    }
}
