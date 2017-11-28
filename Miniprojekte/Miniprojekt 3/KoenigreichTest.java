import org.junit.jupiter.api.*;

import java.util.Arrays;


public class KoenigreichTest {

    private static Koenigreich createReich() {
        Person dieter = new Person("dieter", Rang.FUERST, null, null, true);
        Person annabell = new Person("annabell", Rang.FUERST, null, null, false);
        Person anneliese = new Person("anneliese", Rang.FUERST, null, null, false);
        Person mueller = new Person("mueller", Rang.ARBEITER, null, null, true);
        Person horst = new Person("horst", Rang.BUERGER, null, null, true);

        Koenigreich constructedReich = new Koenigreich("random_name");
        constructedReich.geburt(dieter);
        constructedReich.geburt(annabell);
        constructedReich.geburt(anneliese);
        constructedReich.geburt(mueller);
        constructedReich.geburt(horst);
        return constructedReich;
    }

    @Test
    public void constructorTest(){
        Koenigreich constructedReich = new Koenigreich("random_name");
        Assertions.assertTrue(constructedReich.spitze != null);
        Assertions.assertEquals("random_name", constructedReich.spitze.getName());
        Assertions.assertEquals(Rang.KOENIG, constructedReich.spitze.getRang());
    }

    //Aufgabe 2
    @Test
    public void geburtTest()
    {
        Person dieter = new Person("dieter", Rang.FUERST, null, null, true);
        Person annabell = new Person("annabell", Rang.FUERST, null, null, false);
        Person anneliese = new Person("anneliese", Rang.FUERST, null, null, false);
        Person mueller = new Person("mueller", Rang.ARBEITER, null, null, true);
        Person horst = new Person("horst", Rang.BUERGER, null, null, true);
        Person nic_the_second_king = new Person("Nic", Rang.KOENIG, null, null, true);

        Koenigreich constructedReich = new Koenigreich("random_name");


        constructedReich.geburt(dieter);
        Assertions.assertEquals(dieter, constructedReich.spitze.getLinks());
        constructedReich.geburt(annabell);
        Assertions.assertEquals(annabell, constructedReich.spitze.getRechts());
        constructedReich.geburt(anneliese);
        Assertions.assertEquals(anneliese, constructedReich.spitze.getRechts().getRechts());
        constructedReich.geburt(mueller);
        Assertions.assertEquals(mueller, constructedReich.spitze.getLinks().getLinks());
        constructedReich.geburt(horst);
        Assertions.assertEquals(horst, constructedReich.spitze.getLinks().getLinks());
        Assertions.assertEquals(mueller, constructedReich.spitze.getLinks().getLinks().getLinks());
        constructedReich.geburt(nic_the_second_king);
        Assertions.assertTrue(Arrays.equals(new Person[] {}, constructedReich.suche("Nic", Rang.KOENIG)));

    }

    //Aufgabe 3
    @Test
    public void volkszaehlungTest()
    {
        Person dieter = new Person("dieter", Rang.FUERST, null, null, true);
        Person annabell = new Person("annabell", Rang.FUERST, null, null, false);
        Person anneliese = new Person("anneliese", Rang.FUERST, null, null, false);
        Person mueller = new Person("mueller", Rang.ARBEITER, null, null, true);
        Person horst = new Person("horst", Rang.BUERGER, null, null, true);

        Koenigreich constructedReich = new Koenigreich("random_name");
        constructedReich.geburt(dieter);
        constructedReich.geburt(annabell);
        constructedReich.geburt(anneliese);
        constructedReich.geburt(mueller);
        constructedReich.geburt(horst);

        final int size = 6;
        Person[] all_persons = {constructedReich.spitze, dieter, horst, mueller, annabell, anneliese};

        Assertions.assertArrayEquals(all_persons, constructedReich.volkszaehlung());
    }

    //Aufgabe 4
    @Test
    public void sucheTest()
    {

    }

    //Aufgabe 5
    @Test
    public void exekutionTest()
    {
    }

    //Aufgabe 6
    @Test
    public void revolutionTest()
    {
    }
}
