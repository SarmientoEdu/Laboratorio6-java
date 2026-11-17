import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contraseña con do-while
 *
 * Autor: Santos Jesus
 * Fecha: 2026-11-17
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        // Variables de control
        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // TODO 1: ciclo do-while
        do {
            contrasena = JOptionPane.showInputDialog("Ingrese una contrasena:");
            if (contrasena == null) {
                contrasena = ""; // si cancela, se trata como vacia
            }
            intentos++;

            // Recorrer la contrasena buscando digito y mayuscula
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

            // Verificar las reglas en orden
            if (contrasena.length() < 8) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos 8 caracteres");
            } else if (!tieneDigito) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos un digito");
            } else if (!tieneMayuscula) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos una mayuscula");
            } else {
                JOptionPane.showMessageDialog(null, "Contrasena aceptada");
                valida = true;
            }
        } while (!valida);

        // TODO 2: nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // si falla, se queda "DESCONOCIDO"
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(fmt);

        // TODO 3: resultado final
        String mensaje = "Contrasena aceptada\n"
                + "Intentos realizados: " + intentos + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}