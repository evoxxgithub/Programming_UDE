public class Demoklausur_3 {/* 3a)
Klasse:        |   Methodenkopf:
Zahlenliste    |   void benenne(String name); 
Zahlenliste    |   String liesName();
Zahlenliste    |   Field: String name;
Bruch          |   boolean gleich(vergleichbar x);
Bruch          |   boolean kleiner(vergleichbar x);
dvListe        |   vergleichbar Erstes();
dvListe        |   vergleichbar Letztes();
dvListe        |   vergleichbar Naechstes();
dvListe        |   vergleichbar Vorangehendes();
Zahlenliste    |   void sortiereEin(vergleichbar neu);

//Note: Eventuell wäre noch ein Feld double groesse in der Klasse Bruch sinnvoll, wenn man die Größe von einer anderen Klasse die 
//vergleichbar implementiert mit dieser einfacher vergleichen will.

// 3b)

/* Davon ausgehend, dass sortiereEin() die Elemente nach aufsteigender Reihenfolge sortieren soll:

vergleichbar Erstes(){
Lesezeiger = Kopf;
return Lesezeiger;
}
vergleichbar Letztes(){
Lesezeiger = Fuss;
return Lesezeiger;
}
vergleichbar Naechstes(){
Lesezeiger = Lesezeiger.Nf;
return Lesezeiger;
}
vergleichbar Vorangehendes(){
Lesezeiger = Lesezeiger.Vg;
return Lesezeiger;
}
void benenne(String name){
this.name = name;
}
String liesName(){
return name;
}
boolean gleich(vergleichbar x){
if (x instanceof Bruch){
Bruch b = x;
if (erweitere(this,b) == erweitere(b, this) return true;
}
return false;
}
boolean kleiner(vergleichbar x){
if (x instanceof Bruch){
Bruch b = x;
if (erweitere(this, b.Nenner) < erweitere(b, this.Nenner) return true;
}
return false;
}
int erweitere(Bruch b, int n){
if (b.Nenner*n > 0) return b.Zaehler*n;
else return -b.Zaehler*n;
}
void sortiereEin(vergleichbar neu) {
    boolean einsortiert = false;
    if (Kopf.Info.kleiner(neu)) {
        neu.Nf = Kopf;
        Kopf.Vg = neu;
        Kopf = neu;
        einsortiert = true;
    } else {
        Element Vg = Kopf.Vg;
        for (Element temp = Kopf; !einsortiert; temp = temp.Nf) {
            if (temp == null) {
                temp = new Element();
                einsortiert = true;
                temp.Info = neu;
                temp.Nf = null;
                temp.Vg = Vg
            } else {
                if (temo.Info.kleiner(neu)) {
                    Element toAdd = new Elemnt();
                    toAdd.Info = neu;
                    toAdd.Nf = temp.Nf;
                    toAdd.Vg = temp;
                    temp.Nf = toAdd;
                    if (toAdd.Nf != null) toAdd.Nf.Vg = toAdd;
                    einsortiert = true;
                }
                Vg = temp;
            }
        }
    }

// 3c)

    Bruch b = z.Erstes().Info;
    b = z.Naechstes().Info;
    double Kehrwert = b.Nenner / b.Zaehler;

// 3d)

    In der Klasse Bruch müsste eine double-Variable groesse implementiert werden.
            Die Methoden kleiner, gleich in der Klasse Bruch müssten analog geändert werden.Oder man ändert vergleichbar
    zu einer abstrakten Klasse um die dieses Feld vererbt und ändert auch hier die Methoden.

            So könnte man die abstrakte Klasse rational_number implementieren, die vergleichbar implementiert und das
    Feld groesse besitzt.
            Bruch und Gleitkommazahl würden dann von rational_number erben. */
}