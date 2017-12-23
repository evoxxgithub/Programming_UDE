public class Demoklausur_1 { /*
    // 1a)
boolean vollstaendig(){
if (Kopf != null){
for (Element temp = Kopf;temp != null; temp = temp.Nf){
if (temp.Zahl == null || temp.Zahl.length < 1) return false;
}
}
else return false;
return true;
}
// 1b)
boolean streng_monoton_steigend(){
if (!vollstaendig) return false;
int current;
for (Element temp = Kopf; temp != null; temp = temp.Nf){
for (int i = 0;i < temp.Zahl.length; i++){
if (current != null && !temp.Zahl[i]>current) return false;
current = temp.Zahl[i];
}
}
return true;
}
// c)
boolean ueberall(){
if (!vollstaendig()) return false;
for (int zahl : Kopf.Zahl){
if (isEverywhere(zahl) return true;
}
return false;
}
boolean isEverywhere(int zahl){
for (Element temp = Kopf.Nf; temp != null; temp = temp.Nf){
if (!inElement(temp, zahl) return false;
}
return true;
}
boolean inElement(Element temp, int zahl){
for (int i : temp.Zahl){
if ( i == zahl) return true;
}
return false;
}
// d)
void loesche(){
int[] values = Kopf.Zahl;
Kopf = Kopf.Nf;
int[] newvalues = new int[Kopf.Zahl.length+values.length];
for (int i = 0;i<Kopf.Zahl.length; i+){
newvalues[i] = Kopf.Zahl[i];
}
for (int i = 0;i<values.length;i++){
newvalues[Kopf.Zahl.length+i] = values[i];
}
Kopf.Zahl = newvalues;
} */
}