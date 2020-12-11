package metodosOrdenamiento;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Métodos de Ordenamiento
 * @author leonChanci
 * @since 4/12/2020
 */

public class OrdenamientoInterno {
    final static String TITLE_MENU = "*** METÓDOS DE ORDENAMIENTO ***"; 
    Integer vector[];
    int tamanoVector;
    //Tamaño del vector
    
    public Integer[] insertarVector(int tamanoVec) {
        tamanoVector = tamanoVec;
        vector = new Integer[tamanoVec];  
        for (int i = 0; i < tamanoVec; i++) {
            int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un elemento al vector, en la posición ["+i+"]", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE));
            vector[i] = dato;
        }
        return vector;
    }

    public void mostrar(Integer[] vector, long tiempoTotalEjecucion) {
        Date Date = new Date(tiempoTotalEjecucion);
        String salida = "Vector = [ ";
        for (int i = 0; i < vector.length; i++) {
            if(tamanoVector-1 == i){
               salida = salida+vector[i]; 
            }else{
               salida = salida+vector[i]+"  |  "; 
           }              
        }
        if(tiempoTotalEjecucion == 0){
            JOptionPane.showMessageDialog(null, salida+" ]", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, salida+" ]\n"
                    + "\nY el tiempo de ejecución fue de: "+Date.getTime()+" nanosegundos.", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    public Integer[] timSort(Integer[] copiaVectorTimSort) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void ejecutarMetodoQuickSort(Integer[] copiaVectorQuickSort){
        //Las variables primero y ultimo son para calcular el pivote; es decir, donde se partirá el vector
        int primero = 0;
        int ultimo = tamanoVector-1;
        long tiempoInicio, tiempoFin, tiempoTotal; //Variables para determinar el tiempo de ejecución
        //tiempoInicio = System.currentTimeMillis();
        tiempoInicio = System.nanoTime();
        quickSort(copiaVectorQuickSort, primero, ultimo);
        tiempoFin = System.nanoTime();
        tiempoTotal = tiempoFin - tiempoInicio;
        mostrar(copiaVectorQuickSort, tiempoTotal);
    }
    
    public void quickSort(Integer[] vector, int primero, int ultimo) {
        int i, j, central;
        double pivote;
        //Se halla el pivote sumando la pocición 0 con la ultima posición => MITAD del vector
        central = (primero + ultimo) / 2;
        pivote = vector[central];
        i = primero;
        j = ultimo;
        do{
            while (vector[i] < pivote) i++;
            while (vector[j] > pivote) j--;
                if (i <= j){
                    int temp;
                    temp = vector[i];
                    vector[i] = vector[j];
                    vector[j] = temp;
                    i++;
                    j--;
                }
        } while (i <= j);
        if (primero < j){
            quickSort(vector, primero, j);
        }
        if (i < ultimo) {
            quickSort(vector, i, ultimo);
        }
    }

    public void burbuja(Integer[] copiaVectorBurbuja) {
        Integer tmp;
        long tiempoInicio, tiempoFin;

        tiempoInicio = System.nanoTime();

        for (int i = 0; i < (copiaVectorBurbuja.length - 1); i++) {
            for (int j = 0; j < (copiaVectorBurbuja.length - 1); j++) {
                if (copiaVectorBurbuja[j] > copiaVectorBurbuja[j + 1]) { // Si numeroActual > numeroSiguiente
                    tmp = copiaVectorBurbuja[j];
                    copiaVectorBurbuja[j] = copiaVectorBurbuja[j + 1];
                    copiaVectorBurbuja[j + 1] = tmp;
                }
            }
        }

        tiempoFin = System.nanoTime();

        // Mostrando el arreglo ordenado
        mostrar(copiaVectorBurbuja, (tiempoFin - tiempoInicio));
    }

    public Integer[] shellSort(Integer[] copiaVectorShellSort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer[] raddixSort(Integer[] copiaVectorRaddixSort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
