import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contrasena con do-while
 *
 * Autor: Norlan Gago
 * Fecha: 2026-11-16
 */
public class Ejercicio4 {

    static java.io.BufferedReader br =
            new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

    // Lee de consola en modo headless (autograde) o con dialogo si hay GUI
    static String leerTexto(String mensaje) {
        try {
            if (java.awt.GraphicsEnvironment.isHeadless()) return br.readLine();
            return JOptionPane.showInputDialog(mensaje);
        } catch (java.io.IOException e) {
            return null;
        }
    }

    // Siempre imprime en consola; muestra el dialogo solo si hay GUI
    static void mostrar(String texto) {
        System.out.println(texto);
        if (!java.awt.GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) {

        // Variables de control
        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // En headless la primera linea de stdin es la semilla: se descarta
        if (java.awt.GraphicsEnvironment.isHeadless()) leerTexto("");

        // Ciclo DO-WHILE
        do {
            contrasena = leerTexto("Ingresa una contrasena:");
            if (contrasena == null) {
                mostrar("Operacion cancelada por el usuario");
                return; // el usuario cancelo o no hay mas entrada
            }
            intentos++;

            // Regla a: longitud >= 8
            if (contrasena.length() < 8) {
                mostrar("La contrasena debe tener al menos 8 caracteres");
                continue;
            }

            // Regla b: contiene digito
            boolean tieneDigito = false;
            for (int i = 0; i < contrasena.length(); i++) {
                if (Character.isDigit(contrasena.charAt(i))) {
                    tieneDigito = true;
                    break;
                }
            }
            if (!tieneDigito) {
                mostrar("La contrasena debe tener al menos un digito");
                continue;
            }

            // Regla c: contiene mayuscula
            boolean tieneMayuscula = false;
            for (int i = 0; i < contrasena.length(); i++) {
                if (Character.isUpperCase(contrasena.charAt(i))) {
                    tieneMayuscula = true;
                    break;
                }
            }
            if (!tieneMayuscula) {
                mostrar("La contrasena debe tener al menos una mayuscula");
                continue;
            }

            // Cumple las 3 reglas
            valida = true;

        } while (!valida);

        // Nombre de PC y fecha/hora
        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            // se mantiene "DESCONOCIDO"
        }
        String fechaHora = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Mensaje final
        String mensaje = "Contrasena aceptada\n"
                + "Intentos realizados: " + intentos + "\n"
                + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

        mostrar(mensaje);
    }
}