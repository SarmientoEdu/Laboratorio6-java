import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: Jesus Santos 
 * Fecha: 2026-11-17
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla
        String texto = JOptionPane.showInputDialog("Ultimos 3 digitos de tu cedula:");
        int semilla = Integer.parseInt(texto.trim());

        // TODO 2: calcular N y K
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        // TODO 3: construir la serie con while
        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();

        int i = 1;
        while (i <= n) {
            int termino = k * i;
            sumaTotal += termino;
            serie.append(termino);
            if (i < n) {
                serie.append(", ");
            }
            i++;
        }

        // TODO 4: nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // si falla, se queda "DESCONOCIDO"
        }
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(fmt);

        // TODO 5: mostrar el resultado
        String mensaje = "Serie: " + serie + " (" + n + " terminos)\n"
                + "Suma total: " + sumaTotal + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}