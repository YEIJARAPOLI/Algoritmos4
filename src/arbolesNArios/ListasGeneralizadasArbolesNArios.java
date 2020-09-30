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
                + "\n1. Insertar Árbol - OK"
                + "\n2. Mostrar Arbol - OK"
                + "\n3. Eliminar - OK"
                + "\n4. Buscar Dato - OK"
                + "\n5. Mostrar Raíces - OK "
                + "\n6. Mostrar Hojas - OK"
                + "\n7. Mostrar Grado Arbol"
                + "\n8. Mostrar Grado Dato Dado - OK "
                + "\n9. Mostrar Hijos Dato Dado - OK"
                + "\n10. Mostrar Nivel - OK"
                + "\n11. Mostrar Altura - OK"
                + "\n12. Mostrar Padre Dato Dato - OK"
                + "\n0. SALIR";
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
                    if(arbol.getRaiz() != null ){
                        arbol.mostrarArbol(arbol.getRaiz());
                    }else{
                        JOptionPane.showMessageDialog(null, "¡El Arbol está Vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE); 
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
                    arbol.mostrarRaices(arbol.getRaiz());
                    break;
                //Mostrar Hojas
                case 6:
                    arbol.mostrarHojas(arbol.getRaiz());
                    break;
                //Mostrar Grado Arbol
                case 7:
                    break;
                //Mostrar Grado Dato Dado
                case 8:                  
                    String datoDadoGetGrado;
                    datoDadoGetGrado = JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo a buscarle el grado", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    arbol.mostrarGradoDatoDado(arbol.getRaiz(), datoDadoGetGrado);
                    break; 
                //Mostrar Hijos Dato Dado 
                case 9:
                    String datoDadoGetHijos;
                    datoDadoGetHijos = JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo a buscarle los hijos", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    arbol.mostrarHijosDatoDado(arbol.getRaiz(), datoDadoGetHijos);
                    break;    
                //Mostrar Nivel
                case 10:
                    Integer nivel = 1;
                    dato = JOptionPane.showInputDialog(null, "Ingrese el dato a calcularle el nivel", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    nivel = arbol.mostrarNivel(arbol.getRaiz(), dato, 1);
                    System.out.println("El nivel del dato '" + dato + "' en el arbol es :: " + nivel);
                    break;
                //Mostrar Altura
                case 11:
                    Integer altura = 1;
                    altura = arbol.mostrarAltura(arbol.getRaiz());
                    System.out.println("La altura del arbol es :: " + altura);
                    break;
                //Mostrar Padre Dato Dato
                case 12:
                    String datoDadoGetPadre;
                    datoDadoGetPadre = JOptionPane.showInputDialog(null, "Ingrese el dato del Nodo a buscarle el padre", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    arbol.mostrarPadreDatoDado(arbol.getRaiz(), datoDadoGetPadre);
                    break; 
                case 0:
                    System.exit(0);
                    break;
                default:JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
}
