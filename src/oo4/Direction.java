package oo4;

/**
 * @author Sébastiaan Versteeg / s4459636
 */
public enum Direction {
    N(0, -1), E(1, 0), S(0, 1), W(-1, 0);
    public final int dx, dy;

    private Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Direction turnLeft(Direction d) {
        switch (d) {
            case N:
                return Direction.W;
            case E:
                return Direction.N;
            case S:
                return Direction.E;
            case W:
                return Direction.S;
            default:
                return d;
        }
    }

    public static Direction turnRight(Direction d) {
        switch (d) {
            case N:
                return Direction.E;
            case E:
                return Direction.S;
            case S:
                return Direction.W;
            case W:
                return Direction.N;
            default:
                return d;
        }
    }
}
