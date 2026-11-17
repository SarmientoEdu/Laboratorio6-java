import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 5
 * Tabla de Multiplicar con for y Manejo de Excepciones
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio5 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla (últimos 3 dígitos de tu cédula)
        // ============================================================
        int semilla = 0;

        // ============================================================
        // TODO 2: Calcular M y L con la semilla:
        //   M = 2 + (semilla % 19)    → número de la tabla (2-20)
        //   L = 5 + (semilla % 8)     → límite de la tabla (5-12)
        // ============================================================
        int m = 0;
        int l = 0;

        // ============================================================
        // TODO 3: Implementar la tabla de multiplicar con:
        //   - Un bloque TRY que:
        //       1. Lanza IllegalArgumentException si M < 1 o M > 20
        //          con mensaje: "Error: numero fuera de rango [1-20]"
        //       2. Construye la tabla con un ciclo FOR de 1 hasta L
        //          Formato de cada línea: "M x i  = resultado"
        //   - Un CATCH para NumberFormatException:
        //       Muestra: "Error: entrada no numerica"
        //   - Un CATCH para IllegalArgumentException:
        //       Muestra el mensaje de la excepción
        //   - Un bloque FINALLY que siempre imprime: "Proceso finalizado"
        //
        // Nota: en este ejercicio el valor de M ya está calculado por
        // la semilla, no lo leas del JOptionPane (el autograde lo controla).
        // El try/catch se aplica para demostrar el manejo de excepciones
        // con la validación del rango.
        // ============================================================

        StringBuilder tabla = new StringBuilder();
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        // --- escribe tu try / catch / finally aquí ---


        // ============================================================
        // TODO 4: Mostrar resultado con JOptionPane.showMessageDialog
        // Formato EXACTO (salida normal):
        //   Tabla del M
        //   M x 1  = M
        //   M x 2  = 2M
        //   ...
        //   M x L  = resultado
        //   Proceso finalizado
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // ============================================================

    }
}
