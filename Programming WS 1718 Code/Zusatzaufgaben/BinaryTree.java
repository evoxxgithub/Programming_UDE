/*
 * In dieser Aufgabe soll der Umgang mit Binaerbaeumen und Rekursionen geuebt
 * werden. Aehnlich wie in Listen erfolgt der Zugriff auf die Baumelemente ueber
 * eine Verkettung. Im Fall des Binaerbaums hat jedes Baumelement (TreeNode)
 * maximal zwei Nachfolger vom gleichen Typ (smaller, larger). Ein Nachfolger
 * mit dem Wert null bedeutet, dass der Baum an der Stelle nicht weitergeht.
 * Der Binaerbaum dieser Aufgabe soll eine sortierte Zahlenmenge enthalten. Fuer
 * jeden Knoten im Baum soll gelten, dass seine Zahl groesser ist als die Zahlen
 * aller seiner unter smaller zu findenden Nachfolger und kleiner als alle
 * seiner unter larger zu findenden Nachfolger. Der Baum soll duplikatfrei sein,
 * d.h. keine Zahl soll in dem Baum mehrfach vorkommen.
 * 
 * Fuer alle hier zu implementierenden Methoden bietet sich die Verwendung von
 * Rekursionen an.
 * 
 * HINWEIS:
 *   Fuer die Implemetierung der Methoden kann es notwendig sein Hilfsmethoden
 *   zu verwenden. Sie duerfen fuer die Loesung dieser Aufgabe beliebige
 *   Hilfsmethoden erstellen.
 */

public class BinaryTree {
	
	BinaryTreeNode top;

	public BinaryTree(){
		top	= null;
	}
	
	
	/* 
	 * BEGINN des zu implementierenden Bereichs
	 */
	
	
	/*
	 * Mit dieser Methode soll ein neuer Knoten mit der durch den Parameter
	 * number gegebenen Zahl in den Baum eingefuegt werden. Die vorhandene
	 * Struktur des Baumes soll dabei nicht geaendert werden und die neue Zahl
	 * als Blatt (Knoten ohne Nachfolger) im Baum zu finden sein.
	 * Ist die Zahl bereits im Baum vorhanden, soll nichts geschehen.
	 * 
	 * Beispiel:
	 *                             5
	 * 							/     \
	 *                         2      17
	 *                        /      /  \
	 *                      -3      8   20
	 *                      
	 * Aufruf von Tree.insert(4)
	 * 
	 *                             5
	 * 							/     \
	 *                         2      17
	 *                        / \    /  \
	 *                      -3   4  8   20
	 */

	public static void main(String[] args) {

	}

	/** in dieser Methode müssen wir eine neue node aus der int-value erstellen und sie in den Baum einsortieren.
	 *  wir fangen bei der suche natürlich bei der spitze unseres baumes an.
	 *
	 * @param number ist hierbei die nummer der gefragten neuen Node
	 *
	 */

	public void insert(int number){
		BinaryTreeNode nodeToInsert = new BinaryTreeNode(number);
		if (top == null) top = nodeToInsert;
		else sortIntoTree(top, nodeToInsert);
	}




	/*
	 * Diese Methode soll die maximale Tiefe eines Baumes zurueckgeben. Die
	 * maximale Tiefe ist die Laenge des weitesten Weges den man von der Wurzel
	 * des Baumes zu einem Blatt zuruecklegen kann.
	 * 
	 * Beispiel:
	 *                           5
	 * 							/ \
	 *                         2   17
	 *                        /
	 *                      -3
	 * 
	 * Die maximale Tiefe wird in diesem Baum entlang des Pfades 5 -> 2 -> -3
	 * erreicht. Der Wert betraegt 3. Falls der Baum kein Element enthaelt und
	 * damit leer ist, soll die zurueckgegebene Tiefe 0 sein.
	 */

	/** mithilfe dieser Methode sortieren wir die Node in unseren Baum ein
	 *  doch wie stellen wir sicher, dass die Node an der korrekten Stelle einsortiert wird?
	 *  Wir starten an der spitze unseres baumes, von da aus müssen wir überprüfen ob unsere node einen größeren oder
	 *  einen kleineren Wert als die spitze hat. Wenn erstes der Fall ist müssen wir unsere Node auf jeden Fall links
	 *  von der spitze einfuegen, andernfalls rechts von der spitze
	 *
	 *  jetzt können wir uns folgendes überlegen: ist die seite der spitze, an der wir einsortieren wollen leer, dann
	 *  haben wir unseren punkt gefunden und können bei spitze.smaller / spitze.larger einfach unsere node einfügen.
	 *  Ist sie nicht leer können wir die linke / rechte Seite des baumes als neue spitze ansehen - unsere Node muss
	 *  ja auf jeden fall in diesem Teil des baumes sein, da die knoten ja alle nach größe sortiert sind.
	 *  Also können wir die sortIntoTree methode erneut aufrufen, nur dieses mal mit der linke / rechten seite des
	 *  baumes als neuem parameter. Dieses Spiel kann man solange fortführen, bis wir an einem knoten angekommen
	 *  sind, bei dem die einzuordnende Seite also smaller / larger leer ist. Dort fügen wir dann unsere node ein und
	 *  haben fertig einsortiert.
	 * */

	private void sortIntoTree(BinaryTreeNode spitze, BinaryTreeNode nodeToInsert) {

		if (spitze.number > nodeToInsert.number) {
			// die spitze ist hier größer, wir sortieren links/am kleineren element ein
			if (spitze.smaller == null) spitze.smaller = nodeToInsert; // wir wären hier fertig mit einsortieren
			else sortIntoTree(spitze.smaller, nodeToInsert); // wir sortieren in den linken teil des baumes ein.
		} else if (spitze.number < nodeToInsert.number) {
			// die spitze ist hier kleiner, wir sortieren rechts/am groesseren element ein
			if (spitze.larger == null) spitze.larger = nodeToInsert; //wir wären hier fertig mit einsortieren
			else sortIntoTree(spitze.larger, nodeToInsert); // wir sortieren in den rechten Teil des Baumes ein.
		}
	}

	public int maxDepth(){
		return maxDepth(top);
	}



	/*
	 * Mit dieser Methode soll die Summe ueber alle Elemente des Baumes
	 * zurueckgegeben werden. Ist der Baum leer, soll 0 zurueckgegeben werden.
	 * 
	 * Beispiel:
	 *                           5
	 * 							/ \
	 *                         2   17
	 *                        /
	 *                      -3
	 *                      
	 * Die Summe ueber diesen Baum ware 5 + 2 + (-3) + 17 = 21
	 */
	
	private int maxDepth(BinaryTreeNode top) {
		if (top == null) return 0;
		return 1+ Math.max(maxDepth(top.smaller), maxDepth(top.larger));
	}
	
	
	
	/*
	 * Mit dieser Methode soll die durch number gegebene Zahl aus dem Baum
	 * entfernt werden. Ist diese Zahl nicht im Baum vorhanden, soll nichts
	 * geschehen. Dabei ist zu beachten, dass der Baum nach dem Entfernen eines
	 * Elements wieder der oben geforderten Sortierung entspricht.
	 */
	
	public int sumOfElements(){
		if (top == null) return 0;
		else return getSumOfTree(top);
	}

	private int getSumOfTree(BinaryTreeNode node) {
		if (node == null) return 0;
		else return node.number + getSumOfTree(node.smaller) + getSumOfTree(node.larger);
	}

	/*
	 * ENDE des zu implementierenden Bereichs
	 */
	
	public void deleteNumber(int number){
		if (top == null) return;
		if (top.number != number) deleteNumberInTree(top, number);
		else deleteTop();
	}

	private void deleteTop() {
		if (top.larger != null) {
			BinaryTreeNode leftTreePart = top.smaller;
			top = top.larger;
			if(leftTreePart != null) hangOnNextFreePart(leftTreePart, top);
		} else top = top.smaller;
	}

	private void deleteNumberInTree(BinaryTreeNode node, int number) {
			if (node.number > number) {
				if (node.smaller == null) return;
				if (node.smaller.number == number) deleteSmallerOf(node);
				else deleteNumberInTree(node.smaller, number);
		} else {
				if (node.larger == null) return;
				if (node.larger.number == number) deleteLargerOf(node);
				else deleteNumberInTree(node.larger, number);
			}
	}

	private void deleteSmallerOf(BinaryTreeNode node) {
		if (node.smaller.larger != null) {
			BinaryTreeNode leftTreePart = node.smaller.smaller;
			node.smaller = node.smaller.larger;
			if (leftTreePart != null) hangOnNextFreePart(leftTreePart, node.smaller);
		} else node.smaller = node.smaller.smaller;
	}

	private void deleteLargerOf(BinaryTreeNode node) {
		if (node.larger.larger != null) {
			BinaryTreeNode leftTreePart = node.larger.smaller;
			node.larger = node.larger.larger;
			if (leftTreePart != null) hangOnNextFreePart(leftTreePart, node.larger);
		} else node.larger = node.larger.smaller;

	}

	private void hangOnNextFreePart(BinaryTreeNode leftTreePart, BinaryTreeNode rightTreePart) {
		if (rightTreePart.smaller == null) rightTreePart.smaller = leftTreePart;
		else hangOnNextFreePart(leftTreePart, rightTreePart.smaller);
	}

}
