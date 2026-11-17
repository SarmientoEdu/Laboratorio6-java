import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: Melquisedec Medina
 * Fecha: 2026-11-16
 */
public class Ejercicio1 {

    public static void main(String[] args) throws IOException {

        // TODO 1: leer la semilla (ultimos 3 digitos de la cedula)
        // Si no hay pantalla (autograde), la semilla llega por stdin.
        boolean headless = java.awt.GraphicsEnvironment.isHeadless();

        String entrada;
        if (headless) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            entrada = br.readLine();
        } else {
            entrada = JOptionPane.showInputDialog("Ingresa los ultimos 3 digitos de tu cedula:");
        }
        int semilla = Integer.parseInt(entrada.trim());

        // TODO 2: calcular la temperatura
        int base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // TODO 3: clasificar con if / else if / else
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
        } catch (Exception e) {
            // si falla, se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: mostrar el resultado
        String mensaje = String.format(java.util.Locale.US, "Temperatura: %.1f °C%n", temp)
                + "Clasificacion: " + clasificacion + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        if (headless) {
            System.out.println(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}