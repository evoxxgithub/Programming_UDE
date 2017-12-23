import java.util.Scanner;

public class Uebung_3 {
	
	//Aufgabe 1:
	static void aufgabe1(){
		
		//Version for-Schleife:
		
		for (int i=1; i<501; i++) {
			if (i%9==0 && i%17==0) System.out.println(i + " ist teilbar durch 9 und 17.");
		}
		System.out.println("-------------------------------"); // Abtrennung der Lösungen
		
		//Version while-Schleife
		int i = 1;
		while (i<501) {
			if(i%9==0 && i%17==0) System.out.println(i + " ist teilbar durch 9 und 17.");
			i++;
		}
	}
	
	//Aufgabe 2:
	static void aufgabe2(){
		double x = 1.0035;
		double euro = 1;
		int anzahl_jahre = 0;
		while (euro<1000000) {
			euro = euro*x;
			anzahl_jahre++;
		}
		System.out.println("Die Anzahl der Jahre bis der Euro zu einer Millinon geworden ist beträgt: " + anzahl_jahre);
	}
	
	//Aufgabe 3:
	static int fakultaet(int number) {
		if (number <= 1) return 1;
		else {
			return fakultaet((number-1))*number;
		}
	}
	
	//Aufgabe 3:
	static void aufgabe3(){
		int n = 5;
		System.out.println("Die Anzahl der möglichkeiten beträgt: " + fakultaet(n));
	}
	
	//Aufgabe 4:
	static long quersumme(long zahl){
		if (zahl<10) return zahl;
		else {
			return (zahl%10+quersumme(zahl/10)); // rekursive Lösung, funktioniert mit Zahlen innerhalb von long
		}
	}
	
	static void aufgabe4(){
		Scanner s = new Scanner(System.in);
		long zahl=1;
		while (zahl!=0) {
			System.out.println("Bitte Zahl eingeben!");
			zahl = s.nextLong();
			System.out.println("Die Quersumme von " + zahl + " ist " + quersumme(zahl));
		}
	}
	
	//Ausgabe:
	
	public static void main(String[] s) {
		
		aufgabe1();
		aufgabe2();
		aufgabe3();
		aufgabe4();
	}
}