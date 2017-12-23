////////////////////////////////////////////////////////////////////

/*
    Dieser Code ist nicht von mir!
    Danke an Oliver Just für die Lösung.
*/

////////////////////////////////////////////////////////////////////

/*
        public void loescheNachricht(int id) {
				Nachricht var = this.getMessageByID(id);
				if(var!=null) {
					if (hasReference(id)) { //check if message has its refences in an answer
						String newMessage = "<geloeschte Nachricht>";
						for (String hashs : var.getHashTags()) newMessage += " #" + hashs;
						var.setInhalt(newMessage);
					} else {  //no reference
						for(HashKnoten hashKnoten:hashtabelle){
							HashKnoten nf=hashKnoten;
							while (nf!=null){
								Nachrichtenzeiger nz=nf.getNzKopf();
								while(nz!=null){
									if(nz.getNachricht().getId()==id){
										nf.setNzKopf((nz.getNf())); //Nachricht at the Head
									}
									else if (nz.getNf()!=null&&nz.getNf().getNachricht().getId()==id){
										nz.setNf(nz.getNf().getNf()); //Nachricht is not at the Head
									}
									nz=nz.getNf();
								}
								if(nf.getNzKopf()==null){
									deleteEmptyHashKnoten(nf) ; //check if Hashknoten has to be deleted
								}
								nf=nf.getNf();
							}
						}
					}
					if (var.getReferenz() != null){
						if(var.getReferenz().getInhalt().contains("<geloeschte Nachricht>")){
							loescheNachricht(var.getReferenz().getId()); //delete old Nachrichten
						}
					}
				}
			}

			private void deleteEmptyHashKnoten(HashKnoten nf){
				HashKnoten hashknoten = hashtabelle[hashfunktion(nf.getHashtag())];
				if(hashknoten==nf) hashtabelle[hashfunktion(nf.getHashtag())]=nf.getNf(); //hashknoten at the beginning
				else {
					while(hashknoten!=null&&hashknoten.getNf()!=nf) hashknoten=hashknoten.getNf();
					if(hashknoten!=null) hashknoten.setNf(nf.getNf());
				}

			}
			
			private boolean hasReference(int id) {
				for(Nachrichtenzeiger nz : getAllNZ()){
					if(nz.getNachricht().getReferenz()!=null&&nz.getNachricht().getReferenz().getId()==id){
						return true;
					}
				}
				return false;
			}
			
			public Nachricht getMessageByID(int id) {
				for(Nachrichtenzeiger nz : getAllNZ()) if(nz.getNachricht().getId()==id) return nz.getNachricht();
				return null;
			}
			
			private Nachrichtenzeiger[] getAllNZ(){
				//Zähle alle NZ um das Array initialisieren zu können
				int counter=0;
				for(HashKnoten hashKnoten:hashtabelle){
					HashKnoten nf=hashKnoten;
					while (nf!=null){
						Nachrichtenzeiger nz=nf.getNzKopf();
						while(nz!=null){
							counter++;
							nz=nz.getNf();
						}
						nf=nf.getNf();
					}
				}
				Nachrichtenzeiger[] var = new Nachrichtenzeiger[counter];
				//Alle Nachrichtenzeiger zu dem Array hinzufügen
				counter=0;
				for(HashKnoten hashKnoten:hashtabelle){
					HashKnoten nf=hashKnoten;
					while (nf!=null){
						Nachrichtenzeiger nz=nf.getNzKopf();
						while(nz!=null){
							var[counter++]=nz;
							nz=nz.getNf();
						}
						nf=nf.getNf();
					}
				}
				return var;
			}*/