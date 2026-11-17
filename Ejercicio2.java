import javax.swing.JOptionPane;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        // ============================================================
        // TODO 1: Leer la semilla (últimos 3 dígitos de tu cédula)
        // ============================================================
        String inputSemilla = JOptionPane.showInputDialog("Ingrese los últimos 3 dígitos de su cédula (semilla):");
        int semilla = 0;
        try {
            if (inputSemilla != null) {
                semilla = Integer.parseInt(inputSemilla.trim());
            }
        } catch (NumberFormatException e) {
            semilla = 0;
        }

        // ============================================================
        // TODO 2: Calcular precio y código del producto con la semilla:
        // ============================================================
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (int) ((semilla % 5) + 1);

        // ============================================================
        // TODO 3: Determinar el porcentaje de descuento con switch:
        // ============================================================
        int descuentoPct = 0;
        switch (codigo) {
            case 1:
                descuentoPct = 10;
                break;
            case 2:
                descuentoPct = 15;
                break;
            case 3:
                descuentoPct = 5;
                break;
            case 4:
                descuentoPct = 20;
                break;
            default:
                descuentoPct = 0;
                break;
        }

        // ============================================================
        // TODO 4: Calcular descuento_monto y precio_final
        // ============================================================
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // ============================================================
        // TODO 5: Obtener nombre de PC y fecha/hora
        // ============================================================
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "LOCAL";
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = dtf.format(LocalDateTime.now());

        // ============================================================
        // TODO 6: Mostrar resultado con JOptionPane.showMessageDialog
        // ============================================================
        String resultado = String.format(
                "Precio original : $ %.2f\nDescuento (%d%%) : $ %.2f\nPrecio final    : $ %.2f\nComputadora: %s | Fecha: %s",
                precio, descuentoPct, descuentoMonto, precioFinal, nombrePC, fechaHora);

        JOptionPane.showMessageDialog(null, resultado);
    }
}


       
