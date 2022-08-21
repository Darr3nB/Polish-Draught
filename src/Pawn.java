public class Pawn {
    private String color;
    public int player;
    public boolean isCrowned;
    public int rowCoord;
    public int colCoord;
    public String role;

    public Pawn(String color, int rowCoord, int colCoord, int player, String role){
        this.color = color;
        this.player = player;
        this.rowCoord = rowCoord;
        this.colCoord = colCoord;
        this.role = role;
    }


}
