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

//        return (Math.abs(this.curPos.getRow() - newPosition.getRow())
//            == Math.abs(this.curPos.getCol() - newPosition.getCol()));

        // Bishop can move diagonally.
        if( Math.abs(newPosition.getCol() - curPos.getCol()) != Math.abs(newPosition.getRow() - curPos.getRow()))
            return false;

        // Check if there is no piece in the middle way.
        final int dirRow = curPos.getRow() < newPosition.getRow() ? 1 : -1;
        final int dirCol = curPos.getCol() < newPosition.getCol() ? 1 : -1;
        int checkRow = curPos.getRow() + dirRow;
        int checkCol = curPos.getCol() + dirCol;
        while(checkCol != newPosition.getCol() && checkRow != newPosition.getRow()){
            if(board[checkRow][checkCol] != null)
                return false;
            checkRow += dirRow;
            checkCol += dirCol;
        }

        Piece newPosPc = board[newPosition.getRow()][newPosition.getCol()];
        return (newPosPc == null) || newPosPc.isWhite() != isWhite();
    }
}
