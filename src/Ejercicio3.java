package src;

import javax.swing.JOptionPane;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 * Autor: Isaaid Caicedo
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Ingrese los ultimos 3 digitos de su cedula:"
            )
        );

        // TODO 2: Calcular N y K
        int N = 5 + (semilla % 10);
        int K = 2 + (semilla % 8);

        // TODO 3: Calcular la serie usando while
        int contador = 1;
        int suma = 0;

        String serie = "Serie: ";

        while (contador <= N) {

            int multiplo = contador * K;

            suma = suma + multiplo;

            serie = serie + multiplo;

            if (contador < N) {
                serie = serie + ", ";
            }

            contador++;
        }

        serie = serie + " (" + N + " terminos)";

        // TODO 4: Obtener nombre de PC y fecha
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        String fechaHora = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );

        // TODO 5: Mostrar el resultado
        String resultado =
                serie + "\n" +
                "Suma total: " + suma + "\n" +
                "Computadora: " + nombrePC +
                " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
