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
                playerVsPlayer(pawnList);
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

    private static void playerVsPlayer(List<Pawn> pawnList){
        int boardSize = Menu.boardSize();
        Board playerVsPlayerBoard = new Board(boardSize);
        int playerTurn = 1;
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                System.out.println(playerVsPlayerBoard.toString());

                System.out.printf("Player %d turn. Enter an X coordinate to select a pawn: %n", playerTurn);
                char startXCordInput = Character.toUpperCase(sc.next().charAt(0));

                System.out.print("Enter an Y coordinate to select a pawn: ");
                int startYCordInput = sc.nextInt();

                if(!checkPlayerCoordinateInput(startXCordInput, startYCordInput, boardSize)){
                    System.out.println("Invalid input!");
                    continue;
                }

                System.out.print("Enter an X coordinate to step on: ");
                char endXCordInput = Character.toUpperCase(sc.next().charAt(0));

                System.out.println("Enter an Y coordinate to step on:");
                int endYCoordinateInput = sc.nextInt();

                if (!checkPlayerCoordinateInput(endXCordInput, endYCoordinateInput, boardSize)){
                    System.out.println("Invalid input!");
                    continue;
                }

                playerVsPlayerBoard.movePawn(startXCordInput, startYCordInput, endXCordInput, endYCoordinateInput, pawnList);

                if (checkForWin(pawnList)) break;

                playerTurn = playerTurn == 1 ? 2 : 1;
            }catch (Exception e){
                System.out.println("Error");
            }
        }

        if(!Menu.epilogue(playerTurn)){
            System.out.println("Good bye!");
        }
        playGame();
    }

    private static boolean checkPlayerCoordinateInput(char xCoord, int yCoord, int boardSize){
        if(xCoord > 'A' && xCoord < 'Z') return false;
        if (yCoord < 1 || yCoord > boardSize) return false;

        return true;
    }

    private static boolean checkForWin(List<Pawn> pawnList){
        return true;
    }
}
