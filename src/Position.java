public class Position {
    /**
     * row represents the row number from up to down in the board.
     * col represents the col number from left to right in the board.
     * Therefore, 'a8' means row=0, col=0; 'h1' means row=7, col=7.
     */
    private int row;
    private int col;

    public Position(int row, int col) {
        setRow(row);
        setCol(col);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
