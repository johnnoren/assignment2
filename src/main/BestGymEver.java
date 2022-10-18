package main;

import io.MemberReader;
import io.WorkoutWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class BestGymEver {
	public static void main(String[] args) {
		new BestGymEver().run();
	}

	private void run() {
		try (
				var memberFileReader = new MemberReader(new FileReader("src/customers.txt"));
				var workoutFileWriter = new WorkoutWriter(new FileWriter("src/workouts.txt"))
		) {

			System.out.println("Ange namn eller personnummer: ");
			var userInput = new Scanner(System.in).nextLine();;
			memberFileReader.read()
					.filter(member -> member.matches(userInput))
					.peek(member -> System.out.println("Hittade medlem: " + member))
					.peek(workoutFileWriter::write)
					.findAny().ifPresentOrElse((m) -> System.out.println("Inga fler medlemmar matchade."),
									() -> System.out.println("Ingen medlem matchade."));
		} catch (Exception e) {
			System.out.println("Ett filfel inträffade.");
			System.exit(1);
		}
	}
}
