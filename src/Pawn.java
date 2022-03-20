import java.util.Scanner;

public class Pawn extends Piece {
    static final int IMPORTANCE = 1;
    private boolean promoted;
    private boolean isFirstMove;
    private Piece newPiece;


    private enum PROMOTE_PIECE{
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT;
    }

    public Pawn(boolean isWhite, Position pos) {
        super(isWhite, IMPORTANCE, pos);
        promoted = false;
        isFirstMove = true;
        newPiece = null;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public Piece getNewPiece() {
        return newPiece;
    }

    public void promote(PROMOTE_PIECE pcType){
        if(promoted){
            throw new IllegalArgumentException("Already promoted");
        }
        switch(pcType){
            case QUEEN:
                newPiece = new Queen(isWhite(), curPos);
                break;
            case ROOK:
                newPiece = new Rook(isWhite(), curPos);
                break;
            case BISHOP:
                newPiece = new Bishop(isWhite(), curPos);
                break;
            case KNIGHT:
                newPiece = new Knight(isWhite(), curPos);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pcType);
        }
        promoted = true;
        setValue(newPiece.getValue());
    }

    @Override
    public boolean equals(Object o) {
        Pawn piece = (Pawn) o;
        if (piece == null) {
            return false;
        }

        if (piece.promoted != promoted) {
            return false;
        }

        return piece.promoted ? newPiece.equals(piece.newPiece) : super.equals(o);
    }

    @Override
    public String toString() {
        return "Pawn{value='" + getValue() + "'}";
    }

    // Field 兵
    @Override
    public boolean move(Position newPosition, Piece[][] board) {
        if(!super.move(newPosition, board))
            return false;
        isFirstMove = false;

        // Pawn promotes
        final int placeToPromote = isWhite() ? 0 : Game.BOARD_ROW - 1;
        if(!promoted && placeToPromote == newPosition.getRow()){
            int input = -1;
            while(input < 0 ){
                System.out.print("Pawn is promoted! Select the replacement(0:Queen, 1:Rook, 2:Bishop, 3:Knight):");
                Scanner sc = new Scanner(System.in);

                int selNum = sc.nextInt();
                if(selNum < 0 || 4 <= selNum){
                    System.out.println("Invalid number");
                }else{
                    input = selNum;
                }
            }
            promote(PROMOTE_PIECE.values()[input]);
        }

        return true;
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        if(!super.isValidMove(newPosition, board))
            return false;

        // If this pawn is promoted, the movement follows the replacement piece.
        if(isPromoted())
            return newPiece.isValidMove(newPosition, board);

        final int forwardDir = isWhite() ? -1 : 1;
        final int newRow = newPosition.getRow();
        final int newCol = newPosition.getCol();
        Piece newPosPiece = board[newRow][newCol];

        if(newRow == curPos.getRow() + forwardDir){
            // Pawn can move one square forward if there is no piece.
            if(newCol == curPos.getCol() &&
                newPosPiece == null){
                return true;
            }

            // Pawn can move one square diagonally if there is an enemy's piece.
            if(Math.abs(newCol - curPos.getCol()) == 1 &&
                newPosPiece != null &&
                newPosPiece.isWhite() != isWhite()) {
                return true;
            }
        }
        else if(newRow == curPos.getRow() + 2*forwardDir)
        {
            // Pawn can move two squares if it is the first time to move.
            if(newCol == curPos.getCol()){
                Piece oneForwardPiece = board[curPos.getRow() + forwardDir][newCol];
                if(oneForwardPiece == null &&
                    newPosPiece == null &&
                    isFirstMove){
                    return true;
                }
            }
        }

        return false;
    }

}
