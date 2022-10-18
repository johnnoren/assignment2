package io;

import main.IdentityNumber;
import main.Member;
import main.Name;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkoutWriterTest {

	WorkoutWriter workoutWriter;
	StringWriter writtenMembers = new StringWriter();

	@Test
	void read() {
		// Given
		var stringWithMembers = "7502031234, Anna Andersson\n" + "2022-05-03\n" + "8505132345, Per Persson\n" + "2019" +
				"-12-29\n";
		workoutWriter = new WorkoutWriter(writtenMembers);

		// When
		workoutWriter.write(new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"), LocalDate.parse("2022-05" +
				"-03")));
		workoutWriter.write(new Member(new IdentityNumber(8505132345L), new Name("Per Persson"),
				LocalDate.parse("2019-12-29")));

		// Then
		assertEquals(writtenMembers.toString(), stringWithMembers);

	}
}