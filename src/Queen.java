public class Queen extends Piece {
    static final int IMPORTANCE = 9;

    public Queen(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
    }

    @Override
    public String toString() {
        return "Queen{value='" + getValue() + "'}";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(!super.isValidMove(newPosition, board))
            return false;

        // Queen can move horizontally and vertically. Check using rook's method.
        Rook rook = new Rook( isWhite(), curPos );
        if(rook.isValidMove(newPosition, board))
            return true;

        // Queen can move diagonally. Check using bishop's method.
        Bishop bishop = new Bishop( isWhite(), curPos);
        return bishop.isValidMove(newPosition, board);
    }
}
