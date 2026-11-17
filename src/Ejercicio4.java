
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Ejercicio4 {

    public static void main(String[] args) {

        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // TODO 1: Validar contraseña con do-while
        do {
            contrasena = JOptionPane.showInputDialog(
                "Ingrese una contrasena:"
            );

            if (contrasena == null) {
                return;
            }

            intentos++;

            if (contrasena.length() < 8) {
                JOptionPane.showMessageDialog(
                    null,
                    "La contrasena debe tener al menos 8 caracteres"
                );
            } else {

                boolean tieneDigito = false;
                boolean tieneMayuscula = false;

                for (int i = 0; i < contrasena.length(); i++) {
                    char caracter = contrasena.charAt(i);

                    if (Character.isDigit(caracter)) {
                        tieneDigito = true;
                    }
                }

                if (!tieneDigito) {
                    JOptionPane.showMessageDialog(
                        null,
                        "La contrasena debe tener al menos un digito"
                    );
                } else {

                    for (int i = 0; i < contrasena.length(); i++) {
                        char caracter = contrasena.charAt(i);

                        if (Character.isUpperCase(caracter)) {
                            tieneMayuscula = true;
                        }
                    }

                    if (!tieneMayuscula) {
                        JOptionPane.showMessageDialog(
                            null,
                            "La contrasena debe tener al menos una mayuscula"
                        );
                    } else {
                        valida = true;
                    }
                }
            }

        } while (!valida);

        // TODO 2: Obtener computadora y fecha
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (IOException e) {
            nombrePC = "DESCONOCIDO";
        }

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String fechaHora = LocalDateTime.now().format(formato);

        // TODO 3: Mostrar resultado final
        String resultado =
            "Contrasena aceptada\n" +
            "Intentos realizados: " + intentos + "\n" +
            "Computadora: " + nombrePC +
            " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
