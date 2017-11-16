import java.util.Arrays;

public class ArrayVeraendern {

    /*
     * Diese Methode soll das uebergebene int[] array veraendern.
     * Dabei soll die uebergebene zahl an die uebergebene stelle ins Array geschrieben werden,
     * sodass nach dem Aufruf dieser Methode gilt: (array[stelle] == zahl) == true
     */
    public static void veraender(int[] array, int stelle, int zahl)
    {
        //Hier beginnt der zu bearbeitende Teil
        array[stelle] = zahl;
        //Hier endet der zu bearbeitende Teil
    }

    /*
     * Die main Methode. Hier kannst du verschiedene Testfaelle ausprobieren
     */
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};//Das Array, welches getestet wird
        veraender(test, 2, 42);//Methode wird aufgerufen
        System.out.println(Arrays.toString(test));//Sollte nun [1, 2, 42, 4, 5] ausgeben
    }
}
