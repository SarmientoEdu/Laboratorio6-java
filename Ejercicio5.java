import javax.swing.JOptionPane;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Manejo de Excepciones
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio5 {

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

        int m = 2 + (semilla % 19);
        int l = 5 + (semilla % 8);

        StringBuilder tabla = new StringBuilder();
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        try {
            if (m < 1 || m > 20) {
                throw new IllegalArgumentException("Error: numero fuera de rango [1-20]");
            }

            tabla.append("Tabla del ").append(m).append("\n");
            for (int i = 1; i <= l; i++) {
                tabla.append(m).append(" x ").append(i).append("  = ").append(m * i).append("\n");
            }

        } catch (NumberFormatException e) {
            tabla.append("Error: entrada no numerica\n");
        } catch (IllegalArgumentException e) {
            tabla.append(e.getMessage()).append("\n");
        } finally {
            tabla.append("Proceso finalizado\n");
        }

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "LOCAL";
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        fechaHora = dtf.format(LocalDateTime.now());

        tabla.append(String.format("Computadora: %s | Fecha: %s", nombrePC, fechaHora));

        JOptionPane.showMessageDialog(null, tabla.toString());
    }

    
}