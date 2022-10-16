public class PersonalInformation implements Identifiable {
	private final Name name;
	private final IdentityNumber identityNumber;

	private PersonalInformation(Name name, IdentityNumber identityNumber) {
		this.name = name;
		this.identityNumber = identityNumber;
	}

	@Override
	public Name getName() {
		return name;
	}

	@Override
	public IdentityNumber getIdentityNumber() {
		return identityNumber;
	}
}
