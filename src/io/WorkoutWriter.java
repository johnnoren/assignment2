package io;

import main.Member;

import java.io.*;
import java.time.LocalDate;

public class WorkoutWriter implements Closeable {
	private BufferedWriter writer;

	public WorkoutWriter(Writer writer) {
		this.writer = new BufferedWriter(writer);
	}

	public void write(Member member) {
		var stringToWrite =
				"Workout: " + member.getIdentityNumber().toString() + ", " + member.getName().toString() + ", " + LocalDate.now() + "\n";
		try {
			writer.append(stringToWrite);
			writer.flush();
		} catch (IOException e) {
			System.out.println("Det gick inte att skriva till filen.");
			;
			System.exit(1);
		}
		;
	}

	@Override
	public void close() throws IOException {
		writer.close();
	}
}
