package conjuntos;

import javax.swing.*;

/**
 * Conjuntos
 * @author yeijara
 * @since 25/11/2020
 */

public class Conjuntos {

    private int opcion;
    final static String TITLE_MENU = "*** CONJUNTOS ***";

    public static void main(String[] args) {
        String menu = TITLE_MENU
                + "\n" +
                "\n 1. Conjunto en vectores" +
                "\n 2. Conjunto en listas" +
                "\n 3. Combinados" +
                "\n" +
                "\n 0. SALIR";

        Conjuntos conjunto = new Conjuntos();

        do {
            conjunto.opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (conjunto.opcion) {
                case 1:
                    // Conjunto en vectores
                    conjunto.menuConjuntoVector();
                    break;
                case 2:
                    // Conjunto en listas
                    conjunto.menuConjuntoLista();
                    break;
                case 3:
                    // Combinados
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (conjunto.opcion != 0);
    }

    private void menuConjuntoVector() {
        String menu = "CONJUNTOS EN VECTORES"
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
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcion != 0);
    }

    private void menuConjuntoLista() {
        String menu = "CONJUNTOS EN LISTA"
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

        ConjuntoLista conjuntos = new ConjuntoLista();

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
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcion != 0);
    }
}
