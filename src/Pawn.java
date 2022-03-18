public class Pawn extends Piece {
    static final int IMPORTANCE = 1;
    private boolean promoted;
    private Piece newPiece;

    public Pawn(int i, int i1, int i2) {
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

    // Field 兵
    @Override
    public void move(Position newPosition) {
        System.out.println("Moved Forward 1");
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(!super.isValidMove(newPosition, board))
            return false;
        if (this.curPos.getRow() - newPosition.getRow() != 0) {
            return false;
        }

        return true;
    }

    /**
     * Valid Move
     * I'm not sure is this correct? and the special rule,
     */

    public static void main(String[] args) {
        Piece p1 = new Pawn(0, 1, 1);
        System.out.println(p1.getValue());
        System.out.println(p1.getClass());

    }
}
