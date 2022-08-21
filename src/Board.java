import java.util.List;

public class Board {
    // TODO make gameBoard Pawn type
    public Pawn[][] gameBoard;

    public Board(int size){
        gameBoard = new Pawn[size][size];
    }

    @Override
    public String toString(){
        char headerLetter = 'A';
        StringBuilder boardToPrint = new StringBuilder();
        boardToPrint.append("\t");

        for (int i = 0; i < gameBoard.length; i++){
            boardToPrint.append(' ')
                .append(headerLetter)
                .append(' ');
            headerLetter++;
        }
        boardToPrint.append(System.lineSeparator());

        for (int i = 0; i < gameBoard.length; i++){
            boardToPrint.append(i + 1)
                .append("\t");

            for (int j = 0; j < gameBoard.length; j++){
                if (gameBoard[i][j] == null){
                    boardToPrint.append("|0|");
                }else if (gameBoard[i][j].player == 1 && !gameBoard[i][j].isCrowned){
                    boardToPrint.append("|W|");
                }else if (gameBoard[i][j].player == 2 && !gameBoard[i][j].isCrowned){
                    boardToPrint.append("|B|");
                }else if (gameBoard[i][j].player == 1 && gameBoard[i][j].isCrowned){
                    boardToPrint.append("|WQ|");
                }else if (gameBoard[i][j].player == 2 && gameBoard[i][j].isCrowned){
                    boardToPrint.append("|BQ|");
                }
            }
            boardToPrint.append(System.lineSeparator());
        }
        return boardToPrint.toString();
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
