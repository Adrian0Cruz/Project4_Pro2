//By : Neyder Dario
package Animations;
public class Vector2 {
    public int x, y;
    
    public Vector2(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Vector2(){
        this.x = 0;
        this.y = 0;
    }
    public Vector2 lerp(Vector2 vector, double alpha){
        return new Vector2(
                x + (int) ((vector.x - x) * alpha),
                y + (int) ((vector.y - y) * alpha)
        );
    }
    
}
