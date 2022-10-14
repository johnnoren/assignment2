import java.time.LocalDate;
import java.util.Objects;

public class Member implements Person {

	private final Name name;
	private final PersonalIdentityNumber personalIdentityNumber;
	private final LocalDate lastPaymentDate;

	public Member(PersonalIdentityNumber personalIdentityNumber, Name name, LocalDate lastPaymentDate) {
		this.name = name;
		this.personalIdentityNumber = personalIdentityNumber;
		this.lastPaymentDate = lastPaymentDate;
	}

	@Override
	public Name getName() {
		return name;
	}

	@Override
	public PersonalIdentityNumber getPersonalIdentityNumber() {
		return personalIdentityNumber;
	}

	public LocalDate getLastPaymentDate() {
		return lastPaymentDate;
	}

	@Override
	public String toString() {
		return "Member{" + "name=" + name + ", personalIdentityNumber=" + personalIdentityNumber + ", lastPaymentDate" +
				"=" + lastPaymentDate + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Member member = (Member) o;
		return name.equals(member.name) && personalIdentityNumber.equals(member.personalIdentityNumber) && lastPaymentDate.equals(member.lastPaymentDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, personalIdentityNumber, lastPaymentDate);
	}
}
