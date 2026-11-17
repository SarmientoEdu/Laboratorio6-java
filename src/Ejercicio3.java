import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 3
 * Suma de Serie con while
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla (últimos 3 dígitos de tu cédula)
        // ============================================================
        int semilla = 0;

        // ============================================================
        // TODO 2: Calcular N y K con la semilla:
        //   N = 5 + (semilla % 10)    → cantidad de términos (5-14)
        //   K = 2 + (semilla % 8)     → múltiplo base (2-9)
        // ============================================================
        int n = 0;
        int k = 0;

        // ============================================================
        // TODO 3: Construir la serie usando un ciclo WHILE
        //   - Acumula la suma total
        //   - Construye un String con los términos separados por coma
        //     Ejemplo: "3, 6, 9, 12, 15"
        // ============================================================
        int sumaTotal = 0;
        StringBuilder serie = new StringBuilder();
        // --- escribe el ciclo while aquí ---

        // ============================================================
        // TODO 4: Obtener nombre de PC y fecha/hora
        // ============================================================
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        // ============================================================
        // TODO 5: Mostrar resultado con JOptionPane.showMessageDialog
        // Formato EXACTO:
        //   Serie: K, 2K, 3K, ... (N terminos)
        //   Suma total: XXXX
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // ============================================================

    }
}
