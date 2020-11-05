package expresionesRegulares;

import static expresionesRegulares.ExpresionesRegulares.TITLE_MENU;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 * Validar patrón expresiones regulares
 * @author leonChanci
 * @since 23/09/2020
 */
public class ValidarPatron {
    
    private Pattern pattern;
    private Matcher matcher;

    //Válida números célulares con prefijos de Colombia.
    public boolean validarNumeroCelular(String numeroCelular){
        String prefijosClaro = "310|311|312|313|314|320|321|322|323|";
        String prefijosTigo = "300|301|302|304|305|";
        String prefijosMovistar = "315|316|317|318|";
        String otrosOperadores = "319|350|351|303|304|305";
        StringBuilder operadores = new StringBuilder("");
        operadores.append(prefijosClaro).append(prefijosTigo).append(prefijosMovistar).append(otrosOperadores);
        String patron = "(\\+57|\\+0057|0057|57)?("+operadores.toString()+")+[0-9]{7}";

        return validarPatron(patron, numeroCelular, false);
    }
    
    //Encuentra números célulares válidos (prefijos colombia) dentro de un texto.
    public void encontrarNumeroCelular(String texto){
        String prefijosClaro = "310|311|312|313|314|320|321|322|323|";
        String prefijosTigo = "300|301|302|304|305|";
        String prefijosMovistar = "315|316|317|318|";
        String otrosOperadores = "319|350|351|303|304|305";
        StringBuilder operadores = new StringBuilder("");
        operadores.append(prefijosClaro).append(prefijosTigo).append(prefijosMovistar).append(otrosOperadores);
        String patron = "(\\+57|\\+0057|0057|57)?("+operadores.toString()+")+[0-9]{7}";

        encontrarPatron(patron, texto, false);
    }

    //Válida números telefónicos fijos en Medellín.
    public boolean validarNumeroTelefononicoFijo(String numeroTelefonico){
        //Ejemplos encontrados: 
        //212, 221, 226, 230, 233, 234, 235, 254, 257, 267, 286, 
        //353, 373, 384,  
        //427, 476, 492
        //511, 514, 538, 576
        String primerNumeroValido = "2,3,4,5";  
        String proNombreExtensiones = "EXT|EXTENSION|extensión|EXTENSIÓN";
        String patron = "(4|94|094)?["+primerNumeroValido+"]{1}[0-9]{6}(\\s?("+proNombreExtensiones+")\\s?[0-9]{2,4})?";
        return validarPatron(patron, numeroTelefonico, true);
    }

    //Válida direcciones residenciales en Medellín. (CL, CR, AV, TRAS)
    public boolean validarDireccionResidencial(String direccion){
        String nomenclaturas = "CL|CR|AV|TV|CLL|CALLE|CRR|CARRERA|AVENIDA|TRANSVERSAL";
        String validarNum = "[1-9]{1}[0-9]{1,2}";
        String patron = "^(("+nomenclaturas+")\\s"+validarNum+"([a-zA-Z]{1,2})?)?\\s?"      //Válida la primer parte ejem: "CR 30A" 
                       + "((#|("+nomenclaturas+"))\\s?"+validarNum+"([a-zA-Z]{1,2})?\\s?)?" //Válida la segunda parte ejem: "TV 80"
                       + "("+validarNum+"|-"+validarNum+"|(\\s(IN|INT)\\s"+validarNum+"))?";    //Válida la tercera parte ejem: "[00]" , "-20" o " IN 321"
               
        return validarPatron(patron, direccion, true);
    }
         
    //Válida placas de carro el Colombia.
    /*
      Placas Amarillas - Vechículos Particulares - ejem: (AAA 123)
      Placas Blancas - Vechículos Públicos - ejem: (AAA 123)
      Placas Azules - Vechículos Especiales - ejem: (AA 1234)
      Placas Rojas - Vehículos Carga - ejem: (T 1234)
      Placas Verdes - Vehículos Semiremolques y Remolques - ejem: (R12345), (S12345)
      Placas Motocicletas - Ejem: AAA 12A
     */
    public boolean validarPlacasCarro(String placa){
        String patron = "(([A-Z]{3}(\\s|-)?[\\d]{3})|([A-Z]{2}(\\s|-)?[\\d]{4})|"
                      + "((T)(\\s|-)?[\\d]{4})|((R|S)(\\s|-)?[\\d]{5})|"
                      + "([A-Z]{3}(\\s|-)?[\\d]{2}[A-Z]{1}))?";
        return validarPatron(patron, placa, true);
    }
    
    //Válida fecha dd mm aaaa. (1900-2100)
    public boolean validarFecha(String fecha){
        String patron = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])(\\/|-)(((19|20)[0-9]{2})|(21)[0]{2})";
        return validarPatron(patron, fecha, false);
    }
    
    //Válida cédulas en Colombia.
    public boolean validarCedula(String cedula){
        pattern = Pattern.compile("(^[1][0-9]{7,10})|(^[4][0-9]{6,})");
        matcher = pattern.matcher(cedula);
        
        return matcher.find();
    }
    
    public boolean validarDeclaracionVariable(String declaracion) {
        String atributo = "public|private|protected";
        String varEnteros = "byte|Byte|short|Short|int|Integer|long|Long|";
        String varDecimales = "float|Float|double|Double|";
        String varComplementos = "boolean|Boolean|char|Character|String";
        
        StringBuilder tiposVariables = new StringBuilder("");
        tiposVariables.append(varEnteros).append(varDecimales).append(varComplementos);
        
        pattern = Pattern.compile("((" + atributo + ")\\s)?(" + tiposVariables + ")\\s(\\w+)(\\s?(=\\s?)(\"+\\w+\"|\"\"|\\d+);|;$)");
        matcher = pattern.matcher(declaracion);
        
        return matcher.find();
    }
    
    //Válida correo electrónico.
    public boolean validarCorreoElectronico(String correoElectronico){
        pattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(correoElectronico);
        
        return matcher.find();
    }
    
    //Válidar nombre y apellidos
    public boolean validarNombres(String nombre) {
        pattern = Pattern.compile("[A-Z][a-z]+(\\s[A-Z][a-z]+)?");
        matcher = pattern.matcher(nombre);
        
        return matcher.find();
    }
    
    //Encuentra correos electrónicos válidos dentro de un texto
    public void encontrarCorreoElectronico(String texto){
        String patron = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
        encontrarPatron(patron, texto, true);
    }
    
    //Método para compilar el patrón y retornar el resultado
    public boolean validarPatron(String patron, String cadenaAValidar, boolean caseInsensitive){
        if(caseInsensitive){
            pattern = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        }else{
            pattern = Pattern.compile(patron);
        }
        matcher = pattern.matcher(cadenaAValidar);    
        return matcher.matches();
    }
    
    //Método para compilar el patrón y mostrar el resultado encontrado
    public void encontrarPatron(String patron, String texto, boolean caseInsensitive){
        if(caseInsensitive){
            pattern = Pattern.compile(patron, Pattern.CASE_INSENSITIVE);
        }else{
            pattern = Pattern.compile(patron);
        }
        matcher = pattern.matcher(texto);   
        
        int contador = 0;
        while(matcher.find()){
            int desde = matcher.start();
            int hasta = matcher.end();
            contador ++;   
            JOptionPane.showMessageDialog(null, "Desde: "+desde+"- Hasta: "+hasta+"."
                + "\nEl texto que cumple es: '"+texto.substring(desde, hasta)+"'"+".", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
            }
        JOptionPane.showMessageDialog(null, "El patrón se encontró "+contador+" vez(veces) en el texto.", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean validarPassword(String pass) {
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
        
        
        pattern = Pattern.compile("^.*(?=.[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)(?=.*[.@#$%^&+=]).{8,}.*$" ,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(pass);
        
        return matcher.matches();
    }
    
    public boolean validarURL(String url) {
        pattern = Pattern.compile("^((https?|ftp|file)://)?(www{1})[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]" ,Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(url);
        
        return matcher.matches();
    }
}
