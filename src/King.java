public class King extends Piece {
    static final int IMPORTANCE = 1000;

    public King(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
    }

    @Override
    public String toString() {
        return "King{value='" + getValue() + "'}";
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(!super.isValidMove(newPosition, board))
            return false;

        //King can't move more than one square horizontally, vertically, and diagonally.
        if( 1 < (Math.abs(newPosition.getCol() - curPos.getCol())) ||
             1 < (Math.abs(newPosition.getRow() - curPos.getRow())) ){
            return false;
        }

        //King can't move to a place where it will be taken by enemy.
        for (int i = 0 ; i < Game.BOARD_ROW ; i++) {
            for (int j = 0 ; j < Game.BOARD_COL ; j++) {
                Piece enemy = board[i][j];
                if(enemy == null)
                    continue;
                if(enemy.isWhite() == isWhite())
                    continue;
                if(enemy.isValidMove(newPosition, board))
                    return false;
            }
        }

        return true;
    }
}
