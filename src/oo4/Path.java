package oo4;

/**
 * @author Sébastiaan Versteeg / s4459636
 */
public class Path {

    private Direction[] directions;
    private String path;
    private int xCur = 0, yCur = 0, xMin = 0, xMax = 0, yMin = 0, yMax = 0;

    public Path(String path) {
        this.path = path;
        calculate();
    }

    private void calculate() {
        Direction d = Direction.N;

        directions = new Direction[this.path.length()];

        int i = 0;
        for(char c : this.path.toCharArray()) {
            switch(c) {
                case 'l':
                    d = Direction.turnLeft(d);
                    break;
                case 'r':
                    d = Direction.turnRight(d);
                    break;
            }

            xCur += d.dx;
            yCur += d.dy;

            if(xCur < xMin) {
                xMin = xCur;
            } else if(xCur > xMax) {
                xMax = xCur;
            }

            if(yCur < yMin) {
                yMin = yCur;
            } else if(yCur > yMax) {
                yMax = yCur;
            }

            directions[i] = d;
            i++;
        }
    }

    public int getWidth() {
        return Math.abs(xMax - xMin) + 1;
    }

    public int getHeight() {
        return Math.abs(yMax - yMin) + 1;
    }

    public Direction getDirection(int i) {
        return directions[i];
    }

    public int length() {
        return this.path.length();
    }

    public Punt getStart() {
        return new Punt(-xMin, -yMin);
    }

}
