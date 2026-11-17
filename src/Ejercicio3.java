import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: Norlan Gago
 * Fecha: 2026-11-16
 */
public class Ejercicio3 {

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

        // TODO 1: Leer la semilla
        String entrada = leerSemilla();
        if (entrada == null) {
            return; // el usuario cancelo
        }
        int semilla;
        try {
            semilla = Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            mostrar("Entrada invalida. Debes ingresar un numero.");
            return;
        }

        // TODO 2: Calcular N y K
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        // TODO 3: Construir la serie con un ciclo while
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

        // TODO 4: Nombre de PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se mantiene "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: Mostrar resultado
        String mensaje = "Serie: " + serie + " (" + n + " terminos)\n"
                + "Suma total: " + sumaTotal + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        mostrar(mensaje);
    }
}