import javax.swing.JOptionPane;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 4
 * Validador de Contraseña con do-while
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        
    int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        do {
            contrasena = JOptionPane.showInputDialog("Ingrese una contraseña:");
            if (contrasena == null) {
                contrasena = "";
            }
            intentos++;

            if (contrasena.length() < 8) {
                JOptionPane.showMessageDialog(null, "La contrasena debe tener al menos 8 caracteres");
                continue;
            }

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

            if (!tieneDigito) {
                JOptionPane.showMessageDialog(null, "La contrasena debe tener al menos un digito");
                continue;
            }

            if (!tieneMayuscula) {
                JOptionPane.showMessageDialog(null, "La contrasena debe tener al menos una mayuscula");
                continue;
            }

            valida = true;

        } while (!valida);

        String nombrePC = "DESCONOCIDO";
        try {
            nombrePC = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            nombrePC = "LOCAL";
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora = dtf.format(LocalDateTime.now());

        String resultado = String.format("Contrasena aceptada\nIntentos realizados: %d\nComputadora: %s | Fecha: %s",
                intentos, nombrePC, fechaHora);

        JOptionPane.showMessageDialog(null, resultado);
    }
}

