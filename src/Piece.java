import java.util.Objects;


public abstract class Piece {
    private int value;
    private boolean isWhite;
    protected Position curPos;

    public Piece(boolean isWhite, int value, Position pos) {
        this.isWhite = isWhite;
        this.value = value;
        this.curPos = pos;
    }

    @Override
    abstract public String toString();

    public boolean move(Position newPosition, Piece[][] board ){
        if(!isValidMove(newPosition, board)){
            return false;
        }

        board[newPosition.getRow()][newPosition.getCol()] = this;
        board[curPos.getRow()][curPos.getCol()] = null;
        curPos = newPosition;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return value == piece.value && isWhite == piece.isWhite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isWhite);
    }

    public boolean isValidMove(Position newPosition, Piece[][] board ){
        final int rowNew = newPosition.getRow();
        final int colNew = newPosition.getCol();

        /**
         * No move to the out of range
         */
        if(colNew < 0 || rowNew < 0
            || Game.BOARD_COL <= colNew || Game.BOARD_ROW <= rowNew){
            return false;
        }

        /**
         * No capture same color piece
         */
        Piece pcToMove = board[rowNew][colNew];
        if( pcToMove != null &&
                (pcToMove.isWhite() == isWhite() ) ) {
            return false;
        }

        return true;
    }


    public int getValue() {
        return value;
    }

    public boolean isWhite() {
        return isWhite;
    }

    protected void setValue(int value) {
        this.value = value;
    }

    protected void setWhite(boolean white) {
        this.isWhite = white;
    }
}
