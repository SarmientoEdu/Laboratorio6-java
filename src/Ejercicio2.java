import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: Quiroz Miguel
 * Fecha: 2026-11-16
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla
        String entrada = JOptionPane.showInputDialog(
                "Ingresa los ultimos 3 digitos de tu cedula:");
        int semilla = Integer.parseInt(entrada.trim());

        // TODO 2: precio y codigo
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // TODO 3: porcentaje de descuento con switch
        int descuentoPct;
        switch (codigo) {
            case 1:
                descuentoPct = 10; // Electronica
                break;
            case 2:
                descuentoPct = 15; // Ropa
                break;
            case 3:
                descuentoPct = 5;  // Alimentos
                break;
            case 4:
                descuentoPct = 20; // Muebles
                break;
            default:
                descuentoPct = 0;  // No aplica
                break;
        }

        // TODO 4: montos
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // TODO 5: nombre del PC y fecha/hora
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 6: mostrar con el formato exacto
        String mensaje =
                "Precio original : $ " + String.format(Locale.US, "%.2f", precio) + "\n"
              + "Descuento (" + descuentoPct + "%) : $ " + String.format(Locale.US, "%.2f", descuentoMonto) + "\n"
              + "Precio final    : $ " + String.format(Locale.US, "%.2f", precioFinal) + "\n"
              + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}