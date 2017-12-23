/*		      // TODO Aufgabe 3d
		      public int anzahlNachrichtenMindestReferenztiefe(int n) {
		          ArrayList<Integer> nachrichtenIds = new ArrayList<Integer>();
		          for (HashKnoten hash : hashtabelle) {
		              HashKnoten h = hash;
		              while (h != null) {
		                  Nachrichtenzeiger na = h.getNzKopf();
		                  while (na != null) {
		                      if (!containsId( nachrichtenIds, na.getNachricht().getId())&& ermittleReferenzTiefe(na.getNachricht()) >= n) {
		                          nachrichtenIds.add(na.getNachricht().getId());
		                      }
		                      na = na.getNf();
		                  }
		                  h = h.getNf();
		              }
		          }
		          
		          return nachrichtenIds.size();
		      }*/