package expresionesregulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validar patrón expresiones regulares
 * @author leonChanci
 * @since 23/09/2020
 */
public class ValidarPatron {
    
    //Válida números célulares con prefijos de Colombia.
    public boolean validarNumeroCelular(String numeroCelular){
        String claro = "310|311|312|313|314|320|321|322|323|";
        String tigo = "300|301|302|304|305|";
        String movistar = "315|316|317|318|";
        String otrosOperadores = "319|350|351|303|304|305";
        StringBuilder operadores = new StringBuilder("");
        operadores.append(claro).append(tigo).append(movistar).append(otrosOperadores);
        String patron = "(\\+57|\\+0057|0057|57)?("+operadores.toString()+")+[0-9]{7}";
        
        return validarPatron(patron, numeroCelular);
    }
    
    //Válida números telefónicos fijos en Medellín.
    public boolean validarNumeroTelefononicoFijo(String numeroTelefonico){
        
        String patron = "";
        return validarPatron(patron, numeroTelefonico);
    }
    
    public boolean validarPatron(String patron, String cadena){
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    } 
}
