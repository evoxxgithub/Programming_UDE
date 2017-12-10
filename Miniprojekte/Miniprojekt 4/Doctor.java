public class Doctor extends Person {


	private static final String TITLE_STRING = "Dr. ";
	private String phdTopic;

	public Doctor(String firstName, String lastName, int yearOfBirth) {
		super(firstName, lastName, yearOfBirth);

	}

	public String getPhdTopic() {
		return phdTopic;
	}

	public void setPhdTopic(String phdTopic) {
		this.phdTopic = phdTopic;
	}

	public String getName() {
		return TITLE_STRING + super.getName();
	}
}
