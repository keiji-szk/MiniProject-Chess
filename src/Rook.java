public class Rook extends Piece {
    static final int IMPORTANCE = 5;

    public Rook() {
        this(true);
    }

    public Rook(boolean isWhite) {
        super(isWhite, IMPORTANCE);
    }

    @Override
    public String toString() {
        return "Rook{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */
}