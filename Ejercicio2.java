import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: Santamaria Erick
 * Fecha: 2026-11-23
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // Leer la semilla (texto -> entero)
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog("Ingresa los ultimos 3 digitos de tu cedula:"));

        // Datos derivados de la semilla
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // Elegir el porcentaje de descuento con switch
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

        // Calculos
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // Nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // si falla, se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Mensaje con formato exacto
        java.util.Locale us = java.util.Locale.US;
        String mensaje = "Precio original : $ " + String.format(us, "%.2f", precio) + "\n"
                       + "Descuento (" + descuentoPct + "%) : $ " + String.format(us, "%.2f", descuentoMonto) + "\n"
                       + "Precio final    : $ " + String.format(us, "%.2f", precioFinal) + "\n"
                       + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}