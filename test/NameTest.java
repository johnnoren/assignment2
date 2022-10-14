import org.junit.jupiter.api.Test;

public class NameTest {
	// TODO Test all public methods, including toString, equals etc.

	Name name = new Name("Pippi Långstrump");

	@Test
	void toStringTest() {
		assert name.toString()
				   .equals("Pippi Långstrump");
	}
}
