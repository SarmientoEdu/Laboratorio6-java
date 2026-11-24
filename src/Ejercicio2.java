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
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: Eric Fabián De León Batista
 * Fecha: 24/11/2026
 */
public class Ejercicio2 {

    // Si no hay pantalla (como pasa en el autograde de GitHub) se usa la consola
    static boolean consola = GraphicsEnvironment.isHeadless();
    static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    static String leer(String mensaje) throws IOException {
        if (consola) {
            return lector.readLine();
        }
        return JOptionPane.showInputDialog(mensaje);
    }

    static void mostrar(String texto) {
        if (consola) {
            System.out.println(texto);
        } else {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. Leer la semilla
        int semilla = Integer.parseInt(leer("Ingresa los ultimos 3 digitos de tu cedula:").trim());

        // 2. Precio y codigo del producto
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // 3. Porcentaje de descuento segun la categoria
        int descuentoPct;
        String categoria;
        switch (codigo) {
            case 1:
                categoria = "Electronica";
                descuentoPct = 10;
                break;
            case 2:
                categoria = "Ropa";
                descuentoPct = 15;
                break;
            case 3:
                categoria = "Alimentos";
                descuentoPct = 5;
                break;
            case 4:
                categoria = "Muebles";
                descuentoPct = 20;
                break;
            default:
                categoria = "No aplica";
                descuentoPct = 0;
        }

        // 4. Monto del descuento y precio final
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // 5. Nombre de la computadora y fecha/hora
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 6. Mostrar el resultado
        String resultado = String.format(Locale.US, "Precio original : $ %.2f", precio) + "\n"
                + String.format(Locale.US, "Descuento (%d%%) : $ %.2f", descuentoPct, descuentoMonto) + "\n"
                + String.format(Locale.US, "Precio final    : $ %.2f", precioFinal) + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;
        mostrar(resultado);
    }
}
