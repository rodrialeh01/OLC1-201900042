package olc_proyecto1_201900042;
import GUI.Ventana;

/**
 *
 * @author Rodrigo
 */
public class OLC_Proyecto1_201900042 {
    /**
     * @param args the command line arguments
     */
    public static int id_sig = 1;
    public static int is_diag = 1;
    
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }
    public static String tabular(int tabulacion){
        String tabs = "";
        for (int i = 0; i < tabulacion; i++) {
            tabs+="\t"; 
        }
        return tabs;
    }
}
