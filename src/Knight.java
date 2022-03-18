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

    //Field 騎士
    @Override
    public void move(Position newPosition) {
        System.out.println("Moved Like an L");
    }

    // Valid Move

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {

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
