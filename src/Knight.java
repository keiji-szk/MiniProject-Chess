public class Knight extends Piece {

    static final int IMPORTANCE = 2;

    public Knight(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
    }

    @Override
    public String toString() {
        return "Knight{value='" + getValue() + "'}";
    }

    /*
    TODO: override isValidMove().
     */

    // Valid Move

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(!super.isValidMove(newPosition, board))
            return false;

        if (newPosition.getCol() == (this.curPos.getCol() + 2) && newPosition.getRow() == (this.curPos.getRow() + 1) ||
            newPosition.getCol() == (this.curPos.getCol() + 2) && newPosition.getRow() == (this.curPos.getRow() - 1) ||
            newPosition.getCol() == (this.curPos.getCol() - 2) && newPosition.getRow() == (this.curPos.getRow() + 1) ||
            newPosition.getCol() == (this.curPos.getCol() - 2) && newPosition.getRow() == (this.curPos.getRow() - 1) ||
            newPosition.getCol() == (this.curPos.getCol() + 1) && newPosition.getRow() == (this.curPos.getRow() + 2) ||
            newPosition.getCol() == (this.curPos.getCol() - 1) && newPosition.getRow() == (this.curPos.getRow() + 2) ||
            newPosition.getCol() == (this.curPos.getCol() + 1) && newPosition.getRow() == (this.curPos.getRow() - 2) ||
            newPosition.getCol() == (this.curPos.getCol() - 1) && newPosition.getRow() == (this.curPos.getRow() - 2)) {
            return true;
        } else {
            return false;
        }
    }
}
