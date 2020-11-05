package expresionesRegulares;

import java.util.regex.*;
import java.lang.*;

/**
 *
 * @author yeijara
 */
public class ExpresionRegular {
    
    public static void main(String[] args) {
        
        String atributo = "public|private|protected";
        String varEnteros = "byte|Byte|short|Short|int|Integer|long|Long|";
        String varDecimales = "float|Float|double|Double|";
        String varComplementos = "boolean|Boolean|char|Character|String";
        
        StringBuilder tiposVariables = new StringBuilder("");
        tiposVariables.append(varEnteros).append(varDecimales).append(varComplementos);
        
        String cadena = "private String leon = \"uyueyww2323e\";";
        
        Pattern pattern = Pattern.compile("((" + atributo + ")\\s)?(" + tiposVariables + ")\\s(\\w+)(\\s?(=\\s?)(\"+\\w+\"|\"\"|\\d+);|;$)");
        Matcher matcher = pattern.matcher(cadena);
        
        System.out.println(cadena);
        System.out.println(matcher.find());
        
        //matcher.find();
        
        
        
        
        /*int contador = 0;
        Pattern patron = Pattern.compile("[\\d]" ,Pattern.CASE_INSENSITIVE);
        String cadena = "www.yeijara.com", cadenaNueva, palabras[] = patron.split(cadena);
        Matcher m = patron.matcher(cadena);
        
        ExpresionRegular er = new ExpresionRegular();*/
        
        //er.validarNumerosBinarios(cadena);
        //er.validarNumeroEntero(cadena);
        //er.validarNumerosPares(cadena);
        //er.validarNumerosImpares(cadena);
        //er.validarNombres(cadena);
        //er.validarNumerosCelular(cadena);
        //er.validarNumerosCelulares(cadena);
        //er.validarPassword(cadena);
        //er.validarURL(cadena);
        
//        if (m.matches()) { // Busca que coincida
//            //JOptionPane.showMessageDialog(null, "Cumple");
//            System.out.println("Cumple");
//        } else {
//            System.out.println("No cumple");
//        }

//        if (m.lookingAt()) { // Busca que este al inicio de la cadena
//            //JOptionPane.showMessageDialog(null, "Cumple");
//            System.out.println("Cumple");
//        } else {
//            System.out.println("No cumple");
//        }

        /*for (int i = 0; i < palabras.length; i++) { // parte la cadena según el patron
            System.out.println(palabras[i]);
        }*/
        
        //cadenaNueva = m.replaceAll("ZZ");
        /*cadenaNueva = m.replaceFirst("ZZ");  // Reemplaza solo la primera ocurrencia
        System.out.println(cadenaNueva);

        while (m.find()) {
            contador++;
            System.out.println("Desde " + m.start() + " - Hasta " + m.end() + ", el texto que cumple es '" + cadena.substring(m.start(), m.end()) + "'");
        }
        
        System.out.println("Se encontro " + contador + " veces el patron");*/
    }
    
    public void validarNumerosBinarios(String cadena) {
        Pattern patron = Pattern.compile("[^2-9]{8}" ,Pattern.CASE_INSENSITIVE);
        //Pattern patron = Pattern.compile("(0|1)*" ,Pattern.CASE_INSENSITIVE);
        //Pattern patron = Pattern.compile("[01]+" ,Pattern.CASE_INSENSITIVE);
        //Pattern patron = Pattern.compile("[0-9][0-9]*" ,Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(cadena);
        
        if (!m.matches()) {
            System.out.println("La cadena ingresada no es binaria");
        } else {
            System.out.println("La cadena " + cadena + " es un número binario");
        }
    }
    
    public void validarNumeroEntero(String cadena) {
        Pattern patron = Pattern.compile("^-?[0-9]+$" ,Pattern.CASE_INSENSITIVE);
        //Pattern patron = Pattern.compile("-?[0-9]+" ,Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(cadena);
        
        if (!m.matches()) {
            System.out.println("La cadena ingresada no es un número entero");
        } else {
            System.out.println("La cadena " + cadena + " es un número entero");
        }
    }
    
    public void validarNumerosPares(String cadena) {
        Pattern patron = Pattern.compile("^\\d*[02468]$" ,Pattern.CASE_INSENSITIVE);
        //Pattern patron = Pattern.compile("-?[\d]*[02468]" ,Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(cadena);
        
        if (!m.matches()) {
            System.out.println("La cadena ingresada no es un número par");
        } else {
            System.out.println("La cadena " + cadena + " es un número par");
        }
    }
    
    public void validarNumerosImpares(String cadena) {
        Pattern patron = Pattern.compile("^\\d*[13579]$" ,Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(cadena);
        
        if (!m.matches()) {
            System.out.println("La cadena ingresada no es un número impar");
        } else {
            System.out.println("La cadena " + cadena + " es un número impar");
        }
    }
    
    public void validarNombres(String cadena) {
        Pattern patron = Pattern.compile("[A-Z][a-z]+(\\s[A-Z][a-z]+)?" ,Pattern.CASE_INSENSITIVE);
        //Pattern patron = Pattern.compile("((\\D)+()?)+" ,Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(cadena);
        
        if (!m.matches()) {
            System.out.println("La cadena ingresada no es un nombre válido");
        } else {
            System.out.println("La cadena " + cadena + " es un nombre válido");
        }
    }
    
    public void validarNumerosCelular(String cadena) {
        Pattern patron = Pattern.compile("3[0-2]\\d{8}" ,Pattern.CASE_INSENSITIVE);
        //Pattern patron = Pattern.compile("((\\D)+()?)+" ,Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(cadena);
        
        if (!m.matches()) {
            System.out.println("La cadena ingresada no es un número de celular");
        } else {
            System.out.println("La cadena " + cadena + " es un número de celular");
        }
    }
    
    public void validarNumerosCelulares(String cadena) {
        String prefijosClaro = "310|311|312|313|314|320|321|322|323|";
        String prefijosTigo = "300|301|302|304|305|";
        String prefijosMovistar = "315|316|317|318|";
        String prefijosOtros = "319|350|351|303|";
        
        StringBuilder prefijos = new StringBuilder();
        
        prefijos.append(prefijosClaro).append(prefijosTigo).append(prefijosMovistar).append(prefijosOtros);
        
        Pattern patron = Pattern.compile("(\\+57|\\+0057|0057|57)?(" + prefijos.toString() + ")");
        Matcher m = patron.matcher(cadena);
        
        System.out.println(prefijos);
        
        while (m.find()) {
            System.out.println("Desde " + m.start() + " - Hasta " + m.end() + ", el texto que cumple es '" + cadena.substring(m.start(), m.end()) + "'");
        }
    }
    
    // Inicia validadores propuestos por el docente para el trabajo
    private void validarPlacasCarros() {
        
    }
    
    private void validarTelefonosMedellin() {
        
    }
    
    private void validarCelularesColombia() {
        
    }
    
    private void validarDireccionesMedellin() {
        
    }
    
    private void validarEmails() {
        
    }
    
    private void validarFecha() {
        
    }
    
    private void validarCedulas() {
        
    }
    
    private void validarDeclaracionVariable() {
        
    }
    
    private void validarNombreApellido() {
        
    }
    
    private void validarURL(String cadena) {
        Pattern patron = Pattern.compile("^((https?|ftp|file)://)?(www{1})[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]" ,Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(cadena);
        
        if (!m.matches()) {
            System.out.println("URL incorrecta");
        } else {
            System.out.println("URL correcta");
        }
    }
    
    private void validarPassword(String cadena) {
        /**
         * Documentación de los usos de expresiones para la contraseña
         * 
         * ^                   Inicio de un String
         * (?=.{0-9})          Al menos un dígito
         * (?=.*[a-z])         Al menos una minuscula
         * (?=.*[A-Z])         Al menos una mayuscula
         * (?=\\S+$)           Sin espacios
         * (?=.*[.@#$%^&+=])   Caracteres especiales
         * {8,}                Minimo 8 caracteres
         * $                   Fin del String
         *
         **/
        
        
        Pattern patron = Pattern.compile("^.*(?=.[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)(?=.*[.@#$%^&+=]).{8,}.*$" ,Pattern.CASE_INSENSITIVE);
        Matcher m = patron.matcher(cadena);
        
        if (!m.matches()) {
            StringBuilder sb = new StringBuilder();
            
            sb.append("La contraseña debe contener:\n").append("Al menos 8 caracteres\n").append("Al menos 1 dígito\n").append("Al menos un caracter especial\n");
            sb.append("Al menos una minuscula y una mayuscula\n").append("No debe contener espacios ni tabulaciones");
            
            System.out.println(sb.toString());
        } else {
            System.out.println("La constraseña ingresada es correcta");
        }
    }
}
