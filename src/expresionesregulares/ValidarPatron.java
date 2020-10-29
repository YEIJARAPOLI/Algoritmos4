package expresionesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        return validarPatron(patron, numeroCelular);
    }

    //Válida números telefónicos fijos en Medellín.
    public boolean validarNumeroTelefononicoFijo(String numeroTelefonico){

        String patron = "";
        return validarPatron(patron, numeroTelefonico);
    }

    //Válida direcciones residenciales en Medellín. (CL, CR, AV, TRAS)
    public boolean validarDireccionResidencial(String direccion){

        String patron = "";
        return validarPatron(patron, direccion);
    }
         
    //Válida placas de carro el Colombia.
    /* @azules amarilla y blanca 3 letras guion y tres numeros(autos clasicos,particular, servcio publico)
     * @matricula roja T-cuatro numeros (transito libre)
     * @azul dos letras-4numeros(diplomaticos)
     * @verde R|S remolque o semiremolque y 5 numeros
     */
    public boolean validarPlacasCarro(String placa){

        String patron = "";
        return validarPatron(patron, placa);
    }
    
    //Válida fecha dd mm aaaa. (1900-2100)
    public boolean validarFecha(String fecha){

        String patron = "";
        return validarPatron(patron, fecha);
    }
    
    //Válida cédulas en Colombia.
    public boolean validarCedula(String cedula){

        String patron = "";
        return validarPatron(patron, cedula);
    }
    
    //Válida correo electrónico.
    public boolean validarCorreoElectronico(String correoElectronico){

        String patron = "";
        return validarPatron(patron, correoElectronico);
    }
    
    public boolean validarPatron(String patron, String cadena){
        pattern = Pattern.compile(patron);
        matcher = pattern.matcher(cadena);
        
        return matcher.matches();
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
