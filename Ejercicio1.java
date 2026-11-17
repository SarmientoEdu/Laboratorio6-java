
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: Joel Ayarza
 * Fecha: 11-16-2026
 */
public class Ejercicio1 {

    public static void main(String[] args) {
    
        String entrada = JOptionPane.showInputDialog(
            "Ingresa los últimos 3 dígitos de tu cédula:"
        );
        int semilla = Integer.parseInt(entrada);


        int base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

       
        String clasificacion = "";

        if (temp < 0) {
            clasificacion = "Congelante";
        } else if (temp < 10) {
            clasificacion = "Frio";
        } else if (temp < 20) {
            clasificacion = "Fresco";
        } else if (temp < 30) {
            clasificacion = "Templado";
        } else if (temp < 40) {
            clasificacion = "Caluroso";
        } else {
            clasificacion = "Peligroso";
        }

        
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        fechaHora = LocalDateTime.now().format(formato);

        
        String mensaje = String.format(
            "Temperatura: %.1f °C%n" +
            "Clasificacion: %s%n" +
            "Computadora: %s | Fecha: %s",
            temp, clasificacion, nombrePC, fechaHora
        );

        JOptionPane.showMessageDialog(null, mensaje);

    }
}
