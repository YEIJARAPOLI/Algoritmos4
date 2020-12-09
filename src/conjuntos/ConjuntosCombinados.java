package conjuntos;

import javax.swing.*;

/**
 * Conjunto Vectores
 * @author yeijara
 * @since 09/12/2020
 */

public class ConjuntosCombinados {

    final static String TITLE_MENU_COMBINADO = "*** CONJUNTOS COMBINADOS ***";

    private boolean validarConjuntos(ConjuntoLista conjuntoA, ConjuntoVector conjuntoB, boolean requiereA, boolean requiereB) {
        if (requiereA && conjuntoA.isVacio(conjuntoA)) {
            JOptionPane.showMessageDialog(null, "¡Verifique que el conjunto A tengan elementos", TITLE_MENU_COMBINADO, JOptionPane.ERROR_MESSAGE);
            conjuntoA.mostrar(conjuntoA, "A");
            return false;
        }

        if (requiereB && (!conjuntoB.getConjuntos().containsKey("B") || conjuntoB.getConjuntos().get("B").length <= 0)) {
            JOptionPane.showMessageDialog(null, "¡Verifique que el conjunto B tengan elementos", TITLE_MENU_COMBINADO, JOptionPane.ERROR_MESSAGE);
            conjuntoB.mostrar("B", null, null);
            return false;
        }

        return true;
    }

    public NodoConjuntoLista union(ConjuntoLista conjuntoA, ConjuntoVector conjuntoB) {
        NodoConjuntoLista conjuntoLista = conjuntoA.getCabecera();
        ConjuntoLista conjuntoUnionC = new ConjuntoLista();

        if (!validarConjuntos(conjuntoA, conjuntoB, true, true)) {
            return new NodoConjuntoLista("");
        }

        while (conjuntoA != null) {
            conjuntoUnionC.almacenarDato(conjuntoLista.getDato(), "C");

            if (conjuntoLista.getLiga() == null) {
                for (int i = 0; i < conjuntoB.getConjuntos().get("B").length; i++) {
                    if(!conjuntoA.buscarDatoEnConjunto(conjuntoB.getConjuntos().get("B")[i], conjuntoUnionC.getCabecera())){
                        conjuntoUnionC.almacenarDato(conjuntoB.getConjuntos().get("B")[i], "C");
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

        if (!validarConjuntos(conjuntoA, conjuntoB, true, true)) {
            return new NodoConjuntoLista("");
        }

        while (conjuntoA != null) {
            for (int i = 0; i < conjuntoB.getConjuntos().get("B").length; i++) {
                if (conjunto.getDato().equals(conjuntoB.getConjuntos().get("B")[i])) {
                    conjuntoInterseccion.almacenarDato(conjunto.getDato(), "C");
                }
            }

            conjunto = conjunto.getLiga();
        }

        return conjuntoInterseccion.getCabecera();
    }
    
    public void igualdad(ConjuntoLista conjuntoA, ConjuntoVector conjuntoB) {
        NodoConjuntoLista conjunto = conjuntoA.getCabecera();

        if (!validarConjuntos(conjuntoA, conjuntoB, true, true)) {
            return;
        }

        if(conjuntoA.cantidadElementos(conjuntoA) == conjuntoB.cantidadElementos("B")){
            boolean esIgual = true;

            while (conjuntoA != null) {
                if (!buscarDatoEnConjunto(conjunto.getDato(), conjuntoB)) {
                    esIgual = false;
                }

                conjunto = conjunto.getLiga();
            }

            if (esIgual) {
                JOptionPane.showMessageDialog(null, "El conjunto A es IGUAL al conjunto B", TITLE_MENU_COMBINADO, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El conjunto A NO es igual al conjunto B", TITLE_MENU_COMBINADO, JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El conjunto A NO es igual al conjunto B", TITLE_MENU_COMBINADO, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean buscarDatoEnConjunto(String dato, ConjuntoVector conjuntoB) {
        for (int i = 0; i < conjuntoB.getConjuntos().get("B").length; i++) {
            if (dato.equals(conjuntoB.getConjuntos().get("B")[i])) {
                return true;
            }
        }

        return false;
    }

    public NodoConjuntoLista complemento(ConjuntoLista conjuntoA, ConjuntoVector conjuntoB) {
        String nombreConjunto;
        boolean encontrado = true;
        NodoConjuntoLista conjunto = conjuntoA.getCabecera();
        NodoConjuntoLista conjuntoU;
        ConjuntoLista complemento = new ConjuntoLista();

        if (!validarConjuntos(conjuntoA, conjuntoB, (conjuntoB == null) ? true : false, (conjuntoA == null) ? true : false)) {
            return new NodoConjuntoLista("");
        }

        if (conjuntoA == null) {
            nombreConjunto = "<html>B<sup>C</sup></html>";
        } else {
            nombreConjunto = "<html>A<sup>C</sup></html>";
        }

        if(conjuntoA.getConjuntoUniversal() == null){
            conjuntoA.llenarConjuntoUniversal();
        }

        conjuntoU = conjuntoA.getConjuntoUniversal();

        while (conjuntoU != null) {
            if (conjuntoA == null) {
                if(!buscarDatoEnConjunto(conjuntoU.getDato(), conjuntoB)) {
                    encontrado = false;
                }
            } else {
                if (!conjuntoA.buscarDatoEnConjunto(conjuntoU.getDato(), conjunto)) {
                    encontrado = false;
                }
            }

            if (!encontrado) {
                complemento.almacenarDato(conjuntoU.getDato(), nombreConjunto);
                encontrado = true;
            }

            conjuntoU = conjuntoU.getLiga();
        }

        return complemento.getCabecera();
    }

    public NodoConjuntoLista diferencia(ConjuntoLista conjuntoA, ConjuntoVector conjuntoB) {
        NodoConjuntoLista conjunto = conjuntoA.getCabecera();
        ConjuntoLista conjuntoDiferencia = new ConjuntoLista();
        boolean encontrado = true;

        if (!validarConjuntos(conjuntoA, conjuntoB, true, true)) {
            return new NodoConjuntoLista("");
        }

        while (conjunto != null) {
            if (!buscarDatoEnConjunto(conjunto.getDato(), conjuntoB)) {
                encontrado = false;
            }

            if (!encontrado) {
                conjuntoDiferencia.almacenarDato(conjunto.getDato(), "A - B | B - A");
                encontrado = true;
            }

            conjunto = conjunto.getLiga();
        }

        return conjuntoDiferencia.getCabecera();
    }

    public NodoConjuntoLista diferenciaSimetrica(ConjuntoLista conjuntoA, ConjuntoVector conjuntoB) {
        NodoConjuntoLista conjunto = conjuntoA.getCabecera();
        ConjuntoLista diferenciaSimetrica = new ConjuntoLista();
        boolean encontrado = true;

        if (!validarConjuntos(conjuntoA, conjuntoB, true, true)) {
            return new NodoConjuntoLista("");
        }

        while (conjuntoA != null) {
            if (!buscarDatoEnConjunto(conjunto.getDato(), conjuntoB)) {
                encontrado = false;
            }

            if (!encontrado) {
                diferenciaSimetrica.almacenarDato(conjunto.getDato(), "A ∆ B");
                encontrado = true;
            }

            conjunto = conjunto.getLiga();
        }

        conjunto = conjuntoA.getCabecera();

        for (int i = 0; i < conjuntoB.getConjuntos().get("B").length; i++) {
            if (!conjuntoA.buscarDatoEnConjunto(conjuntoB.getConjuntos().get("B")[i], conjunto)) {
                encontrado = false;
            }

            if(!encontrado){
                diferenciaSimetrica.almacenarDato(conjuntoB.getConjuntos().get("B")[i], "A ∆ B");
                encontrado = true;
            }
        }

        return diferenciaSimetrica.getCabecera();
    }
}