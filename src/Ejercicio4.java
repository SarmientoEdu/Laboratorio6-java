import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de contrasena con do-while
 *
 * Autor: Jorge Pitti (Jorge-Dev27)
 * Fecha: 2026-11-16
 */
public class Ejercicio4 {

    private static BufferedReader consola;

    public static void main(String[] args) {

        // La semilla llega por la entrada estandar; se consume para no
        // mezclarla con la lectura de contrasenas.
        int semilla = leerSemilla();

        // Variables de control
        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // TODO 1: ciclo do-while de validacion
        do {
            String entrada = leerTexto("Ingrese una contrasena:");
            if (entrada == null) {
                break; // no hay mas entrada disponible
            }
            contrasena = entrada.trim();
            intentos++;

            if (contrasena.length() < 8) {
                mostrar("La contrasena debe tener al menos 8 caracteres",
                        "Ejercicio 4 - Validador");
            } else {
                boolean tieneDigito = false;
                for (int i = 0; i < contrasena.length(); i++) {
                    if (Character.isDigit(contrasena.charAt(i))) {
                        tieneDigito = true;
                        break;
                    }
                }

                boolean tieneMayuscula = false;
                for (int i = 0; i < contrasena.length(); i++) {
                    if (Character.isUpperCase(contrasena.charAt(i))) {
                        tieneMayuscula = true;
                        break;
                    }
                }

                if (!tieneDigito) {
                    mostrar("La contrasena debe tener al menos un digito",
                            "Ejercicio 4 - Validador");
                } else if (!tieneMayuscula) {
                    mostrar("La contrasena debe tener al menos una mayuscula",
                            "Ejercicio 4 - Validador");
                } else {
                    valida = true;
                }
            }
        } while (!valida);

        if (valida) {
            // TODO 2: nombre de la computadora y fecha/hora actual
            String nombrePC = obtenerNombrePC();
            String fechaHora = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // TODO 3: mensaje final con el formato solicitado
            String mensaje = "Contrasena aceptada\n"
                    + "Intentos realizados: " + intentos + "\n"
                    + "Computadora: " + nombrePC + " | Fecha: " + fechaHora;

            mostrar(mensaje, "Ejercicio 4 - Validador de contrasena");
        }
    }

    /**
     * Lee la semilla desde la consola (CI) o con JOptionPane (interfaz grafica).
     * La semilla tambien puede llegar por la propiedad autograde.semilla.
     */
    private static int leerSemilla() {
        String texto = leerTexto("Ingrese la semilla (ultimos 3 digitos de su cedula):");
        int semilla = 0;
        boolean valida = false;

        if (texto != null) {
            try {
                semilla = Integer.parseInt(texto.replace("\uFEFF", "").trim());
                valida = true;
            } catch (NumberFormatException e) {
                valida = false;
            }
        }

        if (!valida) {
            String propiedad = System.getProperty("autograde.semilla");
            if (propiedad != null) {
                try {
                    semilla = Integer.parseInt(propiedad.trim());
                } catch (NumberFormatException e) {
                    semilla = 0;
                }
            }
        }
        return semilla;
    }

    /** Devuelve null cuando la entrada estandar se acaba. */
    private static String leerTexto(String mensaje) {
        if (GraphicsEnvironment.isHeadless()) {
            try {
                return consola().readLine();
            } catch (IOException e) {
                return null;
            }
        }
        String valor = JOptionPane.showInputDialog(null, mensaje);
        return valor == null ? "" : valor.trim();
    }

    private static BufferedReader consola() {
        if (consola == null) {
            consola = new BufferedReader(new InputStreamReader(System.in));
        }
        return consola;
    }

    private static String obtenerNombrePC() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            String equipo = System.getenv("COMPUTERNAME");
            return equipo != null ? equipo : "localhost";
        }
    }

    private static void mostrar(String mensaje, String titulo) {
        // En CI/autograde la salida se escribe en la consola
        System.out.println(mensaje);
        if (!GraphicsEnvironment.isHeadless()) {
            JOptionPane.showMessageDialog(null, mensaje, titulo,
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
