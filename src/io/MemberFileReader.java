package io;

import main.IdentityNumber;
import main.Member;
import main.Name;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

public class MemberFileReader {

	private final Scanner scanner;

	public MemberFileReader(String fileName) throws FileNotFoundException {
		this.scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
	}

	public Stream<Member> read() {
		Stream.Builder<Member> stream = Stream.builder();
		scanner.useDelimiter(", |\\R");
		while (scanner.hasNext()) {
			var identityNumber = new IdentityNumber(scanner.nextLong());
			var name = new Name(scanner.next());
			var date = LocalDate.parse(scanner.next());
			stream.add(new Member(identityNumber, name, date));
		}
		return stream.build();
	}
}
