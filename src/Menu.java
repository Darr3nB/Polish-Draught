import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int welcomeMenu(){
        StringBuilder welcome = new StringBuilder();
        int menuSelected;
        System.out.println("Welcome to Polish Draught!\n");
        Scanner sc = new Scanner(System.in);

        welcome.append("1. Player vs. Player\n")
            .append("2. Player vs. A.i.\n")
            .append("3. A.i. vs. Player\n")
            .append("4. A.i. vs. A.i.\n")
            .append("0. Quit game\n");

        while (true) {
            try {
                System.out.println(welcome);
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
            }
        }

        //sc.close();
    }
}
