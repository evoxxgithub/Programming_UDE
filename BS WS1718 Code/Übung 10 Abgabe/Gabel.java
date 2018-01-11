class Gabel {
    public static final Object LOCK = new Object();
    public boolean verfuegbar = true;

public void nimmAuf() {
    verfuegbar = false; //nimm Gabel auf (muss verfügbar sein)
    }

public void legeZurueck() {
        verfuegbar = true; //lege Gabel zurück
        }
}