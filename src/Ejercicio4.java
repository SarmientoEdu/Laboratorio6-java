import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contrasena con do-while
 *
 * Autor: Quiroz Miguel
 * Fecha: 2026-11-16
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        // Variables de control
        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // TODO 1: ciclo do-while
        do {
            contrasena = JOptionPane.showInputDialog("Ingresa una contrasena:");
            if (contrasena == null) {
                contrasena = ""; // si cancela, se trata como vacia
            }
            intentos++;

            // regla a: longitud
            if (contrasena.length() < 8) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos 8 caracteres");
                continue;
            }

            // regla b: al menos un digito
            boolean tieneDigito = false;
            for (int i = 0; i < contrasena.length(); i++) {
                if (Character.isDigit(contrasena.charAt(i))) {
                    tieneDigito = true;
                }
            }
            if (!tieneDigito) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos un digito");
                continue;
            }

            // regla c: al menos una mayuscula
            boolean tieneMayuscula = false;
            for (int i = 0; i < contrasena.length(); i++) {
                if (Character.isUpperCase(contrasena.charAt(i))) {
                    tieneMayuscula = true;
                }
            }
            if (!tieneMayuscula) {
                JOptionPane.showMessageDialog(null,
                        "La contrasena debe tener al menos una mayuscula");
                continue;
            }

            // cumple las 3 reglas
            valida = true;
            JOptionPane.showMessageDialog(null, "Contrasena aceptada");

        } while (!valida);

        // TODO 2: nombre del PC y fecha/hora
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 3: resultado final con el formato exacto
        String mensaje = "Contrasena aceptada\n"
                + "Intentos realizados: " + intentos + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}