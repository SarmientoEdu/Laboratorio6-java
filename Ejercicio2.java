
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Ejercicio2 {

    public static void main(String[] args) {

    
        String entrada = JOptionPane.showInputDialog(
            "Ingresa los últimos 3 dígitos de tu cédula:"
        );
        int semilla = Integer.parseInt(entrada);

        
        double precio = 10.0 + (semilla % 90)
                      + (semilla % 11) * 0.5;

        int codigo = (semilla % 5) + 1;
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

        
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        fechaHora = LocalDateTime.now().format(formato);

        
        String mensaje = String.format(
            "Precio original : $ %.2f%n" +
            "Descuento (%d%%) : $ %.2f%n" +
            "Precio final    : $ %.2f%n" +
            "Computadora: %s | Fecha: %s",
            precio, descuentoPct, descuentoMonto,
            precioFinal, nombrePC, fechaHora
        );

        JOptionPane.showMessageDialog(null, mensaje);
    }
}
