import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: Kadir Gonzáelz
 * Fecha: 16-11-2026
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla del usuario (últimos 3 dígitos de cédula)
        // Usa JOptionPane.showInputDialog para pedirla.
        // Convierte a entero con Integer.parseInt
        // ============================================================
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese los ultimos 3 digitos de su cedula:")

        );

        // ============================================================
        // TODO 2: Calcular la temperatura con la fórmula de tu semilla:
        int base = (semilla % 60) - 10;

         double temp = base + (semilla % 7) * 0.5;

        // ============================================================
        // TODO 3: Clasificar la temperatura con if / else if / else
        //   < 0        → "Congelante"
        //   0 – 9.99   → "Frio"
        //   10 – 19.99 → "Fresco"
        //   20 – 29.99 → "Templado"
        //   30 – 39.99 → "Caluroso"
        //   >= 40      → "Peligroso"
        // ============================================================
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

        // ============================================================
        // TODO 4: Obtener nombre de computadora y fecha/hora actual
       String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            nombrePC = "DESCONOCIDO";
        }

        LocalDateTime ahora = LocalDateTime.now();

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String fechaHora = ahora.format(formato);

        // ============================================================
        // TODO 5: Mostrar resultado con JOptionPane.showMessageDialog
        String resultado = String.format(
            java.util.Locale.US,
            "Temperatura: %.1f °C%n" +
            "Clasificacion: %s%n" +
            "Computadora: %s | Fecha: %s",
            temp, clasificacion, nombrePC, fechaHora
        );

        JOptionPane.showMessageDialog(null, resultado);

    }
}
