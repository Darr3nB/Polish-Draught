import java.util.ArrayList;
import java.util.List;

public class Play {
    public static void playGame(){
        // TODO close scanner at the end
        List<Pawn> pawnList = new ArrayList<Pawn>();

        int gameType = Menu.welcomeMenu();
        switch (gameType){
            case 1:
                playerVsPlayer();
                break;
            case 2:
                // TODO PvA
                break;
            case 3:
                // TODO AvP
                break;
            case 4:
                // TODO AVA
                break;
            default:
                System.out.println("Good bye!");
                break;
        }
    }

    private static void playerVsPlayer(){
        int boardSize = Menu.boardSize();
        Board playerVsPlayerBoard = new Board(boardSize);
        System.out.println(playerVsPlayerBoard.toString());
    }
}
