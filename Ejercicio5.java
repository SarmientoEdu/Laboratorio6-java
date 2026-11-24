import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Manejo de Excepciones
 *
 * Autor: Santamaria Erick
 * Fecha: 2026-11-23
 */
public class Ejercicio5 {

    public static void main(String[] args) {

        // TODO 1: leer la semilla como texto (se convierte dentro del try)
        String entrada = JOptionPane.showInputDialog(
            "Ingresa los ultimos 3 digitos de tu cedula:");

        // TODO 2: M y L se calculan dentro del try
        int m = 0;
        int l = 0;

        StringBuilder tabla = new StringBuilder();
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        // TODO 3: try / catch / finally
        try {
            // Si entrada no es un numero (o es null), lanza NumberFormatException
            int semilla = Integer.parseInt(entrada.trim());

            m = 2 + (semilla % 19);
            l = 5 + (semilla % 8);

            // Validacion de rango: lanza la excepcion que luego se captura
            if (m < 1 || m > 20) {
                throw new IllegalArgumentException("Error: numero fuera de rango [1-20]");
            }

            tabla.append("Tabla del ").append(m).append("\n");
            for (int i = 1; i <= l; i++) {
                tabla.append(m).append(" x ").append(i).append("  = ")
                     .append(m * i).append("\n");
            }
        } catch (NumberFormatException e) {
            tabla.append("Error: entrada no numerica\n");
        } catch (IllegalArgumentException e) {
            tabla.append(e.getMessage()).append("\n");
        } catch (NullPointerException e) {
            // el usuario pulso Cancelar: entrada es null
            tabla.append("Error: entrada no numerica\n");
        } finally {
            tabla.append("Proceso finalizado\n");
        }

        // Nombre de PC y fecha/hora
        try {
            nombrePC = java.net.InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se queda "DESCONOCIDO"
        }
        fechaHora = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 4: mostrar resultado
        String mensaje = tabla.toString()
                       + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}