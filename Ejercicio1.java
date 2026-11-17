import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: Gabriel Ibarra
 * Fecha: 16-11-2026
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla del usuario (últimos 3 dígitos de cédula)
        // Usa JOptionPane.showInputDialog para pedirla.
        // Convierte a entero con Integer.parseInt
        // ============================================================
        String inputSemilla = JOptionPane.showInputDialog("Ingrese los últimos 3 dígitos de su cédula:");
        int semilla = 0;
        try{ 
            if (inputSemilla != null){
                semilla = Integer.parseInt(inputSemilla.trim());
            }
        } catch (NumberFormatException e){
            semilla = 0;

        }

        // ============================================================
        // TODO 2: Calcular la temperatura con la fórmula de tu semilla:
        //   base = (semilla % 60) - 10
        //   temp = base + (semilla % 7) * 0.5
        // ============================================================
        double base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // ============================================================
        // TODO 3: Clasificar la temperatura con if / else if / else
        //   < 0        → "Congelante"
        //   0 – 9.99   → "Frio"
        //   10 – 19.99 → "Fresco"
        //   20 – 29.99 → "Templado"
        //   30 – 39.99 → "Caluroso"
        //   >= 40      → "Peligroso"
        // ============================================================
        String clasificacion = "";
        if (temp < 0) {
            clasificacion = "Congelante";
        } else if (temp < 10) { 
            clasificacion = "Frio";
        } else if (temp < 20) {
            clasificacion = "Fresco";
        } else if (temp < 30) {
            clasificacion = "Templado";
        } else if (temp < 40) {
            clasificacion = "Caluroso";
        } else {
            clasificacion = "Peligroso";
        }
        

        // ============================================================
        // TODO 4: Obtener nombre de computadora y fecha/hora actual
        //   Nombre PC : InetAddress.getLocalHost().getHostName()
        //               (importa java.net.InetAddress, maneja la excepción)
        //   Fecha/hora: LocalDateTime.now() formateado como "yyyy-MM-dd HH:mm:ss"
        // ============================================================
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "LOCAL";
            
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = LocalDateTime.now().format(formatter);

        
        // ============================================================
        // TODO 5: Mostrar resultado con JOptionPane.showMessageDialog
        // Formato EXACTO:
        //   Temperatura: XX.X °C
        //   Clasificacion: Caluroso
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // ============================================================

        String resultado = String.format("Temperatura: %.1f °C\nClasificacion: %s\nComputadora: %s | Fecha: %s",temp, clasificacion, nombrePC, fechaHora);
        JOptionPane.showMessageDialog(null, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);


    }
}
