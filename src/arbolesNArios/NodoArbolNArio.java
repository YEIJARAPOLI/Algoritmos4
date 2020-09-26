package arbolesNArios;

import javax.swing.JOptionPane;

/**
 * @author leonChanci
 * @since 09/09/2020
 */
public class NodoArbolNArio {
    //Atributos
    // FALSE 0: Cuando no tiene sublista y contiene datos 
    // TRUE  1: Cuando tiene sublista y no contiene datos
    boolean sw; 
    String dato;
    NodoArbolNArio ligaLista; // Dirección de la lista que contiene la sublista
    NodoArbolNArio liga; //Dirección del siguiente nodo en la lista
    
//    public NodoArbolNArio(String dato){
//        sw = false;
//        this.dato = dato;
//        ligaLista = null;
//        liga = null;
//    }
    
    public NodoArbolNArio(String dato) {
        if (dato == null || dato.isEmpty()) {
            sw = true;
            this.dato = null;
        } else {
            sw = false;
            this.dato = dato;
        }
        ligaLista = null;
        liga = null;
    }
    
    //Getters Y Setters
    public boolean isSw() {
        return sw;
    }

    public void setSw(boolean sw) {
        this.sw = sw;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoArbolNArio getLigaLista() {
        return ligaLista;
    }

    public void setLigaLista(NodoArbolNArio ligaLista) {
        this.ligaLista = ligaLista;
    }

    public NodoArbolNArio getLiga() {
        return liga;
    }
    
    public void setLiga(NodoArbolNArio liga) {
        this.liga = liga;
    }
}
