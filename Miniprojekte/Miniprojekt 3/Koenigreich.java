import java.util.ArrayList;
import java.util.stream.Collectors;

public class Koenigreich {

	Person spitze;

	//Aufgabe 1
	public Koenigreich(String koenig)
	{
		//Bitte hier Code einfuegen.
		this.spitze = new Person(koenig, Rang.KOENIG, null, null, true);
	}
		
	//Aufgabe 2
	public void geburt(Person person)
	{
		//Bitte hier Code einfuegen.
        if (person != null && person.getRang() != Rang.KOENIG) this.sortIntoKingdomTree(person);
	}

    private void sortIntoKingdomTree(Person person) {
	    boolean personIsMale = person.getIstMaennlich();
	    Person treeAfterSex = (personIsMale)? this.spitze.getLinks() : this.spitze.getRechts();

	    if (treeAfterSex == null) {
	        if (personIsMale) this.spitze.setLinks(person);
	        else this.spitze.setRechts(person);
        }

        else if (treeAfterSex.getRang().ordinal() < person.getRang().ordinal()) {
	        person.setLinks(treeAfterSex);
	        if (personIsMale) this.spitze.setLinks(person);
	        else this.spitze.setRechts(person);
        }
        else this.sortAfterRank(person, treeAfterSex);
    }

    private void sortAfterRank(Person person, Person treeToPutInto) {
	    boolean putInRightSide = person.getRang().ordinal() == treeToPutInto.getRang().ordinal();
	    Person nextStepInTree = (putInRightSide)? treeToPutInto.getRechts() : treeToPutInto.getLinks();
	    if (nextStepInTree == null || nextStepInTree.getRang().ordinal() < person.getRang().ordinal()){
	        person.setLinks(nextStepInTree);
	        if (putInRightSide) treeToPutInto.setRechts(person);
	        else treeToPutInto.setLinks(person);
        }
        else sortAfterRank(person, nextStepInTree);
    }

    //Aufgabe 3
	public Person[] volkszaehlung()
	{
        if (spitze == null) return new Person[] {};

        ArrayList<Person> personList = getPeople();
        Person[] arrayToReturn = new Person[personList.size()];
		return personList.toArray(arrayToReturn);
	}

    private ArrayList<Person> getPeople() {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(this.spitze);

        if (this.spitze.getLinks() != null) this.addTreeToVolkszaehlung(this.spitze.getLinks(), personList);
        if (this.spitze.getRechts() != null) this.addTreeToVolkszaehlung(this.spitze.getRechts(), personList);
        return personList;
    }

    private void addTreeToVolkszaehlung(Person currentTree, ArrayList<Person> personList) {
	    personList.add(currentTree);
	    if (currentTree.getRechts() != null) addTreeToVolkszaehlung(currentTree.getRechts(), personList);
	    if (currentTree.getLinks() != null) addTreeToVolkszaehlung(currentTree.getLinks(), personList);
    }

    //Aufgabe 4
	public Person[] suche(String name, Rang rang)
	{
		//Bitte hier Code einfuegen.
        ArrayList<Person> people = this.getPeople();
        ArrayList<Person> filteredList = new ArrayList<>();

        people.stream()
                .filter(p -> name == null || p.getName().equals(name))
                .filter( p -> rang == null || p.getRang() == rang)
                .forEach(p -> filteredList.add(p));


        Person[] searchResultArray = new Person[filteredList.size()];
        filteredList.toArray(searchResultArray);
		return searchResultArray;
	}	
	
	//Aufgabe 5
	public void exekution(String name)
	{
        for (Person person : this.suche(name, null)) {
            if (person.getRang() != Rang.KOENIG) this.execute(person);
        }
    }

    private void execute(Person person) {
	    Person superPerson = searchForSuper(person);
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

    private Person searchForSuper(Person person) {

	    return searchForSuperInTree(person, this.spitze);
    }

    private Person searchForSuperInTree(Person person, Person currentTree) {
	    if (currentTree == null) return null;
	    if (currentTree.getRechts() == person || currentTree.getLinks() == person) return currentTree;

        Person foundInLeftTree = searchForSuperInTree(person, currentTree.getLinks());
        Person foundInRightTree = searchForSuperInTree(person, currentTree.getRechts());

        return (foundInLeftTree == null)? foundInRightTree : foundInLeftTree;
    }

    //Aufgabe 6
	public void revolution(Person person)
	{
		//Bitte hier Code einfuegen.
	}

	public static void main(String[] args)
	{
		Koenigreich k = new Koenigreich("Arthur");
		Person array[] = new Person[15];
		
		array[0] = new Person("Andi", Rang.BUERGER, null, null, true);
		array[1] = new Person("Gabrielle", Rang.FUERST, null, null, false);		
		array[2] = new Person("Sigfried", Rang.FUERST, null, null, true);		
		array[3] = new Person("Anton", Rang.FUERST, null, null, true);
		array[4] = new Person("Sigfried", Rang.BUERGER, null, null, true);
		array[5] = new Person("Fiona", Rang.FUERST, null, null, false);
		array[6] = new Person("Richard", Rang.FUERST, null, null, true);
		array[7] = new Person("Antonia", Rang.FUERST, null, null, false);
		array[8] = new Person("Peter", Rang.BUERGER, null, null, true);		
		array[9] = new Person("Klee", Rang.ARBEITER, null, null, true);
		array[10] = new Person("Susi", Rang.ARBEITER, null, null, false);
		array[11] = new Person("Nelli", Rang.ARBEITER, null, null, false);
		array[12] = new Person("Sigi", Rang.ARBEITER, null, null, true);
		array[13] = new Person("Pia", Rang.ARBEITER, null, null, false);				
		array[14] = new Person("Susanne", Rang.BUERGER, null, null, false);		
		
		for(int i=0; i<array.length;i++)
		{
			k.geburt(array[i]);
		}
		
		Person[] array2 = k.volkszaehlung();
		
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
