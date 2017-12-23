public class Uebung_5 {

    
    //Aufgabe 1:
	static int magischeZahl(int n){
		int zahl = (n*(n*n+1))/2;
		return zahl;
	}
	//Aufgabe 2:
	static boolean istMagisch(int[][] quadrat) {
		
		boolean magisch = true;
		int magische_zahl = magischeZahl(quadrat.length);
		int diagonalsumme1=0;
		int diagonalsumme2=0;
		
		for (int zeile = 0; zeile<quadrat.length;zeile++){
        
			int summe1 = 0;
			int summe2 = 0;
            
			for (int spalte=0; spalte<quadrat[zeile].length;spalte++){
				
			summe1 +=quadrat[zeile][spalte];
			summe2 +=quadrat[spalte][zeile];
            }
            
			if ( summe1 != magische_zahl) magisch = false;
			if ( summe2 != magische_zahl) magisch = false;
			
			diagonalsumme1 += quadrat[zeile][zeile];
			diagonalsumme2 += quadrat[zeile][quadrat.length-(zeile+1)];
			
		}
		
		if (diagonalsumme1!=magische_zahl || diagonalsumme2!=magische_zahl) magisch = false;
		
		return magisch;
	}
	//Aufgabe 3:
	static int[][] erzeugeMQ(int n) {
		
		if (n%2==0) return null;
		int[][] quadrat = new int[n][n];
		int currentzeile = 1;
		int currentspalte = n/2-1;
		
		for (int i=1;i<=n*n;i++) {
			
			currentzeile -= 1;
			currentspalte += 1;
			if (currentzeile == -1) currentzeile = (n-1);
			if (currentspalte == n) currentspalte = 0;
			
			if (quadrat[currentzeile][currentspalte]==0) quadrat[currentzeile][currentspalte] = i;
			else {
				currentspalte -= 1;
				currentzeile += 2;
				if (currentzeile == n) currentzeile = 0;
				if (currentzeile == (n+1)) currentzeile = 1;
				if (currentspalte == -1) currentspalte = (n-1);
				quadrat[currentzeile][currentspalte] = i;
			}
		}
		return quadrat;
        
		}
	
	static void ausgabe(int[][] quadrat){
    
		int n = quadrat.length;
        
		for ( int i = 0;i<n;i++){
        
			for (int j = 0;j<n;j++){
            
				System.out.print(String.format("%3d", quadrat[i][j]));
			}
            
			System.out.println();
		}
	}
	
	
	
	
	// MAIN-Methode:
	
	public static void main(String[] args) {
    
        //Tests:
		System.out.println(magischeZahl(3));
		int[][] quadrat = { {8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 }};
		System.out.println(istMagisch(quadrat));
		ausgabe(erzeugeMQ(3));
				
	}
}