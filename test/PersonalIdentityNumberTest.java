import org.junit.jupiter.api.Test;

public class PersonalIdentityNumberTest {
	// TODO Test all public methods, including toString, equals etc.

	PersonalIdentityNumber personalIdentityNumber = new PersonalIdentityNumber(1234567890L);
	@Test
	void toStringTest() {
		assert personalIdentityNumber.toString()
									 .equals("1234567890");

	}
}
