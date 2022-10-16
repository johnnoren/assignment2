package main;

import java.util.Objects;

public class IdentityNumber {
	private Long number;

	public IdentityNumber(Long number) {
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
		IdentityNumber that = (IdentityNumber) o;
		return number.equals(that.number);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
