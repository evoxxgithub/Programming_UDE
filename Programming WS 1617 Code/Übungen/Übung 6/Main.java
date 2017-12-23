public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Aufgabenteil 1:
		Quader[] Array = { new Quader(3,4,8), new Quader(10,25,49), new Quader(6,4,10), new Quader(4,5,7),
				new Quader(14,8,4), new Quader(10,20,30) };
		
		int maxvolume = 0;
		int maxsurface = 0;
		for (int i = 0;i<6;i++) {
			if (Array[i].volume(Array[i]) > maxvolume) maxvolume = Array[i].volume(Array[i]);
			if (Array[i].surfacearea(Array[i]) > maxsurface) maxsurface = Array[i].surfacearea(Array[i]);
		}
		System.out.println(maxvolume);
		System.out.println(maxsurface);
		
		//Aufgabenteil 2:
		/* keine Lust mir vernünftige daten auszudenken */
		Spieler Olli = new Spieler("Olli", 35, 1, 't');
		Spieler Timo = new Spieler("Timo", 27, 1, 't');
		Spieler[] h = { Timo };
		Spieler[] b = { Olli };
		Mannschaft hsv = new Mannschaft("HSV", h);
		Mannschaft bayern = new Mannschaft("Bayern München", b);
		int[] t = { 1, 7 };
		Fussballspiel hsv_vs_bayern = new Fussballspiel(bayern, hsv, t);
		// #Traumfussball
			
	}

}
