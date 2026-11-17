import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de serie con while
 *
 * Autor: Jorge Pitti (Jorge-Dev27)
 * Fecha: 2026-11-16
 */
public class Ejercicio3 {

    private static BufferedReader consola;

    public static void main(String[] args) {

        // TODO 1: leer la semilla (ultimos 3 digitos de la cedula)
        int semilla = leerSemilla();

        // TODO 2: calcular N y K con la semilla
        int n = 5 + (semilla % 10);    // cantidad de terminos (5-14)
        int k = 2 + (semilla % 8);     // multiplo base (2-9)

        // TODO 3: construir la serie con un ciclo while
        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();
        int i = 1;
        while (i <= n) {
            int termino = i * k;
            sumaTotal += termino;
            if (i > 1) {
                serie.append(", ");
            }
            serie.append(termino);
            i++;
        }

        // TODO 4: nombre de la computadora y fecha/hora actual
        String nombrePC = obtenerNombrePC();
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: mostrar la salida segun la guia del laboratorio
        String mensaje = "Serie: " + serie + "\n"
                + "Suma total: " + sumaTotal + "\n"
                + "Terminos (N): " + n + " | K = " + k + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        mostrar(mensaje, "Ejercicio 3 - Suma de serie");
    }

    /**
     * Lee la semilla desde la consola (CI) o con JOptionPane (interfaz grafica).
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
        // En CI/autograde la salida se escribe en la consola
        System.out.println(mensaje);
        if (!GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, mensaje, titulo,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
