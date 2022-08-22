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
        int rowMarker = 0;
        StringBuilder boardToPrint = new StringBuilder();
        boardToPrint.append("\t");

        for (int i = 0; i < gameBoard.length; i++){
            boardToPrint.append(' ')
                .append(headerLetter)
                .append(' ');
            headerLetter++;
        }
        boardToPrint.append(System.lineSeparator());

        for(Pawn[] line : gameBoard){
            boardToPrint.append(rowMarker)
                .append("\t");
            rowMarker++;

            for (Pawn pawn : line){
                if (pawn == null){
                    boardToPrint.append("|0|");
                }else if (pawn.player == 1 && !pawn.isCrowned()){
                    boardToPrint.append("|W|");
                }else if (pawn.player == 2 && !pawn.isCrowned()){
                    boardToPrint.append("|B|");
                }else if (pawn.player == 1 && pawn.isCrowned()){
                    boardToPrint.append("|WQ|");
                }else if (pawn.player == 2 && pawn.isCrowned()){
                    boardToPrint.append("|BQ|");
                }
            }
            boardToPrint.append(System.lineSeparator());
        }

//        for (int i = 0; i < gameBoard.length; i++){
//            boardToPrint.append(i + 1)
//                .append("\t");
//
//            for (int j = 0; j < gameBoard.length; j++){
//                if (gameBoard[i][j] == null){
//                    boardToPrint.append("|0|");
//                }else if (gameBoard[i][j].player == 1 && !gameBoard[i][j].isCrowned){
//                    boardToPrint.append("|W|");
//                }else if (gameBoard[i][j].player == 2 && !gameBoard[i][j].isCrowned){
//                    boardToPrint.append("|B|");
//                }else if (gameBoard[i][j].player == 1 && gameBoard[i][j].isCrowned){
//                    boardToPrint.append("|WQ|");
//                }else if (gameBoard[i][j].player == 2 && gameBoard[i][j].isCrowned){
//                    boardToPrint.append("|BQ|");
//                }
//            }
//            boardToPrint.append(System.lineSeparator());
//        }
        return boardToPrint.toString();
    }

    public void movePawn(int starRow, int startCol, int rowToMoveTo, int colToMoveTo, List<Pawn> pawnList){
        // TODO check after move can it be crowned
        for (Pawn pawn : pawnList) {
            if (pawn.x == starRow && pawn.y == startCol){
                pawn.x = rowToMoveTo;
                pawn.y = colToMoveTo;
                return;
            }
        }
    }

    public void removePawn(int rowCoordToZero, int colCoordToZero, List<Pawn> listToClean){
        Pawn pawnToRemove = null;

        for (Pawn pawn:listToClean) {
            if(pawn.x == rowCoordToZero && pawn.y == colCoordToZero){
                pawnToRemove = pawn;
            }
        }

        if (pawnToRemove != null){
            listToClean.remove(pawnToRemove);
        }
    }

    public void placeOrReplacePawnsOnBoard(List<Pawn> pawnList){
        nullAllPawns();

        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; j < gameBoard.length; j++){
                for (Pawn pawn : pawnList){
                    if (i == pawn.x && j == pawn.y){
                        gameBoard[i][j] = pawn;
                    }
                }
            }
        }
    }

    private void nullAllPawns(){
        for (Pawn[] line : gameBoard){
            for (Pawn pawn : line){
                pawn = null;
            }
        }
    }
}
