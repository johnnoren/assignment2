import org.junit.jupiter.api.Test;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class MemberParserTest {
	// TODO Test all public methods, including toString, equals etc.

	String testString = "7502031234, Anna Andersson\n" + "2022-05-03\n" + "8505132345, Per Persson\n" + "2019-12-29\n";

	MemberParser memberParser = new MemberParser(new StringReader(testString));

	@Test
	void parseTest() {
		List<Member> expectedMembers = new ArrayList<>();
		expectedMembers.add(new Member(new PersonalIdentityNumber(7502031234L),new Name("Anna Andersson"), LocalDate.parse("2022-05-03")));
		expectedMembers.add(new Member(new PersonalIdentityNumber(8505132345L),new Name("Per Persson"), LocalDate.parse("2019-12-29")));

		assert memberParser.parse().allMatch(expectedMembers::contains);

	}
}