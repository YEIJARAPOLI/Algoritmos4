package conjuntos;

import javax.swing.JOptionPane;

/**
 * Conjunto Lista
 * @author leonChanci
 * @since 26/11/2020
 */

public class ConjuntoLista {
    final static String TITLE_MENU_LISTAS = "*** CONJUNTOS LISTAS ***";
    NodoConjuntoLista cabecera;
    NodoConjuntoLista conjuntoUniversal;
    
    public ConjuntoLista() {
        cabecera = null;
    }
    
    public void llenarConjuntoUniversal() {
        NodoConjuntoLista conjuntoUniversal_A = new NodoConjuntoLista("Rojo");
        NodoConjuntoLista conjuntoUniversal_B = new NodoConjuntoLista("Verde");
        NodoConjuntoLista conjuntoUniversal_C = new NodoConjuntoLista("Amarillo");
        NodoConjuntoLista conjuntoUniversal_D = new NodoConjuntoLista("Azul");
        NodoConjuntoLista conjuntoUniversal_E = new NodoConjuntoLista("Morado");
        NodoConjuntoLista conjuntoUniversal_F = new NodoConjuntoLista("Naranja");
        NodoConjuntoLista conjuntoUniversal_G = new NodoConjuntoLista("Blanco");
        NodoConjuntoLista conjuntoUniversal_H = new NodoConjuntoLista("Negro");
        conjuntoUniversal_A.setLiga(conjuntoUniversal_B);
        conjuntoUniversal_B.setLiga(conjuntoUniversal_C);
        conjuntoUniversal_C.setLiga(conjuntoUniversal_D);
        conjuntoUniversal_D.setLiga(conjuntoUniversal_E);
        conjuntoUniversal_E.setLiga(conjuntoUniversal_F);
        conjuntoUniversal_F.setLiga(conjuntoUniversal_G);
        conjuntoUniversal_G.setLiga(conjuntoUniversal_H);
        conjuntoUniversal = conjuntoUniversal_A;
    }

    public NodoConjuntoLista agregar(){
        if(conjuntoUniversal != null){
            llenarConjuntoUniversal(); 
        }
        String respuesta = "S";
       
        while (respuesta.equals("S") || respuesta.equals("s")) {
            String dato = JOptionPane.showInputDialog(null, "Ingrese el dato a ingresar al conjunto", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
            if(buscarDatoEnConjuntoUniversal(dato)){
                cabecera = this.almacenarDato(dato);
            }else{
                JOptionPane.showMessageDialog(null, "¡El dato no pertenece al conjunto Universal!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
            }
            respuesta = JOptionPane.showInputDialog(null, "Desea ingresar otro dato al conjunto? (S/N)", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
        }
        return cabecera;
    }
    
    public boolean buscarDatoEnConjuntoUniversal(String dato) {
        NodoConjuntoLista nodo = conjuntoUniversal;

        while(nodo != null){
            if(nodo.getDato().equals(dato)){
                return true;
            }
            nodo = nodo.getLiga();
        }
        return false;
    }
    
    public NodoConjuntoLista almacenarDato(String dato){
        NodoConjuntoLista nodo = cabecera, anterior = null;
        
        while(nodo != null){
            anterior = nodo;
            nodo = nodo.getLiga();           
        }
        
        if(nodo != null && nodo.getDato().equals(dato)){
            JOptionPane.showMessageDialog(null, "¡Ya existe el dato en el conjunto!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
        }else{
            NodoConjuntoLista newDatoConjunto = new NodoConjuntoLista(dato);
            newDatoConjunto.setLiga(nodo);
            if(nodo == cabecera){
                cabecera = newDatoConjunto;
            }else{
                anterior.setLiga(newDatoConjunto);
            }
        }  
        return cabecera;
    } 
    
    public void mostrar(){
        NodoConjuntoLista nodo = cabecera;
         String salida="";
        if(cabecera == null){
            JOptionPane.showMessageDialog(null, "¡El conjunto está vacío!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
        }else{
            while(nodo != null){
                salida = salida+nodo.getDato()+" - "; 
                nodo = nodo.getLiga();
            }
            JOptionPane.showMessageDialog(null, "Datos del conjunto:\n"+salida, TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
        } 
    }
}
