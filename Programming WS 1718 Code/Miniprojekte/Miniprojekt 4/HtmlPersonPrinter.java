public class HtmlPersonPrinter extends PersonPrinter{

    private enum Wrappers {

        LIST_START("<ul>\n"), ITEM_START("<li>"), ITEM_END("</li>\n"), LIST_END("</ul>\n");

        private String value;

        Wrappers(String value) {
            this.value = value;
        }


        @Override
        public String toString() {
            return this.value;
        }
    }

    @Override
    public void printNames(Person[] items) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Wrappers.LIST_START);
        for (Person person : items) {
            stringBuilder.append(Wrappers.ITEM_START);
            stringBuilder.append(person.getName());
            stringBuilder.append(Wrappers.ITEM_END);

        }

        stringBuilder.append(Wrappers.LIST_END);

        System.out.println(stringBuilder.toString());

    }
}
