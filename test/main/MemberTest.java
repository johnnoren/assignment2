package main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {

	@Test
	@DisplayName("A member can be matched through their name or identity number.")
	void matchesTest() {
		// Given
		Member member = new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"),
				LocalDate.parse("2022" + "-05" + "-03"));
		// When
		boolean result1 = member.matches("7502031234");
		boolean result2 = member.matches("Anna Andersson");
		boolean result3 = member.matches("not valid");
		// Then
		assertTrue(result1);
		assertTrue(result2);
		assertFalse(result3);
	}

	@Test
	@DisplayName("A member converted into a string includes information about whether the member is active or not")
	void toStringTest() {
		// Given
		Member activeMember = new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"),
				LocalDate.now().minusMonths(12));
		Member inactiveMember = new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"),
				LocalDate.now().minusMonths(13));
		var activeMemberString = "7502031234 Anna Andersson " + LocalDate.now().minusMonths(12) + " <-- " + "AKTIV\n";
		var inActiveMemberString = "7502031234 Anna Andersson " + LocalDate.now().minusMonths(13) + " <-- EJ AKTIV\n";
		// When
		var convertedActiveMemberString = activeMember.toString();
		var convertedInActiveMemberString = inactiveMember.toString();
		// Then
		assertEquals(convertedActiveMemberString, activeMemberString);
		assertEquals(convertedInActiveMemberString, inActiveMemberString);
	}

	@Test
	@DisplayName("A member with a payment date of more than 12 months ago is inactive.")
	void isActiveTest() {
		// Given
		Member activeMember = new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"),
				LocalDate.now().minusMonths(12));
		Member inactiveMember = new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"),
				LocalDate.now().minusMonths(13));

		// When
		var activeMemberResponse = activeMember.isActive();
		var inActiveMemberResponse = inactiveMember.isActive();
		// Then
		assertTrue(activeMemberResponse);
		assertFalse(inActiveMemberResponse);
	}
}
