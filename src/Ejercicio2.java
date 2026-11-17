package src;

import javax.swing.JOptionPane;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 * Autor: Isaaid Caicedo
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Ingrese los ultimos 3 digitos de su cedula:"
            )
        );

        // TODO 2: Calcular precio y codigo
        double precio = 10.0 + (semilla % 90)
                + (semilla % 11) * 0.5;

        int codigo = (semilla % 5) + 1;

        // TODO 3: Determinar descuento con switch
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

        // TODO 4: Calcular descuento y precio final
        double descuentoMonto =
                precio * (descuentoPct / 100.0);

        double precioFinal = precio - descuentoMonto;

        // TODO 5: Obtener nombre de PC y fecha
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        String fechaHora = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );

        // TODO 6: Mostrar resultado
        String resultado = String.format(
            Locale.US,
            "Precio original : $ %.2f\n" +
            "Descuento (%d%%) : $ %.2f\n" +
            "Precio final    : $ %.2f\n" +
            "Computadora: %s | Fecha: %s",
            precio,
            descuentoPct,
            descuentoMonto,
            precioFinal,
            nombrePC,
            fechaHora
        );

        JOptionPane.showMessageDialog(null, resultado);
    }
}
