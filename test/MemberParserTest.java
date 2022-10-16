import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MemberParserTest {
	// TODO Test all public methods, including toString, equals etc.

	String testString;
	MemberParser memberParser;

	@BeforeEach
	void setup() {
		testString = "7502031234, Anna Andersson\n" + "2022-05-03\n" + "8505132345, Per Persson\n" + "2019-12-29\n";
		memberParser = new MemberParser(new StringReader(testString));
	}

	@Test
	@DisplayName("Should parse members from a passed reader.")
	void parse_ValidReaderPassed_MembersReturned() {
		// Given
		List<Member> members = new ArrayList<>();
		members.add(new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"), LocalDate.parse("2022-05" +
				"-03")));
		members.add(new Member(new IdentityNumber(8505132345L), new Name("Per Persson"),
				LocalDate.parse("2019-12-29")));
		// When
		List<Member> actualMembers = memberParser.parse()
												 .collect(Collectors.toList());
		// Then
		assertIterableEquals(members, actualMembers);
	}
}