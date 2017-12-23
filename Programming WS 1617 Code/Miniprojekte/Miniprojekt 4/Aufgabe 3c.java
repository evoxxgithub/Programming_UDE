/*		      // TODO AUFGABE 3c
		      public double verhaeltnisZeigerZuHashKnoten() {
		          int anzahlKnoten = 0;
		          int anzahlNachrichtenzeiger = 0;
		          for (HashKnoten hash : hashtabelle) {
		              HashKnoten h = hash;
		              while (h != null) {
		                  anzahlKnoten++;
		                  Nachrichtenzeiger n = h.getNzKopf();
		                  while(n != null) {
		                      anzahlNachrichtenzeiger++;
		                      n = n.getNf();
		                  }
		                  h = h.getNf();
		             }
		          }
		          if (anzahlKnoten > 0) return (double)anzahlNachrichtenzeiger / (double)anzahlKnoten;
		          else return -1;
		      }
		      
		      public int ermittleReferenzTiefe(Nachricht n) {
		          if (n.getReferenz() == null) return 0;
		          else return 1+ermittleReferenzTiefe(n.getReferenz());
		      }*/