package io;

import main.IdentityNumber;
import main.Member;
import main.Name;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

public class MemberReader implements Closeable {

	private final Scanner scanner;

	public MemberReader(Reader reader) {
		this.scanner = new Scanner(new BufferedReader(reader));
	}

	public Stream<Member> read() {
		Stream.Builder<Member> stream = Stream.builder();
		scanner.useDelimiter(", |\\R+");
		while (scanner.hasNext()) {
			var identityNumber = new IdentityNumber(scanner.nextLong());
			var name = new Name(scanner.next());
			var date = LocalDate.parse(scanner.next());
			stream.add(new Member(identityNumber, name, date));
		}
		return stream.build();
	}

	@Override
	public void close() {
		scanner.close();
	}
}
