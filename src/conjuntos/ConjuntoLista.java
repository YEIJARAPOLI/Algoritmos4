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

    public NodoConjuntoLista getConjuntoUniversal() {
        return conjuntoUniversal;
    }

    public void setConjuntoUniversal(NodoConjuntoLista conjuntoUniversal) {
        this.conjuntoUniversal = conjuntoUniversal;
    }

    public void llenarConjuntoUniversal() {
        NodoConjuntoLista conjuntoUniversal_Rojo = new NodoConjuntoLista("Rojo");
        NodoConjuntoLista conjuntoUniversal_Verde = new NodoConjuntoLista("Verde");
        NodoConjuntoLista conjuntoUniversal_Amarillo = new NodoConjuntoLista("Amarillo");
        NodoConjuntoLista conjuntoUniversal_Azul = new NodoConjuntoLista("Azul");
        NodoConjuntoLista conjuntoUniversal_Morado = new NodoConjuntoLista("Morado");
        NodoConjuntoLista conjuntoUniversal_Naranja = new NodoConjuntoLista("Naranja");
        NodoConjuntoLista conjuntoUniversal_Blanco = new NodoConjuntoLista("Blanco");
        NodoConjuntoLista conjuntoUniversal_Negro = new NodoConjuntoLista("Negro");
        conjuntoUniversal_Rojo.setLiga(conjuntoUniversal_Verde);
        conjuntoUniversal_Verde.setLiga(conjuntoUniversal_Amarillo);
        conjuntoUniversal_Amarillo.setLiga(conjuntoUniversal_Azul);
        conjuntoUniversal_Azul.setLiga(conjuntoUniversal_Morado);
        conjuntoUniversal_Morado.setLiga(conjuntoUniversal_Naranja);
        conjuntoUniversal_Naranja.setLiga(conjuntoUniversal_Blanco);
        conjuntoUniversal_Blanco.setLiga(conjuntoUniversal_Negro);
        conjuntoUniversal = conjuntoUniversal_Rojo;
    }

    public NodoConjuntoLista agregar(String nombreConjunto){
        if(conjuntoUniversal == null){
            llenarConjuntoUniversal(); 
        }
        String respuesta = "S";
       
        while (respuesta.equals("S") || respuesta.equals("s")) {
            String dato = JOptionPane.showInputDialog(null, "Ingrese elemento al conjunto: '"+nombreConjunto+"'", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
            if(buscarDatoEnConjunto(dato, conjuntoUniversal)){
                cabecera = this.almacenarDato(dato, nombreConjunto);
            }else{
                JOptionPane.showMessageDialog(null, "¡El elemento '"+dato+"' no pertenece al conjunto Universal!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
            }
            respuesta = JOptionPane.showInputDialog(null, "Desea ingresar otro elemento al conjunto: '"+nombreConjunto+"' ? (S/N)", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
        }
        return cabecera;
    }
    
    public boolean buscarDatoEnConjunto(String dato, NodoConjuntoLista conjunto) {
        NodoConjuntoLista nodo = conjunto;
        while(nodo != null){
            if(nodo.getDato().equals(dato)){
                return true;
            }
            nodo = nodo.getLiga();
        }
        return false;
    }
    
    public NodoConjuntoLista almacenarDato(String dato, String nombreConjunto){
        NodoConjuntoLista nodo = cabecera, anterior = null;
        if(nodo != null && nodo.getDato().equals(dato)){
            JOptionPane.showMessageDialog(null, "¡El elemento "+dato+" ∈ al conjunto "+nombreConjunto+"!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
            return cabecera;
        }
        while(nodo != null){
            anterior = nodo;
            nodo = nodo.getLiga();           
        }
        
        NodoConjuntoLista newDatoConjunto = new NodoConjuntoLista(dato);
        newDatoConjunto.setLiga(nodo);
        if(nodo == cabecera){
            cabecera = newDatoConjunto;
        }else{
            anterior.setLiga(newDatoConjunto);
        }
        return cabecera;
    } 
    
    public void mostrar(ConjuntoLista conjuntoLista, String nombreConjunto){
        NodoConjuntoLista nodo = conjuntoLista.getCabecera();
         String salida= "<html>"+nombreConjunto+" = { ";
        if(nodo == null){
            JOptionPane.showMessageDialog(null, "¡El conjunto "+ nombreConjunto +" está vacío!\n\n"+nombreConjunto+" = ∅", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE); 
        }else{
            while(nodo != null){
                if(nodo.getLiga() != null){
                    salida = salida+nodo.getDato()+", "; 
                }else{
                    salida = salida+nodo.getDato()+" }"; 
                }              
                nodo = nodo.getLiga();
            }
            JOptionPane.showMessageDialog(null, salida+"</html>", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
        } 
    }

    public void borrarElemento(ConjuntoLista conjuntoLista, String nombreConjunto) {
        String dato = JOptionPane.showInputDialog(null, "Ingrese el elemento a borrar en el conjunto: "+nombreConjunto, TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
        NodoConjuntoLista nodo = conjuntoLista.getCabecera(), anterior = nodo;
        
        if(buscarDatoEnConjunto(dato, nodo)){
            while(nodo != null){  
                if(nodo.getDato().equals(dato) && nodo == conjuntoLista.getCabecera()){
                    conjuntoLista.setCabecera(nodo.getLiga());
                    return;
                }else if(nodo.getDato().equals(dato) && nodo.getLiga() == null){
                    anterior.setLiga(null);
                    return;
                }else if(nodo.getDato().equals(dato) && nodo != conjuntoLista.getCabecera()){
                    anterior.setLiga(nodo.getLiga());
                    return;
                }
                anterior = nodo;
                nodo = nodo.getLiga();           
            }     
        }else{
            JOptionPane.showMessageDialog(null, "¡El elemento "+dato+ " ∉ al conjunto '"+nombreConjunto+"'!", TITLE_MENU_LISTAS, JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    public void vaciarElementos(ConjuntoLista conjuntoLista, String nombreConjunto) {
        conjuntoLista.setCabecera(null);
        JOptionPane.showMessageDialog(null, "Los elementos del conjunto '"+nombreConjunto+"' se vaciaron.", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public int cantidadElementos(ConjuntoLista conjuntoLista){
        NodoConjuntoLista nodo = conjuntoLista.getCabecera();
        int contador = 0;
        while(nodo != null){
                contador = contador+1;
                nodo = nodo.getLiga();
        }
        return contador;
    }
    
    public NodoConjuntoLista union(ConjuntoLista conjuntoListaA, ConjuntoLista conjuntoListaB) {
        NodoConjuntoLista conjuntoA = conjuntoListaA.getCabecera();
        NodoConjuntoLista conjuntoB = conjuntoListaB.getCabecera();
        ConjuntoLista conjuntoUnionC = new ConjuntoLista();
        while(conjuntoA != null){
            conjuntoUnionC.almacenarDato(conjuntoA.getDato(), "C");
            if(conjuntoA.getLiga() == null){
                while(conjuntoB != null){
                    if(!buscarDatoEnConjunto(conjuntoB.getDato(), conjuntoUnionC.getCabecera())){
                        conjuntoUnionC.almacenarDato(conjuntoB.getDato(), "C");
                    }
                    conjuntoB = conjuntoB.getLiga();
                }
                return conjuntoUnionC.getCabecera();
            }
            conjuntoA = conjuntoA.getLiga();
        }
        return conjuntoUnionC.getCabecera();
    }
    
    public NodoConjuntoLista interseccion(ConjuntoLista conjuntoListaA, ConjuntoLista conjuntoListaB) {
        NodoConjuntoLista conjuntoA = conjuntoListaA.getCabecera();
        NodoConjuntoLista conjuntoB;
        ConjuntoLista conjuntoInterseccionC = new ConjuntoLista();
        while(conjuntoA != null){
            conjuntoB = conjuntoListaB.getCabecera();
            while(conjuntoB != null){
                if(conjuntoA.getDato().equals(conjuntoB.getDato())){
                   conjuntoInterseccionC.almacenarDato(conjuntoA.getDato(),"C");
                }
               conjuntoB = conjuntoB.getLiga();
            }
            conjuntoA = conjuntoA.getLiga();
        }
        return conjuntoInterseccionC.getCabecera();
    }
    
    public void igualacion(ConjuntoLista conjuntoListaA, ConjuntoLista conjuntoListaB) {
        NodoConjuntoLista conjuntoA = conjuntoListaA.getCabecera();
        NodoConjuntoLista conjuntoB = conjuntoListaB.getCabecera();
        if(cantidadElementos(conjuntoListaA) == cantidadElementos(conjuntoListaA)){
            boolean esIgual = true;
            while(conjuntoA != null){
                if(!buscarDatoEnConjunto(conjuntoA.getDato(), conjuntoB)){
                    esIgual = false;
                }
                conjuntoA = conjuntoA.getLiga();
            }
            if(esIgual){
                JOptionPane.showMessageDialog(null, "El conjunto A es IGUAL al conjunto B", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
            }else{
               JOptionPane.showMessageDialog(null, "El conjunto A NO es igual al conjunto B", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "El conjunto A NO es igual al conjunto B", TITLE_MENU_LISTAS, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public NodoConjuntoLista complemento(ConjuntoLista conjuntoLista, String nombreConjunto) {
        String nombreConjuntoComplemento = "<html>"+nombreConjunto+"<sup>C</sup></html>";
        NodoConjuntoLista conjunto = conjuntoLista.getCabecera();
         if(conjuntoUniversal == null){
            llenarConjuntoUniversal(); 
        }
        NodoConjuntoLista conjuntoU = conjuntoUniversal;
        ConjuntoLista conjuntoComplemento = new ConjuntoLista();
        boolean encontrado = true;
        while(conjuntoU != null){
            if(!buscarDatoEnConjunto(conjuntoU.getDato(), conjunto)){
                encontrado = false;
            }
            if(!encontrado){
                conjuntoComplemento.almacenarDato(conjuntoU.getDato(), nombreConjuntoComplemento);
                encontrado = true;
            }
            conjuntoU = conjuntoU.getLiga();
        }
        return conjuntoComplemento.getCabecera();
    }
    
    public NodoConjuntoLista diferencia(ConjuntoLista conjuntoLista1, ConjuntoLista conjuntoLista2){
        NodoConjuntoLista conjunto1 = conjuntoLista1.getCabecera();
        NodoConjuntoLista conjunto2 = conjuntoLista2.getCabecera();
        ConjuntoLista conjuntoDiferencia = new ConjuntoLista();
        boolean encontrado = true;
        while(conjunto1 != null){
            if(!buscarDatoEnConjunto(conjunto1.getDato(), conjunto2)){
                encontrado = false;
            }
            if(!encontrado){
                conjuntoDiferencia.almacenarDato(conjunto1.getDato(), "A - B | B - A");
                encontrado = true;
            }
            conjunto1 = conjunto1.getLiga();
        }
        return conjuntoDiferencia.getCabecera();
    }
    
    public NodoConjuntoLista diferenciaSimetrica(ConjuntoLista conjuntoListaA, ConjuntoLista conjuntoListaB){
        NodoConjuntoLista conjuntoA = conjuntoListaA.getCabecera();
        NodoConjuntoLista conjuntoB = conjuntoListaB.getCabecera();
        ConjuntoLista conjuntoDiferenciaSimetrica = new ConjuntoLista();
        boolean encontrado = true;
        while(conjuntoA != null){
            if(!buscarDatoEnConjunto(conjuntoA.getDato(), conjuntoB)){
                encontrado = false;
            }
            if(!encontrado){
                conjuntoDiferenciaSimetrica.almacenarDato(conjuntoA.getDato(), "A ∆ B");
                encontrado = true;
            }
            conjuntoA = conjuntoA.getLiga();
        }
        conjuntoA = conjuntoListaA.getCabecera();
        while(conjuntoB != null){
            if(!buscarDatoEnConjunto(conjuntoB.getDato(), conjuntoA)){
                encontrado = false;
            }
            if(!encontrado){
                conjuntoDiferenciaSimetrica.almacenarDato(conjuntoB.getDato(), "A ∆ B");
                encontrado = true;
            }
            conjuntoB = conjuntoB.getLiga();
        }
        return conjuntoDiferenciaSimetrica.getCabecera();
    }
    
    public boolean isVacio(ConjuntoLista conjuntoLista){
        return conjuntoLista.getCabecera() ==  null;
    }
    
    public NodoConjuntoLista getCabecera(){
        return cabecera;
    }
    
    public void setCabecera(NodoConjuntoLista cabecera){
        this.cabecera = cabecera;
    }

}
