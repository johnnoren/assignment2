package main;

import main.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

	Name name = new Name("Pippi Långstrump");

	@Test
	@DisplayName("A name can be converted into a string.")
	void toStringTest() {
		assert name.toString().equals("Pippi Långstrump");
	}
}
