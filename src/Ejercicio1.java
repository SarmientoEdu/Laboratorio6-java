import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de temperatura con if / else if / else
 *
 * Autor: Jorge Pitti (Jorge-Dev27)
 * Fecha: 2026-11-16
 */
public class Ejercicio1 {

    private static BufferedReader consola;

    public static void main(String[] args) {

        // TODO 1: leer la semilla (ultimos 3 digitos de la cedula)
        int semilla = leerSemilla();

        // TODO 2: calcular la temperatura con la formula de la semilla
        int base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // TODO 3: clasificar la temperatura con if / else if / else
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

        // TODO 4: nombre de la computadora y fecha/hora actual
        String nombrePC = obtenerNombrePC();
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: mostrar el resultado con el formato solicitado
        String mensaje = "Temperatura: " + String.format("%.1f", temp) + " \u00b0C\n"
                + "Clasificacion: " + clasificacion + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        mostrar(mensaje, "Ejercicio 1 - Clasificador de temperatura");
    }

    /**
     * Lee la semilla desde la consola (modo headless) o con JOptionPane (modo grafico).
     * La semilla tambien puede llegar por la propiedad autograde.semilla.
     */
    private static int leerSemilla() {
        String texto = leerTexto("Ingrese la semilla (ultimos 3 digitos de su cedula):");
        int semilla = 0;
        boolean valida = false;

        if (texto != null) {
            try {
                semilla = Integer.parseInt(texto.replace("\uFEFF", "").trim());
                valida = true;
            } catch (NumberFormatException e) {
                valida = false;
            }
        }

        if (!valida) {
            String propiedad = System.getProperty("autograde.semilla");
            if (propiedad != null) {
                try {
                    semilla = Integer.parseInt(propiedad.trim());
                } catch (NumberFormatException e) {
                    semilla = 0;
                }
            }
        }
        return semilla;
    }

    private static String leerTexto(String mensaje) {
        if (GraphicsEnvironment.isHeadless()) {
            try {
                return consola().readLine();
            } catch (IOException e) {
                return null;
            }
        }
        String valor = JOptionPane.showInputDialog(null, mensaje);
        return valor == null ? "" : valor.trim();
    }

    private static BufferedReader consola() {
        if (consola == null) {
            consola = new BufferedReader(new InputStreamReader(System.in));
        }
        return consola;
    }

    private static String obtenerNombrePC() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            String equipo = System.getenv("COMPUTERNAME");
            return equipo != null ? equipo : "localhost";
        }
    }

    private static void mostrar(String mensaje, String titulo) {
        // En modo headless (CI/autograde) la salida se escribe en la consola
        System.out.println(mensaje);
        if (!GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, mensaje, titulo,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
