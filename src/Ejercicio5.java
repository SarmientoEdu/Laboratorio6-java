import javax.swing.JOptionPane;
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
 * Autor: Melquisedec Medina
 * Fecha: 2026-11-16
 */
public class Ejercicio5 {

    public static void main(String[] args) throws IOException {

        // TODO 1: leer el texto de entrada (semilla). Por stdin si no hay pantalla.
        boolean headless = java.awt.GraphicsEnvironment.isHeadless();

        String entrada;
        if (headless) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            entrada = br.readLine();
        } else {
            entrada = JOptionPane.showInputDialog("Ingresa los ultimos 3 digitos de tu cedula:");
        }
        if (entrada == null) {
            entrada = "";   // ventana cancelada o entrada vacia
        }

        // TODO 2 y 3: try / catch / finally
        StringBuilder tabla = new StringBuilder();
        try {
            // Si el texto no es un numero, parseInt lanza NumberFormatException
            int semilla = Integer.parseInt(entrada.trim());
            int m = 2 + (semilla % 19);
            int l = 5 + (semilla % 8);

            if (m < 1 || m > 20) {
                throw new IllegalArgumentException("Error: numero fuera de rango [1-20]");
            }

            tabla.append("Tabla del ").append(m).append("\n");
            for (int i = 1; i <= l; i++) {
                tabla.append(m).append(" x ").append(i).append("  = ").append(m * i).append("\n");
            }
        } catch (NumberFormatException e) {
            tabla.append("Error: entrada no numerica\n");
        } catch (IllegalArgumentException e) {
            tabla.append(e.getMessage()).append("\n");
        } finally {
            tabla.append("Proceso finalizado\n");
        }

        // nombre de la PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se queda "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // TODO 4: mostrar el resultado
        String mensaje = tabla + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        if (headless) {
            System.out.println(mensaje);
        } else {
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}