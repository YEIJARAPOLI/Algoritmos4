package metodosOrdenamiento;

import arbolesNArios.ArbolNArio;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Ordenamientos {
    final static String TITLE_MENU = "*** METÓDOS DE ORDENAMIENTO ***"; 
    
    public static void main(String[] args) {
        OrdenamientoInterno ordenamiento = new OrdenamientoInterno();
        int tamanoVector = 0;
        Integer[] vector = null;

        String menu = TITLE_MENU
                + "\n"
                + "\n  1. Insertar Vector"
                + "\n  2. Mostrar Vector"
                + "\n  3. Método Tim Sort"
                + "\n  4. Método Quick Sort"
                + "\n  5. Método Burbuja"
                + "\n  6. Método Shell Sort"
                + "\n  7. Método Raddix Sort"
                + "\n"
                + "\n  0. SALIR";
        int opcion;

        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(opcion){
                //Insertar
                case 1:
                    tamanoVector = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tamaño del vector", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE));
                    vector = ordenamiento.insertarVector(tamanoVector);
                    ordenamiento.mostrar(vector,0);
                    break;
                //Mostrar
                case 2:
                    if(vector != null){
                        ordenamiento.mostrar(vector,0);
                    }else{
                        mostrarMensajeVectorVacio();
                    }   
                    break;
                //Tim Sort
                case 3: 
                    if(vector != null){
                        Integer[] copiaVectorTimSort = hacerCopiaVector(vector);
                        ordenamiento.timSort(copiaVectorTimSort); 
                    }else{
                        mostrarMensajeVectorVacio();
                    }
                    break; 
                //Quick Sort
                case 4:
                    //V: 15,67,08,16,44,27,12,35 => 08,12,15,16,27,35,44,67
                    if(vector != null){
                        Integer[] copiaVectorQuickSort = hacerCopiaVector(vector);
                        ordenamiento.ejecutarMetodoQuickSort(copiaVectorQuickSort); 
                    }else{
                        mostrarMensajeVectorVacio();
                    }
                    break;
                //Burbuja
                case 5:
                    if(vector != null){
                        Integer[] copiaVectorBurbuja = hacerCopiaVector(vector);
                        ordenamiento.burbuja(copiaVectorBurbuja);
                    }else{
                        mostrarMensajeVectorVacio();
                    }
                    break;
                //Shell Sort
                case 6:
                    if(vector != null){
                        Integer[] copiaVectorShellSort = hacerCopiaVector(vector);
                        ordenamiento.shellSort(copiaVectorShellSort);
                    }else{
                        mostrarMensajeVectorVacio();
                    }
                    break;
                //Raddix Sort
                case 7:
                    if(vector != null){
                        Integer[] copiaVectorRaddixSort = hacerCopiaVector(vector);
                        ordenamiento.raddixSort(copiaVectorRaddixSort);
                    }else{
                        mostrarMensajeVectorVacio();
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

    private static Integer[] hacerCopiaVector(Integer[] vector) {
        Integer[] copiaVector = new Integer[vector.length];  
        for (int i = 0; i < copiaVector.length; i++) {
            copiaVector[i] = vector[i];
        }
        return copiaVector;
    }

    private static void mostrarMensajeVectorVacio() {
        JOptionPane.showMessageDialog(null, "¡El vector esta vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
    }

    
}
