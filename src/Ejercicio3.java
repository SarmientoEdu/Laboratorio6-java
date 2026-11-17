import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: Quiroz Miguel
 * Fecha: 2026-11-16
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla
        String entrada = JOptionPane.showInputDialog(
                "Ingresa los ultimos 3 digitos de tu cedula:");
        int semilla = Integer.parseInt(entrada.trim());

        // TODO 2: calcular N y K
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        // TODO 3: ciclo while para construir la serie y la suma
        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();
        int i = 1;
        while (i <= n) {
            int termino = i * k;
            sumaTotal += termino;
            if (i > 1) {
                serie.append(", ");
            }
            serie.append(termino);
            i++;
        }

        // TODO 4: nombre del PC y fecha/hora
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: mostrar el resultado con el formato exacto
        String mensaje = "Serie: " + serie + " (" + n + " terminos)\n"
                + "Suma total: " + sumaTotal + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}