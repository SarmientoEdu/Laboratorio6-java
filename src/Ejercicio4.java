import javax.swing.JOptionPane;
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

        // ============================================================
        // Variables de control
        // ============================================================
        int intentos = 0;
        boolean valida = false;
        String contrasena = "";

        // ============================================================
        // TODO 1: Implementar el ciclo DO-WHILE que:
        //   1. Pide una contraseña con JOptionPane.showInputDialog
        //   2. Incrementa el contador de intentos
        //   3. Verifica las 3 reglas en orden:
        //      a. Longitud >= 8  → si falla: "La contrasena debe tener al menos 8 caracteres"
        //      b. Contiene dígito (usa Character.isDigit en un for)
        //                        → si falla: "La contrasena debe tener al menos un digito"
        //      c. Contiene mayúscula (usa Character.isUpperCase en un for)
        //                        → si falla: "La contrasena debe tener al menos una mayuscula"
        //   4. Si cumple las 3: muestra JOptionPane con "Contrasena aceptada"
        //      y pone valida = true
        //   5. Si falla alguna: muestra el mensaje de error con JOptionPane
        //      y continúa el ciclo
        // El ciclo repite mientras !valida
        // ============================================================

        // ============================================================
        // TODO 2: Obtener nombre de PC y fecha/hora
        // ============================================================
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        // ============================================================
        // TODO 3: Mostrar resultado final con JOptionPane.showMessageDialog
        // Formato EXACTO:
        //   Contrasena aceptada
        //   Intentos realizados: X
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // ============================================================

    }
}
