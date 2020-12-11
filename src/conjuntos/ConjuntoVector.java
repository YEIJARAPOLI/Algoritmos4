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

    Map<String, String[]> conjuntos;

    public ConjuntoVector() {
        conjuntos = new HashMap<>();
        asignarConjuntoUniversal();
    }
    
    public Map<String, String[]> getConjuntos() {
        return conjuntos;
    }

    public void setConjuntos(Map<String, String[]> conjuntos) {
        this.conjuntos = conjuntos;
    }

    private void asignarConjuntoUniversal() {
        conjuntos.put("Universal", new String[]{ "Rojo", "Verde", "Amarillo", "Azul", "Morado", "Naranja", "Blanco", "Negro" });
    }

    public String[] agregar(String nombreConjunto) {
        String respuesta = "S";

        while (respuesta.equalsIgnoreCase("S")) {
            String dato = JOptionPane.showInputDialog(null, "Ingrese elemento al conjunto: '" + nombreConjunto + "'", "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);

            if (this.almacenarDato(dato, nombreConjunto)) {
                JOptionPane.showMessageDialog(null, "¡El elemento '" + dato + "' ya esta asignado al conjunto '" + nombreConjunto + "' o al Universal!", "*** CONJUNTOS VECTORES ***", JOptionPane.ERROR_MESSAGE);
            }

            respuesta = JOptionPane.showInputDialog(null, "Desea ingresar otro elemento al conjunto: '"+nombreConjunto+"' ? (S/N)", "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    private boolean almacenarDato(String dato, String nombreConjunto) {
        if (conjuntos != null && conjuntos.containsKey(nombreConjunto)) {
            boolean existe = false;
            String[] tmp = conjuntos.get(nombreConjunto);

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i].equals(dato)) {
                    existe = true;
                    break;
                } else {
                    existe = false;
                }
            }

            if (!existe) {
                String[] tmp2 = new String[tmp.length + 1];

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

            String[] tmp = new String[1];

            tmp[0] = dato;
            conjuntos.put(nombreConjunto, tmp);

            return false;
        }
    }

    public void mostrar(String nombreConjunto, String c1, String c2) {
        if (conjuntos != null && nombreConjunto != null && conjuntos.containsKey(nombreConjunto)) {
            String salida = "";

            if ((c1 == null || c1.isEmpty()) && (c2 == null || c2.isEmpty())) {
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
                String dato = JOptionPane.showInputDialog(null, "Ingrese elemento a eliminar del conjunto: '" + nombreConjunto + "'", "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
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
                    String[] tmp = new String[conjuntos.get(nombreConjunto).length - 1];

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
            conjuntos.replace(nombreConjunto, new String[0]);
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
        String[] conjuntoUnion = null;
        List<String> tmp = new ArrayList<>();

        this.conjuntos.remove("Union");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            conjuntoUnion = conjuntos.get(conjunto1);
            conjuntoUnion = evaluarUnion(conjuntos.get(conjunto2), conjuntoUnion);

            this.conjuntos.put("Union", conjuntoUnion);
        }
    }

    private String[] evaluarUnion(String[] c1, String[] c2) {
        String[] union = c2;

        for (int i = 0; i < c1.length; i++) {
            boolean existe = false;

            for (int j = 0; j < c2.length; j++) {
                if (c1[i].equals(c2[j])) {
                    existe = true;
                    break;
                }
            }

            if (!existe) {
                String[] tmp = union;
                union = new String[union.length + 1];

                for (int k = 0; k < tmp.length; k++) {
                    union[k] = tmp[k];
                }

                union[tmp.length] = c1[i];
            }
        }

        return union;
    }

    public void interseccion(String conjunto1, String conjunto2) {
        String[] conjuntoInterseccion = null;
        List<String> tmp = new ArrayList<>();

        this.conjuntos.remove("Interseccion");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            for (int i = 0; i < conjuntos.get(conjunto1).length; i++) {
                for (int j = 0; j < conjuntos.get(conjunto2).length; j++) {
                    if (conjuntos.get(conjunto1)[i].equals(conjuntos.get(conjunto2)[j])) {
                        tmp.add(conjuntos.get(conjunto1)[i]);
                        break;
                    }
                }
            }

            if (tmp.size() > 0) {
                conjuntoInterseccion = new String[tmp.size()];

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
                        if (conjuntos.get(conjunto1)[i].equals(conjuntos.get(conjunto2)[j])) {
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
        String[] complemento = new String[0];
        this.conjuntos.remove("Complemento");

        if (conjuntos != null && conjuntos.containsKey(conjunto)) {
            if (!conjuntos.containsKey("Universal")) {
                asignarConjuntoUniversal();
            }

            for (int i = 0; i < conjuntos.get("Universal").length; i++) {
                boolean existe = false;

                for (int j = 0; j < conjuntos.get(conjunto).length; j++) {
                    if (conjuntos.get("Universal")[i].equals(conjuntos.get(conjunto)[j])) {
                        existe = true;
                        break;
                    } else {
                        existe = false;
                    }
                }

                if (!existe) {
                    String[] tmp = complemento;
                    complemento = new String[complemento.length + 1];

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
        String[] conjuntoDiferencia = new String[0];
        this.conjuntos.remove("Diferencia");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            for (int i = 0; i < conjuntos.get(conjunto1).length; i++) {
                boolean existe = false;

                for (int j = 0; j < conjuntos.get(conjunto2).length; j++) {
                    if (conjuntos.get(conjunto1)[i].equals(conjuntos.get(conjunto2)[j])) {
                        existe = true;
                        break;
                    }
                }

                if (!existe) {
                    String[] tmp = conjuntoDiferencia;
                    conjuntoDiferencia = new String[conjuntoDiferencia.length + 1];

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
        String[] conjuntoDiferenciaSimetrica = new String[0];
        String[] tmpConjunto2;
        this.conjuntos.remove("Diferencia-Simetrica");

        if (conjuntos != null && conjuntos.containsKey(conjunto1) && conjuntos.containsKey(conjunto2)) {
            tmpConjunto2 = conjuntos.get(conjunto2);

            for (int i = 0; i < conjuntos.get(conjunto1).length; i++) {
                boolean existe = false;

                for (int j = 0; j < tmpConjunto2.length; j++) {
                    if (tmpConjunto2[j] != null && conjuntos.get(conjunto1)[i].equals(tmpConjunto2[j])) {
                        existe = true;
                        tmpConjunto2[j] = null;
                        break;
                    }
                }

                if (!existe) {
                    String[] tmp = conjuntoDiferenciaSimetrica;
                    conjuntoDiferenciaSimetrica = new String[conjuntoDiferenciaSimetrica.length + 1];

                    for (int k = 0; k < tmp.length; k++) {
                        conjuntoDiferenciaSimetrica[k] = tmp[k];
                    }

                    conjuntoDiferenciaSimetrica[tmp.length] = conjuntos.get(conjunto1)[i];
                }
            }

            if (tmpConjunto2.length > 0) {
                for (int j = 0; j < tmpConjunto2.length; j++) {
                    if (tmpConjunto2[j] != null) {
                        String[] tmp = conjuntoDiferenciaSimetrica;
                        conjuntoDiferenciaSimetrica = new String[conjuntoDiferenciaSimetrica.length + 1];

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
    public boolean buscarDatoEnConjunto(String dato, ConjuntoVector conjuntoVec) {
        for (int i = 0; i < conjuntoVec.conjuntos.get("B").length; i++) {
            if(conjuntoVec.conjuntos.get("B")[i].equals(dato)){
                return true;
            }
        }
        return false;
    }
}
