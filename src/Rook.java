public class Rook extends Piece {
    static final int IMPORTANCE = 5;

    public Rook(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
    }

    @Override
    public String toString() {
        return "Rook{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */
}