// 28 - 04 -2024
//tarea de listas circulares sencillas
package programacion2_pro4;
//@author Jesús Hernández
import Ui.View;
import java.awt.geom.RoundRectangle2D;
public class Programacion2_Pro4 {
    public static void main(String[] args) {
        System.out.println("hello world");
        View V = new View();
        V.setSize(700, 600);
        //V.setShape(new RoundRectangle2D.Double(0, 0, 700, 600, 40, 40));
        V.setResizable(false);
        V.setLocationRelativeTo(null);
        V.setVisible(true);
    }
}