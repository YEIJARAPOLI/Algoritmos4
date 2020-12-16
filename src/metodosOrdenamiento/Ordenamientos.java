package metodosOrdenamiento;

import arbolesNArios.ArbolNArio;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Ordenamientos {
    final static String TITLE_MENU = "*** MÉTODOS DE ORDENAMIENTO ***"; 
    
    public static void main(String[] args) {
        OrdenamientoInterno ordenamiento = new OrdenamientoInterno();
        int tamanoVector = 0;
        Integer[] vector = null;

        String menu = TITLE_MENU
                + "\n"
                + "\n  1. Insertar Vector"
                + "\n  2. Mostrar Vector"
                + "\n"
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
                    /*Integer vector[] = {15,248,67,8,16,398,47,27,12,777,
                                     35,111,89,6,999,510,37,3,74,62,
                                     58,567,44,30,28,19,409,1,603,88};*/
                    
                    vector = ordenamiento.insertarVectorFast(vector);
                    ordenamiento.mostrar(vector,0);
                    /*
                    El Tim Sort y el Quick Sort son los mas rapidos
                    Luego sigue el shell sort
                    y los mas lentos serían el burbuja y el raddix sort
                    */
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
                    //V: 15,67,8,16,44,27,12,35 => 08,12,15,16,27,35,44,67
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
