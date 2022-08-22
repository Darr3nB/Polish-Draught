import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // TODO close scanner at the end
        List<Pawn> pawnList = new ArrayList<Pawn>();

        int gameType = Menu.welcomeMenu();

        int boardSize = Menu.boardSize();

        Board newBoard = new Board(boardSize);

        System.out.println(newBoard.toString());

    }
}
