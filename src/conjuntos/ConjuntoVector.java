package conjuntos;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Conjunto Vectores
 * @author yeijara
 * @since 25/11/2020
 */

public class ConjuntoVector {

    private int n;
    String[] conjunto;
    String[] conjuntoUniversal;

    //List<String[]> conjuntos;
    Map<String, Integer[]> conjuntos;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String[] agregar(String nombreConjunto) {
        if (conjuntoUniversal == null) {
            // Llenar el conjunto universal
        }

        String respuesta = "S";

        while (respuesta.equalsIgnoreCase("S")) {
            Integer dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese elemento al conjunto: '" + nombreConjunto + "'", "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE));

            if (this.almacenarDato(dato, nombreConjunto)) {
                JOptionPane.showMessageDialog(null, "¡El elemento '" + dato + "' ya esta asignado al conjunto '" + nombreConjunto + "'!", "*** CONJUNTOS VECTORES ***", JOptionPane.ERROR_MESSAGE);
            }

            respuesta = JOptionPane.showInputDialog(null, "Desea ingresar otro elemento al conjunto: '"+nombreConjunto+"' ? (S/N)", "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
        }

        return null;
    }

    private boolean almacenarDato(Integer dato, String nombreConjunto) {
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

    public void mostrar(String nombreConjunto) {
        if (conjuntos != null) {
            String salida = "<html>" + nombreConjunto + " = { ";

            for (int i = 0; i < conjuntos.get(nombreConjunto).length; i++) {
                if (i == ((conjuntos.get(nombreConjunto).length) - 1)) {
                    salida += conjuntos.get(nombreConjunto)[i];
                } else {
                    salida += conjuntos.get(nombreConjunto)[i] + ", ";
                }
            }

            salida += " }</html>";

            JOptionPane.showMessageDialog(null, "\n"+salida, "*** CONJUNTOS VECTORES ***", JOptionPane.INFORMATION_MESSAGE);
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
}
