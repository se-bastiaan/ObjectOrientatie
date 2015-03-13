package oo6;

import java.util.Collection;

/**
 * An interface for representing (abstract) constant configurations, i.e.
 * configurations of which the structure cannot be changed.
 *
 * @author Sjaak Smetsers
 * @author Sébastiaan Versteeg // s4459636
 * @version 1.2
 * @since 28-02-2013
 */
public interface Configuration extends Comparable<Configuration> {

    /**
     * To obtain the successors for a specific (node of a) configuration
     *
     * @return a collection of configurations containing the successors
     */
    public Collection<Configuration> successors();

    /**
     * For marking final / goal Configuration.
     *
     * @return {@code true} when the {@link Configuration} is a solution for the problem. {@code false} if not.
     */
    public boolean isSolution();

}
