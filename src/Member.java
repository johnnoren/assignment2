import java.time.LocalDate;
import java.util.Objects;

public class Member implements Person {

	private final Name name;
	private final IdentityNumber identityNumber;
	private final LocalDate lastPaymentDate;

	private Member(IdentityNumber identityNumber, Name name, LocalDate lastPaymentDate) {
		this.name = name;
		this.identityNumber = identityNumber;
		this.lastPaymentDate = lastPaymentDate;
	}

	public Member create(String name, String identityNumber, String lastPaymentDate) {
		var parsedName = new Name(name);
		var parsedIdentityNumber = new IdentityNumber(Long.parseLong(identityNumber));
		var parsedDate = LocalDate.parse(lastPaymentDate);
		return new Member(parsedIdentityNumber, parsedName, parsedDate);
	}

	@Override
	public Name getName() {
		return name;
	}

	@Override
	public IdentityNumber getIdentityNumber() {
		return identityNumber;
	}

	public LocalDate getLastPaymentDate() {
		return lastPaymentDate;
	}

	@Override
	public String toString() {
		return "Member{" + "name=" + name + ", personalIdentityNumber=" + identityNumber + ", lastPaymentDate" + "=" + lastPaymentDate + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Member member = (Member) o;
		return name.equals(member.name) && identityNumber.equals(member.identityNumber) && lastPaymentDate.equals(member.lastPaymentDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, identityNumber, lastPaymentDate);
	}
}
