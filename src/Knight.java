import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sébastiaan Versteeg // s4459636
 * @author Giel Besouw // s4483898
 */
public class Knight {

    private final Position[] INITIAL_MOVES = {new Position(1, 2), new Position(1, -2), new Position(2, 1), new Position(2, -1), new Position(-1, 2), new Position(-1, -2), new Position(-2, 1), new Position(-2, -1)};

    private Position mPosition;
    private List<Position> mMoves = new ArrayList<Position>();
    private int mIterations = 0;

    public Knight(Position p) {
        mPosition = p;
        for (int i = 0; i < INITIAL_MOVES.length; i++) {
            mMoves.add(INITIAL_MOVES[i]);
        }
    }

    /**
     * Move to position on board
     * @param b {@link Board}
     * @param position {@link Position}
     */
    public void moveToPosition(Board b, Position position) {
        boolean valid = false;

        for (Position move : mMoves) {
            if (mPosition.getX() + move.getX() == position.getX() && mPosition.getY() + move.getY() == position.getY()) {
                valid = true;
                break;
            }
        }

        if (!b.isValidPosition(position) || b.getPositionState(position)) {
            valid = false;
        }

        if (!valid) {
            return;
        }

        b.setPositionState(position, true);
        mPosition = position;
    }

    /**
     * Get current position
     *
     * @return {@link Position}
     */
    public Position getPosition() {
        return mPosition;
    }

    /**
     * @return Get the amount of moves
     */
    public int getAmountMoves() {
        return mIterations;
    }

    /**
     * Solve the board!
     * @param board {@link Board}
     * @param closed Path should be closed if {@code true}
     * @return All used moves
     */
    public List<Position> solveBoard(Board board, boolean closed) {
        List<Position> moves = new ArrayList<Position>();
        mIterations = 0;
        if (board.isValidPosition(mPosition) && solveStep(board, moves, mPosition)) {
            if(closed) {
                if (moves.get(0) == moves.get(moves.size() - 1)) {
                    return moves;
                } else {
                    return solveBoard(board, closed);
                }
            } else {
                return moves;
            }
        }
        return null;
    }

    /**
     * Try one step
     * @param board {@link Board}
     * @param moves All previous moves
     * @param pos {@link Position}
     * @return Step solved puzzle
     */
    private boolean solveStep(Board board, List<Position> moves, Position pos) {
        mIterations++;
        moves.add(pos);
        board.setPositionState(pos, true);
        mPosition = pos;
        if (moves.size() == board.getSize()) {
            return true; // Solved
        }

        List<Position> nextSteps = findNextSteps(board);
        for (Position step : nextSteps) {
            if (solveStep(board, moves, step)) return true;
        }

        board.setPositionState(pos, false);
        moves.remove(moves.size() - 1);
        mPosition = pos;
        return false;
    }

    /**
     * Find next steps
     * @param board {@link Board}
     * @return List of possible next positions
     */
    private List<Position> findNextSteps(Board board) {
        List<Position> steps = new ArrayList<Position>();

        /*for (Position move : mMoves) {
            int x = mPosition.getX() + move.getX();
            int y = mPosition.getY() + move.getY();
            Position pos = new Position(x, y);
            if (!board.isValidPosition(pos) || board.getPositionState(pos)) {
                continue;
            }
            steps.add(pos);
        }*/

        double widthCenter	= (board.getSize()-1)/2;
        double heightCenter = (board.getSize()-1)/2;

        for (Position move : mMoves) {
            int x = mPosition.getX() + move.getX();
            int y = mPosition.getY() + move.getY();
            Position pos = new Position(x, y);
            if (!board.isValidPosition(pos) || board.getPositionState(pos)) {
                continue;
            }
            // Count available next moves
            int nextMoves = 0;
            for (Position subMove : mMoves) {
                int nextX = x + subMove.getX();
                int nextY = y + subMove.getY();
                Position nextPos = new Position(nextX, nextY);
                if (!board.isValidPosition(nextPos) || board.getPositionState(nextPos)) {
                    continue;
                }
                nextMoves++;
            }
            pos.setNextMoves(nextMoves);

            // Measure distance to center
            double distanceX = Math.abs(widthCenter - x);
            double distanceY = Math.abs(heightCenter - y);
            pos.setDistance(Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)));

            steps.add(pos);
        }

        Collections.sort(steps, new Comparator<Position>() {
            @Override
            public int compare(Position pos1, Position pos2) {
                if(pos1.getNextMoves() == pos2.getNextMoves()) {
                    if(pos1.getDistance() == pos2.getDistance()) {
                        return 0;
                    }
                    return (pos1.getDistance() < pos2.getDistance()) ? -1 : 1;
                }
                return (pos1.getNextMoves() < pos2.getNextMoves()) ? -1 : 1;
            }
        });

        return steps;
    }

}
