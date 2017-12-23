
public class Aufgabe_9_1 {

	
	public static void main(String...strings){
		Baum b = new Baum();
		
		
		int value[] = {15,10,7,20,17,21,5};
		
		for(int i=0; i <= value.length-1; i++){
			b.fuegeEin(value[i]);
		}
		
		b.inOrder();
	}
}
