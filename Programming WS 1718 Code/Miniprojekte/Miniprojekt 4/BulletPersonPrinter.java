
public class BulletPersonPrinter extends PersonPrinter {

    private static final String LISTING_PREFIX = "* ";
    private static final String NEWLINE = "\n";

    @Override
    public void printNames(Person[] items) {

        StringBuilder stringBuilder = new StringBuilder();
        for (Person person : items) {

            stringBuilder.append(LISTING_PREFIX);
            stringBuilder.append(person.getName());
            stringBuilder.append(NEWLINE);
        }
        System.out.println(stringBuilder.toString());
    }
}
