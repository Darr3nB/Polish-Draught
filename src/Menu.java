import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static int welcomeMenu(){
        // TODO check if input is int and a valid menu point
        StringBuilder welcome = new StringBuilder();
        int menuSelected = 0;
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
        // TODO check if input is int and between range
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a field size (10-20): ");
        int boardSize = sc.nextInt();
        //sc.close();

        return boardSize;
    }
}
