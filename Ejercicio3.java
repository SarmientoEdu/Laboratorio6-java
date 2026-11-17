import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Ejercicio3 {

    public static void main(String[] args) {

               String entrada = JOptionPane.showInputDialog(
            "Ingresa los últimos 3 dígitos de tu cédula:"
        );
        int semilla = Integer.parseInt(entrada);

        
        int N = 5 + (semilla % 10);
        int K = 2 + (semilla % 8);

        
        int contador = 1;
        int suma = 0;
        String serie = "";

        while (contador <= N) {

            int numero = contador * K;
            suma += numero;

            serie += numero;

            if (contador < N) {
                serie += ", ";
            }

            contador++;
        }

        
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }

        DateTimeFormatter formato =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        fechaHora = LocalDateTime.now().format(formato);

    
        String mensaje =
            "Serie: " + serie + " (" + N + " terminos)\n" +
            "Suma total: " + suma + "\n" +
            "Computadora: " + nombrePC +
            " | Fecha: " + fechaHora;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}
