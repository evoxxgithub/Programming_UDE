class Philosoph extends Thread {

    private boolean fuerImmer = true;
    private Gabel linkeGabel, rechteGabel;

        public void run() {
        while ( fuerImmer ) {
            denke();
            nimmGabelnAuf();
            iss();
            legeGabelnZurueck();
            }
        }

        public void nimmGabelnAuf() {
            while(!(linkeGabel.verfuegbar && rechteGabel.verfuegbar)){
                Thread.yield();
            }
            synchronized (Gabel.LOCK) {
                if (!(linkeGabel.verfuegbar && rechteGabel.verfuegbar)) return; // falls ein philo schneller ist
                // (obwohl sehr unwahrscheinlich)
                rechteGabel.nimmAuf();
                linkeGabel.nimmAuf();
            }

        }

        public void legeGabelnZurueck() {
            linkeGabel.legeZurueck();
            rechteGabel.legeZurueck();
        }

        public void denke(){

        }
        public void iss() {

        }
}