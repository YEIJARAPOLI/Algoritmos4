package arbolesNArios;

import javax.swing.JOptionPane;

/**
 * @author leonChanci
 * @since 09/09/2020
 */
public class ArbolNArio {
    NodoArbolNArio raiz;
    String datoABuscar = null;
    boolean registroEliminado = false;
    
    final static String TITLE_MENU = "** ARBOL N__ARIO **"; 
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
                //Imprimir las hojas de un arbol if(listaRecibida != listaEnviada){
                //Imprimir las raices de un arbol if(listaRecibida == listaEnviada){
                //if(q != p){
                   // JOptionPane.showMessageDialog(null, listaRecibida.getDato());  
                // }
                //JOptionPane.showMessageDialog(null, q.getDato()); 
                System.out.print(q.getDato()+ ",  ");
            
            }else{
                mostrarArbol(q.getLigaLista());
                //Pueden haber otras instrucciones
            }
            q=q.getLiga();
        }
        //Pueden haber otras instrucciones
    }
  
   /**
    * Método insertar llenando la raiz
    * @author leonChanci
    * @since 16/09/2020
    * @param dato Dato a Insertar
    * @param datoBuscar Nodo a buscar para insertar
    */
    public void insertar(String dato, String datoBuscar){
        datoABuscar = datoBuscar;
        raiz = insertarNodo(raiz, dato, false);    
    }
    
   /**
    * Método insertar Insertando los Nodos
    * @author leonChanci
    * @since 18/09/2020
    * @param p NodoArbolNArio
    * @param dato Nodo a buscar para insertar
    * @param encontroElDato TRUE: Si encontró el nodo para insertar
    *                       FALSE: De lo contrario
    * @return raiz NodoArbolNArio
    */
    public NodoArbolNArio insertarNodo(NodoArbolNArio p, String dato, boolean encontroElDato){
        NodoArbolNArio q = p;
        NodoArbolNArio auxiliar, auxiliarConHijos;
        if(q == null){
            q = new NodoArbolNArio(dato);
            return q;
        }else{
            while(q != null && encontroElDato == false){
                //NO tiene hijos (Nodo Cabeza)
                if(q.isSw() == false && q.getDato().equals(datoABuscar)){
                    encontroElDato = true;
                    //Si es nodo raiz 
                    if(q == p){
                        auxiliar = q.getLiga(); 
                        //Si tiene hijos
                        if(auxiliar != null){
                           while(auxiliar != null){
                                if(auxiliar.getLiga() == null){
                                    NodoArbolNArio nuevoNodoAlFinal = insertarNodo(auxiliar.getLiga(), dato, true);
                                    auxiliar.setLiga(nuevoNodoAlFinal);
                                    return raiz;  
                                }
                            auxiliar = auxiliar.getLiga();
                            }
                        //Si no tiene hijos
                        }else{                          
                            NodoArbolNArio nuevoNodo = insertarNodo(q.getLiga(), dato, true);
                            q.setLiga(nuevoNodo);
                            //return q;
                        } 
                    //Si no es nodo cabeza
                    }else{
                        NodoArbolNArio nuevoNodo = insertarNodo(q.getLigaLista(), q.getDato(), true);
                        q.setSw(true);  
                        q.setLigaLista(nuevoNodo);
                        NodoArbolNArio nuevoNodoHijo = insertarNodo(nuevoNodo.getLiga(), dato, true);
                        nuevoNodo.setLiga(nuevoNodoHijo);
                        return raiz;
                    }
                //Tiene hijos
                }else if(q.isSw() == true && q.getDato().equals(datoABuscar)){
                    auxiliarConHijos = q.getLigaLista();
                    if(auxiliarConHijos != null){
                        while(auxiliarConHijos != null){
                            if(auxiliarConHijos.getLiga() == null){
                                NodoArbolNArio nuevoNodoAlFinal = insertarNodo(auxiliarConHijos.getLiga(), dato, true);
                                auxiliarConHijos.setLiga(nuevoNodoAlFinal);
                                return raiz;  
                            }
                        auxiliarConHijos = auxiliarConHijos.getLiga();
                        }
                    }
                }else if(q.isSw() == true){
                    auxiliarConHijos = q.getLigaLista();
                    if(auxiliarConHijos != null){
                        while(auxiliarConHijos != null){
                            if(auxiliarConHijos.getDato().equals(datoABuscar)){
                                NodoArbolNArio nuevoNodo = insertarNodo(auxiliarConHijos.getLigaLista(), auxiliarConHijos.getDato(), true);
                                auxiliarConHijos.setSw(true);  
                                auxiliarConHijos.setLigaLista(nuevoNodo);
                                NodoArbolNArio nuevoNodoHijo = insertarNodo(nuevoNodo.getLiga(), dato, true);
                                nuevoNodo.setLiga(nuevoNodoHijo);
                                return raiz;
                            }
                        auxiliarConHijos = auxiliarConHijos.getLiga();
                        }   
                    }
                }
                q = q.getLiga();    
            }  
        } 
        return raiz;
    }
    
    //Método eliminar
    public void eliminarNodo(String dato){
        if (raiz == null) {
            JOptionPane.showMessageDialog(null, "El arbol se encuentra vacio");
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
    
   /**
    * Método mostrar el grado de un dato(Nodo) dado
    * @author leonChanci
    * @return 
    * @since 11/09/2020
    * @param listaEnviada NodoArbolNArio
    * @param dato Dato del Nodo buscarle el grado
    * @param sw 
    * @return sw
    */
    public boolean mostrarGradoDatoDado(NodoArbolNArio listaEnviada, String dato, boolean sw){
        NodoArbolNArio listaRecibida = listaEnviada;
        NodoArbolNArio listaAuxiliar;
        int gradoNodo = 0;
        while(listaRecibida != null && sw == false){ 
            if(listaRecibida.isSw() == false && listaRecibida.getDato().equals(datoABuscar)){
                sw = true;
                if(listaRecibida==listaEnviada){
                        listaAuxiliar = listaRecibida.getLiga();
                        while(listaAuxiliar != null){
                            gradoNodo++;
                            listaAuxiliar = listaAuxiliar.getLiga();
                        }         
                }     
                JOptionPane.showMessageDialog(null, "El grado de "+dato+" es "+gradoNodo);
            }else{
                mostrarGradoDatoDado(listaRecibida.getLigaLista(), dato, sw);
            }
            listaRecibida=listaRecibida.getLiga();
        }
        return sw;  
    }
 
    //Getters and setters
    //Método para Obtener la raiz del árbol
    public NodoArbolNArio getRaiz(){
        return(raiz);
    }
    
    //Método para Setear la raiz del árbo
    public void setRaiz(NodoArbolNArio raiz){
        this.raiz = raiz;
    }
}
