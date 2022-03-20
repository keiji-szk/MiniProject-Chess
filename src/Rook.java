public class Rook extends Piece {
    static final int IMPORTANCE = 5;

    public Rook(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
    }

    @Override
    public String toString() {
        return "Rook{value='" + getValue() + "'}";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(!super.isValidMove(newPosition, board))
            return false;

        if(newPosition.getCol() == curPos.getCol()) {
            // Rook can move vertically. Check if there is no piece in the middle way.
            final int dirRow = curPos.getRow() < newPosition.getRow() ? 1 : -1;
            int checkRow = curPos.getRow() + dirRow;
            while (checkRow != newPosition.getRow()) {
                if (board[checkRow][curPos.getCol()] != null)
                    return false;
                checkRow += dirRow;
            }
        }
        else if(newPosition.getRow() == curPos.getRow())
        {
            // Rook can move horizontally. Check if there is no piece in the middle way.
            final int dirCol = curPos.getCol() < newPosition.getCol() ? 1 : -1;
            int checkCol = curPos.getCol() + dirCol;
            while(checkCol != newPosition.getCol()){
                if(board[curPos.getRow()][checkCol] != null)
                    return false;
                checkCol += dirCol;
            }
        }
        else
        {
            return false;
        }

        Piece newPosPc = board[newPosition.getRow()][newPosition.getCol()];
        return (newPosPc == null) || newPosPc.isWhite() != isWhite();
    }
}