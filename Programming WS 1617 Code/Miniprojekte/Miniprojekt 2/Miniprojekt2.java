import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Miniprojekt2 {

	/*
	 * Wichtig: Die Methodensignatur darf nicht veraendert werden.
	 */
	public Miniprojekt2() {

	}

	// Aufgabe 1
	public int sollTeile(int Stunde) {

		if (Stunde > 4 && Stunde < 12)
			return 150;
		else if (Stunde > 4 && Stunde < 21)
			return 200;
		else
			return 120;
	}

	// Aufgabe 2
	public double[] mittlereStdProduktionSchicht(int[][] stundenproduktion, int tag) {
		// Bitte ergaenzen!
		double[] ergebnis = { 0, 0, 0 };
		int h = 5;
		for (int count = 0; count < 24; count++) {
			if (h == 24) {
				h = 0;
				tag += 1;
			}
			if (h > 4 && h < 12)
				ergebnis[0] += stundenproduktion[tag][h];
			else if (h > 4 && h < 21)
				ergebnis[1] += stundenproduktion[tag][h];
			else
				ergebnis[2] += stundenproduktion[tag][h];
			h++;
		}
		ergebnis[0] /= 7;
		ergebnis[1] /= 9;
		ergebnis[2] /= 8;
		return ergebnis;
	}

	// Aufgabe 3
	public int[] tagesproduktion(int[][] stundenproduktion) {
		int[] tagesproduktion = new int[10];
		for (int tag = 0; tag < 10; tag++) {
			for (int h = 0; h < 24; h++) {
				tagesproduktion[tag] += stundenproduktion[tag][h];
			}
		}

		return tagesproduktion;

	}

	// Aufgabe 4
	public int[] istSollVergleich(int[][] stundenproduktion) {
		// Bitte ergaenzen!
		int[] vergleich = { -3810, -3810, -3810, -3810, -3810, -3810, -3810, -3810, -3810, -3810 };
		for (int tag = 0; tag < 10; tag++) {
			for (int h = 0; h < 24; h++) {
				vergleich[tag] += stundenproduktion[tag][h];
			}
		}

		return vergleich;
	}

	// Aufgabe 5
	public int minMittlereStdProd(int[][] stundenproduktion, int tag) {
		// Bitte ergaenzen!
		double[] a = mittlereStdProduktionSchicht(stundenproduktion, tag);
		if (a[2] < a[1] && a[2] < a[0])
			return 2;
		else if (a[1] < a[0])
			return 1;
		else
			return 0;
	}

	// Aufgabe 6
	public int maxMittlereStdProd(int[][] stundenproduktion, int tag) {

		double[] a = mittlereStdProduktionSchicht(stundenproduktion, tag);
		if (a[0] > a[1] && a[0] > a[2])
			return 0;
		else if (a[1] > a[2])
			return 1;
		else
			return 2;
	}

	// Aufgabe 7
	public int[] minSchichtProd(int[][] stundenproduktion) {
		int[] minschicht = new int[3];
		minschicht[2] = 2349912;
		int j = 5;
		for (int i = 1; i < 9; i++) {
			int frueschicht = 0;
			int mittschicht = 0;
			int nachtschicht = 0;

			for (int counter = 0; counter < 24; counter++) {
				j++;
				if (j == 24)
					j = 0;
				if (j > 4 && j < 12)
					frueschicht += stundenproduktion[i][j];
				else if (j > 11 && j < 21)
					mittschicht += stundenproduktion[i][j];
				else
					nachtschicht += stundenproduktion[i][j];
			}

			if (frueschicht < minschicht[2]) {
				minschicht[2] = frueschicht;
				minschicht[0] = i;
				minschicht[1] = 0;
			}
			if (mittschicht < minschicht[2]) {
				minschicht[2] = mittschicht;
				minschicht[0] = i;
				minschicht[1] = 1;
			}
			if (i != 8) {
				if (nachtschicht < minschicht[2]) {
					minschicht[2] = nachtschicht;
					minschicht[0] = i;
					minschicht[1] = 2;
				}
			}

		}
		return minschicht;
	}

	// Aufgabe 8
	public int[] maxSchichtProd(int[][] stundenproduktion) {

		int[] minschicht = new int[3];
		minschicht[2] = 0;
		int j = 5;
		for (int i = 1; i < 9; i++) {
			int frueschicht = 0;
			int mittschicht = 0;
			int nachtschicht = 0;

			for (int counter = 0; counter < 24; counter++) {
				j++;
				if (j == 24)
					j = 0;
				if (j > 4 && j < 12)
					frueschicht += stundenproduktion[i][j];
				else if (j > 11 && j < 21)
					mittschicht += stundenproduktion[i][j];
				else
					nachtschicht += stundenproduktion[i][j];
			}

			if (frueschicht > minschicht[2]) {
				minschicht[2] = frueschicht;
				minschicht[0] = i;
				minschicht[1] = 0;
			}
			if (mittschicht > minschicht[2]) {
				minschicht[2] = mittschicht;
				minschicht[0] = i;
				minschicht[1] = 1;
			}
			if (i != 8) {
				if (nachtschicht > minschicht[2]) {
					minschicht[2] = nachtschicht;
					minschicht[0] = i;
					minschicht[1] = 2;
				}
			}

		}
		return minschicht;
	}
	// Aufgabe 9

	public int[] differentStdProd(int[][] stundenproduktion, int tag) {
		int laenge = 0;
		List<Integer> list = new ArrayList<Integer>();

		for (int h = 0; h < 24; h++) {
			if (!list.contains(stundenproduktion[tag][h])) {
				list.add(stundenproduktion[tag][h]);
				laenge++;
			}
		}
		int[] prods = new int[laenge];
		list.sort(null);
		for (int i = 0; i < laenge; i++) {
			prods[i] = list.get(i);
		}
		return prods;
	}

	// Aufgabe 10
	public int secondStundeProd(int[][] stundenproduktion, int std) {
		int höchsteprod = 0;
		int zweiteprod = 0;
		for (int i = 0;i<stundenproduktion.length;i++) {
			if (stundenproduktion[i][std] >= höchsteprod){
				zweiteprod = höchsteprod;
				höchsteprod = stundenproduktion[i][std];
			} else {
				if (stundenproduktion[i][std] >= zweiteprod) zweiteprod = stundenproduktion[i][std];
			}
			
		}
		return zweiteprod;
	}
	
	//Extra-methoden für aufgabe 11:
	static int calctag(int d, int h) {
		if (h==24) d += 1;
		if (h==-1) d -= 1;
		return d;
	}
	static int calcstunde(int h) {
		if (h==24) h=0;
		if (h==-1) h=23;
		return h;
	}
	
	
	// Aufgabe 11
	public int[] maxProfitMargin(int[][] stundenproduktion) {
		
		int[] profitmargin = {0, 0, 0 };
		
		for (int i = 1;i<9;i++){
			for (int j = 0;j<24;j++){
				
				// Die stunde 0 von tag 1 und die stunde 23 von tag 8 dürfen nicht verwendet werden, da es für sie nicht
				// ausreichend Werte in der Tabelle gibt
				if ((i != 1 || j != 0) && (i != 8 || j != 23) ) {
					if (
							stundenproduktion[i][j] > stundenproduktion[calctag(i-1, j-1)][calcstunde(j-1)] && 
							stundenproduktion[i][j] > stundenproduktion[i][calcstunde(j-1)] && 
							stundenproduktion[i][j] > stundenproduktion[calctag(i+1, j-1)][calcstunde(j-1)] &&
							stundenproduktion[i][j] > stundenproduktion[i-1][j] && 
							stundenproduktion[i][j] > stundenproduktion[i+1][j] &&
							stundenproduktion[i][j] > stundenproduktion[calctag(i-1, j+1)][calcstunde(j+1)] && 
							stundenproduktion[i][j] > stundenproduktion[i][calcstunde(j+1)] && 
							stundenproduktion[i][j] > stundenproduktion[calctag(i+1, j+1)][calcstunde(j+1)] &&
							stundenproduktion[i][j] >= profitmargin[2]
						) {
						profitmargin[0]=i;
						profitmargin[1]=j;
						profitmargin[2]=stundenproduktion[i][j];
					}
				}
			}
		}
		
		return profitmargin;
	}

	// Aufgabe 12
	public int[] maxLostSchicht(int[][] stundenproduktion) {
		
		int[] maxLost = new int[3];
		
		for (int i = 0; i < stundenproduktion.length;i++){
			for (int j = 0; j < stundenproduktion[i].length;j++) {
				int verlust = stundenproduktion[i][j] - sollTeile(j);
				if (verlust <= maxLost[2]) {
					maxLost[0] = i;
					if (j > 4 && j < 12)	maxLost[1] =  0;
					else if (j > 4 && j < 21)	maxLost[1] =  1;
					else maxLost[1] = 2;
					maxLost[2] = verlust;
				}
			}
		}
		
		return maxLost;
	}

	public void ausgabeA(int[][] array) {
		if (array == null) {
			System.out.println("null");
		} else {
			for (int i = 0; i < array.length; i++) {
				System.out.println(Arrays.toString(array[i]));
			}
		}
	}

	public void ausgabeA(int[] array) {
		if (array == null) {
			System.out.println("null");
		} else {
			for (int i = 0; i < array.length; i++)
				System.out.println("[" + array[i] + "]");
		}
	}

	public void ausgabeA(double[] array) {
		if (array == null) {
			System.out.println("null");
		} else {
			for (int i = 0; i < array.length; i++)
				System.out.println("[" + array[i] + "]");
		}
	}

	public static void main(String[] args) {

		Miniprojekt2 mini2 = new Miniprojekt2();
		// Konstruktor initialiert das Array SollTeile wie folgt
		/*
		 * Loesung[0-11] = 937 Loesung[12-18]= 503 Loesung[19-23]= 700.
		 */
		int tag = 0;

		int[][] stundenproduktion = new int[][] {
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 },
				{ 120, 120, 120, 120, 120, 150, 150, 150, 150, 150, 150, 150, 200, 200, 200, 200, 200, 200, 200, 200,
						200, 120, 120, 120 } };

		System.out.println("Aufgabe 1) sollTeile(5)" + mini2.sollTeile(5));
		System.out.println("Aufgabe 1) sollTeile(12)" + mini2.sollTeile(12));
		System.out.println("Aufgabe 1) sollTeile(21)" + mini2.sollTeile(21));

		/*
		 * Erwartete Loesung: Aufgabe 1) sollTeile(0)150 Aufgabe 1)
		 * sollTeile(12)200 Aufgabe 1) sollTeile(21)120
		 */

		double[] stundenprod = mini2.mittlereStdProduktionSchicht(stundenproduktion, tag);
		System.out.println("Aufgabe 2) mittlereStdProduktionSchicht");
		mini2.ausgabeA(stundenprod);
		/*
		 * Erwartete Loesung: [150.0] [200.0] [120.0]
		 */

		int[] tagesProd = mini2.tagesproduktion(stundenproduktion);
		System.out.println("Aufgabe 3) tagesproduktion");
		mini2.ausgabeA(tagesProd);
		/*
		 * Erwartete Loesung: [3810] [3810] [3810] [3810] [3810] [3810] [3810]
		 * [3810] [3810] [3810]
		 */

		int[] sollIstV = mini2.istSollVergleich(stundenproduktion);
		System.out.println("Aufgabe 4) istSollVergleich ");
		mini2.ausgabeA(sollIstV);

		/*
		 * Erwartete Loesung: [0] [0] [0] [0] [0] [0] [0] [0] [0] [0]
		 */

		System.out.println("Aufgabe 5) minMittlereStudProd: " + mini2.minMittlereStdProd(stundenproduktion, tag));

		/*
		 * Erwartete Loesung: minMittlereStudProd --> 2 (Nachtschicht)
		 */

		System.out.println("Aufgabe 6) maxMittlereStdProd: " + mini2.maxMittlereStdProd(stundenproduktion, tag));

		/*
		 * Erwartete Loesung: maxMittlereStdProd --> 1 (Mittangsschicht)
		 */

	}

}