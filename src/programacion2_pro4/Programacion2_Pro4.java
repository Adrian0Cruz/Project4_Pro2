// 28 - 04 -2024
//tarea de listas circulares sencillas
package programacion2_pro4;
//@author Jesús Hernández
import Ui.*;
import java.awt.geom.RoundRectangle2D;
public class Programacion2_Pro4 {
    public static void main ( String[] args )  {
        System.out.println ( "hello world" );
        Menu M = new Menu (  );
        M.setSize ( 700, 600 );
        M.setShape (new RoundRectangle2D.Double ( 0, 0, 700, 600, 25, 25 ) );
        M.setResizable ( false );
        M.setLocationRelativeTo ( null );
        M.setVisible ( true );
    }
}