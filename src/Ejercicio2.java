import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: Norlan Gago
 * Fecha: 2026-11-16
 */
public class Ejercicio2 {

    // Semilla: propiedad del autograde, variable de entorno o dialogo
    static String leerSemilla() {
        String s = System.getProperty("autograde.semilla");
        if (s == null) s = System.getenv("AUTOGRADE_SEMILLA");
        if (s == null) {
            s = JOptionPane.showInputDialog(
                    "Ingresa los ultimos 3 digitos de tu cedula:");
        }
        return s;
    }

    // Siempre imprime en consola; muestra el dialogo solo si hay GUI
    static void mostrar(String texto) {
        System.out.println(texto);
        if (!java.awt.GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        String entrada = leerSemilla();
        if (entrada == null) {
            return; // el usuario cancelo
        }
        int semilla;
        try {
            semilla = Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            mostrar("Entrada invalida. Debes ingresar un numero.");
            return;
        }

        // TODO 2: Calcular precio y codigo del producto
        double precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5;
        int codigo = (semilla % 5) + 1;

        // TODO 3: Determinar el porcentaje de descuento con switch
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
                descuentoPct = 0;
                break;
        }

        // TODO 4: Calcular descuento_monto y precio_final
        double descuentoMonto = precio * (descuentoPct / 100.0);
        double precioFinal = precio - descuentoMonto;

        // TODO 5: Nombre de PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se mantiene "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 6: Mostrar resultado
        String mensaje = String.format(Locale.US,
                "Precio original : $ %.2f%n"
              + "Descuento (%d%%) : $ %.2f%n"
              + "Precio final    : $ %.2f%n"
              + "Computadora: %s | Fecha: %s",
                precio, descuentoPct, descuentoMonto, precioFinal,
                nombrePC, fechaHora);

        mostrar(mensaje);
    }
}