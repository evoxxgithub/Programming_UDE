import java.util.ArrayList;
import java.util.stream.Collectors;

public class Koenigreich {

	Buerger spitze;

	//Aufgabe 1
	public Koenigreich(String koenig)
	{
		//Bitte hier Code einfuegen.
		this.spitze = new Buerger(koenig, Rang.KOENIG, null, null, true);
	}
		
	//Aufgabe 2
	public void geburt(Buerger person)
	{
		//Bitte hier Code einfuegen.
        if (person != null && person.getRang() != Rang.KOENIG) this.sortUpwardsIntoTree(person);
	}

    private void sortUpwardsIntoTree(Buerger person) {
	    boolean personIsMale = person.getIstMaennlich();
	    Buerger treeAfterSex = (personIsMale)? this.spitze.getLinks() : this.spitze.getRechts();

	    if (treeAfterSex == null) {
	        if (personIsMale) this.spitze.setLinks(person);
	        else this.spitze.setRechts(person);
        }

        else if (treeAfterSex.getRang().ordinal() < person.getRang().ordinal()) {
	        person.setLinks(treeAfterSex);
	        if (personIsMale) this.spitze.setLinks(person);
	        else this.spitze.setRechts(person);
        }
        else this.sortUpwardsAfterRank(person, treeAfterSex);
    }

    private void sortUpwardsAfterRank(Buerger person, Buerger treeToPutInto) {
	    boolean putInRightSide = person.getRang().ordinal() == treeToPutInto.getRang().ordinal();
	    Buerger nextStepInTree = (putInRightSide)? treeToPutInto.getRechts() : treeToPutInto.getLinks();
	    if (nextStepInTree == null || nextStepInTree.getRang().ordinal() < person.getRang().ordinal()){
	        person.setLinks(nextStepInTree);
	        if (putInRightSide) treeToPutInto.setRechts(person);
	        else treeToPutInto.setLinks(person);
        }
        else sortUpwardsAfterRank(person, nextStepInTree);
    }

    //Aufgabe 3
	public Buerger[] volkszaehlung()
	{
        if (spitze == null) return new Buerger[] {};

        ArrayList<Buerger> personList = getPeople();
        Buerger[] arrayToReturn = new Buerger[personList.size()];
		return personList.toArray(arrayToReturn);
	}

    private ArrayList<Buerger> getPeople() {

        ArrayList<Buerger> personList = new ArrayList<>();
        if (this.spitze == null) return personList;

        personList.add(this.spitze);

        if (this.spitze.getLinks() != null) this.addTreeToVolkszaehlung(this.spitze.getLinks(), personList);
        if (this.spitze.getRechts() != null) this.addTreeToVolkszaehlung(this.spitze.getRechts(), personList);

        return personList;
    }

    private void addTreeToVolkszaehlung(Buerger currentTree, ArrayList<Buerger> personList) {
	    personList.add(currentTree);
	    if (currentTree.getRechts() != null) addTreeToVolkszaehlung(currentTree.getRechts(), personList);
	    if (currentTree.getLinks() != null) addTreeToVolkszaehlung(currentTree.getLinks(), personList);
    }

    //Aufgabe 4
	public Buerger[] suche(String name, Rang rang)
	{

	    if (name == null && rang == null) return null;


		//Bitte hier Code einfuegen.
        final ArrayList<Buerger> people = this.getPeople();
        final ArrayList<Buerger> filteredList = new ArrayList<>();

        people.stream()
				.filter(p -> name == null || p.getName().equals(name))
                .filter( p -> rang == null || p.getRang() == rang)
                .forEach(p -> filteredList.add(p));
        for (Buerger person : filteredList) {
            if (person == null) filteredList.remove(person);
        }
        if (filteredList.size() == 0) return null;
        Buerger[] searchResultArray = new Buerger[filteredList.size()];
        filteredList.toArray(searchResultArray);
        return searchResultArray;
	}	
	
	//Aufgabe 5
	public void exekution(String name)
	{
	    Buerger[] all_personsWithName = this.suche(name, null);
	    if (all_personsWithName == null) return;
        for (Buerger person : all_personsWithName) {
            if (person.getRang() != Rang.KOENIG) this.execute(person);
        }
    }

    private void execute(Buerger person) {
	    Buerger superPerson = searchForSuper(person);
	    boolean rightAfterPersonIsNull = person.getRechts() == null;
        boolean personIsRightOfSuper = superPerson.getRechts() == person;
        if (personIsRightOfSuper) {
            if (rightAfterPersonIsNull) superPerson.setRechts(person.getLinks());
            else {
                superPerson.setRechts(person.getRechts());
                person.getRechts().setLinks(person.getLinks());
            }
        } else {
            if (rightAfterPersonIsNull) superPerson.setLinks(person.getLinks());
            else {

                superPerson.setLinks(person.getRechts());
                person.getRechts().setLinks(person.getLinks());
            }
        }
    }

    private Buerger searchForSuper(Buerger person) {

	    return searchForSuperInTree(person, this.spitze);
    }

    private Buerger searchForSuperInTree(Buerger person, Buerger currentTree) {
	    if (currentTree == null) return null;
	    if (currentTree.getRechts() == person || currentTree.getLinks() == person) return currentTree;

        Buerger foundInLeftTree = searchForSuperInTree(person, currentTree.getLinks());
        Buerger foundInRightTree = searchForSuperInTree(person, currentTree.getRechts());

        return (foundInLeftTree == null)? foundInRightTree : foundInLeftTree;
    }

    //Aufgabe 6
	public void revolution(Buerger person)
	{
	    Buerger[] all_persons = this.volkszaehlung();
        for (Buerger p : all_persons) {
            p.setLinks(null);
            p.setRechts(null);
        }
        this.spitze = person;
        for (Buerger p : all_persons) {
            if (p != person) this.sortDownWardsIntoTree(p);
        }
    }

    private void sortDownWardsIntoTree(Buerger person) {
        boolean personIsMale = person.getIstMaennlich();
        Buerger treeAfterSex = (personIsMale)? this.spitze.getLinks() : this.spitze.getRechts();

        if (treeAfterSex == null) {
            if (personIsMale) this.spitze.setLinks(person);
            else this.spitze.setRechts(person);
        }

        else if (treeAfterSex.getRang().ordinal() > person.getRang().ordinal()) {
            person.setLinks(treeAfterSex);
            if (personIsMale) this.spitze.setLinks(person);
            else this.spitze.setRechts(person);
        }
        else this.sortDownWardsAfterRank(person, treeAfterSex);
    }

    private void sortDownWardsAfterRank(Buerger person, Buerger treeToPutInto) {
        boolean putInRightSide = person.getRang().ordinal() == treeToPutInto.getRang().ordinal();
        Buerger nextStepInTree = (putInRightSide)? treeToPutInto.getRechts() : treeToPutInto.getLinks();
        if (nextStepInTree == null || nextStepInTree.getRang().ordinal() > person.getRang().ordinal()){
            person.setLinks(nextStepInTree);
            if (putInRightSide) treeToPutInto.setRechts(person);
            else treeToPutInto.setLinks(person);
        }
        else sortUpwardsAfterRank(person, nextStepInTree);
    }

	public static void main(String[] args)
	{
		Koenigreich k = new Koenigreich("Arthur");
		Buerger array[] = new Buerger[15];
		
		array[0] = new Buerger("Andi", Rang.BUERGER, null, null, true);
		array[1] = new Buerger("Gabrielle", Rang.FUERST, null, null, false);
		array[2] = new Buerger("Sigfried", Rang.FUERST, null, null, true);
		array[3] = new Buerger("Anton", Rang.FUERST, null, null, true);
		array[4] = new Buerger("Sigfried", Rang.BUERGER, null, null, true);
		array[5] = new Buerger("Fiona", Rang.FUERST, null, null, false);
		array[6] = new Buerger("Richard", Rang.FUERST, null, null, true);
		array[7] = new Buerger("Antonia", Rang.FUERST, null, null, false);
		array[8] = new Buerger("Peter", Rang.BUERGER, null, null, true);
		array[9] = new Buerger("Klee", Rang.ARBEITER, null, null, true);
		array[10] = new Buerger("Susi", Rang.ARBEITER, null, null, false);
		array[11] = new Buerger("Nelli", Rang.ARBEITER, null, null, false);
		array[12] = new Buerger("Sigi", Rang.ARBEITER, null, null, true);
		array[13] = new Buerger("Pia", Rang.ARBEITER, null, null, false);
		array[14] = new Buerger("Susanne", Rang.BUERGER, null, null, false);
		
		for(int i=0; i<array.length;i++)
		{
			k.geburt(array[i]);
		}
		
		Buerger[] array2 = k.volkszaehlung();
		
		for(int i=0; i<array2.length;i++)
		{
			array2[i].vorstellen();
		}
		
		System.out.println("\nEs wird exekutiert:\n");
		
		k.exekution("Antonia");
		
		array2 = k.volkszaehlung();
		
		for(int i=0; i<array2.length;i++)
		{
			array2[i].vorstellen();
		}
		
		System.out.println("\nNun startet die Suche1:\n");
		
		array2 = k.suche("Sigfried", null);
		
		for(int i=0; i<array2.length;i++)
		{
			array2[i].vorstellen();
		}
		
		System.out.println("\nNun startet die Suche2:\n");
		
		array2 = k.suche(null, Rang.BUERGER);
		
		for(int i=0; i<array2.length;i++)
		{
			array2[i].vorstellen();
		}
		
		System.out.println("\nNun startet die Suche3:\n");
		
		array2 = k.suche("Klee", Rang.ARBEITER);
		
		for(int i=0; i<array2.length;i++)
		{
			array2[i].vorstellen();
		}
		
		System.out.println("\nNun folgt die Revolution:\n");
		
		k.revolution(array[9]);
		array2 = k.volkszaehlung();
		
		for(int i=0; i<array2.length;i++)
		{
			array2[i].vorstellen();
		}
		
	}
}
