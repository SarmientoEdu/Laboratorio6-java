import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: Kadir Gonzalez
 * Fecha: 16-11-2026
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla (últimos 3 dígitos de tu cédula)
        // ============================================================
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog("Ingrese los ultimos 3 digitos de su cedula:")
        );

        // ============================================================
        // TODO 2: Calcular N y K con la semilla:
        //   N = 5 + (semilla % 10)    → cantidad de términos (5-14)
        //   K = 2 + (semilla % 8)     → múltiplo base (2-9)
        // ============================================================
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        // ============================================================
        // TODO 3: Construir la serie usando un ciclo WHILE
        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();
        int contador = 1;

        while (contador <= n) {
            int termino = contador * k;

            sumaTotal += termino;

            if (contador > 1) {
                serie.append(", ");
            }

            serie.append(termino);

            contador++;
        }

        // ============================================================
        // TODO 4: Obtener nombre de PC y fecha/hora
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
        // TODO 5: Mostrar resultado con JOptionPane.showMessageDialog
         String resultado =
            "Serie: " + serie + " (" + n + " terminos)\n" +
            "Suma total: " + sumaTotal + "\n" +
            "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, resultado);

    }
}
