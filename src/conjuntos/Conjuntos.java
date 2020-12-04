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
    final static String TITLE_MENU_COMBINADO = "*** CONJUNTOS COMBINADOS ***";

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
                     conjunto.menuCombinado();
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
            String nombreConjunto;
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    // Agregar
                    nombreConjunto = JOptionPane.showInputDialog(null, "Ingrese el nombre del conjunto a agregar", TITLE_MENU_VECTORES, JOptionPane.INFORMATION_MESSAGE);

                    if (!nombreConjunto.isEmpty()) {
                        conjuntos.agregar(nombreConjunto);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡No ha ingresado un nombre de conjunto!", TITLE_MENU_VECTORES, JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    // Mostrar
                    nombreConjunto = JOptionPane.showInputDialog(null, "Ingrese el nombre del conjunto a mostrar", TITLE_MENU_VECTORES, JOptionPane.INFORMATION_MESSAGE);

                    if (!nombreConjunto.isEmpty()) {
                        conjuntos.mostrar(nombreConjunto);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡No ha ingresado un nombre de conjunto!", TITLE_MENU_VECTORES, JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    // Borrar
                    nombreConjunto = JOptionPane.showInputDialog(null, "Ingrese el nombre del conjunto", TITLE_MENU_VECTORES, JOptionPane.INFORMATION_MESSAGE);

                    if (!nombreConjunto.isEmpty()) {
                        conjuntos.borrarElemento(nombreConjunto);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡No ha ingresado un nombre de conjunto!", TITLE_MENU_VECTORES, JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 4:
                    // Vaciar
                    nombreConjunto = JOptionPane.showInputDialog(null, "Ingrese el nombre del conjunto", TITLE_MENU_VECTORES, JOptionPane.INFORMATION_MESSAGE);

                    if (!nombreConjunto.isEmpty()) {
                        conjuntos.vaciarElementos(nombreConjunto);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡No ha ingresado un nombre de conjunto!", TITLE_MENU_VECTORES, JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 5:
                    // Cantidad Elementos
                    nombreConjunto = JOptionPane.showInputDialog(null, "Ingrese el nombre del conjunto", TITLE_MENU_VECTORES, JOptionPane.INFORMATION_MESSAGE);

                    if (!nombreConjunto.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La cantidad de elementos del conjunto '"
                                + nombreConjunto + "' son: " + conjuntos.cantidadElementos(nombreConjunto), TITLE_MENU_VECTORES, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡No ha ingresado un nombre de conjunto!", TITLE_MENU_VECTORES, JOptionPane.ERROR_MESSAGE);
                    }
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
        ConjuntoLista conjuntoListaUnion = new ConjuntoLista();
        ConjuntoLista conjuntoListaInterseccion = new ConjuntoLista();
        ConjuntoLista conjuntoListaIgualdad = new ConjuntoLista();
        ConjuntoLista conjuntoListaComplementoA = new ConjuntoLista();
        ConjuntoLista conjuntoListaComplementoB = new ConjuntoLista();
        ConjuntoLista conjuntoListaDiferenciaA = new ConjuntoLista();
        ConjuntoLista conjuntoListaDiferenciaB = new ConjuntoLista();
        ConjuntoLista conjuntoListaDiferenciaSimetrica = new ConjuntoLista();
        String menu = TITLE_MENU_LISTAS
                + "\n" +
                "\n 1. Agregar conjunto A - OK" +
                "\n 2. Agregar conjunto B - OK" +
                "\n 3. Mostrar - OK" +
                "\n 4. Borrar - OK" +
                "\n 5. Vaciar - OK" +
                "\n 6. Cantidad Elementos - OK" +
                "\n 7. Unión - OK" +
                "\n 8. Intersección - OK" +
                "\n 9. Igualdad - OK" +
                "\n 10. Complemento - OK" +
                "\n 11. Posición" +
                "\n 12. Diferencia - OK" +
                "\n 13. Diferencia Simétrica - OK" +
                "\n" +
                "\n 0. SALIR";
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                
                case 1:
                    // Agregar
                    conjuntoListaA.agregar("A");
                    conjuntoListaA.mostrar(conjuntoListaA, "A");
                    break;
                case 2:
                    // Agregar
                    conjuntoListaB.agregar("B");
                    conjuntoListaB.mostrar(conjuntoListaB, "B");
                    break;
                case 3:
                    // Mostrar
                    if(!conjuntoListaA.isVacio(conjuntoListaA)){
                        conjuntoListaA.mostrar(conjuntoListaA, "A");
                    }
                    if(!conjuntoListaB.isVacio(conjuntoListaB)){
                        conjuntoListaB.mostrar(conjuntoListaB, "B");
                    }
                    if(conjuntoListaA.isVacio(conjuntoListaA) && conjuntoListaB.isVacio(conjuntoListaB)){
                        JOptionPane.showMessageDialog(null, "¡No existen conjuntos!\n"
                                + "A = ∅\n"
                                + "B = ∅\n"
                                + "Agrege alguno...", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 4:
                    // Borrar
                    String respuestaBorrar = JOptionPane.showInputDialog(null, "Ingrese el conjunto en el cual borrará un elemento(A/B)", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
                    if(respuestaBorrar.equals("A") || respuestaBorrar.equals("a")){
                        if(!conjuntoListaA.isVacio(conjuntoListaA)){
                            conjuntoListaA.borrarElemento(conjuntoListaA, "A");    
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No existe el conjunto 'A' !\nA = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);                        
                        }
                    }else if(respuestaBorrar.equals("B") || respuestaBorrar.equals("b")){
                        if(!conjuntoListaB.isVacio(conjuntoListaB)){
                            conjuntoListaB.borrarElemento(conjuntoListaB, "B");    
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No existe el conjunto 'B' !\nB = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);                         
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡El conjunto '"+respuestaBorrar+"' no existe!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
                    } 
                    break;
                case 5:
                    // Vaciar
                    String respuestaVaciar = JOptionPane.showInputDialog(null, "Ingrese el conjunto el cual se vaciará(A/B)", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
                    if(respuestaVaciar.equals("A") || respuestaVaciar.equals("a")){
                        if(!conjuntoListaA.isVacio(conjuntoListaA)){
                            conjuntoListaA.vaciarElementos(conjuntoListaA, "A");   
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No existe el conjunto 'A' !\nA = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);                          
                        }
                    }else if(respuestaVaciar.equals("B") || respuestaVaciar.equals("b")){
                        if(!conjuntoListaB.isVacio(conjuntoListaB)){
                            conjuntoListaB.vaciarElementos(conjuntoListaB, "B");    
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No existe el conjunto 'B' !\nB = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);                          
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡El conjunto '"+respuestaVaciar+"' no existe!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                case 6:
                    // Cantidad Elementos
                    String respuestaCantidad = JOptionPane.showInputDialog(null, "Ingrese el conjunto en el cual se mostrará la cantidad de elementos(A/B)", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
                    if(respuestaCantidad.equals("A") || respuestaCantidad.equals("a")){
                        if(!conjuntoListaA.isVacio(conjuntoListaA)){
                            int contador = conjuntoListaA.cantidadElementos(conjuntoListaA);    
                                JOptionPane.showMessageDialog(null, "La cantidad de elementos del conjunto 'A' son: "+contador, TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No existe el conjunto 'A' !\nA = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);                          
                        }
                    }else if(respuestaCantidad.equals("B") || respuestaCantidad.equals("b")){
                        if(!conjuntoListaB.isVacio(conjuntoListaB)){
                            int contador = conjuntoListaB.cantidadElementos(conjuntoListaB);  
                                JOptionPane.showMessageDialog(null, "La cantidad de elementos del conjunto 'A' son: "+contador, TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);                           
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No existe el conjunto 'B' !\nB = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);                          
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡El conjunto '"+respuestaCantidad+"' no existe!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
                    } 
                    
                    break;
                case 7:
                    // Union
                    if(!conjuntoListaA.isVacio(conjuntoListaA) && !conjuntoListaB.isVacio(conjuntoListaB)){ 
                        conjuntoListaUnion.setCabecera(conjuntoListaUnion.union(conjuntoListaA, conjuntoListaB));
                        conjuntoListaUnion.mostrar(conjuntoListaUnion, "A ∪ B = C");
                    }else{
                        JOptionPane.showMessageDialog(null, "¡Verifique que los conjuntos tengan elementos", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);
                        conjuntoListaA.mostrar(conjuntoListaA, "A");
                        conjuntoListaB.mostrar(conjuntoListaB, "B");
                    }
                    break;
                case 8:
                    // Intersección
                    if(!conjuntoListaA.isVacio(conjuntoListaA) && !conjuntoListaB.isVacio(conjuntoListaB)){
                        conjuntoListaInterseccion.setCabecera(conjuntoListaInterseccion.interseccion(conjuntoListaA, conjuntoListaB));
                        conjuntoListaInterseccion.mostrar(conjuntoListaInterseccion, "A ∩ B = C");
                    }else{
                        JOptionPane.showMessageDialog(null, "¡Verifique que los conjuntos tengan elementos", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);
                        conjuntoListaA.mostrar(conjuntoListaA, "A");
                        conjuntoListaB.mostrar(conjuntoListaB, "B");
                    }
                    break;
                case 9:
                    // Igualdad
                    if(!conjuntoListaA.isVacio(conjuntoListaA) && !conjuntoListaB.isVacio(conjuntoListaB)){ 
                        conjuntoListaIgualdad.igualacion(conjuntoListaA, conjuntoListaB);
                    }else{
                        JOptionPane.showMessageDialog(null, "¡Verifique que los dos conjuntos tengan elementos", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);
                        conjuntoListaA.mostrar(conjuntoListaA, "A");
                        conjuntoListaB.mostrar(conjuntoListaB, "B");
                    }
                    break;
                case 10:
                    // Complemento
                    String respuestaComplemento = JOptionPane.showInputDialog(null, "Ingrese el conjunto para hallar su complemento(A/B)", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
                    if(respuestaComplemento.equals("A") || respuestaComplemento.equals("a")){
                        if(!conjuntoListaA.isVacio(conjuntoListaA)){
                            conjuntoListaComplementoA.setCabecera(conjuntoListaComplementoA.complemento(conjuntoListaA, "A"));
                            conjuntoListaComplementoA.mostrar(conjuntoListaComplementoA, "A<sup>C</sup>");
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No existe el conjunto 'A' !\nA = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);                          
                        }
                    }else if(respuestaComplemento.equals("B") || respuestaComplemento.equals("b")){
                        if(!conjuntoListaB.isVacio(conjuntoListaB)){
                            conjuntoListaComplementoB.setCabecera(conjuntoListaComplementoB.complemento(conjuntoListaB, "A"));
                            conjuntoListaComplementoB.mostrar(conjuntoListaComplementoB, "B<sup>C</sup>");  
                        }else{
                            JOptionPane.showMessageDialog(null, "¡No existe el conjunto 'B' !\nB = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);                          
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡El conjunto '"+respuestaComplemento+"' no existe!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
                    }
                    break;
                case 11:
                    // Posiciòn
                    break;
                case 12:
                    // Diferencia
                    if(!conjuntoListaA.isVacio(conjuntoListaA) && !conjuntoListaB.isVacio(conjuntoListaB)){ 
                        String respuestaDiferencia = JOptionPane.showInputDialog(null, "Ingrese el conjunto para hallar la diferencia(A/B)", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
                        if(respuestaDiferencia.equals("A") || respuestaDiferencia.equals("a")){
                                conjuntoListaDiferenciaA.setCabecera(conjuntoListaDiferenciaA.diferencia(conjuntoListaA, conjuntoListaB));
                                conjuntoListaDiferenciaA.mostrar(conjuntoListaDiferenciaA, "A - B");
                        }else if(respuestaDiferencia.equals("B") || respuestaDiferencia.equals("b")){
                                conjuntoListaDiferenciaB.setCabecera(conjuntoListaDiferenciaB.diferencia(conjuntoListaB, conjuntoListaA));
                                conjuntoListaDiferenciaB.mostrar(conjuntoListaDiferenciaB, "B - A");  
                        }else{
                            JOptionPane.showMessageDialog(null, "¡El conjunto '"+respuestaDiferencia+"' no existe!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡Verifique que los conjuntos A & B tengan elementos", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);
                        conjuntoListaA.mostrar(conjuntoListaA, "A");
                        conjuntoListaB.mostrar(conjuntoListaB, "B");
                    }
                    break;
                case 13:
                    // Diferencia Simétrica
                    if(!conjuntoListaA.isVacio(conjuntoListaA) && !conjuntoListaB.isVacio(conjuntoListaB)){ 
                        conjuntoListaDiferenciaSimetrica.setCabecera(conjuntoListaDiferenciaSimetrica.diferenciaSimetrica(conjuntoListaA, conjuntoListaB));
                        conjuntoListaDiferenciaSimetrica.mostrar(conjuntoListaDiferenciaSimetrica, "A ∆ B");         
                    }else{
                        JOptionPane.showMessageDialog(null, "¡Verifique que los conjuntos A & B tengan elementos", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);
                        conjuntoListaA.mostrar(conjuntoListaA, "A");
                        conjuntoListaB.mostrar(conjuntoListaB, "B");
                    }
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
    
     private void menuCombinado() {
        ConjuntoLista conjuntoListaA = new ConjuntoLista();
        String menu = TITLE_MENU_COMBINADO
                + "\n" +
                "\n 1. Agregar conjunto A Lista" +
                "\n 2. Agregar conjunto B Vector" +
                "\n 3. Mostrar" +
                "\n 4. Borrar " +
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
                    conjuntoListaA.agregar("A");
                    conjuntoListaA.mostrar(conjuntoListaA, "A");
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
                    // Diferencia Simétrica
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU_COMBINADO, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcion != 0);
    }
}
