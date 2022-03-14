import java.util.Objects;


public abstract class Piece {
    private int value;
    private boolean isWhite;
    protected Position curPos;

    public Piece(boolean isWhite, int value) {
        this.isWhite = isWhite;
        this.value = value;
        this.curPos = new Position(0, 0);
    }

    @Override
    abstract public String toString();

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

    public void move(Position pos){
        curPos = pos;
    }

    public boolean isValidMove(Position newPosition, Piece[][] board ){
        final int rowNew = newPosition.getRow();
        final int colNew = newPosition.getCol();

        if(colNew < 0 || rowNew < 0
            || Game.BOARD_COL <= colNew || Game.BOARD_ROW <= rowNew)
            return false;

        if(board[rowNew][colNew] != null)
            return false;

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
