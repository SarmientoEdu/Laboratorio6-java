import javax.swing.JOptionPane;
import java.awt.GraphicsEnvironment;
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
 * Autor: Eric Fabián De León Batista
 * Fecha: 24/11/2026
 */
public class Ejercicio3 {

    // Si no hay pantalla (como pasa en el autograde de GitHub) se usa la consola
    static boolean consola = GraphicsEnvironment.isHeadless();
    static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    static String leer(String mensaje) throws IOException {
        if (consola) {
            return lector.readLine();
        }
        return JOptionPane.showInputDialog(mensaje);
    }

    static void mostrar(String texto) {
        if (consola) {
            System.out.println(texto);
        } else {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) throws IOException {

        // 1. Leer la semilla
        int semilla = Integer.parseInt(leer("Ingresa los ultimos 3 digitos de tu cedula:").trim());

        // 2. Cantidad de terminos (N) y multiplo base (K)
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        // 3. Recorrer la serie con while: se suma cada termino y se agrega al texto
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

        // 4. Nombre de la computadora y fecha/hora
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 5. Mostrar el resultado
        String resultado = "Serie: " + serie + " (" + n + " terminos)\n"
                + "Suma total: " + sumaTotal + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;
        mostrar(resultado);
    }
}
