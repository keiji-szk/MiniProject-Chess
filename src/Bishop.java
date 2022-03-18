public class Bishop extends Piece {
    static final int IMPORTANCE = 3;

    public Bishop() {
        this(true);
    }

    public Bishop(boolean isWhite) {
        super(isWhite, IMPORTANCE);
    }

    @Override
    public String toString() {
        return "Bishop{value='" + getValue() + "'}";
    }
    /*
    TODO: override isValidMove().
     */
}
