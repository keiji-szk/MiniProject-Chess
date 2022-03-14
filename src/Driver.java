import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.showBoard();

        if(game.movePiece(new Position(1, 0), new Position(2, 0))){
            System.out.println("Move!");
            game.showBoard();
        }
    }
}
