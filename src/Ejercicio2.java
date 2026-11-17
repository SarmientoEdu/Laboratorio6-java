
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

public class Ejercicio2 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        String entrada = JOptionPane.showInputDialog(
            "Ingrese los ultimos 3 digitos de su cedula:"
        );
        int semilla = Integer.parseInt(entrada);

        // TODO 2: Calcular precio y codigo
        double precio = 10.0 + (semilla % 90)
                        + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // TODO 3: Determinar descuento con switch
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

        // TODO 4: Calcular descuento y precio final
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // TODO 5: Obtener computadora y fecha
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (IOException e) {
            nombrePC = "DESCONOCIDO";
        }

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String fechaHora = LocalDateTime.now().format(formato);

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
