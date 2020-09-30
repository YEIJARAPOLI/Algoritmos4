package arbolesNArios;

import javax.swing.JOptionPane;

/**
 * @author leonChanci
 * @since 09/09/2020
 */
public class ArbolNArio {
    NodoArbolNArio raiz;
    int gradoFinalArbol = 1;
    boolean registroEliminado = false;
    
    //Variable tipo text para el nombre del MENÚ
    final static String TITLE_MENU = "*** ARBOL N_ARIO ***"; 
    
    //Método constructor
    public ArbolNArio() {
        raiz = null; 
    }

   /**
    * Método para mostrar(Recorrer) las litas 
    * @author leonChanci
    * @since 09/09/2020
    * @param p Objet tipo NodoArbolNArio 
    */
    public void mostrarArbol(NodoArbolNArio p){
        NodoArbolNArio q = p;
        while(q != null){
            if(q.isSw() == false){
                System.out.print(q.getDato()+" - ");
            
            }else{
                mostrarArbol(q.getLigaLista());
            }
            q = q.getLiga();
        }
    }
      
   /**
    * Método para Insertar un Nodo
    * @author leonChanci
    * @since 16/09/2020
    * @param p Objet tipo NodoArbolNArio
    * @param dato Dato a Insertar
    * @return nuevoNodo
    */
    public NodoArbolNArio insertNodo(NodoArbolNArio p, String dato){
        NodoArbolNArio nuevoNodo = null;
        if(p == null){
           nuevoNodo = new NodoArbolNArio(dato);
        }
        return nuevoNodo;
    }
   
   /**
    * Método Insertar Arbol
    * @author leonChanci
    * @since 18/09/2020
    * @param p NodoArbolNArio
    * @param dato Nodo a buscar para insertar
    * @param datoBuscar Dato a buscar para insertar
    */
    public void insertarArbol(NodoArbolNArio p, String dato, String datoBuscar){
        NodoArbolNArio q = p;
        NodoArbolNArio auxiliar;
        while(q != null ){ 
            if(q.isSw() == false && q.getDato().equals(datoBuscar)){
                //Si es Nodo cabeza
                if(q == p){
                    auxiliar = q.getLiga(); 
                    //Si tiene hijos insertar al final
                    if(auxiliar != null){
                        while(auxiliar != null){
                            if(auxiliar.getLiga() == null){
                                auxiliar.setLiga(new NodoArbolNArio(dato));
                                return;  
                            }
                        auxiliar = auxiliar.getLiga();
                        }
                    //Si no tiene hijos
                    }else{
                        q.setLiga(new NodoArbolNArio(dato));    
                        return;
                    }
                //Si NO es Nodo cabeza Inserte hijo
                }else if(q != p){
                    q.setDato("");  
                    q.setSw(true);  
                    NodoArbolNArio nuevoNodoHijo = insertNodo(q.getLigaLista(), datoBuscar);
                    q.setLigaLista(nuevoNodoHijo);    
                    nuevoNodoHijo.setLiga(new NodoArbolNArio(dato));
                    return;
                }
            }
            else{
                insertarArbol(q.getLigaLista(), dato, datoBuscar);
            }
            q = q.getLiga();
        }
    }

    //Método eliminar
    public void eliminarNodo(String dato){
        if (raiz == null) {
            JOptionPane.showMessageDialog(null, "¡El arbol se encuentra vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        eliminarNodo(raiz, dato);
    }
    
    private NodoArbolNArio eliminarNodo(NodoArbolNArio nodo, String dato) {
        NodoArbolNArio q = nodo, p, ant = null, sig;
        
        while (q != null) {
            if (!q.isSw()) {
                if (q.getDato().equals(dato)) {
                    if (raiz == q) {
                        if (q.getLiga() != null) {
                            if (!q.getLiga().isSw()) {
                                raiz = q.getLiga();
                                break;
                            } else {
                                // El nodo que le sigue a la cabeza contiene una lista y por tanto sus hijos pasaran hacer nodos
                                sig = q.getLiga();
                                raiz = q.getLiga().getLigaLista();
                                p = raiz;
                                
                                while (p != null) {
                                    if (p.getLiga() == null) {
                                        p.setLiga(sig.getLiga());
                                        break;
                                    }
                                    
                                    p = p.getLiga();
                                }
                                
                                registroEliminado = true;
                            }
                        }
                    } else {
                        if (q.getLiga().isSw()) {
                            if (ant != null && !ant.isSw()) {
                                ant.setLiga(q.getLiga());
                                break;
                            } else {
                                sig = q.getLiga();
                                q = q.getLiga().getLigaLista();
                                p = q;

                                while (p != null) {
                                    if (p.getLiga() == null) {
                                        p.setLiga(sig.getLiga());
                                        break;
                                    }

                                    p = p.getLiga();
                                }

                                registroEliminado = true;
                                return q;
                            }
                        } else {
                            ant.setLiga(q.getLiga());
                            break;
                        }
                    }
                }
            } else {
                NodoArbolNArio eliminado = eliminarNodo(q.getLigaLista(), dato);
                if (registroEliminado) {
                    q.setLigaLista(eliminado);
                }
            }
            
            if (registroEliminado) {
                break;
            }
            
            ant = q;
            q = q.getLiga();
        }
        
        //return registroEliminado;
        return q;
    }
    
    //Método Buscar Dato
    public void buscarDato(String dato){
        if (raiz == null) {
            JOptionPane.showMessageDialog(null, "¡El arbol se encuentra vacío!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        buscarDato(raiz, dato);
    }
    
    private boolean buscarDato(NodoArbolNArio p, String dato) {
        NodoArbolNArio q = p;
        
        while (q != null) {
            if (!q.isSw()) {
                if (q.getDato().equals(dato)) {
                    System.out.println("Se encontro el dato '" + dato + "', solicitado por el usuario");
                    return true;
                }
            } else {
                buscarDato(q.getLigaLista(), dato);
            }
            
            q = q.getLiga();
        }
        
        return false;
    }

   /**
    * Método para mostrar las raíces del Árbol
    * @author leonChanci
    * @since 25/09/2020
    * @param p Objet tipo NodoArbolNArio 
    */
    public void mostrarRaices(NodoArbolNArio p){
        NodoArbolNArio q = p;
        while(q != null){
            if(q.isSw() == false){
                if(q == p){
                   System.out.print(q.getDato()+ " - ");
                }
            }else{
                mostrarRaices(q.getLigaLista());
            }
            q = q.getLiga();
        }
    }
    
   /**
    * Método para mostrar las hojas del Árbol
    * @author leonChanci
    * @since 25/09/2020
    * @param p Objet tipo NodoArbolNArio 
    */
    public void mostrarHojas(NodoArbolNArio p){
        NodoArbolNArio q = p;
        while(q != null){
            if(q.isSw() == false){
                if(q != p){
                   System.out.print(q.getDato()+ " - ");
                }
            }else{
                mostrarHojas(q.getLigaLista());
            }
            q = q.getLiga();
        }
    }
    
   /**
    * Método para mostrar el grado del Árbol
    * @author leonChanci
    * @since 30/09/2020
    * @param p Objet tipo NodoArbolNArio 
    */
    public int mostrarGradoArbol(NodoArbolNArio p){
        int gradoNodo = 0;
        NodoArbolNArio q = p, auxiliar;
        
        while(q != null){ 
            if(q.isSw() == false){
                if(q == p){
                    auxiliar = q.getLiga();
                    while(auxiliar != null){
                        gradoNodo++;     
                    auxiliar = auxiliar.getLiga();
                    }     
                    if(gradoNodo > gradoFinalArbol){
                        gradoFinalArbol = gradoNodo;
                    }
                } 
            }else{
                mostrarGradoArbol(q.getLigaLista());
                
            }
            q = q.getLiga();
        }
        return gradoFinalArbol;
    } 
    
   /**
    * Método mostrar el grado de un dato(Nodo) dado
    * @author leonChanci
    * @since 11/09/2020
    * @param p Objet tipo NodoArbolNArio
    * @param dato Dato del Nodo buscarle el grado
    */
    public void mostrarGradoDatoDado(NodoArbolNArio p, String dato){
        NodoArbolNArio q = p;
        NodoArbolNArio auxiliar;
        int gradoNodo = 0;
        while(q != null){ 
            if(q.isSw() == false && q.getDato().equals(dato)){
                if(q == p){
                    auxiliar = q.getLiga();
                    while(auxiliar != null){
                        gradoNodo++;
                    auxiliar = auxiliar.getLiga();
                    }         
                }     
                JOptionPane.showMessageDialog(null, "El grado del Nodo \'"+dato+"\' es "+gradoNodo+".");
                return;
            }else{
                mostrarGradoDatoDado(q.getLigaLista(), dato);
            }
            q = q.getLiga();
        } 
    }
 
   /**
    * Método mostrar los hijos de un dato(Nodo) dado
    * @author leonChanci
    * @since 25/09/2020
    * @param p Objet tipo NodoArbolNArio
    * @param dato Dato del Nodo buscarle los hijos
    */
    public void mostrarHijosDatoDado(NodoArbolNArio p, String dato){
        NodoArbolNArio q = p;
        NodoArbolNArio auxiliar;
        while(q != null){ 
            if(q.isSw() == false && q.getDato().equals(dato)){
                if(q == p){
                    auxiliar = q.getLiga();
                    while(auxiliar != null){
                        if(auxiliar.getDato() == null){
                            System.out.print(auxiliar.getLigaLista().getDato()+ ",  "); 
                        }else{
                            System.out.print(auxiliar.getDato()+ ",  ");  
                        }   
                    auxiliar = auxiliar.getLiga();
                    }   
                }     
            }else{
                mostrarHijosDatoDado(q.getLigaLista(), dato);
            }
            q = q.getLiga();
        } 
    } 
    
    public int mostrarNivel(NodoArbolNArio p, String dato, int nivel){
        int tmp = 0;
        NodoArbolNArio q = p;
        
        if (q == null) {
            return -1;
        } else if (q.getDato().equals(dato)) {
            return nivel;
        } else {
            while (q != null) {
                if (q.isSw()) {
                    tmp = mostrarNivel(q.getLigaLista(), dato, nivel + 1);
                    
                    if (tmp != -1) {
                        return tmp;
                    }
                } else if (q.getDato().equals(dato)) {
                    return nivel + 1;
                }
                
                q = q.getLiga();
            }
            
            return -1;
        }
    }
        
    public int mostrarAltura(NodoArbolNArio p){
        int mayor = 0, tmp;
        boolean bandera = false;
        NodoArbolNArio q = p;
        
        if (q == null) {
            return 0;
        } else {
            while (q != null) {
                if (q.isSw()) {
                    tmp = mostrarAltura(q.getLigaLista());
                    
                    if (tmp > mayor) {
                        mayor = tmp;
                    }
                }
                
                if (!bandera && q.getLiga() != null) {
                    mayor++;
                    bandera = true;
                }
                
                q = q.getLiga();
            }
            
            return mayor + 1;
        }
    }
 
   /**
    * Método mostrar el padre de un dato(Nodo) dado
    * @author leonChanci
    * @since 25/09/2020
    * @param p Objet tipo NodoArbolNArio
    * @param dato Dato del Nodo buscarle el padre
    * @param anterior Dato del Nodo buscarle el padre
    * @param sw Dato del Nodo buscarle el padre
    * @return sw
    */
    public boolean mostrarPadreDatoDado(NodoArbolNArio p, String dato, NodoArbolNArio anterior, boolean sw){
        NodoArbolNArio q = p, auxiliar;
        while(q != null){ 
            if(q.isSw() == false && q.getDato().equals(dato)){
                sw = true;
                if(q == p){ 
                    if(anterior != null){ 
                        auxiliar = q.getLiga();
                        while(auxiliar != null){
                            if(auxiliar.getDato() == null && anterior.getDato() != null){
                                System.out.println("El padre del Nodo \'"+dato+"\' es " + anterior.getDato());
                                return true;
                            }        
                        auxiliar = auxiliar.getLiga();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "¡El Nodo \'"+dato+"\' es el Nodo Raíz!");
                        return true;
                    }
                    System.out.println("El padre del Nodo \'"+dato+"\' es " + anterior.getDato());
                }else{
                    System.out.println("El padre del Nodo \'"+dato+"\' es " + p.getDato());
                    return true;
                }   
            }else{
                mostrarPadreDatoDado(q.getLigaLista(), dato, anterior, false);
            }
            if( p!= null){
                anterior = p; 
            }
            q = q.getLiga();
        } 
        return sw;
    } 
    
    //Getters and Setters
    //Método para Obtener la raiz del árbol
    public NodoArbolNArio getRaiz(){
        return(raiz);
    }
    
    //Método para Setear la raiz del árbo
    public void setRaiz(NodoArbolNArio raiz){
        this.raiz = raiz;
    }
}