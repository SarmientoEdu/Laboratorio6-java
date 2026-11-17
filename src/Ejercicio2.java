import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: Jesus Santos
 * Fecha: 2026-11-17
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla
        String texto = JOptionPane.showInputDialog("Ultimos 3 digitos de tu cedula:");
        int semilla = Integer.parseInt(texto.trim());

        // TODO 2: precio y codigo del producto
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // TODO 3: porcentaje de descuento con switch
        int descuentoPct;
        switch (codigo) {
            case 1:             // Electronica
                descuentoPct = 10;
                break;
            case 2:             // Ropa
                descuentoPct = 15;
                break;
            case 3:             // Alimentos
                descuentoPct = 5;
                break;
            case 4:             // Muebles
                descuentoPct = 20;
                break;
            default:
                descuentoPct = 0;
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
            // si falla, se queda "DESCONOCIDO"
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(fmt);

        // TODO 6: mostrar el resultado
        String mensaje =
                "Precio original : $ " + String.format(Locale.US, "%.2f", precio) + "\n"
              + "Descuento (" + descuentoPct + "%) : $ " + String.format(Locale.US, "%.2f", descuentoMonto) + "\n"
              + "Precio final    : $ " + String.format(Locale.US, "%.2f", precioFinal) + "\n"
              + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}