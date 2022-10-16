import org.junit.jupiter.api.Test;

public class IdentityNumberTest {
	// TODO Test all public methods, including toString, equals etc.

	IdentityNumber identityNumber = new IdentityNumber(1234567890L);
	@Test
	void toStringTest() {
		assert identityNumber.toString()
							 .equals("1234567890");

	}
}
