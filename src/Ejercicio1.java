
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;
import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        String entrada = JOptionPane.showInputDialog(
            "Ingrese los ultimos 3 digitos de su cedula:"
        );

        int semilla = Integer.parseInt(entrada);

        // TODO 2: Calcular temperatura
        int base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // TODO 3: Clasificar temperatura
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

        // TODO 4: Obtener computadora y fecha
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (IOException e) {
            nombrePC = "DESCONOCIDO";
        }

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String fechaHora = LocalDateTime.now().format(formato);

        // TODO 5: Mostrar resultado
        String resultado = String.format(
            java.util.Locale.US,
            "Temperatura: %.1f °C\n" +
            "Clasificacion: %s\n" +
            "Computadora: %s | Fecha: %s",
            temp,
            clasificacion,
            nombrePC,
            fechaHora
        );

        JOptionPane.showMessageDialog(null, resultado);
    }
}
