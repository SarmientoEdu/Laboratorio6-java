import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: Kadir Gonzalez
 * Fecha: 16-11-2026
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla (últimos 3 dígitos de tu cédula)
        // ============================================================
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese los ultimos 3 digitos de su cedula:")
        );
        // ============================================================
        // TODO 2: Calcular precio y código del producto con la semilla:
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // ============================================================
        // TODO 3: Determinar el porcentaje de descuento con switch:

        int descuentoPct;
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
        //   descuento_monto = precio * (descuentoPct / 100.0)
        //   precio_final    = precio - descuento_monto
        // ============================================================
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal =precio - descuentoMonto;

        // ============================================================
        // TODO 5: Obtener nombre de PC y fecha/hora
        // ============================================================
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            nombrePC = "DESCONOCIDO";
        }

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = ahora.format(formato);

        // ============================================================
        // TODO 6: Mostrar resultado con JOptionPane.showMessageDialog
          String resultado = String.format(
            java.util.Locale.US,
            "Precio original : $ %.2f%n" +
            "Descuento (%d%%) : $ %.2f%n" +
            "Precio final    : $ %.2f%n" +
            "Computadora: %s | Fecha: %s",
            precio, descuentoPct, descuentoMonto, precioFinal, nombrePC, fechaHora
        );

        JOptionPane.showMessageDialog(null, resultado);

    }
}
