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
				var memberReader = new MemberReader(new FileReader("src/resources/customers.txt"));
				var workoutWriter = new WorkoutWriter(new FileWriter("src/resources/workouts.txt", true))
		) {

			System.out.println("Ange namn eller personnummer: ");
			var userInput = new Scanner(System.in).nextLine();
			memberReader.read()
					.filter(member -> member.matches(userInput))
					.peek(member -> System.out.println("Hittade medlem: " + member))
					.peek(member -> {
						if (member.isActive()) {
							workoutWriter.write(member);
						}
					})
					.findAny().ifPresentOrElse((m) -> System.out.println("Inga fler medlemmar matchade."),
								() -> System.out.println("Ingen medlem matchade."));
		} catch (Exception e) {
			System.out.println("Ett filfel inträffade.");
			System.exit(1);
		}
	}
}
