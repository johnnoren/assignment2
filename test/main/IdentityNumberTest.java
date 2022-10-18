package main;

import main.IdentityNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IdentityNumberTest {

	IdentityNumber identityNumber = new IdentityNumber(1234567890L);
	@Test
	@DisplayName("An identity number can be converted into a string.")
	void toStringTest() {
		assert identityNumber.toString().equals("1234567890");
	}
}
