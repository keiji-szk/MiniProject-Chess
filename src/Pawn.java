public class Pawn extends Piece {
    static final int IMPORTANCE = 1;
    private boolean promoted;
    private Piece newPiece;

    public Pawn() {
        this(true);
    }

    public Pawn(boolean isWhite) {
        super(isWhite, IMPORTANCE);
        promoted = false;
        newPiece = null;
    }

    public void promote(Piece newPiece) throws Exception {
        if ((newPiece.getClass() != Queen.class) &&
                (newPiece.getClass() != Rook.class) &&
                (newPiece.getClass() != Bishop.class) &&
                (newPiece.getClass() != Knight.class)) {
            throw new Exception(newPiece.getClass() + " is invalid argument for promote() method");
        }

        promoted = true;
        this.newPiece = newPiece;
        this.newPiece.setWhite(isWhite());
        setValue(newPiece.getValue());
    }

    @Override
    public boolean equals(Object o) {
        Pawn piece = (Pawn) o;
        if (piece == null) {
            return false;
        }

        if (piece.promoted != promoted) {
            return false;
        }

        return piece.promoted ? newPiece.equals(piece.newPiece) : super.equals(o);
    }

    @Override
    public String toString() {
        return "Pawn{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */
}
