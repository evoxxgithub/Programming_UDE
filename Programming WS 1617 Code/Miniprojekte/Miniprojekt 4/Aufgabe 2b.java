/*		      // TODO AUFGABE 2b
		      public int hashfunktion(String s) {
		          // Implementieren Sie hier Ihre Loesung
		          int  summe = 0;
		          for (int i = 0;i<s.length();i++) {
		              summe += s.charAt(i)*powerOf(256 % hashtabelle.length, i);
		          }
		         return ((1+summe) % hashtabelle.length);
		      } 
		      public int powerOf(int base, int exponent) {
		          if (exponent == 0) return 1;
		          int result = base;
		          for (int i = 1;i<exponent;i++) {
		              result = (result*base) % hashtabelle.length; 
		         }
		          return result;
		      }*/