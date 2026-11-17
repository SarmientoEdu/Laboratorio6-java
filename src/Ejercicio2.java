import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de descuentos con switch
 *
 * Autor: Jorge Pitti (Jorge-Dev27)
 * Fecha: 2026-11-16
 */
public class Ejercicio2 {

    private static BufferedReader consola;

    public static void main(String[] args) {

        // TODO 1: leer la semilla (ultimos 3 digitos de la cedula)
        int semilla = leerSemilla();

        // TODO 2: calcular precio y codigo del producto con la semilla
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // TODO 3: determinar el porcentaje de descuento con switch
        int descuentoPct;
        switch (codigo) {
            case 1:
                // Electronica
                descuentoPct = 10;
                break;
            case 2:
                // Ropa
                descuentoPct = 15;
                break;
            case 3:
                // Alimentos
                descuentoPct = 5;
                break;
            case 4:
                // Muebles
                descuentoPct = 20;
                break;
            default:
                descuentoPct = 0;
                break;
        }

        // TODO 4: calcular el monto del descuento y el precio final
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // TODO 5: nombre de la computadora y fecha/hora actual
        String nombrePC = obtenerNombrePC();
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 6: mostrar el resultado con el formato solicitado
        String mensaje = "Precio original : $ " + dinero(precio) + "\n"
                + "Descuento (" + descuentoPct + "%) : $ " + dinero(descuentoMonto) + "\n"
                + "Precio final    : $ " + dinero(precioFinal) + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        mostrar(mensaje, "Ejercicio 2 - Calculadora de descuentos");
    }

    /** Formatea un monto con dos decimales y punto decimal. */
    private static String dinero(double valor) {
        return String.format(Locale.US, "%.2f", valor);
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
