import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: Santamaria Erick
 * Fecha: 2026-11-23
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog("Ingresa los ultimos 3 digitos de tu cedula:"));

        // TODO 2: calcular N y K
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        // TODO 3: ciclo while para construir la serie y sumar
        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();

        int i = 1;
        while (i <= n) {
            int termino = i * k;
            sumaTotal += termino;
            serie.append(termino);
            if (i < n) {
                serie.append(", ");
            }
            i++;
        }

        // TODO 4: nombre de PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: mostrar resultado
        String mensaje = "Serie: " + serie + " (" + n + " terminos)\n"
                       + "Suma total: " + sumaTotal + "\n"
                       + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}