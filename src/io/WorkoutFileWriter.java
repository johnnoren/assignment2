package io;

import main.Member;

import java.io.*;
import java.time.LocalDate;
import java.util.stream.Stream;

public class WorkoutFileWriter {
	private final BufferedWriter writer;

	public WorkoutFileWriter(String fileName) throws IOException {
		this.writer = new BufferedWriter(new FileWriter(fileName));
	}

	public void write(Stream<Member> members) {
		members.forEach(member -> {
			var stringToWrite =
					"Workout: " + member.getIdentityNumber().toString() + ", " + member.getName().toString() + ", " + LocalDate.now();
			try {
				writer.append(stringToWrite);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
	}
}
