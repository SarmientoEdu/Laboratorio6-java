import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de multiplicar con for y manejo de excepciones
 *
 * Autor: Jorge Pitti (Jorge-Dev27)
 * Fecha: 2026-11-16
 */
public class Ejercicio5 {

    private static BufferedReader consola;

    public static void main(String[] args) {

        // TODO 1: leer la semilla (ultimos 3 digitos de la cedula)
        int semilla = leerSemilla();

        // TODO 2: calcular M y L con la semilla
        int m = 2 + (semilla % 19);   // numero de la tabla (2-20)
        int l = 5 + (semilla % 8);    // limite de la tabla (5-12)

        StringBuilder tabla = new StringBuilder();
        String nombrePC = obtenerNombrePC();
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 3: tabla de multiplicar con try / catch / finally
        try {
            if (m < 1 || m > 20) {
                throw new IllegalArgumentException(
                        "Error: numero fuera de rango [1-20]");
            }

            tabla.append("Tabla del ").append(m).append("\n");
            for (int i = 1; i <= l; i++) {
                tabla.append(m).append(" x ").append(i)
                        .append("  = ").append(m * i).append("\n");
            }
        } catch (NumberFormatException e) {
            // Se conserva por si la entrada de M deja de venir de la semilla
            tabla.append("Error: entrada no numerica");
        } catch (IllegalArgumentException e) {
            tabla.append(e.getMessage());
        } finally {
            tabla.append("Proceso finalizado");
        }

        // TODO 4: mostrar el resultado con el formato solicitado
        String mensaje = tabla.toString() + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        mostrar(mensaje, "Ejercicio 5 - Tabla de multiplicar");
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
