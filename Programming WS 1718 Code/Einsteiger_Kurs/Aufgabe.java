/*
 * In dieser Aufgabe geht es darum,
 * den Umgang mit Objekten etwas zu ueben.
 * Dazu sollte man zunaechst einmal Objekte
 * erstellen koennen.
 * Wenn du die Methoden dieser Klasse korrekt
 * implementiert hast, solltest du wissen, wozu man
 * das Schluesselwort new verwendet und wie man
 * Methoden von Objekten aufruft.
 */
public class Aufgabe
{
    /*
     * Diese Methode soll irgendein Objekt zurueckgeben.
     * Vollkommen egal, welche Klasse du instanziierst.
     * Objekte von Klassen macht man mit dem Schluesselwort new.
     */
    public Object getAnyObject()
    {
        return new Object();
    }

    /*
     * Nun wird es etwas spezifischer.
     * Gib ein Objekt der Klasse Klasse zurueck.
     */
    public Klasse getKlasse()
    {
        return new Klasse();
    }

    /*
     * Jetzt gib wieder ein Objekt vom Typ Klasse zurueck.
     * Diesmal soll aber die Variable zahl des Objektes den Wert haben,
     * der hier als Parameter uebergeben wird.
     */
    public Klasse getKlasse(int zahl)
    {

        return new Klasse(zahl);
    }

    /*
     * Analog zu der vorherigen Aufgabe sollst du hier wieder ein
     * Objekt vom Typ Klasse zurueckgeben.
     * Der Wert der Variablen zahl spielt hier aber keine Rolle mehr.
     * Stattdessen soll die Variable string den uebergebenen String enthalten.
     */
    public Klasse getKlasse(String string)
    {
        Klasse neueKlasse = new Klasse();
        neueKlasse.setString(string);
        return neueKlasse;
    }

    /*
     * Die main Methode.
     * Hier kannst du deine Methoden testen.
     * Natuerlich kannst du auch eigene Testfaelle schreiben.
     */
    public static void main(String[] args)
    {
        Aufgabe aufgabe = new Aufgabe();
        System.out.println("Ein Objekt: "+aufgabe.getAnyObject());//Hier sollte etwas ausgegeben werden. Egal was, aber nicht null.
        System.out.println("Ein Objekt vom Typ Klasse: "+aufgabe.getKlasse());//Hier sollte ein Objekt vom Typ Klasse ausgegeben werden.
        System.out.println("Ein Objekt vom Typ Klasse mit dem Wert zahl = 42: "+aufgabe.getKlasse(42));//Hier sollte auch ein Objekt vom Typ Klasse ausgegeben werden, diesmal aber mit zahl = 42
        System.out.println("Ein Objekt vom Typ Klasse mit dem Wert string = \"Hallo Welt!\": "+aufgabe.getKlasse("Hallo Welt!"));//Hier soll ein Objekt vom Typ Klasse ausgegeben werden, wobei string = "Hallo Welt!" ist
    }
}
