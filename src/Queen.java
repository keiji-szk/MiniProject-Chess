public class Queen extends Piece {
    static final int IMPORTANCE = 9;

    public Queen() {
        this(true);
    }

    public Queen(boolean isWhite) {
        super(isWhite, IMPORTANCE);
    }

    @Override
    public String toString() {
        return "Queen{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */
}
