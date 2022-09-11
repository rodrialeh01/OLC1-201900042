package olc_proyecto1_201900042;
import GUI.Ventana;

/**
 *
 * @author Rodrigo
 */
public class OLC_Proyecto1_201900042 {
    public static int contador = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
    public static String tabular(int contador){
        String tabs = "";
        for (int i = 0; i < contador; i++) {
            tabs+="\t"; 
        }
        return tabs;
    }
}
