package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {
    public static void game(){
        // TODO close scanner at the end
        List<domain.Pawn> pawnList = new ArrayList<domain.Pawn>();

        int gameType = Menu.welcomeMenuAndSelectOne();

        int playerTurn = Menu.gameTypeSelectedMenu(gameType, pawnList);

        if(!Menu.epilogue(playerTurn)){
            System.out.println("Good bye!");
        }else {
            game();
        }
    }

    public static int playerVsPlayer(List<domain.Pawn> pawnList){
        int boardSize = Menu.boardSize();
        domain.Board playerVsPlayerBoard = new domain.Board(boardSize);
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

                System.out.print("Enter an Y coordinate to step on: ");
                int endYCoordinateInput = sc.nextInt();

                if (!checkPlayerCoordinateInput(endXCordInput, endYCoordinateInput, boardSize)){
                    System.out.println("Invalid input!");
                    continue;
                }

                playerVsPlayerBoard.movePawn(startXCordInput, startYCordInput, endXCordInput, endYCoordinateInput, pawnList);

                if (checkForWin(pawnList)) break;

                playerTurn = playerTurn != 2 ? 2 : 1;
            }catch (Exception e){
                System.out.println("Error" + e);
            }
        }

        return playerTurn;
    }

    private static boolean checkPlayerCoordinateInput(char xCoord, int yCoord, int boardSize){
        if (!Character.isLetter(xCoord)) { return false; }
        if (yCoord < 1 || yCoord > boardSize) { return false; }

        return true;
    }

    private static boolean checkForWin(List<domain.Pawn> pawnList){
        return false;
    }
}
