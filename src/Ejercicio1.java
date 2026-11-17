import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: Norlan Gago
 * Fecha: 2026-11-16
 */
public class Ejercicio1 {

    // Semilla: propiedad del autograde, variable de entorno o dialogo
    static String leerSemilla() {
        String s = System.getProperty("autograde.semilla");
        if (s == null) s = System.getenv("AUTOGRADE_SEMILLA");
        if (s == null) {
            s = JOptionPane.showInputDialog(
                    "Ingresa los ultimos 3 digitos de tu cedula:");
        }
        return s;
    }

    // Siempre imprime en consola; muestra el dialogo solo si hay GUI
    static void mostrar(String texto) {
        System.out.println(texto);
        if (!java.awt.GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        String entrada = leerSemilla();
        if (entrada == null) {
            return; // el usuario cancelo
        }
        int semilla;
        try {
            semilla = Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            mostrar("Entrada invalida. Debes ingresar un numero.");
            return;
        }

        // TODO 2: Calcular la temperatura
        int base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // TODO 3: Clasificar la temperatura
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

        // TODO 4: Nombre de computadora y fecha/hora actual
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se mantiene "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: Mostrar resultado
        String mensaje = String.format(java.util.Locale.US,
                "Temperatura: %.1f \u00B0C%nClasificacion: %s%nComputadora: %s | Fecha: %s",
                temp, clasificacion, nombrePC, fechaHora);

        mostrar(mensaje);
    }
}