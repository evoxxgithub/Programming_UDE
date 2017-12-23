public class Hanoi {
	
	static int counter = 0;
	
		static void loese(int n, int quelle, int frei, int ziel){
			if (n==1) {System.out.println("scheibe 1 von " +quelle+ " nach " + ziel);
			}
			else {
				loese(n-1, quelle, ziel, frei);
				System.out.println("<< frei: "+frei+ " | ziel: "+ziel);
				System.out.println("scheibe " + n + " von " +quelle+ " nach " + ziel);
				loese(n-1, frei, quelle, ziel);
			}	
		}
		public static void main(String[] s) {
		loese(1, 1, 2, 3);
		}
}
