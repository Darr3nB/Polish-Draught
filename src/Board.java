import java.util.List;

public class Board {
    public int[][] gameBoard;

    public Board(int size){
        gameBoard = new int[size][size];
    }

    @Override
    public String toString(){
        char headerLetter = 'A';
        StringBuilder header = new StringBuilder();
        header.append("\t");

        for (int i = 0; i < gameBoard.length; i++){
            header.append(' ')
                .append(headerLetter)
                .append(' ');
            headerLetter++;
        }
        System.out.println(header);

        for (int i = 0; i < gameBoard.length; i++){
            StringBuilder boardToPrint = new StringBuilder();
            boardToPrint.append(i + 1)
                .append("\t");

            for (int j = 0; j < gameBoard.length; j++){
                if(gameBoard[i][j] == 0) {
                    boardToPrint.append("|0|");
                }else if(gameBoard[i][j] == 1){
                    boardToPrint.append("|W|");
                }else if (gameBoard[i][j] == 2){
                    boardToPrint.append("|B|");
                }else if (gameBoard[i][j] == 3){
                    boardToPrint.append("|WQ|");
                }else if (gameBoard[i][j] == 4){
                    boardToPrint.append("BQ");
                }
            }
            System.out.println(boardToPrint);
        }

        return "Board is printed!";
    }

    public void movePawn(int newRow, int newCol, Pawn pawn){
        // TODO check after move can it be crowned
        pawn.rowCoord = newRow;
        pawn.colCoord = newCol;
    }

    public void removePawn(int rowCoordToZero, int colCoordToZero, List<Pawn> listToClean){
        Pawn pawnToRemove = null;

        for (Pawn pawn:listToClean) {
            if(pawn.rowCoord == rowCoordToZero && pawn.colCoord == colCoordToZero){
                pawnToRemove = pawn;
            }
        }

        if (pawnToRemove != null){
            listToClean.remove(pawnToRemove);
        }
    }
}
