/**
 * @author Sébastiaan Versteeg // s4459636
 * @author Giel Besouw // s4483898
 */
public class Position {

    private int mX;
    private int mY;
    private int mNextMoves;
    private double mDistance;

    public Position(int x, int y) {
        mX = x;
        mY = y;
        mNextMoves = 0;
        mDistance = 0;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public void setX(int x) {
        mX = x;
    }

    public void setY(int y) {
        mY = y;
    }

    public void setNextMoves(int moves) {
        mNextMoves = moves;
    }

    public int getNextMoves() {
        return mNextMoves;
    }

    public void setDistance(double distance) {
        mDistance = distance;
    }

    public double getDistance() {
        return mDistance;
    }

}
