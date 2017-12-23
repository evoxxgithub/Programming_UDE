		 /*     public void antworteAufNachricht(String verfasser, String inhalt, int id) {
		    	  
		    	  Nachricht neu = new Nachricht(verfasser, inhalt, nachrichtenId++);
		    	  neu.setReferenz(findeNachricht(id));
		    	  String[] refhashtags = neu.getReferenz().getHashTags();
		    	  ArrayList<String> hashtaglist = new ArrayList<String>();
		    	  for (String hashtag : neu.getHashTags()){
		    		  hashtaglist.add(hashtag);
		    	  }
		    	  
		    	  for (String refhashtag : refhashtags){
		    		  boolean found = false;
		    		  for (String hashtag : neu.getHashTags()){
		    			  if (refhashtag.equals(hashtag)) found = true;
		    		  }
		    		  if (!found) {
		    			  hashtaglist.add(refhashtag);
		    		  }
		    	  }
		    	  String[] hashtags = new String[hashtaglist.size()];
		    	  for (int i = 0; i < hashtags.length; i++){
		    		  hashtags[i] = hashtaglist.get(i);
		    	  }
		    	  neu.setHashTags(hashtags);
		    	  
		    	  sortiereNachrichtEin(neu);
		    	  
		      }
              
              		      private Nachricht findeNachricht(int id){
		    	  for (HashKnoten hash : hashtabelle) {
		    		  for (HashKnoten h = hash;h != null; h = h.getNf()){
		    			  for (Nachrichtenzeiger n = h.getNzKopf();n != null; n = n.getNf()) {
		    				  if (n.getNachricht().getId() == id) return n.getNachricht();
		    			  }
		    		  }
		    	  }
		    	  return null;
		      }*/