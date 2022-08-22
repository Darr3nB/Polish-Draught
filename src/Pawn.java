public class Pawn {
    private String color;
    public int player;
    public boolean isCrowned;
    public int x;
    public int y;
    public String role;

    public Pawn(String color, int rowCoord, int colCoord, int player, boolean isCrowned){
        this.color = color;
        this.player = player;
        this.x = rowCoord;
        this.y = colCoord;
        this.isCrowned = isCrowned;
    }

    public void crownMe(){
        this.isCrowned = true;
    }

    public String getColo(){ return this.color; }

    public boolean isCrowned(){ return this.isCrowned; }
}
