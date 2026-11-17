import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: Santos Jesus 
 * Fecha: 2026-11-17
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla
        String texto = JOptionPane.showInputDialog("Ultimos 3 digitos de tu cedula:");
        int semilla = Integer.parseInt(texto.trim());

        // TODO 2: calcular la temperatura
        double base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // TODO 3: clasificar
        String clasificacion;
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

        // TODO 4: nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            // si falla, se queda "DESCONOCIDO"
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(fmt);

        // TODO 5: mostrar el resultado
        String mensaje = "Temperatura: " + String.format(Locale.US, "%.1f", temp) + " \u00B0C\n"
                + "Clasificacion: " + clasificacion + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}