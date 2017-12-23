public class Element {

    int wert;
    Element kopf, weiter;

    public Element(int wert, Element kopf) {
        this.wert = wert;
        this.kopf = kopf;
    }
}
