// Begrüßung
//
// Die Methode greeting soll eine Begrüßung abhängig vom als Parameter
// übergebenen Namen zurückgeben. Vervollständigen Sie die Methode
// greeting so, dass sie folgenden Aufrufbeispielen genügt:
//
// greeting("Anton") --> "Hallo, Anton!"
// greeting("Barbara") --> "Hallo, Barbara!"
// greeting("Christoph") --> "Hallo, Christoph!"
//
// Hinweis: Wenn Sie das Programm ausführen, können Sie einen Namen eingeben und so Ihre Implementierung testen.
import java.util.Scanner;

public class Greeting {

    // ----- diese Methode verändern -----
    public static String greeting(String name) {
        String greeting = "Hallo, " + name + "!";

        return greeting;
    }

    private static String getName() {
        System.out.print("Name: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();

        return name;
    }

    public static void main(String[] args) {
        String name = getName();
        System.out.println(greeting(name));
    }

}
