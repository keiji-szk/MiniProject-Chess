public class Bishop extends Piece {

    static final int IMPORTANCE = 3;

    public Bishop(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
    }

    @Override
    public String toString(){
        return "Bishop{value='" + getValue() + "'}";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if (!super.isValidMove(newPosition, board))
            return false;

        return (Math.abs(this.curPos.getRow() - newPosition.getRow())
            == Math.abs(this.curPos.getCol() - newPosition.getCol()));
    }
}
