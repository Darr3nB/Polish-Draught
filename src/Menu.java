import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int welcomeMenu(){
        StringBuilder menuPoints = new StringBuilder();
        int menuSelected;
        System.out.println("Welcome to Polish Draught!\n");
        Scanner sc = new Scanner(System.in);

        menuPoints.append("1. Player vs. Player\n")
            .append("2. Player vs. A.i.\n")
            .append("3. A.i. vs. Player\n")
            .append("4. A.i. vs. A.i.\n")
            .append("0. Quit game\n");

        while (true) {
            try {
                System.out.println(menuPoints);
                System.out.print("Select a menu point: ");
                int input = sc.nextInt();

                if (input < 0 || input > 4){
                    System.out.println("Invalid menu point!\n");
                    continue;
                }
                menuSelected = input;

                return menuSelected;
            }catch (InputMismatchException e){
                System.out.println("Invalid input!");
                sc.next();
                System.out.println(System.lineSeparator());
            }catch (Exception e){
                System.out.println("An error has occurred: " + e);
                sc.next();
                System.out.println(System.lineSeparator());
            }

            //sc.close();
        }
    }

    public static int boardSize(){
        Scanner sc = new Scanner(System.in);
        int boardSize;

        while (true){
            try {
                System.out.print("Enter a field size (10-20): ");
                int input = sc.nextInt();

                if (input < 10 || input > 20){
                    System.out.println("Invalid board size!");
                    continue;
                }
                boardSize = input;

                return boardSize;
            }catch (InputMismatchException e){
                System.out.println("Invalid input!");
                sc.next();
                System.out.println(System.lineSeparator());
            }catch (Exception e){
                System.out.println("An error has occurred: " + e);
                sc.next();
                System.out.println(System.lineSeparator());
            }
        }

        //sc.close();
    }

    public static boolean epilogue(int player){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Congratulation! Player %d has won the game!%n", player);

        while (true) {
            try {
                System.out.println("Do you want to play again? 1: yes 2: no");
                int input = sc.nextInt();

                if (input < 1 || input > 2){
                    System.out.println("Invalid input");
                    continue;
                }

                return input == 1;
            }catch (InputMismatchException e){
                System.out.println("Invalid input!");
                sc.next();
                System.out.println(System.lineSeparator());
            }catch (Exception e){
                System.out.println("An error has occurred: " + e);
                sc.next();
                System.out.println(System.lineSeparator());
            }
        }

        //sc.close();
    }
}
