import java.util.Scanner;

public class Game {
    public static int BOARD_ROW = 8;
    public static int BOARD_COL = 8;

    // Menu options
    public static int INPUT_INVALID = -1;
    public static int INPUT_OK = 0;
    public static int INPUT_AGAIN = 1;
    public static int INPUT_RESIGN = 2;


    private Piece[][] board;

    public Game() {
        this.board = new Piece[BOARD_ROW][BOARD_COL];
        Initialise();
    }

    public boolean movePiece(Position posFrom, Position posTo){
        Piece pc = board[posFrom.getRow()][posFrom.getCol()];
        if(pc == null){
            return false;
        }

        return pc.move(posTo, board);
    }

    public void showBoard(){
        for(int r = 0; r < BOARD_ROW; ++r){
            for(int c = 0; c < BOARD_COL; ++c){
                printPiece(board[r][c]);
                System.out.print(" ");
            }
            System.out.println("  " + (8 - r));
        }
        System.out.println("\na b c d e f g h\n");
    }

    private void printPiece(Piece pc){
        if(pc instanceof Pawn){
            pc = ((Pawn) pc).isPromoted() ? ((Pawn) pc).getNewPiece() : pc;
        }

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
        /* Create Black pieces*/
        this.board[0][0] = new Rook     (false, new Position(0, 0));
        this.board[0][1] = new Knight   (false, new Position(0, 1));
        this.board[0][2] = new Bishop   (false, new Position(0, 2));
        this.board[0][3] = new Queen    (false, new Position(0, 3));
        this.board[0][4] = new King     (false, new Position(0, 4));
        this.board[0][5] = new Bishop   (false, new Position(0, 5));
        this.board[0][6] = new Knight   (false, new Position(0, 6));
        this.board[0][7] = new Rook     (false, new Position(0, 7));
        this.board[1][0] = new Pawn     (false, new Position(1, 0));
        this.board[1][1] = new Pawn     (false, new Position(1, 1));
        this.board[1][2] = new Pawn     (false, new Position(1, 2));
        this.board[1][3] = new Pawn     (false, new Position(1, 3));
        this.board[1][4] = new Pawn     (false, new Position(1, 4));
        this.board[1][5] = new Pawn     (false, new Position(1, 5));
        this.board[1][6] = new Pawn     (false, new Position(1, 6));
        this.board[1][7] = new Pawn     (false, new Position(1, 7));

        /* Create White pieces*/
        this.board[7][0] = new Rook     (true, new Position(7, 0));
        this.board[7][1] = new Knight   (true, new Position(7, 1));
        this.board[7][2] = new Bishop   (true, new Position(7, 2));
        this.board[7][3] = new Queen    (true, new Position(7, 3));
        this.board[7][4] = new King     (true, new Position(7, 4));
        this.board[7][5] = new Bishop   (true, new Position(7, 5));
        this.board[7][6] = new Knight   (true, new Position(7, 6));
        this.board[7][7] = new Rook     (true, new Position(7, 7));
        this.board[6][0] = new Pawn     (true, new Position(6, 0));
        this.board[6][1] = new Pawn     (true, new Position(6, 1));
        this.board[6][2] = new Pawn     (true, new Position(6, 2));
        this.board[6][3] = new Pawn     (true, new Position(6, 3));
        this.board[6][4] = new Pawn     (true, new Position(6, 4));
        this.board[6][5] = new Pawn     (true, new Position(6, 5));
        this.board[6][6] = new Pawn     (true, new Position(6, 6));
        this.board[6][7] = new Pawn     (true, new Position(6, 7));
    }

    public void printHelp() {
        System.out.println("* type 'help' for help");
        System.out.println("* type 'board' to see the board again");
        System.out.println("* type 'resign' to resign");
        System.out.println("* type 'moves' to list all possible moves");
        System.out.println("* type a square (e.g. b1, e2) to list all possible moves for that square");
        System.out.println("* type UCI (e.g. b1c3, e7e8) to make a move");
        System.out.println("* type 'debug' to debug movement of each piece");
    }

    public String userInput(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }

    public int handleInput(String input, boolean isWhite) {
        switch (input) {
            case "help":
                printHelp();
                return INPUT_AGAIN;
            case "resign":
                return INPUT_RESIGN;
            case "board":
                showBoard();
                return INPUT_AGAIN;
            case "moves":
                printAllMoves(isWhite);
                return INPUT_AGAIN;
            case "debug":
                debugMoves();
                return INPUT_AGAIN;
        }

        if (input.length() == 2) {
            // SQUARE
            int col = Integer.valueOf(input.charAt(0)) - 97; // 97 is ASCII for a
            int row = 7 - (Integer.valueOf(input.charAt(1)) - 1 - 48); // 48 is ASCII for 0
            if (row < 0 || col < 0 || row >= BOARD_ROW || col >= BOARD_COL) {
                return INPUT_INVALID;
            }
            if (this.board[row][col] != null && this.board[row][col].isWhite() == isWhite) {
                possibleMoves(row, col);
                return INPUT_AGAIN;
            } else {
                return INPUT_INVALID;
            }
        } else if (input.length() == 4) {
            // UCI
            int col = Integer.valueOf(input.charAt(0)) - 97; // 97 is ASCII for a
            int row = 7 - ( input.charAt(1) - 1 - 48 ); // 48 is ASCII for 0
            int newCol = Integer.valueOf(input.charAt(2)) - 97; // 97 is ASCII for a
            int newRow = 7 - (Integer.valueOf(input.charAt(3)) - 1 - 48); // 48 is ASCII for 0
            if (row < 0 || col < 0 || row >= BOARD_ROW || col >= BOARD_COL ||
                newRow < 0 || newCol < 0 || newRow >= BOARD_ROW || newCol >= BOARD_COL) {
                return INPUT_INVALID;
            }

            Piece pc = this.board[row][col];
            if (pc != null && pc.isWhite() == isWhite) {
                Position newPos = new Position(newRow,newCol);
                Position oldPos = new Position(row,col);
                if (this.movePiece(oldPos,newPos)) {
                    return INPUT_OK;
                } else {
                    return INPUT_INVALID;
                }
            }
        }

        return INPUT_INVALID;
    }

    public void startGame() {
        showBoard();
        boolean finishGame = false;
        String input;
        int opt;
        while (!finishGame) {
            // White
            System.out.println("White to move. ♔ is white. ♚ is black.");
            input = userInput("Enter UCI (type 'help' for help): ");
            opt = handleInput(input, true);
            while (opt != INPUT_OK && opt != INPUT_RESIGN) {
                if (opt == INPUT_INVALID) {
                    System.out.println("Invalid input, please try again\n");
                }
                System.out.println("White to move. ♔ is white. ♚ is black.");
                input = userInput("Enter UCI (type 'help' for help): ");
                opt = handleInput(input, true);
            }
            showBoard();
            if (opt == INPUT_RESIGN) {
                System.out.println("Game over - 0-1 - Black won by resignation");
                return;
            }

            // Black
            System.out.println("Black to move. ♔ is white. ♚ is black.");
            input = userInput("Enter UCI (type 'help' for help): ");
            opt = handleInput(input, false);
            while (opt != INPUT_OK && opt != INPUT_RESIGN) {
                if (opt == INPUT_INVALID) {
                    System.out.println("Invalid input, please try again\n");
                }
                System.out.println("Black to move. ♔ is white. ♚ is black.");
                input = userInput("Enter UCI (type 'help' for help): ");
                opt = handleInput(input, false);
            }
            showBoard();
            if (opt == INPUT_RESIGN) {
                System.out.println("Game over - 1-0 - White won by resignation");
                return;
            }

        }

    }

    public String positionToChar(int row, int col) {
        char colChar = (char)(col + 97);
        return String.valueOf(colChar) + (8-row);
    }

    public void possibleMoves(int row, int col) {
        String pos = positionToChar(row,col);
        Piece piece = this.board[row][col];
        Position newPos;
        System.out.println("Possible moves for " + pos + ":");
        System.out.print("{");
        int count = 0;
        for (int i = 0 ; i < BOARD_ROW ; i++) {
            for (int j = 0 ; j<BOARD_COL; j++ ) {
                newPos = new Position(i,j);
                if (piece.isValidMove(newPos,this.board)) {
                    if (count > 0) {
                        System.out.print(", ");
                    }
                    count++;
                    System.out.print(positionToChar(i,j));

                }
            }
        }
        System.out.println("}");

    }

    public void printAllMoves(boolean isWhite) {
        System.out.println("All possible moves to " + (isWhite ? "WHITE" : "BLACK") + ":");
        for (int i = 0 ; i < BOARD_ROW ; i++) {
            for (int j = 0 ; j < BOARD_COL ; j++) {
                if (this.board[i][j] != null && this.board[i][j].isWhite() == isWhite) {
                    possibleMoves(i, j);
                }
            }
        }
    }

    private void debugMoves(){
        board = new Piece[BOARD_ROW][BOARD_COL];

        /* Create Black pieces*/
        this.board[0][1] = new Knight   (false, new Position(0, 1));
        this.board[0][4] = new King     (false, new Position(0, 4));
        this.board[0][7] = new Rook     (false, new Position(0, 7));
        this.board[1][7] = new Pawn     (false, new Position(1, 7));

        /* Create White pieces*/
        this.board[7][0] = new Rook     (true, new Position(7, 0));
        this.board[7][1] = new Knight   (true, new Position(7, 1));
        this.board[7][2] = new Bishop   (true, new Position(7, 2));
        this.board[7][3] = new Queen    (true, new Position(7, 3));
        this.board[7][4] = new King     (true, new Position(7, 4));
        this.board[7][5] = new Bishop   (true, new Position(7, 5));
        this.board[7][6] = new Knight   (true, new Position(7, 6));
        this.board[7][7] = new Rook     (true, new Position(7, 7));
        this.board[1][2] = new Pawn     (true, new Position(1, 2));

        showBoard();
    }
}
