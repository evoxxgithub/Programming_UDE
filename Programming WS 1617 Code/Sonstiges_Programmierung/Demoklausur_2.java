public class Demoklausur_2 { /*// 2a)
int Anzahl(int n){
return anzahlVon(Wurzel, n)
}
int anzahlVon(Knoten k, int n){
if ( k== null) return 0;
if (k.Zahl == n) return 1+ anzahlVon(k.links, n) + anzahlVon(k.rechts, n);
else return anzahlVon(k.links, n) + anzahlVon(k.rechts, n);
}
// 2b)
m(15) -------------> 4
|---m(82)----------> 3
|   |---m(39)------> 1
|   |---m(43)------> 2
|       |---m(58)--> 0
|       |---m(71)--> 1
|---m(27)----------> 0

// 2c)

Die Methode gibt die maximal ben�tigte Rekusionstiefe an, die ben�tigt wird, um ein Blatt des Baumes zu erreichen, welches direkt
aus einem vollst�ndig besetztem ast k (k.links != null && k.rechts != null) entspringt. Liefert die methode 0, bedeutet dies,
dass kein solches Blatt existiert. */
}