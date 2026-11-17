import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla del usuario (últimos 3 dígitos de cédula)
        // Usa JOptionPane.showInputDialog para pedirla.
        // Convierte a entero con Integer.parseInt
        // ============================================================
        int semilla = 0; // reemplaza este 0

        // ============================================================
        // TODO 2: Calcular la temperatura con la fórmula de tu semilla:
        //   base = (semilla % 60) - 10
        //   temp = base + (semilla % 7) * 0.5
        // ============================================================
        double temp = 0.0; // reemplaza este 0.0

        // ============================================================
        // TODO 3: Clasificar la temperatura con if / else if / else
        //   < 0        → "Congelante"
        //   0 – 9.99   → "Frio"
        //   10 – 19.99 → "Fresco"
        //   20 – 29.99 → "Templado"
        //   30 – 39.99 → "Caluroso"
        //   >= 40      → "Peligroso"
        // ============================================================
        String clasificacion = ""; // reemplaza este ""

        // ============================================================
        // TODO 4: Obtener nombre de computadora y fecha/hora actual
        //   Nombre PC : InetAddress.getLocalHost().getHostName()
        //               (importa java.net.InetAddress, maneja la excepción)
        //   Fecha/hora: LocalDateTime.now() formateado como "yyyy-MM-dd HH:mm:ss"
        // ============================================================
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        // ============================================================
        // TODO 5: Mostrar resultado con JOptionPane.showMessageDialog
        // Formato EXACTO:
        //   Temperatura: XX.X °C
        //   Clasificacion: Caluroso
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // ============================================================

    }
}
