package conjuntos;

/**
 * @author leonChanci
 * @since 26/11/2020
 */
public class NodoConjuntoLista {
    NodoConjuntoLista liga;
    String dato;
    
    public NodoConjuntoLista(String dato) {
        this.dato = dato;
        liga = null;
    }

    public NodoConjuntoLista getLiga() {
        return liga;
    }

    public void setLiga(NodoConjuntoLista liga) {
        this.liga = liga;
    }
    
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
}
