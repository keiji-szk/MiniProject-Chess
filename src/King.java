public class King extends Piece {
    static final int IMPORTANCE = 1000;

    public King() {
        this(true);
    }

    public King(boolean isWhite) {
        super(isWhite, IMPORTANCE);
    }

    @Override
    public String toString() {
        return "King{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */
}
