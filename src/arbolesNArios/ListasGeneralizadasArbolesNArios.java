package arbolesNArios;

import javax.swing.JOptionPane;

/**
 * Arboles N Arios con Listas Generalizadas
 * @author leonChanci
 * @since 09/09/2020
 */
public class ListasGeneralizadasArbolesNArios {

    //Variable tipo text para el nombre del MENÚ
    final static String TITLE_MENU = "*** ARBOLES N_ARIOS ***"; 
    
    public static void main(String[] args) {
        ArbolNArio arbol = new ArbolNArio();
        
        String menu = TITLE_MENU
                + "\n"
                + "\n  1. Insertar Árbol"
                + "\n  2. Mostrar Arbol"
                + "\n  3. Eliminar"
                + "\n  4. Buscar Dato"
                + "\n  5. Mostrar Raíces"
                + "\n  6. Mostrar Hojas"
                + "\n  7. Mostrar Grado Arbol"
                + "\n  8. Mostrar Grado Dato Dado"
                + "\n  9. Mostrar Hijos Dato Dado"
                + "\n10. Mostrar Nivel"
                + "\n11. Mostrar Altura"
                + "\n12. Mostrar Padre Dato Dato"
                + "\n"
                + "\n  0. SALIR";
        int opcion;
        String dato;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                //Insertar Árbol
                case 1: 
                    String datoBuscarForInsert;
                    dato = JOptionPane.showInputDialog(null, "Ingrese Dato a Insertar", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    if(arbol.getRaiz() != null){
                        datoBuscarForInsert = JOptionPane.showInputDialog(null, "Ingrese el Nodo donde quiere Insertar el dato", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);                        
                    }else{ 
                        NodoArbolNArio raiz = new NodoArbolNArio(dato);
                        arbol.setRaiz(raiz);
                        break;
                    }
                    arbol.insertarArbol(arbol.getRaiz(), dato, datoBuscarForInsert);
                    break;
                //Mostrar arbol
                case 2:
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Arbol está Vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);    
                    }else{
                        arbol.mostrarArbol(arbol.getRaiz());
                    }
                    break;
                //Eliminar
                case 3:  
                    String datoBuscarForDelete;
                    datoBuscarForDelete = JOptionPane.showInputDialog(null, "Ingrese Dato a Elminar", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    arbol.eliminarNodo(datoBuscarForDelete);
                    break;
                //Buscar Dato
                case 4:
                    dato = JOptionPane.showInputDialog(null, "Ingrese Dato a Buscar", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    arbol.buscarDato(dato);
                    break;
                //Mostrar Raices
                case 5:
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Arbol está Vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);    
                    }else{
                        arbol.mostrarRaices(arbol.getRaiz());
                    }
                    break;
                //Mostrar Hojas
                case 6:
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Arbol está Vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);    
                    }else{
                        arbol.mostrarHojas(arbol.getRaiz());
                    }
                    break;
                //Mostrar Grado Arbol
                case 7:
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Árbol está vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE); 
                    }else{
                        int gradoArbol = arbol.mostrarGradoArbol(arbol.getRaiz());
                        JOptionPane.showMessageDialog(null, "El grado del Árbol es "+gradoArbol+".");
                        break;
                    }
                    break;
                //Mostrar Grado Dato Dado
                case 8:   
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Arbol está Vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);    
                    }else{
                        String datoDadoGetGrado;
                        datoDadoGetGrado = JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo a buscarle el grado", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                        arbol.mostrarGradoDatoDado(arbol.getRaiz(), datoDadoGetGrado);
                    }
                    break; 
                //Mostrar Hijos Dato Dado 
                case 9:
                    String datoDadoGetHijos;
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Árbol está vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE); 
                    }else{
                        datoDadoGetHijos = JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo a buscarle los hijos", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);                        
                        arbol.mostrarHijosDatoDado(arbol.getRaiz(), datoDadoGetHijos);    
                    }
                    break;   
                //Mostrar Nivel
                case 10:
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Árbol está vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE); 
                    }else{
                        Integer nivel = 1;
                        dato = JOptionPane.showInputDialog(null, "Ingrese el dato a calcularle el nivel", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                        nivel = arbol.mostrarNivel(arbol.getRaiz(), dato, 1);
                        JOptionPane.showMessageDialog(null, "El nivel del Nodo '" + dato + "' en el Árbol es " + nivel+".");
                    }
                    break;
                //Mostrar Altura
                case 11:
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Árbol está vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE); 
                    }else{
                        Integer altura = 1;
                        altura = arbol.mostrarAltura(arbol.getRaiz());
                        JOptionPane.showMessageDialog(null, "La altura del Árbol es "+altura+".");
                    }
                    break;
                //Mostrar Padre Dato Dato
                case 12:
                    String datoDadoGetPadre;
                    if(isArbolVacio(arbol.getRaiz())){
                        JOptionPane.showMessageDialog(null, "¡El Árbol está vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE); 
                    }else {
                        datoDadoGetPadre = JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo a buscarle el padre", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                        arbol.mostrarPadreDatoDado(arbol.getRaiz(), datoDadoGetPadre, null, false);                    
                    }
                    break; 
                case 0:
                    System.exit(0);
                    break;
                default:JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(opcion != 0);
    }
    
    public static boolean isArbolVacio(NodoArbolNArio arbol){
        if(arbol != null){
            return false;
        }
        return true;
    }
    
    public NodoArbolNArio crearArbol(ArbolNArio arbol){
        arbol.setRaiz(new NodoArbolNArio("X"));
        arbol.getRaiz().setLiga(new NodoArbolNArio(null));
        arbol.getRaiz().getLiga().setLigaLista(new NodoArbolNArio("C"));
        arbol.getRaiz().getLiga().getLigaLista().setLiga(new NodoArbolNArio("D"));
        arbol.getRaiz().getLiga().getLigaLista().getLiga().setLiga(new NodoArbolNArio("E"));
        
        arbol.getRaiz().getLiga().setLiga(new NodoArbolNArio("F"));
        
        arbol.getRaiz().getLiga().getLiga().setLiga(new NodoArbolNArio(null));
        arbol.getRaiz().getLiga().getLiga().getLiga().setLigaLista(new NodoArbolNArio("H"));
        arbol.getRaiz().getLiga().getLiga().getLiga().getLigaLista().setLiga(new NodoArbolNArio("W"));
        
        arbol.getRaiz().getLiga().getLiga().getLiga().getLigaLista().getLiga().setLiga(new NodoArbolNArio(null));
        arbol.getRaiz().getLiga().getLiga().getLiga().getLigaLista().getLiga().getLiga().setLigaLista(new NodoArbolNArio("G"));
        arbol.getRaiz().getLiga().getLiga().getLiga().getLigaLista().getLiga().getLiga().getLigaLista().setLiga(new NodoArbolNArio("Z"));
        
        arbol.getRaiz().getLiga().getLiga().getLiga().getLigaLista().getLiga().getLiga().setLiga(new NodoArbolNArio("K"));
        arbol.getRaiz().getLiga().getLiga().getLiga().getLigaLista().getLiga().getLiga().getLiga().setLiga(new NodoArbolNArio("M"));
        
        arbol.getRaiz().getLiga().getLiga().getLiga().setLiga(new NodoArbolNArio("S"));

        return arbol.getRaiz();
    }
}
