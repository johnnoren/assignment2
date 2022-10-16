package main;

import java.time.LocalDate;
import java.util.Objects;

public class Member {

	private final Name name;
	private final IdentityNumber identityNumber;
	private final LocalDate lastPaymentDate;

	public Member( IdentityNumber identityNumber, Name name, LocalDate lastPaymentDate) {
		this.name = name;
		this.identityNumber = identityNumber;
		this.lastPaymentDate = lastPaymentDate;
	}


	public Name getName() {
		return name;
	}

	public IdentityNumber getIdentityNumber() {
		return identityNumber;
	}

	public LocalDate getLastPaymentDate() {
		return lastPaymentDate;
	}

	@Override
	public String toString() {
		return "member.main.Member{" + "name=" + name + ", personalIdentityNumber=" + identityNumber + ", lastPaymentDate" + "=" + lastPaymentDate + '}';
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
