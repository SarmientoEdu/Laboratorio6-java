import javax.swing.JOptionPane;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Manejo de Excepciones
 *
 * Autor: Eric Fabián De León Batista
 * Fecha: 24/11/2026
 */
public class Ejercicio5 {

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

        StringBuilder tabla = new StringBuilder();

        try {
            // 1. Leer la semilla como texto y convertirla
            //    (si no es un numero, parseInt lanza NumberFormatException)
            String entrada = leer("Ingresa los ultimos 3 digitos de tu cedula:");
            if (entrada == null) {
                entrada = "";
            }
            int semilla = Integer.parseInt(entrada.trim());

            // 2. Numero de la tabla (M) y limite (L)
            int m = 2 + (semilla % 19);
            int l = 5 + (semilla % 8);

            // 3. Validar el rango de M
            if (m < 1 || m > 20) {
                throw new IllegalArgumentException("Error: numero fuera de rango [1-20]");
            }

            // 4. Armar la tabla con for
            tabla.append("Tabla del ").append(m).append("\n");
            for (int i = 1; i <= l; i++) {
                tabla.append(m).append(" x ").append(i).append("  = ").append(m * i).append("\n");
            }

        } catch (NumberFormatException e) {
            tabla.append("Error: entrada no numerica\n");
        } catch (IllegalArgumentException e) {
            tabla.append(e.getMessage()).append("\n");
        } finally {
            // Esto se ejecuta siempre, haya error o no
            tabla.append("Proceso finalizado\n");
        }

        // Nombre de la computadora y fecha/hora
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        tabla.append("Computadora: ").append(nombrePC).append(" | Fecha: ").append(fechaHora);
        mostrar(tabla.toString());
    }
}
