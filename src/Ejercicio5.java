package src;

import javax.swing.JOptionPane;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Excepciones
 * Autor: Isaaid Caicedo
 */
public class Ejercicio5 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        int semilla = Integer.parseInt(
            JOptionPane.showInputDialog(
                "Ingrese los ultimos 3 digitos de su cedula:"
            )
        );

        // TODO 2: Calcular M y L
        int M = 2 + (semilla % 19);
        int L = 5 + (semilla % 8);

        String resultado = "";

        try {

            // TODO 3: Leer el numero como texto
            String entrada = JOptionPane.showInputDialog(
                "Ingrese el numero para la tabla de multiplicar:"
            );

            if (entrada == null) {
                return;
            }

            M = Integer.parseInt(entrada);

            // TODO 4: Validar el rango
            if (M < 1 || M > 20) {
                throw new IllegalArgumentException(
                    "Error: numero fuera de rango [1-20]"
                );
            }

            // TODO 5: Generar tabla con for
            resultado = "Tabla del " + M + "\n";

            for (int i = 1; i <= L; i++) {

                int multiplicacion = M * i;

                resultado += M + " x " + i +
                        "  = " + multiplicacion + "\n";
            }

        } catch (NumberFormatException e) {

            resultado = "Error: entrada no numerica\n";

        } catch (IllegalArgumentException e) {

            resultado = e.getMessage() + "\n";

        } finally {

            // TODO 6: Mensaje obligatorio
            resultado += "Proceso finalizado\n";

            String nombrePC = "DESCONOCIDO";

            try {
                nombrePC = InetAddress.getLocalHost().getHostName();
            } catch (Exception e) {
                nombrePC = "DESCONOCIDO";
            }

            String fechaHora = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );

            resultado += "Computadora: " + nombrePC +
                    " | Fecha: " + fechaHora;

            JOptionPane.showMessageDialog(null, resultado);
        }
    }
}
