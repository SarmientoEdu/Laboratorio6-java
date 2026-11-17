import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contraseña con do-while
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        // ============================================================
        // Variables de control
        // ============================================================
        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // ============================================================
        // TODO 1: Implementar el ciclo DO-WHILE que:
        do {
            contrasena = JOptionPane.showInputDialog(
                "Ingrese una contraseña:"
            );

            intentos++;

            String mensajeError = "";

            if (contrasena.length() < 8) {
                mensajeError = "La contrasena debe tener al menos 8 caracteres";
            } else {

                boolean tieneDigito = false;

                for (int i = 0; i < contrasena.length(); i++) {
                    if (Character.isDigit(contrasena.charAt(i))) {
                        tieneDigito = true;
                        break;
                    }
                }

                if (!tieneDigito) {
                    mensajeError = "La contrasena debe tener al menos un digito";
                } else {

                    boolean tieneMayuscula = false;

                    for (int i = 0; i < contrasena.length(); i++) {
                        if (Character.isUpperCase(contrasena.charAt(i))) {
                            tieneMayuscula = true;
                            break;
                        }
                    }

                    if (!tieneMayuscula) {
                        mensajeError = "La contrasena debe tener al menos una mayuscula";
                    }
                }
            }

            if (mensajeError.equals("")) {
                JOptionPane.showMessageDialog(null, "Contrasena aceptada");
                valida = true;
            } else {
                JOptionPane.showMessageDialog(null, mensajeError);
            }

        } while (!valida);

        // ============================================================
        // TODO 2: Obtener nombre de PC y fecha/hora
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            nombrePC = "DESCONOCIDO";
        }

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = ahora.format(formato);
        // ============================================================
        // TODO 3: Mostrar resultado final con JOptionPane.showMessageDialog
        String resultado =
            "Contrasena aceptada\n" +
            "Intentos realizados: " + intentos + "\n" +
            "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, resultado);

    }
}
