import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: Melquisedec Medina
 * Fecha: 2026-11-16
 */
public class Ejercicio3 {

    public static void main(String[] args) throws IOException {

        // TODO 1: leer la semilla (por stdin si no hay pantalla)
        boolean headless = java.awt.GraphicsEnvironment.isHeadless();

        String entrada;
        if (headless) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            entrada = br.readLine();
        } else {
            entrada = JOptionPane.showInputDialog("Ingresa los ultimos 3 digitos de tu cedula:");
        }
        int semilla = Integer.parseInt(entrada.trim());

        // TODO 2: N (cantidad de terminos) y K (multiplo base)
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        // TODO 3: construir la serie con un ciclo WHILE
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

        // TODO 4: nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: mostrar el resultado
        String mensaje = "Serie: " + serie + " (" + n + " terminos)\n"
                + "Suma total: " + sumaTotal + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        if (headless) {
            System.out.println(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}