import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

public class MemberParser {
	private final Scanner scanner;
	private final StringBuilder stringBuilder = new StringBuilder();

	public MemberParser(Reader in) {
		this.scanner = new Scanner(in);
	}

	public Stream<Member> parse() {
		Stream.Builder<Member> stream = Stream.builder();
		int charRead;
		scanner.useDelimiter(", |\\R");
		while (scanner.hasNext()) {
			var personalIdentityNumber = new IdentityNumber(scanner.nextLong());
			var name = new Name(scanner.next());
			var date = LocalDate.parse(scanner.next());
			stream.add(new Member(personalIdentityNumber, name, date));
		}
		return stream.build();
	}
}
