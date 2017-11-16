public class Train {

	// Kann für die Ausgabe verwendet werden
	private static final String LOCOMOTIVE = "<___|o|";

	private Waggon head;

	public int getSize() {
		int baum = 1;
		Waggon pointer = this.head;
		if (this.head == null) return 0;
		while (pointer.getNext() != null){
			baum++;
			pointer = pointer.getNext();
		}
		return baum;
	}

	public int getPassengerCount() {
		if (this.head == null) return 0;
		int baum = this.head.getPassengers();
		Waggon pointer = this.head;
		while (pointer.getNext() != null) {
			pointer = pointer.getNext();
			baum += pointer.getPassengers();
		}
		return baum;
	}

	public int getCapacity() {
		if (this.head == null) return 0;
		int baum = this.head.getCapacity();
		Waggon pointer = this.head;
		while (pointer.getNext() != null) {
			pointer = pointer.getNext();
			baum += pointer.getCapacity();
		}
		return baum;
	}

	public void appendWaggon(Waggon waggon) {
		Waggon lastWaggon = this.getLastWaggon();
		if (lastWaggon != null) lastWaggon.setNext(waggon);
		else this.head = waggon;
	}

	private Waggon getLastWaggon() {
		Waggon lastWaggon = this.head;
		if (lastWaggon == null) return null;
		while (lastWaggon.getNext() != null) {
			lastWaggon = lastWaggon.getNext();
		}
		return lastWaggon;
	}

	private Waggon goToWaggon(int index){
		int currentIndex = 0;
		Waggon currentWaggon = this.head;
		while (currentIndex < index && currentWaggon != null){
			System.out.println("in goto while currentindex is: " + currentIndex);
			currentWaggon = currentWaggon.getNext();
			currentIndex++;
		}
		return currentWaggon;
	}

	public void boardPassengers(int numberOfPassengers) {
		Waggon currentWaggon = this.head;
		int passengersLeft = numberOfPassengers;
		while (currentWaggon != null && passengersLeft > 0){
			int seatsLeft = currentWaggon.getCapacity()-currentWaggon.getPassengers();
			if (seatsLeft > 0){
				int numberOfPassengersSeatingHere = Math.min(seatsLeft, passengersLeft);
				passengersLeft -= numberOfPassengersSeatingHere;
				currentWaggon.setPassengers(currentWaggon.getPassengers()+numberOfPassengersSeatingHere);
			}
			currentWaggon = currentWaggon.getNext();
		}
	}

	public Train uncoupleWaggons(int index) {
		Waggon uncoupleWaggon = this.goToWaggon(index);
		Train newTrain = new Train();
		newTrain.appendWaggon(uncoupleWaggon);
		Waggon waggonBefore = (index > 0)? this.goToWaggon(index-1): this.head;
		waggonBefore.setNext(null);
		return newTrain;
	}

	public void insertWaggon(Waggon waggon, int index) {
		if (index == 0) {
			Waggon oldHead = this.head;
			this.head = waggon;
			waggon.setNext(oldHead);

		} else {
			Waggon insertAt = (index >= this.getSize())? this.getLastWaggon() : this.goToWaggon(index-1);
			Waggon after = insertAt.getNext();
			insertAt.setNext(waggon);
			waggon.setNext(after);
		}

	}

	public void turnOver() {
		Waggon last = this.getLastWaggon();
		int lastIndex = this.getSize()-1;
		Waggon temp = this.getLastWaggon();
		for (int i = this.getSize()-2; i >= 0; i--) {
			System.out.println("i is: " + i);
			Waggon current = this.getWaggonAt(i);
			temp.setNext(current);
			temp = current;
		}
		this.head.setNext(null);
		this.head = last;
	}

	public void removeWaggon(Waggon waggon) {
		if (this.head == null) return;
		if (waggon == this.head) { this.head = head.getNext(); return; }
		Waggon currentWaggon = this.head;
		while (currentWaggon.getNext() != null) {
			if (currentWaggon.getNext() == waggon) { currentWaggon.setNext(currentWaggon.getNext().getNext()); return; }
			currentWaggon = currentWaggon.getNext();
		}
	}

	public Waggon getWaggonAt(int index) {
		return this.goToWaggon(index);
	}

	@Override
	public String toString() {
		if (getSize() == 0) {
			return LOCOMOTIVE;
		}

		StringBuilder str = new StringBuilder(LOCOMOTIVE);

		Waggon pointer = head;
		while (pointer != null) {
			str.append(" <---> ");
			str.append(pointer.getName());
			pointer = pointer.getNext();
		}

		return str.toString();
	}

}
