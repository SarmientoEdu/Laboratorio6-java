import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 1
 * Clasificador de Temperatura con if/else if/else
 *
 * Autor: Santamaria Erick // Adrian Villarreal
 * Fecha: 2026-11-23
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla (texto -> entero)
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog("Ingresa los ultimos 3 digitos de tu cedula:"));

        // TODO 2: calcular la temperatura
        int base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // TODO 3: clasificar (de menor a mayor, solo con el limite superior)
        String clasificacion;
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

        // TODO 4: nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // si falla, se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 5: mostrar el resultado
        String mensaje = "Temperatura: " + String.format(java.util.Locale.US, "%.1f", temp) + " \u00B0C\n"
                       + "Clasificacion: " + clasificacion + "\n"
                       + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}