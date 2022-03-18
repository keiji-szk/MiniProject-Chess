public class Knight extends Piece {
    static final int IMPORTANCE = 2;

    public Knight() {
        this(true);
    }

    public Knight(boolean isWhite) {
        super(isWhite, IMPORTANCE);
    }

    @Override
    public String toString() {
        return "Knight{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */
}

