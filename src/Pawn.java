public class Pawn {
    private char color;
    public int player;
    public boolean isCrowned = false;
    public int x;
    public int y;
    public String role;

    public Pawn(char color, int rowCoord, int colCoord, int player){
        this.color = color;
        this.player = player;
        this.x = rowCoord;
        this.y = colCoord;
    }

    public void crownMe(){
        this.isCrowned = true;
    }

    public char getColor(){ return this.color; }

    public boolean isCrowned(){ return this.isCrowned; }
}
