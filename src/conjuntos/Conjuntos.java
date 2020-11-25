package conjuntos;

import javax.swing.*;

/**
 * Conjuntos
 * @author yeijara
 * @since 25/11/2020
 */

public class Conjuntos {

    final static String TITLE_MENU = "*** CONJUNTOS ***";

    public static void main(String[] args) {
        String menu = TITLE_MENU
                + "\n" +
                "\n 1. Agregar" +
                "\n 2. Mostrar" +
                "\n 3. Borrar" +
                "\n 4. Vaciar" +
                "\n 5. Cantidad Elementos" +
                "\n 6. Unión" +
                "\n 7. Intersección" +
                "\n 8. Igualdad" +
                "\n 9. Complemento" +
                "\n 10. Posición" +
                "\n 11. Diferencia" +
                "\n 12. Diferencia Simetrica" +
                "\n" +
                "\n 0. SALIR";

        ConjuntoVector conjuntos = new ConjuntoVector();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    // Agregar
                    break;
                case 2:
                    // Mostrar
                    break;
                case 3:
                    // Borrar
                    break;
                case 4:
                    // Vaciar
                    break;
                case 5:
                    // Cantidad Elementos
                    break;
                case 6:
                    // Union
                    break;
                case 7:
                    // Intersección
                    break;
                case 8:
                    // Igualdad
                    break;
                case 9:
                    // Complemento
                    break;
                case 10:
                    // Posiciòn
                    break;
                case 11:
                    // Diferencia
                    break;
                case 12:
                    // Diferencia Simetrica
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcion != 0);
    }
}
