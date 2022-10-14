import java.util.Objects;

public class PersonalIdentityNumber {
	private Long number;

	public PersonalIdentityNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return number.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PersonalIdentityNumber that = (PersonalIdentityNumber) o;
		return number.equals(that.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
