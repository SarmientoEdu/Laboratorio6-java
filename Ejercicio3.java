import javax.swing.JOptionPane;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio3 {

    public static void main(String[] args) {

String inputSemilla = JOptionPane.showInputDialog("Ingrese los últimos 3 dígitos de su cédula (semilla):");
        int semilla = 0;
        try {
            if (inputSemilla != null) {
                semilla = Integer.parseInt(inputSemilla.trim());
            }
        } catch (NumberFormatException e) {
            semilla = 0;
        }

        int n = 5 + (int) (semilla % 10);
        int k = 2 + (int) (semilla % 8);

        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();
        int i = 1;

        while (i <= n) {
            int termino = i * k;
            sumaTotal += termino;
            if (i == 1) {
                serie.append(termino);
            } else {
                serie.append(", ").append(termino);
            }
            i++;
        }

        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "LOCAL";
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = dtf.format(LocalDateTime.now());

        String resultado = String.format("Serie: %s (%d terminos)\nSuma total: %d\nComputadora: %s | Fecha: %s",
                serie.toString(), n, sumaTotal, nombrePC, fechaHora);

        JOptionPane.showMessageDialog(null, resultado);
    }
}       