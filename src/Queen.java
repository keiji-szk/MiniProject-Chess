public class Queen extends Piece {
    static final int IMPORTANCE = 9;

    public Queen(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
    }

    @Override
    public String toString() {
        return "Queen{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */
}
