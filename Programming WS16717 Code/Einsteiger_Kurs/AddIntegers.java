// Integer-Werte addieren
//
// Modifizieren Sie die Methode "add" so, dass sie die Variablen "a" und "b" addiert und das Ergebnis zurückgibt.

public class AddIntegers {

    // ----- Modifizieren Sie diese Methode -----
    public static int add(int a, int b) {
        int result = a + b;

        return result;
    }
    // ------------------------------------------

    public static void main(String[] args) {
        // Testaufruf
        System.out.println("  0 + 1 = " + add(0, 1) + " (1 ist korrekt)");
        System.out.println("  1 + 0 = " + add(1, 0) + " (1 ist korrekt)");
        System.out.println("260 + (-5) = " + add(260, -5) + " (255 ist korrekt)");
        System.out.println("-12 + 20 = " + add(-12, 20) + " (8 ist korrekt)");
    }

}
