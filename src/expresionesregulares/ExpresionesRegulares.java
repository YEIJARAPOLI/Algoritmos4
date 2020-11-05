package expresionesRegulares;

import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Expresiones Regulares
 * @author leonChanci
 * @since 23/10/2020
 */
public class ExpresionesRegulares {
    //Variable tipo text para el nombre del MENÚ
    final static String TITLE_MENU = "*** EXPRESIONES REGULARES ***";
    
    public static void main(String[] args) {
        /* Expresiones regulares
           Escribir una expresión regular para validar cada una de las siguientes entradas:
        */
        String menu = TITLE_MENU
                + "\n"
                + "\n  1. Número celular Colombia"
                + "\n  2. Número teléfono fijos Medellín"
                + "\n  3. Direcciones residenciales en Medellín"
                + "\n  4. Placas carro Colombia"
                + "\n  5. Fecha formato (dd mm aaaa)"
                + "\n  6. Cédula Colombiana"
                + "\n  7. Direccion correo electrónico"
                + "\n  8. Direccion sitios web (URL)"
                + "\n  9. Declaracion variables java"
                + "\n  10. Nombres y apellidos"
                + "\n  11. Contaseña segura"
                + "\n  12. Buscar celulares validos(Colombia) dentro de un texto"
                + "\n  13. Buscar correosElectrónicos validos dentro de un texto"
                + "\n"
                + "\n  0. SALIR";

        ValidarPatron validarPatron = new ValidarPatron();
        int opcion;
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch(opcion){
                //Números de teléfonos celulares en Colombia.
                case 1:
                    String numeroCelular = JOptionPane.showInputDialog(null, "Ingrese número de célular a validar. ", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    if(validarPatron.validarNumeroCelular(numeroCelular)){
                        JOptionPane.showMessageDialog(null, "El número célular ingresado, ¡Es Válido!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "El número célular ingresado, ¡No es Válido!", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Números de teléfonos fijos en Medellín.
                case 2:
                    String numeroFijo = JOptionPane.showInputDialog(null, "Ingrese número telefónico a validar. ", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    if(validarPatron.validarNumeroTelefononicoFijo(numeroFijo)){
                        JOptionPane.showMessageDialog(null, "El número telefónico ingresado, ¡Es Válido!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "El número telefónico ingresado, ¡No es Válido!", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Direcciones residenciales en Medellín.  (CL, CR, AV, TV).
                case 3:
                    String direccion = JOptionPane.showInputDialog(null, "Ingrese dirección residencial a validar. (CL, CR, AV, TV).", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    if(validarPatron.validarDireccionResidencial(direccion)){
                        JOptionPane.showMessageDialog(null, "La dirección residencial ingresada, ¡Es Válida!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "La dirección residencial ingresada, ¡No es Válida!", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Placas de carro el Colombia.
                case 4:
                    String placa = JOptionPane.showInputDialog(null, "Ingrese placa a validar. ", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    if(validarPatron.validarPlacasCarro(placa)){
                        JOptionPane.showMessageDialog(null, "La placa ingresada, ¡Es Válida!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "La placa ingresada, ¡No es Válida!", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Fecha en formato dd mm aaaa. (1900-2100)
                case 5:
                    String fecha = JOptionPane.showInputDialog(null, "Ingrese fecha a validar. ", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    if(validarPatron.validarFecha(fecha)){
                        JOptionPane.showMessageDialog(null, "La fecha ingresada, ¡Es Válida!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "La fecha ingresada, ¡No es Válida!", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Cédulas en Colombia.
                case 6:
                    String cedula = JOptionPane.showInputDialog(null, "Ingrese cédula a validar. ", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    
                    if(validarPatron.validarCedula(cedula)){
                        JOptionPane.showMessageDialog(null, "La cédula ingresada, ¡Es Válida!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "La cédula ingresada, ¡No es Válida!", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Direcciones de correos electrónicos.
                case 7:
                    String correoElectronico = JOptionPane.showInputDialog(null, "Ingrese correo electrónico a validar. ", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    
                    if(validarPatron.validarCorreoElectronico(correoElectronico)){
                        JOptionPane.showMessageDialog(null, "El correo electrónico ingresado, ¡Es Válido!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "El correo electrónico ingresado, ¡No es Válido!", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Direcciones de sitios web (URL).
                case 8:
                    String url = JOptionPane.showInputDialog(null, "Ingrese la URL a validar", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    
                    if (validarPatron.validarURL(url)) {
                        JOptionPane.showMessageDialog(null, "¡URL validada exitosamente!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La URL ingresada no es valida", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Una declaracion de variables en java.
                case 9:
                    String variable = JOptionPane.showInputDialog(null, "Ingrese la variable", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    
                    if (validarPatron.validarDeclaracionVariable(variable)) {
                        JOptionPane.showMessageDialog(null, "¡Variable validada exitosamente!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "La variable ingresada no es valida", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Nombres y apellidos.
                case 10:
                    String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre a validar", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    
                    if (validarPatron.validarNombres(nombre)) {
                        JOptionPane.showMessageDialog(null, "¡Nombre valido exitosamente!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El nombre ingresado no es valida", TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Contraseña segura.
                case 11:
                    String password = JOptionPane.showInputDialog(null, "Digite la contraseña", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    
                    if (validarPatron.validarPassword(password)) {
                        JOptionPane.showMessageDialog(null, "¡Contraseña validada exitosamente!", TITLE_MENU, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        StringBuilder sb = new StringBuilder();

                        sb.append("La contraseña debe contener:\n\n")
                                .append("Al menos 8 caracteres\n")
                                .append("Al menos 1 dígito\n")
                                .append("Al menos un caracter especial\n")
                                .append("Al menos una minuscula y una mayuscula\n")
                                .append("No debe contener espacios ni tabulaciones\n");

                        JOptionPane.showMessageDialog(null, sb.toString(), TITLE_MENU, JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                //Buscar celulares validos(Colombia) dentro de un texto
                case 12:
                    String texto = "Texto3098976654 @gmail.comdatos celulares3216750078contactos de telefono *3512291647"
                            + "correosleon@hotmail.es Electronicos360125887524610321243232291647 numero de vivienda y direcciones"
                            + "numerode Cudula de ciudadaniasara@gmail.com ";
                    validarPatron.encontrarNumeroCelular(texto);
                    break;
                //13. Buscar correosElectrónicos validos dentro de un texto
                case 13:
                    String texto2 = "Texto3098976654 @gmail.comdatos celulares3216750078contactos de telefono *3512291647"
                            + " correosleon@hotmail.es Electronicos360125887524610321243232291647 numero de vivienda y direcciones"
                            + "numerode Cudula de ciudadaniasara@gmail.com prueb@gmail.c";
                    validarPatron.encontrarCorreoElectronico(texto2);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
}
