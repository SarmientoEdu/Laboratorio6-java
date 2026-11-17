
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Manejo de Excepciones
 *
 * Autor: Joel Ayarza
 * Fecha: 2026-11-16
 */
public class Ejercicio5 {

    public static void main(String[] args) {

    
        int semilla = 0;

        
        int m = 0;
        int l = 0;

        StringBuilder tabla = new StringBuilder();
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        try {

            String entrada = JOptionPane.showInputDialog(
                "Ingresa los últimos 3 dígitos de tu cédula:"
            );

            semilla = Integer.parseInt(entrada);

            m = 2 + (semilla % 19);
            l = 5 + (semilla % 8);

            tabla.append("Tabla del ").append(m).append("\n");

            
            if (m < 1 || m > 20) {
                throw new IllegalArgumentException(
                    "Error: numero fuera de rango [1-20]"
                );
            }

            
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

       
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        
        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        fechaHora = LocalDateTime.now().format(formato);

        
        String mensaje = tabla.toString()
            + "Computadora: " + nombrePC
            + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}
