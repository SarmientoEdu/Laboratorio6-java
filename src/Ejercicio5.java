import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Ejercicio5 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        int semilla = 0;

        // TODO 2: Calcular M y L
        int m = 0;
        int l = 0;

        StringBuilder tabla = new StringBuilder();
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        // Obtener nombre de la computadora
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (IOException e) {
            nombrePC = "DESCONOCIDO";
        }

        // Obtener fecha y hora
        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        fechaHora = LocalDateTime.now().format(formato);

        try {
            String entrada = JOptionPane.showInputDialog(
                "Ingrese los últimos 3 dígitos de su cédula:"
            );

            semilla = Integer.parseInt(entrada);

            m = 2 + (semilla % 19);
            l = 5 + (semilla % 8);

            if (m < 1 || m > 20) {
                throw new IllegalArgumentException(
                    "Error: numero fuera de rango [1-20]"
                );
            }

            tabla.append("Tabla del ").append(m).append("\n");

            for (int i = 1; i <= l; i++) {
                tabla.append(m)
                     .append(" x ")
                     .append(i)
                     .append("  = ")
                     .append(m * i)
                     .append("\n");
            }

        } catch (NumberFormatException e) {
            tabla.append("Error: entrada no numerica\n");

        } catch (IllegalArgumentException e) {
            tabla.append(e.getMessage()).append("\n");

        } finally {
            tabla.append("Proceso finalizado\n");
        }

        tabla.append("Computadora: ")
             .append(nombrePC)
             .append(" | Fecha: ")
             .append(fechaHora);

        JOptionPane.showMessageDialog(null, tabla.toString());
    }
}