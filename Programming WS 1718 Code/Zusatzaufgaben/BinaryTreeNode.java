
public class BinaryTreeNode {

	/** die Node Klasse beschreibt einen Knoten in einem Baum. Eine Node in einem Baum hat immer einen Eigenwert
	 * (hier number) und eine beliebige anzahl (hier zwei) an childnodes. Bei diesem Baum handelt es sich um einen
	 * binaerbaum, daher hat jede Node zwei childnodes und diese sind über ihre gräße (jeweiliger int-wert number)
	 * nach links und rechts sortiert.
	 * Bemerkung: Nodes am Ende des baumes, sog. Blätter besitzen zwar die Felder smaller, larger (also die
	 * childnodes), diese sind jedoch mit dem Wert null gefüllt. Wenn eine node also smaller == null und larger ==
	 * null hat, ist diese Node ein blatt und an der Stelle der Baum zuende.
	 */



	int			number;
	BinaryTreeNode	smaller;
	BinaryTreeNode	larger;
	
	public BinaryTreeNode(int number){
		this.number	= number;
	}

	/** gibt die aktuelle nummer der Node aus **/
	
	public int getNumber(){
		return number;
	}

	/** gibt die linke Seite (die nach der ordnung kleiner ist) aus **/
	
	public BinaryTreeNode getSmaller(){
		return smaller;
	}

	/** setter für die linke Seite **/
	
	public void setSmaller(BinaryTreeNode smaller){
		this.smaller = smaller;
	}

	/** gibt die rechte Seite (die nach der ordnung groesser ist) aus **/
	
	public BinaryTreeNode getLarger(){
		return larger;
	}

	/** setter für die rechte Seite **/
	
	public void setLarger(BinaryTreeNode larger){
		this.larger = larger;
	}
}
