package io;

import main.IdentityNumber;
import main.Member;
import main.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class MemberReaderTest {

	MemberReader memberReader;
	List<Member> listWithMembers;

	@Test
	@DisplayName("Members can be read from file.")
	void readTest() {
		// Given
		var stringWithMembers =
				"7502031234, Anna Andersson\n" + "2022-05-03\n" + "8505132345, Per Persson\n" + "2019" + "-12-29\n";
		memberReader = new MemberReader(new StringReader(stringWithMembers));

		listWithMembers = new ArrayList<>();
		listWithMembers.add(new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"), LocalDate.parse(
				"2022-05" + "-03")));
		listWithMembers.add(new Member(new IdentityNumber(8505132345L), new Name("Per Persson"), LocalDate.parse("2019" +
				"-12-29")));

		// When
		List<Member> membersRead = memberReader.read().collect(Collectors.toList());

		// Then
		assertEquals(membersRead, listWithMembers);
	}
}