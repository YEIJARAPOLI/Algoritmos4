package conjuntos;
import javax.swing.JOptionPane;

/**
 * Conjunto Vectores
 * @author yeijara
 * @since 09/12/2020
 */

public class ConjuntosCombinados {
    final static String TITLE_MENU_COMBINADO = "*** CONJUNTOS COMBINADOS ***";

    public NodoConjuntoLista union(ConjuntoLista conjuntoA, ConjuntoVector conjuntoB) {
        NodoConjuntoLista conjuntoLista = conjuntoA.getCabecera();
        ConjuntoLista conjuntoUnionC = new ConjuntoLista();

        while(conjuntoA != null){
            conjuntoUnionC.almacenarDato(conjuntoLista.getDato(), "C");

            if(conjuntoLista.getLiga() == null){
                for (int i = 0; i < conjuntoB.conjuntos.get("B").length; i++) {
                    if(!conjuntoA.buscarDatoEnConjunto(conjuntoB.conjuntos.get("B")[i], conjuntoUnionC.getCabecera())){
                        conjuntoUnionC.almacenarDato(conjuntoB.conjuntos.get("B")[i], "C");
                    }
                }

                return conjuntoUnionC.getCabecera();
            }

            conjuntoLista = conjuntoLista.getLiga();
        }

        return conjuntoUnionC.getCabecera();
    }

    public NodoConjuntoLista interseccion(ConjuntoLista conjuntoListaA, ConjuntoVector conjuntoVectorB) {
        NodoConjuntoLista conjuntoA = conjuntoListaA.getCabecera();
        ConjuntoLista conjuntoInterseccionC = new ConjuntoLista();
        while(conjuntoA != null){
            
            for (int i = 0; i < conjuntoVectorB.conjuntos.get("B").length; i++) {
                if(conjuntoA.getDato().equals(conjuntoVectorB.conjuntos.get("B")[i])){
                    conjuntoInterseccionC.almacenarDato(conjuntoVectorB.conjuntos.get("B")[i], "C");
                }
            }
            conjuntoA = conjuntoA.getLiga();
            }
        return conjuntoInterseccionC.getCabecera();
    }

    public void igualacion(ConjuntoLista conjuntoListaA, ConjuntoVector conjuntoVectorB) {
        NodoConjuntoLista conjuntoA = conjuntoListaA.getCabecera();
        if(conjuntoListaA.cantidadElementos(conjuntoListaA) == conjuntoVectorB.conjuntos.get("B").length){
            boolean esIgual = true;
            for (int i = 0; i < conjuntoVectorB.conjuntos.get("B").length; i++) {
                if(!conjuntoListaA.buscarDatoEnConjunto(conjuntoVectorB.conjuntos.get("B")[i], conjuntoA)){
                    esIgual = false;
                }
            }
            if(esIgual){
                JOptionPane.showMessageDialog(null, "El conjunto A es IGUAL al conjunto B", TITLE_MENU_COMBINADO, JOptionPane.INFORMATION_MESSAGE);
            }else{
               JOptionPane.showMessageDialog(null, "El conjunto A NO es igual al conjunto B", TITLE_MENU_COMBINADO, JOptionPane.INFORMATION_MESSAGE); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "El conjunto A NO es igual al conjunto B", TITLE_MENU_COMBINADO, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public NodoConjuntoLista diferencia(ConjuntoLista conjuntoLista, ConjuntoVector conjuntoVector, boolean flujo){
        NodoConjuntoLista conjunto1 = conjuntoLista.getCabecera();
        ConjuntoLista conjuntoDiferencia = new ConjuntoLista();
        boolean encontrado = true;
        
        if(flujo){
            while(conjunto1 != null){
                if(!conjuntoVector.buscarDatoEnConjunto(conjunto1.getDato(), conjuntoVector)){
                    encontrado = false;
                }
                if(!encontrado){
                    conjuntoDiferencia.almacenarDato(conjunto1.getDato(), "A - B");
                    encontrado = true;
                }
                conjunto1 = conjunto1.getLiga();
            }
        }else{
            for (int i = 0; i < conjuntoVector.conjuntos.get("B").length; i++) {
                if(!conjuntoLista.buscarDatoEnConjunto(conjuntoVector.conjuntos.get("B")[i], conjunto1)){
                    encontrado = false;
                }
                if(!encontrado){
                    conjuntoDiferencia.almacenarDato(conjuntoVector.conjuntos.get("B")[i], "B - A");
                    encontrado = true;
                }
            }
        }
        return conjuntoDiferencia.getCabecera();
    }
    
    public NodoConjuntoLista diferenciaSimetrica(ConjuntoLista conjuntoListaA, ConjuntoVector conjuntoVectorB){
        NodoConjuntoLista conjuntoA = conjuntoListaA.getCabecera();
        ConjuntoLista conjuntoDiferenciaSimetrica = new ConjuntoLista();
        boolean encontrado = true;
        while(conjuntoA != null){
            if(!conjuntoVectorB.buscarDatoEnConjunto(conjuntoA.getDato(), conjuntoVectorB)){
                    encontrado = false;
            }
            if(!encontrado){
                conjuntoDiferenciaSimetrica.almacenarDato(conjuntoA.getDato(), "A ∆ B");
                encontrado = true;
            }
            conjuntoA = conjuntoA.getLiga();
        }
        conjuntoA = conjuntoListaA.getCabecera();
        
        for (int i = 0; i < conjuntoVectorB.conjuntos.get("B").length; i++) {
            if(!conjuntoListaA.buscarDatoEnConjunto(conjuntoVectorB.conjuntos.get("B")[i], conjuntoA)){
                    encontrado = false;
            }
            if(!encontrado){
                conjuntoDiferenciaSimetrica.almacenarDato(conjuntoVectorB.conjuntos.get("B")[i], "A ∆ B");
                encontrado = true;
            }
        }
        return conjuntoDiferenciaSimetrica.getCabecera();
    }
}
