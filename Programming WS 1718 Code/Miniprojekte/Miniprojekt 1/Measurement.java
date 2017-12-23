import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Measurement {

    private int[] data;

    public Measurement() {
        this.data = new int[0];
    }

    public void addValue(int value) {

        int[] newdata = new int[this.data.length+1];
        for (int i = 0; i < this.data.length; i++) {
            newdata[i] = data[i];
        }
        newdata[newdata.length-1] = value;
        this.data = newdata;
    }

    public void addValues(int[] values) {

        int[] newdata = new int[this.data.length+ values.length];
        for (int i = 0; i < this.data.length; i++) {
            newdata[i] = data[i];
        }
        for (int i = 0; i < values.length; i++) {
            newdata[this.data.length + i] = values[i];
        }
        this.data = newdata;
    }

    public int getMinimumValue() {

        int min = Integer.MAX_VALUE;
        for (int value : this.data) {
            if (value < min) min = value;
        }
        return min;
    }

    public int[] getValuesAboveThreshold(int threshold) {

        List<Integer> aboveThreshholdList = new ArrayList<>();
        for (int value : this.data) {
            if (value > threshold) aboveThreshholdList.add(value);
        }
        int[] threshholdArray = new int[aboveThreshholdList.size()];
        for (int i = 0; i < aboveThreshholdList.size(); i++) {
            threshholdArray[i] = aboveThreshholdList.get(i);
        }
        return threshholdArray;
    }

    // --------------------------------------------------------------

    public void printData() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String[] args) {
        Measurement m = new Measurement();
        System.out.println("Neues Measurement-Objekt m erzeugt. m:");
        // ErwarteteAusgabe:
        // []
        m.printData();

        System.out.println("------------------------------------------------------------------");

        m.addValue(85);
        System.out.println("Hinzufügen eines neuen Wertes. m:");
        // Erwartete Ausgabe:
        // [85]
        m.printData();

        System.out.println("------------------------------------------------------------------");

        m.addValues(new int[] { 58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93 });
        System.out.println("Hinzuzfügen einer Menge von Werten. m:");
        // Erwartete Ausgabe:
        // [85, 58, 78, 61, 72, 93, 81, 79, 78, 75, 81, 93]
        m.printData();

        System.out.println("------------------------------------------------------------------");

        int minimumValue = m.getMinimumValue();
        System.out.println("Minimaler Wert der Messreihe m:");
        // Erwartete Ausgabe: 58
        System.out.println(minimumValue);

        System.out.println("------------------------------------------------------------------");

        int[] valuesAbove78 = m.getValuesAboveThreshold(78);
        System.out.println("Messwerte über 78:");
        // Erwartete Ausgabe:
        // [85, 93, 81, 79, 81, 93]
        System.out.println(Arrays.toString(valuesAbove78));

        System.out.println("------------------------------------------------------------------");

        int[] valuesAbove93 = m.getValuesAboveThreshold(93);
        System.out.println("Messwerte über 93:");
        // Erwartete Ausgabe:
        // []
        System.out.println(Arrays.toString(valuesAbove93));
    }

}
