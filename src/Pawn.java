public class Pawn {
    private String color;
    public int player;
    public boolean isCrowned;
    public int rowCoord;
    public int colCoord;

    public Pawn(String color, int rowCoord, int colCoord, int player){
        this.color = color;
        this.player = player;
        this.rowCoord = rowCoord;
        this.colCoord = colCoord;
    }

    
}
