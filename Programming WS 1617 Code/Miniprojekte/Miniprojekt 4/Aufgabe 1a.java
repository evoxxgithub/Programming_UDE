/*	// TODO AUFGABE 1a
	public Nachricht(String verfasser, String inhalt, int id) {
		// Implementieren Sie hier Ihre Loesung
		this.verfasser = verfasser;
		this.inhalt = inhalt;
		this.id = id;
		String[] words = inhalt.split(" ");
		ArrayList<String> list = new ArrayList<String>();
		for (String word : words) {
			if (word.length() > 1 && word.substring(0, 1).equals("#")) list.add(word.substring(1));
		}
		String[] hashtable = new String[list.size()];
		for (int i = 0;i<hashtable.length;i++){
			hashtable[i] = list.get(i);
		}
		this.setHashTags(hashtable);
	}*/