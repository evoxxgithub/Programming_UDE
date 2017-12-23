/*		      private boolean containsId(ArrayList<Integer> nachrichtenIds, int id){
		         for (Integer i : nachrichtenIds) {
		             if (i == id) return true;
		          }
		          return false;
		      }
		      // TODO AUFGABE 3b
		      public int anzahlNachrichten() {
		          // Implementieren Sie hier Ihre Loesung
		          ArrayList<Integer> nachrichtenIds = new ArrayList<Integer>();
		          for (HashKnoten hash : hashtabelle) {
		              HashKnoten h = hash;
		              while (h != null) {
		                  Nachrichtenzeiger n = h.getNzKopf();
		                  while (n != null) {
		                      if (!containsId(nachrichtenIds, n.getNachricht().getId())) nachrichtenIds.add(n.getNachricht().getId());
		                     n = n.getNf();
		                  }
		                  h = h.getNf();
		              } 
		          }
		          return nachrichtenIds.size();
		      }*/