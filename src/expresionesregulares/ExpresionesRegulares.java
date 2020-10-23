package expresionesregulares;

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
                + "\n1. Números de teléfonos celulares en Colombia."
                + "\n2. Números de teléfonos fijos en Medellín."
                + "\n3. Direcciones residenciales en Medellín."
                + "\n4. Placas de carro el Colombia."
                + "\n5. Fecha en formato dd mm aaaa."
                + "\n6. Cédulas en Colombia."
                + "\n7. Direcciones de correos electrónicos."
                + "\n8. Direcciones de sitios web (URL)."
                + "\n9. Una declaracion de variables en java."
                + "\n10. Nombres y apellidos."
                + "\n11. Contaseña segura."
                + "\n0. SALIR";
        
        ValidarPatron validarPatron = new ValidarPatron();
        int opcion;      
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, TITLE_MENU, JOptionPane.QUESTION_MESSAGE));
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
                    break; 
                //Una declaracion de variables en java. 
                case 9:
                    break;   
                //Nombres y apellidos. 
                case 10:
                    break;
                //Contraseña segura. 
                case 11:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:JOptionPane.showMessageDialog(null, "¡OPCIÓN INCORRECTA!", TITLE_MENU, JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
}
