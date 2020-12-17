package metodosOrdenamiento;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;
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
        Random random = new Random();
        vector = new Integer[tamanoVec];  
        for (int i = 0; i < tamanoVec; i++) {
            //int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un elemento al vector, en la posición ["+i+"]", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE));
            //vector[i] = dato;
            vector[i] = random.nextInt(1000);
        }
        return vector;
    }
   
    public Integer[] insertarVectorFast(Integer[] newVector) {
       vector = newVector;  
       tamanoVector = newVector.length;
       return vector;
    }
    
    public void mostrar(Integer[] vector, long tiempoTotalEjecucion) {
        Date Date = new Date(tiempoTotalEjecucion);
        long segundos = TimeUnit.NANOSECONDS.convert(Date.getTime(), TimeUnit.MILLISECONDS);     
        
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
                    + "\nY el tiempo de ejecución fue de: "+Date.getTime()+" nanosegundos. ", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

    public  void timSort(Integer[] copiaVectorTimSort) {
        long tiempoInicio, tiempoFin;
        tiempoInicio = System.nanoTime();
                
        int tamanoV = copiaVectorTimSort.length;
        int tamanoSubV = 0;
        if(tamanoV > 2048){
            tamanoSubV = tamanoV / 1024;
        }else{
            tamanoSubV = 100;
        }
        for (int i = 0; i < tamanoV; i += tamanoSubV) {
            timInsercion(copiaVectorTimSort, i, Math.min((i + tamanoSubV - 1), (tamanoV -1)));
        }
        for (int tamanoM = tamanoSubV; tamanoM < tamanoV; tamanoM = 2 * tamanoM) {
            for (int izquierda = 0; izquierda < tamanoV; izquierda += 2 * tamanoM) {
               int medio = izquierda + tamanoM - 1;
               int derecha = Math.min((izquierda + 2 * tamanoM - 1), (tamanoV - 1));
               if(medio <= derecha){
                   timMerge(copiaVectorTimSort, izquierda, medio, derecha);
               }
            }
        }
        tiempoFin = System.nanoTime();
        mostrar(copiaVectorTimSort, tiempoFin - tiempoInicio);
    }
    
    public static void timInsercion(Integer[] copiaVectorTimSort, int izquierda, int derecha){
        for (int i = izquierda + 1; i <= derecha; i++) {
            int intercambio = copiaVectorTimSort[i];
            int j = i - 1;
            while(copiaVectorTimSort[j] > intercambio && j >= izquierda){
                copiaVectorTimSort[j+1] = copiaVectorTimSort[j];
                j--;
                if(j < 0){
                    break;
                }
            }
            copiaVectorTimSort[j+1] = intercambio;
        }
    }
    
    public static void timMerge(Integer[] copiaVectorTimSort, int izquierda, int medio, int derecha){
        int tamanoIzq = medio - izquierda + 1;
        int tamanoDer = derecha - medio;
        Integer[] tempIzq = new Integer[tamanoIzq];
        Integer[] tempDer = new Integer[tamanoDer];       
        
        for (int x = 0; x < tamanoIzq; x++) {
            tempIzq[x] = copiaVectorTimSort[izquierda + x];
        }
        for (int x = 0; x < tamanoDer; x++) {
            tempDer[x] = copiaVectorTimSort[medio + 1 + x];
        }
        
        int i = 0;
        int j = 0;
        int k = izquierda;
        
        while (i < tamanoIzq && j < tamanoDer){
            if(tempIzq[i] <= tempDer[j]){
                copiaVectorTimSort[k] = tempIzq[i];
                i++;
            }else{
                copiaVectorTimSort[k] = tempDer[j];
                j++;
            }
            k++;
        }
        
        while (i < tamanoIzq){
            copiaVectorTimSort[k] = tempIzq[i];
            k++;
            i++;
        }
        
        while (j < tamanoDer){
            copiaVectorTimSort[k] = tempDer[j];
            k++;
            j++;
        }
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
    
    /* Divide el vector en subvectores empezando con un pivote*/
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

    public void shellSort(Integer[] copiaVectorShellSort) {
        long tiempoInicio, tiempoFin;

        tiempoInicio = System.nanoTime();

        for (int increment = copiaVectorShellSort.length / 2; increment > 0; increment = (increment == 2) ? 1 : (int) Math.round(increment / 2.2)) {
            for (int i = increment; i < copiaVectorShellSort.length; i++) {
                for (int j = i; j >= increment && copiaVectorShellSort[j - increment] > copiaVectorShellSort[j]; j -= increment) {
                    int tmp = copiaVectorShellSort[j];

                    copiaVectorShellSort[j] = copiaVectorShellSort[j - increment];
                    copiaVectorShellSort[j - increment] = tmp;
                }
            }
        }

        tiempoFin = System.nanoTime();

        // Mostrando el arreglo ordenado
        mostrar(copiaVectorShellSort, (tiempoFin - tiempoInicio));
    }

    public void raddixSort(Integer[] copiaVectorRaddixSort) {
        int j;
        long tiempoInicio, tiempoFin;

        tiempoInicio = System.nanoTime();

        for (int x = Integer.SIZE - 1; x >= 0; x--) {
            Integer tmp[] = new Integer[copiaVectorRaddixSort.length];

            j = 0;

            for (int i = 0; i < copiaVectorRaddixSort.length; i++) {
                boolean mover = copiaVectorRaddixSort[i] << x >= 0;

                if (x == 0 ? !mover : mover) {
                    tmp[j] = copiaVectorRaddixSort[i];
                    j++;
                } else {
                    copiaVectorRaddixSort[i - j] = copiaVectorRaddixSort[i];
                }
            }

            for (int i = j; i < copiaVectorRaddixSort.length; i++) {
                tmp[i] = copiaVectorRaddixSort[i - j];
            }

            copiaVectorRaddixSort = tmp;
        }

        tiempoFin = System.nanoTime();

        // Mostrando el arreglo ordenado
        mostrar(copiaVectorRaddixSort, (tiempoFin - tiempoInicio));
    }

}
