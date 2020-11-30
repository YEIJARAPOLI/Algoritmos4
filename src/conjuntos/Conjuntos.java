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
    final static String TITLE_MENU_VECTORES = "*** CONJUNTOS VECTORES ***";
    final static String TITLE_MENU_LISTAS = "*** CONJUNTOS LISTAS ***";

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
        String menu = TITLE_MENU_VECTORES
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
                    JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU_VECTORES, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcion != 0);
    }

    private void menuConjuntoLista() {
        ConjuntoLista conjuntoListaA = new ConjuntoLista();
        ConjuntoLista conjuntoListaB = new ConjuntoLista();
        String menu = TITLE_MENU_LISTAS
                + "\n" +
                "\n 1. Agregar conjunto A" +
                "\n 2. Agregar conjunto B" +
                "\n 3. Mostrar" +
                "\n 4. Borrar" +
                "\n 5. Vaciar" +
                "\n 6. Cantidad Elementos" +
                "\n 7. Unión" +
                "\n 8. Intersección" +
                "\n 9. Igualdad" +
                "\n 10. Complemento" +
                "\n 11. Posición" +
                "\n 12. Diferencia" +
                "\n 13. Diferencia Simétrica" +
                "\n" +
                "\n 0. SALIR";

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                
                case 1:
                    // Agregar
                    conjuntoListaA.agregar();
                    conjuntoListaA.mostrar();
                    break;
                case 2:
                    // Agregar

                    conjuntoListaB.agregar();
                    conjuntoListaB.mostrar();
                    break;
                case 3:
                    // Mostrar
                    conjuntoListaA.mostrar();
                    conjuntoListaB.mostrar();
                    break;
                case 4:
                    // Borrar
                    break;
                case 5:
                    // Vaciar
                    break;
                case 6:
                    // Cantidad Elementos
                    break;
                case 7:
                    // Union
                    break;
                case 8:
                    // Intersección
                    break;
                case 9:
                    // Igualdad
                    break;
                case 10:
                    // Complemento
                    break;
                case 11:
                    // Posiciòn
                    break;
                case 12:
                    // Diferencia
                    break;
                case 13:
                    // Diferencia Simétrica
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcion != 0);
    }
}
