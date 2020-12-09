package conjuntos;

/**
 * Conjunto Vectores
 * @author yeijara
 * @since 09/12/2020
 */

public class ConjuntosCombinados {

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

    public NodoConjuntoLista interseccion(ConjuntoLista conjuntoA, ConjuntoVector conjuntoB) {
        NodoConjuntoLista conjunto = conjuntoA.getCabecera();
        ConjuntoLista conjuntoInterseccion = new ConjuntoLista();

        while(conjuntoA != null){
            for (int i = 0; i < conjuntoB.conjuntos.get("B").length; i++) {
                if (conjunto.getDato().equals(conjuntoB.conjuntos.get("B")[i])) {
                    conjuntoInterseccion.almacenarDato(conjunto.getDato(), "C");
                }
            }

            conjunto = conjunto.getLiga();
        }

        return conjuntoInterseccion.getCabecera();
    }
}
