import javax.swing.JOptionPane;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: Eric Fabián De León Batista
 * Fecha: 24/11/2026
 */
public class Ejercicio1 {

    // Si no hay pantalla (como pasa en el autograde de GitHub) se usa la consola
    static boolean consola = GraphicsEnvironment.isHeadless();
    static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    // Pide un dato con JOptionPane, o lo lee de la consola si no hay pantalla
    static String leer(String mensaje) throws IOException {
        if (consola) {
            return lector.readLine();
        }
        return JOptionPane.showInputDialog(mensaje);
    }

    // Muestra el texto con JOptionPane, o lo imprime en consola si no hay pantalla
    static void mostrar(String texto) {
        if (consola) {
            System.out.println(texto);
        } else {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. Leer la semilla (ultimos 3 digitos de la cedula)
        int semilla = Integer.parseInt(leer("Ingresa los ultimos 3 digitos de tu cedula:").trim());

        // 2. Calcular la temperatura con la formula
        int base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // 3. Clasificar con if / else if / else
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

        // 4. Nombre de la computadora y fecha/hora actual
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 5. Mostrar el resultado
        String resultado = String.format(Locale.US, "Temperatura: %.1f °C", temp) + "\n"
                + "Clasificacion: " + clasificacion + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;
        mostrar(resultado);
    }
}
