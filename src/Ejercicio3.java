
import java.io.IOException;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Ejercicio3 {

    public static void main(String[] args) {

        // TODO 1: Leer la semilla
        String entrada = JOptionPane.showInputDialog(
            "Ingrese los ultimos 3 digitos de su cedula:"
        );
        int semilla = Integer.parseInt(entrada);

        // TODO 2: Calcular N y K
        int n = 5 + (semilla % 10);
        int k = 2 + (semilla % 8);

        // TODO 3: Construir la serie usando while
        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();

        int contador = 1;

        while (contador <= n) {
            int termino = contador * k;

            sumaTotal += termino;
            serie.append(termino);

            if (contador < n) {
                serie.append(", ");
            }

            contador++;
        }

        // TODO 4: Obtener computadora y fecha
        String nombrePC = "DESCONOCIDO";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (IOException e) {
            nombrePC = "DESCONOCIDO";
        }

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String fechaHora = LocalDateTime.now().format(formato);

        // TODO 5: Mostrar resultado
        String resultado =
            "Serie: " + serie + " (" + n + " terminos)\n" +
            "Suma total: " + sumaTotal + "\n" +
            "Computadora: " + nombrePC +
            " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, resultado);
    }
}
