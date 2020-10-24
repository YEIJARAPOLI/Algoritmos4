package expresionesRegulares;

import javax.swing.JOptionPane;

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
                + "\n10. Nombres y apellidos"
                + "\n11. Contaseña segura"
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
                    break;
                //Direcciones residenciales en Medellín.
                case 3:
                    break;
                //Placas de carro el Colombia.
                case 4:
                    break;
                //Fecha en formato dd mm aaaa.
                case 5:
                    break;
                //Cédulas en Colombia.
                case 6:
                    break;
                //Direcciones de correos electrónicos.
                case 7:
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
                    break;
                //Nombres y apellidos.
                case 10:
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
