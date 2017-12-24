
public class Liste {
	Element kopf;


	public Liste() {
		// bleibt leer
	}

	public Liste(int[] a) {
		// erstellt eine verkettete Liste aus dem Array a

		if (a != null) {
			for (int i = a.length-1; i >= 0; i--) {
				fuegeEin(a[i]);
			}
		}
	}


	public void fuegeEin(int wert) {
		Element neu = new Element(wert, this.kopf);
		this.kopf = neu;
	}

	public void gibAus() {
		Element i = this.kopf;
		while (i != null) {
			System.out.println(i.wert);
			i = i.weiter;
		}
	}

	public void merge(Liste a) {
		this.kopf = merge(this.kopf, a.kopf);
	}

	private Element merge(Element el1, Element el2) {
		if (el1 != null && el2 != null) {
			if (el2.wert < this.kopf.wert) {
				this.kopf = new Element(el2.wert, this.kopf);
				return merge(this.kopf.weiter, el2.weiter);
			} else if (el1.weiter != null && el2.wert < el1.weiter.wert || el1.weiter == null ){
				el1.weiter = new Element(el2.wert, el1.weiter);;
				return merge(el1.weiter, el2.weiter);
			} else return merge(el1.weiter, el2);
		} else return this.kopf;
	}

	public void reverse() {
		this.kopf = reverse(this.kopf, this.kopf.weiter);
	}

	private Element reverse(Element el1, Element el2) {
		if (el2 != null){
			if (el1.weiter == el2) el1.weiter = null;
			return reverse(new Element(el2.wert, el1), el2.weiter);
		} else return el1;
	}
}
