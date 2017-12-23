import java.util.ArrayList;

public class Miniprojekt3 { /*
	
	public void zeigeSkigebiet(Station[] skigebiet) {
		System.out.println("*** Skigebiet ***");
		for (int i=0;i<skigebiet.length; i++) {
			System.out.println("Station " + skigebiet[i].name);
			
			if (skigebiet[i].lifte != null) {
				System.out.println("Lifte:");
				for(int j =0;j<skigebiet[i].lifte.length;j++) {
					String s = skigebiet[i].lifte[j].name;
					s += " " + skigebiet[i].lifte[j].ziel.name;
					System.out.println("< " + s);
				}
			}
			if (skigebiet[i].pisten != null) {
				System.out.println("Pisten:");
				for (int j =0;j<skigebiet[i].pisten.length;j++) {
					String s = skigebiet[i].pisten[j].name;
					s += " " + skigebiet[i].pisten[j].ziel.name;
					System.out.println("< " + s);
				}
			}
		}
	}
	
	public void zeigeRoute(RElement r) {
		// Gib zeilenweise alle Lifte und Pisten auf der Route r in der gegebenen Reihenfolge aus.
		//
		// KEINE BEWERTUNG DURCH JACK
		
		System.out.println(" **Route **");
		while (r != null) {
			if(r.lift != null) System.out.println(r.lift.name);
			else if (r.piste != null) System.out.println(r.piste.name);
			r = r.nF;
			
		}
	}
	
	public int offeneLifte(Station[] skigebiet) {
		// Zähle, wie viele derzeit offene Lifte es im Skigebiet gibt und liefere
		// diesen Wert zurück.
		int counter = 0;
		for (int station = 0; station < skigebiet.length;station++) {
			if (skigebiet[station].lifte != null) {
				for (int lift= 0; lift < skigebiet[station].lifte.length;lift++) {
				if (skigebiet[station].lifte[lift].status) counter++;
				}
			}
		}
		return counter; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
	}
	
	public int pistenMeter(Station[] skigebiet) {
		// Liefere die insgesamt vorhandenen Pistenmeter im Skigebiet (unabhängig davon, ob
		// die Pisten gesperrt oder offen sind).
		int pistenmeter = 0;
		for (int station = 0; station < skigebiet.length; station++) {
			if (skigebiet[station].pisten != null) {
				for (int piste = 0;piste < skigebiet[station].pisten.length; piste++) {
					pistenmeter += skigebiet[station].pisten[piste].laenge;
				}
			}
		}
		return pistenmeter; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
	}
	
	public int verbrauchtePunkte(RElement r) {
		// Liefere die auf der Route r verbrauchten Liftpunkte.
		int punkte = 0;
		while (r != null) {
			if (r.lift != null) punkte += r.lift.punkte;
			r = r.nF;
		}
		return punkte; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
	}
	
	public char maxFarbe(RElement r) {
		// Liefere die auf der Route r maximal vorkommende Pisten-Schwierigkeit, entsprechend
		// ihrer Farbe: b)lau = leicht, r)ot = mittel, s)chwarz = schwer.
		// Hinweis: Da 'b' im Alphabet vor 'r' kommt und 'r' vor 's', können Sie die
		// Vergleichsoperatoren <, >, = für den character-Wert "farbe" genau wie beim Vergleich
		// von Zahlen verwenden!
		char maxfarbe = 'a';
		while (r != null) {
			if (r.piste != null) {
				if (r.piste.farbe > maxfarbe) maxfarbe = r.piste.farbe;
			}
			r = r.nF;
		}
		return maxfarbe;
	}
	
	public int maxHoehe(RElement r) {
		// Liefere die maximal auf der Route r erreichte Höhe ALS DIFFERENZ VOM START DER ROUTE AUS
		// GEMESSEN.
		// Achtung: Dieser Wert hängt sowohl von den gefahrenen Pisten als auch von den benutzten
		// Liften ab!
		int hdiff = 0;
		int maxhoehe = 0;
		while (r != null) {
			if (r.lift != null) hdiff += r.lift.hdiff;
			else hdiff += r.piste.hdiff;
			if (hdiff>maxhoehe) maxhoehe = hdiff;
			r = r.nF;
		}
		return maxhoehe; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
	}
	
	public int anzahlHuetten(RElement r) {
		// Liefere die Anzahl aller auf der Route r erreichten Hütten.
		// Bitte beachten Sie:
		// *) Die Startstation kann ignoriert werden.
		// *) Wenn die Route an einer bereits zuvor erreichten Hütte erneut vorbeiführt,
		//    treten Mehrfachzählungen auf. Das ist im Kontext dieser Aufgabe ok!
		int huetten = 0;
		while (r != null) {
			if (r.lift != null) {if (r.lift.ziel.huette) huetten++; }
			else if (r.piste.ziel.huette) huetten++;
			r = r.nF;
		}
		return huetten; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
	}
	
	public boolean parallelePistenVon(Station s) {
		// Prüfe, ob es von Station s AUSGEHEND mindestens zwei Pisten mit gleichem Ziel gibt.
		ArrayList<Station> ziele = new ArrayList<Station>();
		if (s.pisten != null) {
		for (int i = 0; i < s.pisten.length; i++) {
			for (int j = 0; j < ziele.size(); j++){
				if (ziele.get(j) == s.pisten[i].ziel) return true;
			}
			ziele.add(s.pisten[i].ziel);
		}
		}
		return false; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
		
	}
	
	public boolean keinLiftAbwaertsZu(Station[] skigebiet, Station s) {
		// Liefert true, wenn kein zu Station s HINFÜHRENDER Lift abwärts geht (hdiff < 0).
		for (int i = 0;i < skigebiet.length;i++) {
			if (skigebiet[i].lifte != null) {
				for (int j = 0; j < skigebiet[i].lifte.length; j++) {
					if (skigebiet[i].lifte[j].ziel == s) {
						if(skigebiet[i].lifte[j].hdiff < 0) return false;
					}
				}
			}
		}
		return true; // Bitte durch Ihre Lösung ersetzen!
	}
	
	public boolean hatAnfaengerRoute(Station s) {
		// Liefert true, falls es von Station s ausgehend einen Lift gibt, an dessen Ziel
		// eine blaue Piste beginnt, die wiederum direkt zu s zurückführt ODER umgekehrt.
		if (s.pisten != null) {
			for (int i = 0; i < s.pisten.length; i++) {
				if (s.pisten[i].ziel.lifte != null) {
					for (int j = 0; j < s.pisten[i].ziel.lifte.length; j++) {
						if (s.pisten[i].ziel.lifte[j].ziel == s && s.pisten[i].farbe == 'b') return true;
					}
				}
			}
		}
		if (s.lifte != null ) {
			for (int i = 0; i < s.lifte.length; i++) {
				if (s.lifte[i].ziel.pisten != null) {
					for (int j = 0; j < s.lifte[i].ziel.pisten.length; j++) {
						if (s.lifte[i].ziel.pisten[j].ziel == s && s.lifte[i].ziel.pisten[j].farbe == 'b') return true;
					}
				}
			}
		}
		return false; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
	}
	public int befahrbarBis(RElement r) {
		// Liefere die Anzahl der Pistenmeter, bis zu der die Route r befahrbar (also nicht
		// gesperrt) ist.
		int meter = 0;
		while (r != null) {
			if (r.piste != null) if (r.piste.status) meter += r.piste.laenge;
			r = r.nF;
		}
		return meter; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
	}
	
	public boolean sindDisjunkt(RElement r1, RElement r2) {
		// Liefere true, falls die beiden Routen r1 und r2 disjunkt sind, d. h. kein Lift sowohl
		// in r1 und r2 vorkommt und keine Piste sowohl in r1 als auch r2 vorkommt.
		ArrayList<Lift> lifte_r1 = new ArrayList<Lift>();
		ArrayList<Piste> pisten_r1 = new ArrayList<Piste>();
		while (r1 != null) {
			if (r1.piste != null) {
				pisten_r1.add(r1.piste);
			} else lifte_r1.add(r1.lift);
			r1 = r1.nF;
		}
		
		while (r2 != null) {
			if (r2.piste != null) {
				for (int i = 0; i < pisten_r1.size(); i++) {
					if (r2.piste == pisten_r1.get(i)) return false;
				}
			} else {
				for (int i = 0; i < lifte_r1.size(); i++) {
					if (r2.lift == lifte_r1.get(i)) return false;
				}
			}
			r2 = r2.nF;
		}
		return true; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung!
	}
	
	
		
	public static void main(String[] args) {
		// alle Stationen
		Station sBrixen = new Station("Brixen", false);
		Station sChoralpe = new Station("Choralpe", true);
		Station sFilzboden = new Station("Filzboden", false);
		Station sOberberg = new Station("Oberberg", false);
		Station sZinsberg = new Station("Zinsberg", false);
		Station sSeidlalm = new Station("Seidlalm", true);
		
		// alle Pisten
		Piste pQuerverbindung = new Piste("Querverbindung", 'r', 800, -200, true, sFilzboden);
		Piste pBuckelpiste = new Piste("Buckelpiste", 's', 500, -200, false, sZinsberg);
		Piste pZinsbergAbfahrt = new Piste("Zinsberg-Abfahrt", 'b', 800, -300, false, sChoralpe);
		Piste pSeidlalmAbfahrt = new Piste("Seidlalm-Abfahrt", 'r', 3800, -400, true, sSeidlalm);
		Piste pTalabfahrtMittel = new Piste("Talabfahrt (mittel)", 'r', 4000, -600, true, sBrixen);
		Piste pTalabfahrtLeicht = new Piste("Talabfahrt (leicht)", 'b', 4200, -600, true, sBrixen);
		
		// alle Lifte
		Lift lGondelbahnAuf = new Lift("Gondelbahn (auf)", 30, 1800, 500, true, sChoralpe);
		Lift lGondelbahnAb = new Lift("Gondelbahn (ab)", 30, 1800, -500, true, sBrixen);
		Lift lOberbergLift = new Lift("Oberberg-Lift", 16, 1700, 700, true, sOberberg);
		Lift lZinsbergLift = new Lift("Zinsberg-Lift", 14, 400, 300, false, sZinsberg);
		
		// ausgehende Lifte und Pisten pro Station
		Lift[] alBrixen = new Lift[]{lGondelbahnAuf};
		Piste[] apBrixen = null;
		Lift[] alChoralpe = new Lift[]{lZinsbergLift, lGondelbahnAb};
		Piste[] apChoralpe = new Piste[]{pQuerverbindung};
		Lift[] alZinsberg = null;
		Piste[] apZinsberg = new Piste[]{pZinsbergAbfahrt};
		Lift[] alFilzboden = new Lift[]{lOberbergLift};
		Piste[] apFilzboden = null;
		Lift[] alOberberg = null;
		Piste[] apOberberg = new Piste[]{pBuckelpiste, pSeidlalmAbfahrt};
		Lift[] alSeidlalm = null;
		Piste[] apSeidlalm = new Piste[]{pTalabfahrtMittel, pTalabfahrtLeicht};
		
		// ausgehende Lifte und Pisten für alle Stationen
		Lift[][] ausgLifte = new Lift[][]{alBrixen, alChoralpe, alZinsberg, alFilzboden, alOberberg, alSeidlalm};
		Piste[][] ausgPisten = new Piste[][]{apBrixen, apChoralpe, apZinsberg, apFilzboden, apOberberg, apSeidlalm};
		
		// erstelle Skigebiet als Array aller Stationen und setze ausgehende Lifte und Pisten für jede Station
		Station[] skigebiet = new Station[]{sBrixen, sChoralpe, sZinsberg, sFilzboden, sOberberg, sSeidlalm};
		for (int is = 0; is < skigebiet.length; is++) {
			skigebiet[is].setzeAusgehendeLifte(ausgLifte[is]);
			skigebiet[is].setzeAusgehendePisten(ausgPisten[is]);

		}
		
		// erstelle Miniprojekt
		Miniprojekt3 m = new Miniprojekt3();
		
		// Beispielroute
		RElement r = new RElement(new Piste[]{pZinsbergAbfahrt},
				                  new Lift[]{lGondelbahnAuf, lZinsbergLift, lGondelbahnAb},
		                    	  new boolean[]{false, false, true, false});


		// An dieser Stelle können Sie unabhängig von JACK Ihre Methoden testen.
		// Anhand der Skizze auf dem Aufgabenblatt sowie den oben in der Klasse Miniprojekt3
		// erstellten Objekten für Lifte, Stationen und Pisten (ergänzen Sie bei Bedarf die
		// Skizze um Höhenangaben etc.) können Sie leicht von Hand ermitteln, welche Ergebnisse
		// Ihre Methoden für bestimmte Parameterwerte liefern müssten.
		// 
		m.zeigeSkigebiet(skigebiet);
		m.zeigeRoute(r);
		System.out.println("offene lifte: " + m.offeneLifte(skigebiet));
		System.out.println("anzahl hütten: " + m.anzahlHuetten(r));
		System.out.println("größte schwierigkeit: " + m.maxFarbe(r));
		System.out.println("länge der piste in metern: " + m.pistenMeter(skigebiet));
		System.out.println("verbrauchte punkte: " + m.verbrauchtePunkte(r));
		System.out.println("Höhendifferenz in metern: " + m.maxHoehe(r));
		System.out.println(" parallele pisten sind vorhanden: " + m.parallelePistenVon(sOberberg));
		System.out.println("Station hat eine Anfaengerroute: " + m.hatAnfaengerRoute(sZinsberg));
		System.out.println("routen sind disjunkt: " + m.sindDisjunkt(r, r));
		System.out.println("lift führt nie abwärts: " + m.keinLiftAbwaertsZu(skigebiet, sSeidlalm));
		System.out.println("route befahrbar bis: " + m.befahrbarBis(r));
		
		
	}
*/
}
