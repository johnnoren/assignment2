package main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemberTest {
	// TODO Test the rest of the important things in the class if any.

	@Test
	@DisplayName("A member can be matched through their name or identity number.")
	void matches_WithStringMatchingNameOrIdentityNumber_ShouldReturnTrue() {
		// Given
		Member member = new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"), LocalDate.parse(
				"2022-05" +
				"-03"));

		// When
		boolean result1 = member.matches("7502031234");
		boolean result2 = member.matches("Anna Andersson");
		boolean result3 = member.matches("not valid");

		// Then
		assertTrue(result1);
		assertTrue(result2);
		assertFalse(result3);
	}
}
