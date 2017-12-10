import org.junit.jupiter.api.*;

import java.util.Arrays;


public class KoenigreichTest {

    private static Koenigreich createReich() {
        Buerger dieter = new Buerger("dieter", Rang.FUERST, null, null, true);
        Buerger annabell = new Buerger("annabell", Rang.FUERST, null, null, false);
        Buerger anneliese = new Buerger("anneliese", Rang.FUERST, null, null, false);
        Buerger mueller = new Buerger("mueller", Rang.ARBEITER, null, null, true);
        Buerger horst = new Buerger("horst", Rang.BUERGER, null, null, true);

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
        Buerger dieter = new Buerger("dieter", Rang.FUERST, null, null, true);
        Buerger annabell = new Buerger("annabell", Rang.FUERST, null, null, false);
        Buerger anneliese = new Buerger("anneliese", Rang.FUERST, null, null, false);
        Buerger mueller = new Buerger("mueller", Rang.ARBEITER, null, null, true);
        Buerger horst = new Buerger("horst", Rang.BUERGER, null, null, true);
        Buerger nic_the_second_king = new Buerger("Nic", Rang.KOENIG, null, null, true);

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
        Assertions.assertTrue(Arrays.equals(null, constructedReich.suche("Nic", Rang.KOENIG)));

    }

    //Aufgabe 3
    @Test
    public void volkszaehlungTest()
    {
        Buerger dieter = new Buerger("dieter", Rang.FUERST, null, null, true);
        Buerger annabell = new Buerger("annabell", Rang.FUERST, null, null, false);
        Buerger anneliese = new Buerger("anneliese", Rang.FUERST, null, null, false);
        Buerger mueller = new Buerger("mueller", Rang.ARBEITER, null, null, true);
        Buerger horst = new Buerger("horst", Rang.BUERGER, null, null, true);

        Koenigreich constructedReich = new Koenigreich("random_name");
        constructedReich.geburt(dieter);
        constructedReich.geburt(annabell);
        constructedReich.geburt(anneliese);
        constructedReich.geburt(mueller);
        constructedReich.geburt(horst);

        final int size = 6;
        Buerger[] all_persons = {constructedReich.spitze, dieter, horst, mueller, annabell, anneliese};

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
