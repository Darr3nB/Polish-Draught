import java.util.Scanner;

public class Menu {

    public static int welcomeMenu(){
        // TODO check if input is int and a valid menu point
        StringBuilder welcome = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        welcome.append("Welcome to Polish Draught!\n")
            .append("1. Player vs. Player\n")
            .append("2. Player vs. A.i.\n")
            .append("3. A.i. vs. Player\n")
            .append("4. A.i. vs. A.i.\n")
            .append("0. Quit game\n");

        System.out.println(welcome);

        System.out.print("Select a menu point: ");
        int menuSelected = sc.nextInt();
        //sc.close();

        return menuSelected;
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
