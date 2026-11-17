import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Manejo de Excepciones
 *
 * Autor: Quiroz Miguel
 * Fecha: 2026-11-16
 */
public class Ejercicio5 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla
        String entrada = JOptionPane.showInputDialog(
                "Ingresa los ultimos 3 digitos de tu cedula:");
        int semilla = Integer.parseInt(entrada.trim());

        // TODO 2: calcular M y L
        int m = 2 + (semilla % 19);
        int l = 5 + (semilla % 8);

        // TODO 3: try / catch / finally
        StringBuilder tabla = new StringBuilder();
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try {
            if (m < 1 || m > 20) {
                throw new IllegalArgumentException("Error: numero fuera de rango [1-20]");
            }

            tabla.append("Tabla del ").append(m).append("\n");
            for (int i = 1; i <= l; i++) {
                tabla.append(m).append(" x ").append(i).append("  = ")
                     .append(m * i).append("\n");
            }
        } catch (NumberFormatException e) {
            tabla.append("Error: entrada no numerica\n");
        } catch (IllegalArgumentException e) {
            tabla.append(e.getMessage()).append("\n");
        } finally {
            tabla.append("Proceso finalizado\n");
        }

        // TODO 4: mostrar con el formato exacto
        String mensaje = tabla
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}