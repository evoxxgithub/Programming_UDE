/*
 * Diese Klasse dient nur als Referenz und darf nicht veraendert werden
 */
public class Klasse {
    private int zahl;//Eine Zahl.
    private String string;//Eine Zeichenkette.

    public Klasse()//Parameterloser Konstruktor, setzt zahl auf 0
    {
        zahl = 0;
    }

    public Klasse(int zahl)//Konstruktor mit einem Parameter, setzt zahl auf den uebergebenen Wert
    {
        this.zahl = zahl;
    }

    //---Getter und Setter Methoden---

    public int getZahl()//Der Wert von Zahl wird zurueckgegeben
    {
        return zahl;
    }

    public void setZahl(int zahl)//Der Wert von Zahl wird neu gesetzt
    {
        this.zahl = zahl;
    }

    public String getString()//Der Wert von string wird zurueckgegeben
    {
        return string;
    }

    public void setString(String string)//Der Wert von String wird neu gesetzt
    {
        this.string = string;
    }

    public String toString()//Gibt einen String zurueck, der die beiden Werte von zahl und string enthaelt.
    {
        String rueckgabe = "Objekt von Klasse mit den folgenden Werten: ";
        rueckgabe = rueckgabe + "Zahl = ";
        rueckgabe = rueckgabe + zahl;
        rueckgabe = rueckgabe + ", String = ";
        rueckgabe = rueckgabe + "\"";
        rueckgabe = rueckgabe + string;
        rueckgabe = rueckgabe + "\"";
        rueckgabe = rueckgabe + ".";
        return rueckgabe;
    }
}
