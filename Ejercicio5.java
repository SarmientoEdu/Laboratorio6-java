import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Manejo de Excepciones
 *
 * Autor: Kadir González
 * Fecha: 16-11-2026
 */
public class Ejercicio5 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        int semilla = 802;

        // TODO 2: Calcular M y L
        int m = 2 + (semilla % 19);
        int l = 5 + (semilla % 8);

        // TODO 3: Tabla de multiplicar con excepciones
        StringBuilder tabla = new StringBuilder();
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        try {

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

            tabla.append("Error: entrada no numerica");

        } catch (IllegalArgumentException e) {

            tabla.append(e.getMessage());

        } finally {

            System.out.println("Proceso finalizado");
        }

        // Obtener nombre de PC y fecha/hora
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            nombrePC = "DESCONOCIDO";
        }

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fechaHora = ahora.format(formato);

        // TODO 4: Mostrar resultado
        String resultado =
            tabla.toString() +
            "Proceso finalizado\n" +
            "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
