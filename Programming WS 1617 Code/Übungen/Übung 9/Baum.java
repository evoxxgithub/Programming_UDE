
public class Baum {
	Knoten wurzel;


	public Baum() {
		// leer;
	}

	public Baum(Knoten wurzel) {
		this.wurzel = wurzel;
	}


	public void fuegeEin(int value) {
		// füge neuen Knoten mit dem Wert value in den Baum ein

		if (wurzel == null) wurzel = new Knoten(value);
		else fuegeEin(value, wurzel);
	}

	private void fuegeEin(int value, Knoten k) {
		// rekursive Hilfsmethode: füge neuen Knoten mit dem Wert value in den Baum
		// mit der Wurzel k ein und gib die neue Wurzel zurück
		if (value <= k.wert) {
			if (k.links == null) k.links = new Knoten(value);
			else fuegeEin(value, k.links);
		} else {
			if (k.rechts == null) k.rechts = new Knoten(value);
			else fuegeEin(value, k.rechts);
		}

		// Bitte ersetzen Sie diese Zeile durch Ihre Lösung.
	}

	public void inOrder() {
		// gib den Baum in In-Order-Reihenfolge aus

		inOrder(wurzel);
		System.out.println();
	}

	private void inOrder(Knoten k) {
		// rekursive Hilfsmethode: gib den Baum mit der Wurzel k in In-Order-Reihenfolge aus
		if (k.links != null) inOrder(k.links);
		System.out.println(k.wert);
		if (k.rechts != null) inOrder(k.rechts);
		return; // Bitte ersetzen Sie diese Zeile durch Ihre Lösung.
	}
}
