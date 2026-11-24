import javax.swing.JOptionPane;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contraseña con do-while
 *
 * Autor: Eric Fabián De León Batista
 * Fecha: 24/11/2026
 */
public class Ejercicio4 {

    // Si no hay pantalla (como pasa en el autograde de GitHub) se usa la consola
    static boolean consola = GraphicsEnvironment.isHeadless();
    static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    static String leer(String mensaje) throws IOException {
        if (consola) {
            return lector.readLine();
        }
        return JOptionPane.showInputDialog(mensaje);
    }

    static void mostrar(String texto) {
        if (consola) {
            System.out.println(texto);
        } else {
            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public static void main(String[] args) throws IOException {

        int intentos = 0;
        boolean valida = false;
        String contrasena;

        // Se repite hasta que la contrasena cumpla las 3 reglas
        // (o hasta que el usuario cancele / ya no haya mas entrada)
        do {
            contrasena = leer("Ingresa una contrasena:");

            if (contrasena != null) {
                intentos++;

                // Revisar caracter por caracter si hay un digito y una mayuscula
                boolean tieneDigito = false;
                boolean tieneMayuscula = false;
                for (int i = 0; i < contrasena.length(); i++) {
                    char c = contrasena.charAt(i);
                    if (Character.isDigit(c)) {
                        tieneDigito = true;
                    }
                    if (Character.isUpperCase(c)) {
                        tieneMayuscula = true;
                    }
                }

                // Se muestra solo el primer requisito que falle
                if (contrasena.length() < 8) {
                    mostrar("La contrasena debe tener al menos 8 caracteres");
                } else if (!tieneDigito) {
                    mostrar("La contrasena debe tener al menos un digito");
                } else if (!tieneMayuscula) {
                    mostrar("La contrasena debe tener al menos una mayuscula");
                } else {
                    valida = true;
                }
            }
        } while (!valida && contrasena != null);

        // Nombre de la computadora y fecha/hora
        String nombrePC;
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "DESCONOCIDO";
        }
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (valida) {
            String resultado = "Contrasena aceptada\n"
                    + "Intentos realizados: " + intentos + "\n"
                    + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;
            mostrar(resultado);
        } else {
            mostrar("No se ingreso una contrasena valida\n"
                    + "Computadora: " + nombrePC + " | Fecha: " + fechaHora);
        }
    }
}
