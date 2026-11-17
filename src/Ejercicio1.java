package src;

import javax.swing.JOptionPane;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ejercicio1 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Ingrese los ultimos 3 digitos de su cedula:"
            )
        );

        // TODO 2: Calcular la temperatura
        int base = (semilla % 60) - 10;
        double temp = base + (semilla % 7) * 0.5;

        // TODO 3: Clasificar la temperatura
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

        // TODO 4: Nombre de PC y fecha
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        String fechaHora = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );

        // TODO 5: Mostrar el resultado
        String resultado = String.format(
            java.util.Locale.US,
            "Temperatura: %.1f °C\n" +
            "Clasificacion: %s\n" +
            "Computadora: %s | Fecha: %s",
            temp, clasificacion, nombrePC, fechaHora
        );

        JOptionPane.showMessageDialog(null, resultado);
    }
}
