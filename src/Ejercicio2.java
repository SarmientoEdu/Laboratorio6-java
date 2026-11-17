import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: Melquisedec Medina
 * Fecha: 2026-11-16
 */
public class Ejercicio2 {

    public static void main(String[] args) throws IOException {

        // TODO 1: leer la semilla (por stdin si no hay pantalla)
        boolean headless = java.awt.GraphicsEnvironment.isHeadless();

        String entrada;
        if (headless) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            entrada = br.readLine();
        } else {
            entrada = JOptionPane.showInputDialog("Ingresa los ultimos 3 digitos de tu cedula:");
        }
        int semilla = Integer.parseInt(entrada.trim());

        // TODO 2: precio y codigo del producto
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // TODO 3: porcentaje de descuento con switch
        int descuentoPct;
        switch (codigo) {
            case 1:
                descuentoPct = 10;   // Electronica
                break;
            case 2:
                descuentoPct = 15;   // Ropa
                break;
            case 3:
                descuentoPct = 5;    // Alimentos
                break;
            case 4:
                descuentoPct = 20;   // Muebles
                break;
            default:
                descuentoPct = 0;    // No aplica
                break;
        }

        // TODO 4: descuento y precio final
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // TODO 5: nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 6: mostrar el resultado
        java.util.Locale us = java.util.Locale.US;
        String mensaje = String.format(us, "Precio original : $ %.2f%n", precio)
                + String.format(us, "Descuento (%d%%) : $ %.2f%n", descuentoPct, descuentoMonto)
                + String.format(us, "Precio final    : $ %.2f%n", precioFinal)
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        if (headless) {
            System.out.println(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}