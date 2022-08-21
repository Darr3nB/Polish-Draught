public class Main {
    public static void main(String[] args){
        // TODO close scanner at the end

        int gameType = Menu.welcomeMenu();

        int boardSize = Menu.boardSize();

        Board newBoard = new Board(boardSize);

        System.out.println(newBoard.toString());

    }
}
