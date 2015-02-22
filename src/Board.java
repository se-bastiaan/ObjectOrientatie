import java.util.List;

/**
 * @author Sébastiaan Versteeg // s4459636
 * @author Giel Besouw // s4483898
 */
public class Board {

    private final String NOT_VISITED = " ";
    private final String VISITED = ".";
    private final String KNIGHT = "K";

    private int mSize, mPositionsVisited;
    private boolean[][] mBoard;

    public Board(int size) {
        mPositionsVisited = 0;
        mSize = size;
        mBoard = initBoard(size);
    }

    private boolean[][] initBoard(int size) {
        boolean[][] board = new boolean[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                board[y][x] = false;
            }
        }
        return board;
    }

    /**
     * Check if the position is valid
     *
     * @param p {@link Position}
     * @return {@code true} if the position is valid, {@code false} if the position is out of bounds
     */
    public boolean isValidPosition(Position p) {
        int x = p.getX();
        int y = p.getY();

        return !(x < 0 || y < 0 || x >= mSize || y >= mSize);
    }

    /**
     * Get state of position
     *
     * @param p {@link Position}
     * @return {@code true} if the position has been visited, {@code false} if the position has not
     */
    public boolean getPositionState(Position p) {
        if (!isValidPosition(p)) {
            throw new IndexOutOfBoundsException("The provided position does not exist in this board.");
        }
        return mBoard[p.getY()][p.getX()];
    }

    /**
     * Set state of position
     *
     * @param p     {@link Position}
     * @param state {@code true} if the position is visited, {@code false} if the position is not
     */
    public void setPositionState(Position p, boolean state) {
        if (!isValidPosition(p)) {
            throw new IndexOutOfBoundsException("The provided position does not exist in this board.");
        }

        int x = p.getX();
        int y = p.getY();

        if (mBoard[y][x] != state) {
            // Increase visit count for true states, decrease for false
            if (state) {
                mPositionsVisited++;
            } else {
                mPositionsVisited--;
            }
        }

        mBoard[y][x] = state;
    }

    /**
     * @return Board size
     */
    public int getSize() {
        return mSize * mSize;
    }

    /**
     * Print all moves
     * @param moves list of moves
     */
    public void outputAllMoves(List<Position> moves) {
        Position initial = moves.get(0);
        moves.remove(0);

        Board b = new Board(mSize);
        Knight k = new Knight(initial);
        setPositionState(initial, true);

        int i = 1;
        System.out.println("1: " + (initial.getX()) + "," + (initial.getY()));
        System.out.println(b.buildString(k));
        for (Position move : moves) {
            System.out.println(i + ": " + (move.getX()) + "," + (move.getY()));
            k.moveToPosition(b, move);
            System.out.println(b.buildString(k));
            i++;
        }
    }

    private String buildString() {
        return buildString(null);
    }

    private String buildString(Knight knight) {
        Position knight_position = null != knight ? knight.getPosition() : null;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < (mSize * 4) + 1; i++) {
            sb.append("-");
        }
        sb.append('\n');
        String hr = sb.toString();

        sb = new StringBuilder();
        for(int y = 0; y < mSize; y++) {
            sb.append(hr);
            sb.append("| ");
            for(int x = 0; x < mSize; x++) {
                if(knight_position != null && knight_position.getX() == x && knight_position.getY() == y) {
                    sb.append(KNIGHT);
                } else if(getPositionState(new Position(x, y))) {
                    sb.append(VISITED);
                } else {
                    sb.append(NOT_VISITED);
                }
            }
            sb.append(" |");
            sb.append('\n');
        }
        sb.append(hr);

        return sb.toString();
    }

    @Override
    public String toString() {
        return buildString();
    }

}