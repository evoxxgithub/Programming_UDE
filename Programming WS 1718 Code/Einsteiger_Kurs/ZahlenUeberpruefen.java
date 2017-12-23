public class ZahlenUeberpruefen {

    /*
     * Diese Methode soll ueberpruefen, ob die uebergebene Zahl gerade ist.
     * Eine Zahl ist genau dann gerade, wenn sie ganzzahlig ohne Rest durch 2
     * teilbar ist. Den Rest einer Division kann man mit dem Zeichen % (Modulo)
     * herausfinden.
     * Beispiele dazu:
     * 5%3 = 2, 8%2 = 0, 9%2 = 1, 42%8 = 2.
     * Sollte dieser Rest bei der Division mit 2 gleich 0 sein, ist die Zahl gerade.
     */
    public static boolean checkEven(int zahl)
    {
        return zahl % 2 == 0;//Dieses Return Statement ist zu bearbeiten.
    }

    /*
     * Diese Methode soll ueberpruefen, ob die uebergebene Zahl ungerade ist.
     * Eine Zahl ist genau dann ungerade, wenn man sie nicht ganzzahlig durch 2 teilen kann,
     * der Rest also bei dieser Division gleich 1 ist.
     * Ausserdem ist eine Zahl ungerade, wenn sie nicht gerade ist.
     */
    public static boolean checkOdd(int zahl)
    {
        return zahl % 2 != 0;//Dieses Return Statement ist zu bearbeiten.
    }

    //In der Main Methode werden verschiedene Testfaelle getestet. Du kannst dir aber auch eigene ausdenken und testen
    public static void main(String[] args) {
        System.out.println(checkEven(42));//Sollte true zurueckgeben
        System.out.println(checkEven(27));//Sollte false zurueckgeben
        System.out.println(checkEven(28));//Sollte true zurueckgeben
        System.out.println(checkOdd(42));//Sollte false zurueckgeben
        System.out.println(checkOdd(27));//Sollte true zurueckgeben
        System.out.println(checkOdd(28));//Sollte false zurueckgeben
    }
}
