package oo4;

/**
 * @author Sébastiaan Versteeg / s4459636
 */
public class Loipe implements InfoLoipe {

    private Path path;
    private Fragment loipe[][];
    private Punt positions[];
    private int width = 0, height = 0, curPos = 0;

    public Loipe(String pathStr) {
        this.path = new Path(pathStr);
        this.width = this.path.getWidth();
        this.height = this.path.getHeight();

        this.loipe = new Fragment[this.width][this.height];
        this.positions = new Punt[this.path.length()];

        fillLoipe();
    }

    private void fillLoipe() {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                loipe[x][y] = null;
            }
        }

        Punt p = this.path.getStart();
        int x = p.getX(), y = p.getY();
        Direction curDirection = Direction.N;
        for(int i = 0; i < this.path.length(); i++) {
            Direction newDirection = this.path.getDirection(i);

            if(loipe[x][y] != null) {
                loipe[x][y] = Fragment.KR;
            } else {
                switch (curDirection) {
                    case N:
                        switch (newDirection) {
                            case N:
                            case S:
                                loipe[x][y] = Fragment.NZ;
                                break;
                            case W:
                                loipe[x][y] = Fragment.ZW;
                                break;
                            case E:
                                loipe[x][y] = Fragment.ZO;
                                break;
                        }
                        break;
                    case E:
                        switch (newDirection) {
                            case E:
                            case W:
                                loipe[x][y] = Fragment.OW;
                                break;
                            case N:
                                loipe[x][y] = Fragment.NW;
                                break;
                            case S:
                                loipe[x][y] = Fragment.ZW;
                                break;
                        }
                        break;
                    case S:
                        switch (newDirection) {
                            case N:
                            case S:
                                loipe[x][y] = Fragment.NZ;
                                break;
                            case W:
                                loipe[x][y] = Fragment.NW;
                                break;
                            case E:
                                loipe[x][y] = Fragment.NO;
                                break;
                        }
                        break;
                    case W:
                        switch (newDirection) {
                            case E:
                            case W:
                                loipe[x][y] = Fragment.OW;
                                break;
                            case N:
                                loipe[x][y] = Fragment.NO;
                                break;
                            case S:
                                loipe[x][y] = Fragment.ZO;
                                break;
                        }
                        break;
                }
            }

            x += newDirection.dx;
            y += newDirection.dy;
            curDirection = newDirection;

            this.positions[i] = new Punt(x, y);
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Fragment getFragment(int x, int y) {
        return loipe[x][y];
    }

    public void setFragment(int x, int y, Fragment f) {
        loipe[x][y] = f;
    }

    @Override
    public Punt start() {
        this.curPos = 0;
        return this.path.getStart();
    }

    @Override
    public Punt stap() {
        if(curPos >= positions.length) return null;

        Punt p = positions[curPos];
        curPos++;
        return p;
    }

}
