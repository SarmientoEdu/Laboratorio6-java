import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de multiplicar con for y manejo de excepciones
 *
 * Autor: Norlan Gago
 * Fecha: 2026-11-16
 */
public class Ejercicio5 {

    // Semilla: propiedad del autograde, variable de entorno o dialogo
    static String leerSemilla() {
        String s = System.getProperty("autograde.semilla");
        if (s == null) s = System.getenv("AUTOGRADE_SEMILLA");
        if (s == null) {
            s = JOptionPane.showInputDialog(
                    "Ingresa los ultimos 3 digitos de tu cedula:");
        }
        return s;
    }

    // Siempre imprime en consola; muestra el dialogo solo si hay GUI
    static void mostrar(String texto) {
        System.out.println(texto);
        if (!java.awt.GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) {

        // Semilla
        String entradaSemilla = leerSemilla();
        if (entradaSemilla == null) {
            return; // el usuario cancelo
        }
        int semilla;
        try {
            semilla = Integer.parseInt(entradaSemilla.trim());
        } catch (NumberFormatException e) {
            mostrar("Entrada invalida. Debes ingresar un numero.");
            return;
        }

        // Datos de la semilla
        int mSemilla = 2 + (semilla % 19); // 2 - 20
        int l = 5 + (semilla % 8);         // 5 - 12

        // M ya viene calculado por la semilla; se trata como texto para
        // demostrar el manejo de NumberFormatException con parseInt
        String entradaM = String.valueOf(mSemilla);

        StringBuilder salida = new StringBuilder();

        try {
            int m = Integer.parseInt(entradaM.trim()); // NumberFormatException si no es numero (o null)

            if (m < 1 || m > 20) {
                throw new IllegalArgumentException("Error: numero fuera de rango [1-20]");
            }

            salida.append("Tabla del ").append(m).append("\n");
            for (int i = 1; i <= l; i++) {
                salida.append(String.format("%d x %-2d = %d%n", m, i, m * i));
            }
        } catch (NumberFormatException e) {
            // Debe ir antes que IllegalArgumentException (es su subclase)
            salida.append("Error: entrada no numerica\n");
        } catch (IllegalArgumentException e) {
            salida.append(e.getMessage()).append("\n");
        } finally {
            salida.append("Proceso finalizado\n");
        }

        // Nombre de PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se mantiene "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        salida.append("Computadora: ").append(nombrePC)
              .append(" | Fecha: ").append(fechaHora);

        mostrar(salida.toString());
    }
}