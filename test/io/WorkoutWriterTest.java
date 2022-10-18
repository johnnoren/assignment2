package io;

import main.IdentityNumber;
import main.Member;
import main.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkoutWriterTest {

	WorkoutWriter workoutWriter;
	StringWriter stringWriter = new StringWriter();

	@Test
	@DisplayName("A workout can be written to file.")
	void writeTest() {
		// Given
		var wantedOutput = "Workout: 7502031234, Anna Andersson, 2022-10-18\nWorkout: 8505132345, Per Persson, " +
				"2022-10-18\n";
		workoutWriter = new WorkoutWriter(stringWriter);

		// When
		workoutWriter.write(new Member(new IdentityNumber(7502031234L), new Name("Anna Andersson"), LocalDate.parse(
				"2022-05" + "-03")));
		workoutWriter.write(new Member(new IdentityNumber(8505132345L), new Name("Per Persson"), LocalDate.parse("2019" +
				"-12-29")));

		var resultFromWriting = stringWriter.toString();

		// Then
		assertEquals(resultFromWriting, wantedOutput);
	}
}