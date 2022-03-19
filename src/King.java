public class King extends Piece {
    static final int IMPORTANCE = 1000;

    public King(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
    }

    @Override
    public String toString() {
        return "King{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */
}
