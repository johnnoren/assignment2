package main;

import java.io.FileReader;
import java.io.FileWriter;

public class BestGymEver {
	public static void main(String[] args) {
		new BestGymEver().run();
	}

	private void run() {

		var parser = new MemberParser();
		var memberReader = new FileReader("src/customers.txt");
		var memberWriter = new FileWriter("src/customers.txt");
		var workoutWriter = new FileWriter("src/workouts.txt");
		parser.parseFrom()





		// TODO Filter out members that paid within the last 12 months

		// TODO Filter out members that matches the result of UserInput.getNameOrIdentityNumber (use a singleton or
		//  similar so that it only asks until a valid format is received and then returns that every time it is called.

		// TODO Call a print method on every remaining object.

		// TODO For each remaining save to other file with todays date.

		// TODO Collect and if zero print no found.
	}
}
