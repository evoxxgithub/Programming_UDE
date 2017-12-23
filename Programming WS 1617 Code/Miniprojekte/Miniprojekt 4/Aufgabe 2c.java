/*		      // TODO AUFGABE 2c
		     public void sortiereNachrichtEin(Nachricht nachricht) {
		         // Implementieren Sie hier Ihre Loesung
		         for (String hashtag : nachricht.getHashTags()) {
		              if (this.hashtabelle[hashfunktion(hashtag)] != null) {
		                  //sortiere in vorhandene HashKnotenliste ein
		                  HashKnoten h = this.hashtabelle[hashfunktion(hashtag)];
		                  boolean knotenfound = false;
		                  //suche in HashKnotenliste nach diesem Hashtag
		                  while (!knotenfound && h != null) {
		                      if (h.getHashtag().equals(hashtag)) {
		                          h.fuegeNachrichtEin(nachricht);
		                          knotenfound = true;
		                          }
		                      h = h.getNf();
		                  }
		                  //wenn kein HashKnoten gefunden, muss neuer Hashknoten einsortiert werden.
		                  if (!knotenfound) {
		                      h = hashtabelle[hashfunktion(hashtag)];
		                      boolean einsortiert = false;
		                      if (h.getHashtag().compareTo(hashtag) > 0) {
		                          HashKnoten neu = new HashKnoten(hashtag, nachricht);
		                          neu.setNf(h);
		                          hashtabelle[hashfunktion(hashtag)] = neu;
		                          einsortiert = true;
		                      }
		                      while (!einsortiert && h != null){
		                          if (h.getNf() == null || h.getNf().getHashtag().compareTo(hashtag) > 0) {
		                              //sortiere ein
		                              HashKnoten neu = new HashKnoten(hashtag, nachricht);
		                              neu.setNf(h.getNf());
		                              h.setNf(neu);
		                              einsortiert = true;
		                          } else h = h.getNf();
		                      }
		                  }
		              } else {
		                  //erstelle neuen HashKnoten
		                 this.hashtabelle[hashfunktion(hashtag)] = new HashKnoten(hashtag, nachricht);
		              }
		          }
		      }*/