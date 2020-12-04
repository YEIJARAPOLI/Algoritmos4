package conjuntos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Conjunto Vectores
 * @author yeijara
 * @since 25/11/2020
 */

public class ConjuntoVector {

    Map<String, Integer[]> conjuntos;

    public ConjuntoVector() {
        conjuntos = new HashMap<>();
        asignarConjuntoUniversal();
    }

    private void asignarConjuntoUniversal() {
        conjuntos.put("Universal", new Integer[]{ 30, 5, 3, 7, 45, 0, 6 });
    }

    public String[] agregar(String nombreConjunto) {
        String respuesta = "S";

        while (respuesta.equalsIgnoreCase("S")) {
            Integer dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese elemento al conjunto: '" + nombreConjunto + "'", "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE));

            if (this.almacenarDato(dato, nombreConjunto)) {
                JOptionPane.showMessageDialog(null, "¡El elemento '" + dato + "' ya esta asignado al conjunto '" + nombreConjunto + "' o al Universal!", "*** CONJUNTOS VECTORES ***", JOptionPane.ERROR_MESSAGE);
            }

            respuesta = JOptionPane.showInputDialog(null, "Desea ingresar otro elemento al conjunto: '"+nombreConjunto+"' ? (S/N)", "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    private boolean almacenarDato(Integer dato, String nombreConjunto) {
        /*for (int i = 0; i < conjuntos.get("Universal").length; i++) {
            if (conjuntos.get("Universal")[i] == dato) {
                return true;
            }
        }*/

        if (conjuntos != null && conjuntos.containsKey(nombreConjunto)) {
            boolean existe = false;
            Integer[] tmp = conjuntos.get(nombreConjunto);

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i].equals(dato)) {
                    existe = true;
                    break;
                } else {
                    existe = false;
                }
            }

            if (!existe) {
                Integer[] tmp2 = new Integer[tmp.length + 1];

                for (int i = 0; i < tmp.length; i++) {
                    tmp2[i] = tmp[i];
                }

                tmp2[(tmp.length + 1) - 1] = dato;

                conjuntos.replace(nombreConjunto, tmp2);
            }

            return existe;
        } else {
            if (conjuntos == null) {
                conjuntos = new HashMap<>();
            }

            Integer[] tmp = new Integer[1];

            tmp[0] = dato;
            conjuntos.put(nombreConjunto, tmp);

            return false;
        }
    }

    public void mostrar(String nombreConjunto, String c1, String c2) {
        if (conjuntos != null && nombreConjunto != null && conjuntos.containsKey(nombreConjunto)) {
            String salida = "";

            if (c1 == null || c1.isEmpty() || c2 == null || c2.isEmpty()) {
                salida = "<html>" + nombreConjunto + " = { ";
            } else {
                if (nombreConjunto.equals("Union")) {
                    salida = "<html>" + c1 + " ∪ " + c2 + " = { ";
                } else if (nombreConjunto.equals("Interseccion")) {
                    salida = "<html>" + c1 + " ∩ " + c2 + " = { ";
                } else if (nombreConjunto.equals("Complemento")) {
                    salida = "<html>" + c1 + "<sup>C</sup> = { ";
                } else if (nombreConjunto.equals("Diferencia")) {
                    salida = "<html>" + c1 + " - " + c2 + " = { ";
                } else if (nombreConjunto.equals("Diferencia-Simetrica")) {
                    salida = "<html>" + c1 + " ∆ " + c2 + " = { ";
                }
            }

            for (int i = 0; i < conjuntos.get(nombreConjunto).length; i++) {
                if (i == ((conjuntos.get(nombreConjunto).length) - 1)) {
                    salida += conjuntos.get(nombreConjunto)[i];
                } else {
                    salida += conjuntos.get(nombreConjunto)[i] + ", ";
                }
            }

            salida += " }</html>";

            JOptionPane.showMessageDialog(null, salida, "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "¡El conjunto '" + nombreConjunto + "' no esta asignado!", "*** CONJUNTOS VECTORES ***", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void borrarElemento(String nombreConjunto) {
        if (conjuntos != null) {
            if (conjuntos.containsKey(nombreConjunto)) {
                Integer dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese elemento a eliminar del cnjunto: '" + nombreConjunto + "'", "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE));
                boolean existe = false;

                for (int i = 0; i < conjuntos.get(nombreConjunto).length; i++) {
                    if (conjuntos.get(nombreConjunto)[i].equals(dato)) {
                        existe = true;
                        break;
                    } else {
                        existe = false;
                    }
                }

                if (existe) {
                    int contador = 0;
                    Integer[] tmp = new Integer[conjuntos.get(nombreConjunto).length - 1];

                    for (int i = 0; i < conjuntos.get(nombreConjunto).length; i++) {
                        if (!conjuntos.get(nombreConjunto)[i].equals(dato)) {
                            tmp[contador] = conjuntos.get(nombreConjunto)[i];
                            contador++;
                        }
                    }

                    conjuntos.replace(nombreConjunto, tmp);
                } else {
                    JOptionPane.showMessageDialog(null, "¡El elemento '" + dato + "' no esta asignado al conjunto '" + nombreConjunto + "'!", "*** CONJUNTOS VECTORES ***", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void vaciarElementos(String nombreConjunto) {
        if (conjuntos != null) {
            conjuntos.replace(nombreConjunto, new Integer[0]);
        }
    }

    public int cantidadElementos(String nombreConjunto) {
        if (conjuntos != null) {
            return conjuntos.get(nombreConjunto).length;
        } else {
            return 0;
        }
    }

    public void union(String conjunto1, String conjunto2) {
        Integer[] conjuntoUnion = null;
        List<Integer> tmp = new ArrayList<>();

        this.conjuntos.remove("Union");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            conjuntoUnion = conjuntos.get(conjunto1);
            conjuntoUnion = evaluarUnion(conjuntos.get(conjunto2), conjuntoUnion);

            /*for (int i = 0; i < conjuntos.get(conjunto1).length; i++) {
                for (int j = 0; j < conjuntos.get(conjunto2).length; j++) {
                    if (conjuntos.get(conjunto1)[i] == conjuntos.get(conjunto2)[j]) {
                        break;
                    }
                }

                tmp.add(conjuntos.get(conjunto1)[i]);
            }

            for (int i = 0; i < conjuntos.get(conjunto2).length; i++) {
                for (int j = 0; j < tmp.size(); j++) {
                    if (tmp.get(j) == conjuntos.get(conjunto2)[i]) {
                        break;
                    }
                }

                tmp.add(conjuntos.get(conjunto2)[i]);
            }

            if (tmp.size() > 0) {
                conjuntoUnion = new Integer[tmp.size()];

                for (int i = 0; i < tmp.size(); i++) {
                    conjuntoUnion[i] = tmp.get(i);
                }*/

                this.conjuntos.put("Union", conjuntoUnion);
            /*}*/
        }
    }

    private Integer[] evaluarUnion(Integer[] c1, Integer[] c2) {
        Integer[] union = c2;

        for (int i = 0; i < c1.length; i++) {
            boolean existe = false;

            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                Integer[] tmp = union;
                union = new Integer[union.length + 1];

                for (int k = 0; k < tmp.length; k++) {
                    union[k] = tmp[k];
                }

                union[tmp.length] = c1[i];
            }
        }

        return union;
    }

    public void interseccion(String conjunto1, String conjunto2) {
        Integer[] conjuntoInterseccion = null;
        List<Integer> tmp = new ArrayList<>();

        this.conjuntos.remove("Interseccion");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            for (int i = 0; i < conjuntos.get(conjunto1).length; i++) {
                for (int j = 0; j < conjuntos.get(conjunto2).length; j++) {
                    if (conjuntos.get(conjunto1)[i] == conjuntos.get(conjunto2)[j]) {
                        tmp.add(conjuntos.get(conjunto1)[i]);
                        break;
                    }
                }
            }

            if (tmp.size() > 0) {
                conjuntoInterseccion = new Integer[tmp.size()];

                for (int i = 0; i < tmp.size(); i++) {
                    conjuntoInterseccion[i] = tmp.get(i);
                }

                this.conjuntos.put("Interseccion", conjuntoInterseccion);
            }
        }
    }

    public void igualarConjuntos(String conjunto1, String conjunto2) {
        this.conjuntos.remove("Igualdad");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            if (cantidadElementos(conjunto1) == cantidadElementos(conjunto2)) {
                boolean esIgual = false;

                for (int i = 0; i < conjuntos.get(conjunto1).length; i++) {
                    for (int j = 0; j < conjuntos.get(conjunto2).length; j++) {
                        if (conjuntos.get(conjunto1)[i] == conjuntos.get(conjunto2)[j]) {
                            esIgual = true;
                            break;
                        } else {
                            esIgual = false;
                        }
                    }
                }

                if (esIgual) {
                    JOptionPane.showMessageDialog(null, "El conjunto " + conjunto1 + " es igual al conjunto " + conjunto2, "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El conjunto " + conjunto1 + " NO es igual al conjunto " + conjunto2, "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El conjunto " + conjunto1 + " NO es igual al conjunto " + conjunto2, "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void obtenerComplemento(String conjunto) {
        Integer[] complemento = new Integer[0];
        this.conjuntos.remove("Complemento");

        if (conjuntos != null && conjuntos.containsKey(conjunto)) {
            if (!conjuntos.containsKey("Universal")) {
                asignarConjuntoUniversal();
            }

            for (int i = 0; i < conjuntos.get("Universal").length; i++) {
                boolean existe = false;

                for (int j = 0; j < conjuntos.get(conjunto).length; j++) {
                    if (conjuntos.get("Universal")[i] == conjuntos.get(conjunto)[j]) {
                        existe = true;
                        break;
                    } else {
                        existe = false;
                    }
                }

                if (!existe) {
                    Integer[] tmp = complemento;
                    complemento = new Integer[complemento.length + 1];

                    for (int k = 0; k < tmp.length; k++) {
                        complemento[k] = tmp[k];
                    }

                    complemento[tmp.length] = conjuntos.get("Universal")[i];
                }
            }

            this.conjuntos.put("Complemento", complemento);
        }
    }

    public void obtenerDiferencia(String conjunto1, String conjunto2) {
        Integer[] conjuntoDiferencia = new Integer[0];
        this.conjuntos.remove("Diferencia");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            for (int i = 0; i < conjuntos.get(conjunto1).length; i++) {
                boolean existe = false;

                for (int j = 0; j < conjuntos.get(conjunto2).length; j++) {
                    if (conjuntos.get(conjunto1)[i] == conjuntos.get(conjunto2)[j]) {
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    Integer[] tmp = conjuntoDiferencia;
                    conjuntoDiferencia = new Integer[conjuntoDiferencia.length + 1];

                    for (int k = 0; k < tmp.length; k++) {
                        conjuntoDiferencia[k] = tmp[k];
                    }

                    conjuntoDiferencia[tmp.length] = conjuntos.get(conjunto1)[i];
                }
            }

            this.conjuntos.put("Diferencia", conjuntoDiferencia);
        }
    }

    public void obtenerDiferenciaSimetrica(String conjunto1, String conjunto2) {
        Integer[] conjuntoDiferenciaSimetrica = new Integer[0];
        Integer[] tmpConjunto2;
        this.conjuntos.remove("Diferencia-Simetrica");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            tmpConjunto2 = conjuntos.get(conjunto2);

            for (int i = 0; i < conjuntos.get(conjunto1).length; i++) {
                boolean existe = false;

                for (int j = 0; j < tmpConjunto2.length; j++) {
                    if (tmpConjunto2[j] != null && conjuntos.get(conjunto1)[i] == tmpConjunto2[j]) {
                        existe = true;
                        tmpConjunto2[j] = null;
                        break;
                    }
                }

                if (!existe) {
                    Integer[] tmp = conjuntoDiferenciaSimetrica;
                    conjuntoDiferenciaSimetrica = new Integer[conjuntoDiferenciaSimetrica.length + 1];

                    for (int k = 0; k < tmp.length; k++) {
                        conjuntoDiferenciaSimetrica[k] = tmp[k];
                    }

                    conjuntoDiferenciaSimetrica[tmp.length] = conjuntos.get(conjunto1)[i];
                }
            }

            if (tmpConjunto2.length > 0) {
                for (int j = 0; j < tmpConjunto2.length; j++) {
                    if (tmpConjunto2[j] != null) {
                        Integer[] tmp = conjuntoDiferenciaSimetrica;
                        conjuntoDiferenciaSimetrica = new Integer[conjuntoDiferenciaSimetrica.length + 1];

                        for (int k = 0; k < tmp.length; k++) {
                            conjuntoDiferenciaSimetrica[k] = tmp[k];
                        }

                        conjuntoDiferenciaSimetrica[tmp.length] = tmpConjunto2[j];
                    }
                }
            }

            this.conjuntos.put("Diferencia-Simetrica", conjuntoDiferenciaSimetrica);
        }
    }
}
