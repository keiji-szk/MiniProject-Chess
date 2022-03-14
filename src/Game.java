public class Game {
    public static int BOARD_ROW = 8;
    public static int BOARD_COL = 8;

    private Piece[][] board;

    public Game() {
        this.board = new Piece[BOARD_ROW][BOARD_COL];
        Initialise();
    }

    public boolean movePiece(Position posFrom, Position posTo){
        Piece pc = board[posFrom.row][posFrom.col];
        if(pc == null){
            return false;
        }

        if(!pc.isValidMove(posTo, board)){
            return false;
        }

        board[posTo.row][posTo.col] = pc;
        board[posFrom.row][posFrom.col] = null;
        pc.move(posTo);
        return true;
    }

    public void showBoard(){
        for(int r = BOARD_ROW - 1; 0 <= r; --r){
            for(int c = 0; c < BOARD_COL; ++c){
                printPiece(board[r][c]);
                System.out.print(" ");
            }
            System.out.println("  " + (r + 1));
        }
        System.out.println("\na b c d e f g h\n");
    }

    private void printPiece(Piece pc){
        if(pc instanceof King ){
            System.out.print( pc.isWhite() ? "♔" : "♚" );
        }else if(pc instanceof Queen){
            System.out.print( pc.isWhite() ? "♕" : "♛" );
        }else if(pc instanceof Rook){
            System.out.print( pc.isWhite() ? "♖" : "♜" );
        }else if(pc instanceof Bishop){
            System.out.print( pc.isWhite() ? "♗" : "♝" );
        }else if(pc instanceof Knight){
            System.out.print( pc.isWhite() ? "♘" : "♞" );
        }else if(pc instanceof Pawn){
            System.out.print( pc.isWhite() ? "♙" : "♟" );
        }else{
            System.out.print( "•" );
        }
    }

    private void Initialise(){
        /* Create White pieces*/
        this.board[0][0] = new Rook(true);
        this.board[0][1] = new Knight(true);
        this.board[0][2] = new Bishop(true);
        this.board[0][3] = new Queen(true);
        this.board[0][4] = new King(true);
        this.board[0][5] = new Bishop(true);
        this.board[0][6] = new Knight(true);
        this.board[0][7] = new Rook(true);
        this.board[1][0] = new Pawn(true);
        this.board[1][1] = new Pawn(true);
        this.board[1][2] = new Pawn(true);
        this.board[1][3] = new Pawn(true);
        this.board[1][4] = new Pawn(true);
        this.board[1][5] = new Pawn(true);
        this.board[1][6] = new Pawn(true);
        this.board[1][7] = new Pawn(true);

        /* Create Black pieces*/
        this.board[7][0] = new Rook(false);
        this.board[7][1] = new Knight(false);
        this.board[7][2] = new Bishop(false);
        this.board[7][3] = new Queen(false);
        this.board[7][4] = new King(false);
        this.board[7][5] = new Bishop(false);
        this.board[7][6] = new Knight(false);
        this.board[7][7] = new Rook(false);
        this.board[6][0] = new Pawn(false);
        this.board[6][1] = new Pawn(false);
        this.board[6][2] = new Pawn(false);
        this.board[6][3] = new Pawn(false);
        this.board[6][4] = new Pawn(false);
        this.board[6][5] = new Pawn(false);
        this.board[6][6] = new Pawn(false);
        this.board[6][7] = new Pawn(false);
    }
}
