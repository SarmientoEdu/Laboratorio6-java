package src;

import javax.swing.JOptionPane;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contrasena con do-while
 * Autor: Isaaid Caicedo
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        String contrasena;
        boolean valida;
        int intentos = 0;

        // TODO 1: Validar contrasena con do-while
        do {

            contrasena = JOptionPane.showInputDialog(
                "Ingrese una contrasena:\n" +
                "- Minimo 8 caracteres\n" +
                "- Al menos un numero\n" +
                "- Al menos una letra mayuscula"
            );

            if (contrasena == null) {
                return;
            }

            intentos++;
            valida = true;

            // TODO 2: Verificar longitud
            if (contrasena.length() < 8) {

                JOptionPane.showMessageDialog(
                    null,
                    "Error: minimo 8 caracteres"
                );

                valida = false;

            } else {

                // TODO 3: Verificar numero y mayuscula
                boolean tieneNumero = false;
                boolean tieneMayuscula = false;

                for (int i = 0; i < contrasena.length(); i++) {

                    char caracter = contrasena.charAt(i);

                    if (caracter >= '0' && caracter <= '9') {
                        tieneNumero = true;
                    }

                    if (caracter >= 'A' && caracter <= 'Z') {
                        tieneMayuscula = true;
                    }
                }

                if (!tieneNumero) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Error: debe contener un numero"
                    );

                    valida = false;

                } else if (!tieneMayuscula) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Error: debe contener una mayuscula"
                    );

                    valida = false;
                }
            }

        } while (!valida);

        // TODO 4: Obtener nombre de PC y fecha
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        String fechaHora = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );

        // TODO 5: Mostrar resultado
        String resultado =
                "Contrasena aceptada\n" +
                "Intentos realizados: " + intentos + "\n" +
                "Computadora: " + nombrePC +
                " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
