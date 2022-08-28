import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                // TODO AvA
                break;
            default:
                System.out.println("Good bye!");
                break;
        }
    }

    private static void playerVsPlayer(){
        int boardSize = Menu.boardSize();
        Board playerVsPlayerBoard = new Board(boardSize);
        int playerTurn = 1;
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                System.out.println(playerVsPlayerBoard.toString());

                System.out.printf("Player %d turn. Enter an X coordinate: %n", playerTurn);
                char playerXCordInput = Character.toUpperCase(sc.next().charAt(0));

                System.out.print("Enter an Y coordinate: ");
                int playerYCordInput = sc.nextInt();

                if(!checkPlayerCoordinateInput(playerXCordInput, playerYCordInput, boardSize)){
                    System.out.println("Invalid input!");
                    continue;
                }

                break;
            }catch (Exception e){
                System.out.println("Error");
            }
        }
    }

    private static boolean checkPlayerCoordinateInput(char xCoord, int yCoord, int boardSize){
        if(xCoord > 'A' && xCoord < 'Z') return false;
        if (yCoord < 10 || yCoord > boardSize) return false;

        return true;
    }
}
