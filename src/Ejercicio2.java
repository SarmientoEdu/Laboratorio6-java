import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Laboratorio 6 - Ejercicio 2
 * Calculadora de Descuentos con switch
 *
 * Autor: [Tu nombre aquí]
 * Fecha: [Fecha]
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        // ============================================================
        // TODO 1: Leer la semilla (últimos 3 dígitos de tu cédula)
        // ============================================================
        int semilla = 0;

        // ============================================================
        // TODO 2: Calcular precio y código del producto con la semilla:
        //   precio = 10.0 + (semilla % 90) + (semilla % 11) * 0.5
        //   codigo = (semilla % 5) + 1
        // ============================================================
        double precio = 0.0;
        int codigo = 0;

        // ============================================================
        // TODO 3: Determinar el porcentaje de descuento con switch:
        //   caso 1 → Electronica  → 10%
        //   caso 2 → Ropa         → 15%
        //   caso 3 → Alimentos    → 5%
        //   caso 4 → Muebles      → 20%
        //   default               → 0%
        // ============================================================
        int descuentoPct = 0;

        // ============================================================
        // TODO 4: Calcular descuento_monto y precio_final
        //   descuento_monto = precio * (descuentoPct / 100.0)
        //   precio_final    = precio - descuento_monto
        // ============================================================
        double descuentoMonto = 0.0;
        double precioFinal = 0.0;

        // ============================================================
        // TODO 5: Obtener nombre de PC y fecha/hora
        // ============================================================
        String nombrePC = "DESCONOCIDO";
        String fechaHora = "";

        // ============================================================
        // TODO 6: Mostrar resultado con JOptionPane.showMessageDialog
        // Formato EXACTO (alinear con espacios):
        //   Precio original : $ XX.XX
        //   Descuento (XX%) : $ XX.XX
        //   Precio final    : $ XX.XX
        //   Computadora: <nombre-PC> | Fecha: YYYY-MM-DD HH:MM:SS
        // Tolerancia aceptada en dinero: ±0.01
        // ============================================================

    }
}
