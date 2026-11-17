import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contrasena con do-while
 *
 * Autor: Melquisedec Medina
 * Fecha: 2026-11-16
 */
public class Ejercicio4 {

    // Muestra un mensaje en ventana, o en consola si no hay pantalla (autograde)
    static void mostrar(boolean headless, String texto) {
        if (headless) {
            System.out.println(texto);
        } else {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) throws IOException {

        boolean headless = java.awt.GraphicsEnvironment.isHeadless();
        BufferedReader br = null;
        if (headless) {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // TODO 1: ciclo DO-WHILE hasta que la contrasena cumpla las 3 reglas
        do {
            if (headless) {
                contrasena = br.readLine();
            } else {
                contrasena = JOptionPane.showInputDialog("Ingresa una contrasena:");
            }
            if (contrasena == null) {
                return; // se cerro la entrada o se cancelo la ventana
            }
            intentos++;

            // Revisar los caracteres con un for
            boolean tieneDigito = false;
            boolean tieneMayuscula = false;
            for (int i = 0; i < contrasena.length(); i++) {
                char c = contrasena.charAt(i);
                if (Character.isDigit(c)) {
                    tieneDigito = true;
                }
                if (Character.isUpperCase(c)) {
                    tieneMayuscula = true;
                }
            }

            // Reglas en orden: se muestra el primer error que falle
            if (contrasena.length() < 8) {
                mostrar(headless, "La contrasena debe tener al menos 8 caracteres");
            } else if (!tieneDigito) {
                mostrar(headless, "La contrasena debe tener al menos un digito");
            } else if (!tieneMayuscula) {
                mostrar(headless, "La contrasena debe tener al menos una mayuscula");
            } else {
                valida = true;
            }
        } while (!valida);

        // TODO 2: nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 3: resultado final
        String mensaje = "Contrasena aceptada\n"
                + "Intentos realizados: " + intentos + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;
        mostrar(headless, mensaje);
    }
}