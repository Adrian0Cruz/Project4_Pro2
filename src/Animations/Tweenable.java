//By : Neyder Dario
package Animations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JComponent;

public class Tweenable {
    private boolean playing = false;
    private Timer player;
    private double smoothness = 25;
    private JComponent component;
    
    private double getSolved( double i, Style style ){
        double t = i;
        switch ( style.ordinal() ) {
                    case 0:
                        t = solveInSine( i );
                        break;
                    case 1:
                        t = solveOutSine( i );
                        break;
                    case 2:
                        t = solveInQuad( i );
                        break;
                    case 3:
                        t = solveOutQuad( i );
                        break;
                    case 4:
                        t = solveOutBounce( i );
                        break;
                    case 5:
                        t = solveOutElastic( i );
                        break;
                }
        return t;
    }
    public void cancelCurrentTween(){
        if ( !playing ){ return; }
        if ( player != null ){
            player.stop();
            
            player = null;
            playing = false;
        }
    }
    
    public void tweenLocation( Vector2 goalLocation, double time, Style style, boolean override ){
        if ( playing ){ if( !override ){ return; } cancelCurrentTween(); }
        playing = true;
        
        Vector2 start = new Vector2( component.getX(), component.getY() );

        double step = 1 / ( time * smoothness );
        double delay = time * step;
        
        player = new Timer( ( int ) ( delay * 1000 ), new ActionListener(){
            private double i = 0;
            private double t = 0;
            
            @Override
            public void actionPerformed( ActionEvent e ) {
                if ( i >= 1.0 ) { cancelCurrentTween(); return; }
                t = getSolved( i, style );

                Vector2 newLocation = start.lerp( goalLocation, t );
                component.setLocation( newLocation.x, newLocation.y );
                i += step;
            }
        });
        
        player.setInitialDelay(0);
        player.start();
    }
    public void tweenSize(Vector2 goalSize, double time, Style style, boolean override){
        if (playing){if(!override){return;}cancelCurrentTween();}
        playing = true;
        
        Vector2 start = new Vector2(component.getWidth(), component.getHeight());

        double step = 1 / (time * smoothness);
        double delay = time * step;
        
        player = new Timer((int) (delay * 1000), new ActionListener(){
            private double i = 0;
            private double t = 0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i >= 1.0) {cancelCurrentTween(); return;}
                t = getSolved(i, style);

                Vector2 newSize = start.lerp(goalSize, t);
                component.setSize(newSize.x, newSize.y);
                i += step;
            }
        });
        
        player.setInitialDelay(0);
        player.start();
    }
    public void tweenSizeAndLocation(Vector2 goalLocation, Vector2 goalSize, double time, Style style, boolean override){
        if (playing){if(!override){return;}cancelCurrentTween();}
        playing = true;
        
        Vector2 startLocation = new Vector2(component.getX(), component.getY());
        Vector2 startSize = new Vector2(component.getWidth(), component.getHeight());

        double step = 1 / (time * smoothness);
        double delay = time * step;
        
        player = new Timer((int) (delay * 1000), new ActionListener(){
            private double i = 0;
            private double t = 0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i >= 1.0) {cancelCurrentTween(); return;}
                t = getSolved(i, style);

                Vector2 newLocation = startLocation.lerp(goalLocation, t);
                Vector2 newSize = startSize.lerp(goalSize, t);
                component.setLocation(newLocation.x, newLocation.y);
                component.setSize(newSize.x, newSize.y);
                i += step;
            }
        });
        
        player.setInitialDelay(0);
        player.start();
    }
    
    private double solveInSine(double t) {
        return 1 - Math.cos(t * Math.PI / 2);
    }
    private double solveOutSine(double t) {
        return Math.sin((t * Math.PI) / 2);
    }
    private double solveInQuad(double t) {
        return t * t;
    }
    private double solveOutQuad(double t) {
        return 1 - (1 - t) * (1 - t);
    }
    private double solveOutBounce(double t) {
        double c1 = 7.5;
        double c2 = 2.9;
        if (t < 1 / c2) {
            return c1 * t * t;
        } else if (t < 2 / c2) {
            return c1 * (t -= 1.5 / c2) * t + 0.75;
        } else if (t < 2.5 / c2) {
            return c1 * (t -= 2.25 / c2) * t + 0.9375;
        } else {
            return c1 * (t -= 2.625 / c2) * t + 0.984375;
        }
    }
    private double solveOutElastic(double t) {
        double c = (2 * Math.PI) / 3;
        return t == 0 ? 0 : t == 1 ? 1 : Math.pow(2, -10 * t) * Math.sin((t * 10 - .75) * c) + 1;
    }
    
    public enum Style {InSine, OutSine, InQuad, OutQuad, OutBounce, OutElastic}
    public boolean isPlaying(){return playing;}
    public void setSmoothness(double smoothness){this.smoothness = smoothness;}
    public double getSmoothness(){return smoothness;}
    
    public Tweenable(JComponent component){this.component = component;}
}