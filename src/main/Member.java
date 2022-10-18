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

	@Override
	public String toString() {
		return identityNumber + " " + name + " " + lastPaymentDate + " <-- " + (lastPaymentDate.isAfter(LocalDate.now().minusYears(1)) ? "AKTIV" : "EJ AKTIV");
		// TODO Test this and in the test change the localdate for testmembers when I create them. Simple solution.
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

	public boolean matches(String s) {
		return s.equals(name.toString()) || s.equals(identityNumber.toString());
	}
}
