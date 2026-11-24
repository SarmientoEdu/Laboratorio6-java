import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contrasena con do-while
 *
 * Autor: Santamaria Erick
 * Fecha: 2026-11-23
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        // Variables de control
        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // TODO 1: ciclo do-while (se ejecuta al menos una vez)
        do {
            contrasena = JOptionPane.showInputDialog("Ingresa una contrasena:");
            intentos++;

            // Si el usuario cancela o cierra la ventana, el texto llega null
            if (contrasena == null) {
                contrasena = "";
            }

            // Buscar digito y mayuscula recorriendo los caracteres
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

            // Verificar las reglas en orden: se muestra el primer error
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
                valida = true;
            }
        } while (!valida);

        // TODO 2: nombre de PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 3: mensaje final con formato exacto
        String mensaje = "Contrasena aceptada\n"
                       + "Intentos realizados: " + intentos + "\n"
                       + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}