/**
 * @author Giel Besouw - s4483898
 * @author Sébastiaan Versteeg - s4459636
 */
public class Positie {
    
    private int x,y;
    
    public Positie(int x, int y){
        this.x=x;
        this.y=y;

    }
    
    public void add(Positie p){
        this.x += p.getX();
        this.y += p.getY();
    }

    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }

}
