import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contraseña con do-while
 *
 * Autor: [joel ayarza]
 * Fecha: [8-1045-1005]
 */


public class Ejercicio4 {

    public static void main(String[] args) {

        
        String contrasena;
        int intentos = 0;
        boolean valida;

        
        do {
            contrasena = JOptionPane.showInputDialog(
                "Ingresa una contraseña:\n" +
                "Minimo 8 caracteres.\n" +
                "Al menos un digito.\n" +
                "Al menos una mayuscula."
            );

            intentos++;
            valida = true;

            if (contrasena == null) {
                return;
            }

                    if (contrasena.length() < 8) {
                JOptionPane.showMessageDialog(
                    null,
                    "Error: minimo 8 caracteres"
                );
                valida = false;

            } else {

                boolean tieneDigito = false;
                boolean tieneMayuscula = false;

                
                for (int i = 0; i < contrasena.length(); i++) {

                    char caracter = contrasena.charAt(i);

                    if (caracter >= '0' && caracter <= '9') {
                        tieneDigito = true;
                    }

                    if (caracter >= 'A' && caracter <= 'Z') {
                        tieneMayuscula = true;
                    }
                }

                if (!tieneDigito) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Error: falta un digito"
                    );
                    valida = false;

                } else if (!tieneMayuscula) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Error: falta una letra mayuscula"
                    );
                    valida = false;
                }
            }

        } while (!valida);

               String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        fechaHora = LocalDateTime.now().format(formato);

       
        String mensaje =
            "Contrasena aceptada\n" +
            "Intentos realizados: " + intentos + "\n" +
            "Computadora: " + nombrePC +
            " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}