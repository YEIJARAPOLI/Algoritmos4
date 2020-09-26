package arbolesNArios;

import javax.swing.JOptionPane;

/**
 * @author leonChanci
 * @since 09/09/2020
 */
public class ArbolNArio {
    NodoArbolNArio raiz;
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
    * @param dato Dato a Insertar
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
    * @param datoBuscar 
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
            if (!q.isSw()/* && (q.getDato().equals(dato))*/) {
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
    public void buscarDato(int dato){
        
    }

   /**
    * Método para mostrar las raíces del árbol
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
    * Método para mostrar las hojas del árbol
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
    
    public void mostrarGradoArbol(NodoArbolNArio p){

    } 
    
   /**
    * Método mostrar el grado de un dato(Nodo) dado
    * @author leonChanci
    * @since 11/09/2020
    * @param p Objet tipo NodoArbolNArio
    * @param dato Dato del Nodo buscarle el grad 
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
    * @param dato Dato del Nodo buscarle el grad 
    */
    public void mostrarHijosDatoDado(NodoArbolNArio p, String dato){
        NodoArbolNArio q = p;
        NodoArbolNArio auxiliar;
        while(q != null){ 
            if(q.isSw() == false && q.getDato().equals(dato)){
                if(q == p){
                    auxiliar = q.getLiga();
                    while(auxiliar != null){
                        if(auxiliar.getDato().equals("")){
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
    
    public void mostrarNivel(NodoArbolNArio p){

    }
        
    public void mostrarAltura(NodoArbolNArio p){

    }
 
   /**
    * Método mostrar el apdre de un dato(Nodo) dado
    * @author leonChanci
    * @since 25/09/2020
    * @param p Objet tipo NodoArbolNArio
    * @param dato Dato del Nodo buscarle el grad 
    */
    public void mostrarPadreDatoDado(NodoArbolNArio p, String dato){
        NodoArbolNArio q = p;
        NodoArbolNArio auxiliar, anterior = null;
        while(q != null){ 
            if(q.isSw() == false && q.getDato().equals(dato)){
                if(q == p){
                        auxiliar = q.getLiga();
                        while(auxiliar != null){   
                        auxiliar = auxiliar.getLiga();
                        }  
                        if(anterior != null){
                        System.out.print(anterior.getDato()+ " - "); }
                }     
            }else{
                mostrarPadreDatoDado(q.getLigaLista(), dato);
            }
            anterior = q;
            q = q.getLiga();
        } 
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