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
                }else if(!pawn.isCrowned()){
                    boardToPrint.append("|%s|".formatted(pawn.getColor()));
                }else if(pawn.isCrowned() && pawn.player == 1){
                    boardToPrint.append("|WQ|");
                }else if(pawn.isCrowned() && pawn.player == 2){
                    boardToPrint.append("|BQ|");
                }
            }
            boardToPrint.append(System.lineSeparator());
        }
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
