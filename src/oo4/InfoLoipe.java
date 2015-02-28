package oo4;

/**
 * @author Sébastiaan Versteeg / s4459636
 */
public interface InfoLoipe {
    public int getWidth();

    public int getHeight();

    public Fragment getFragment(int x, int y);

    public Punt start();

    public Punt stap();
}
