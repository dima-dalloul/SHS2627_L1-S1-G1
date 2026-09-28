import java.util.*;

public class TP2 {

	public static void main(String[] args) {
		int hours, minutes, seconds;
		Scanner scanner = new Scanner(System.in);

		System.out.println("How many hours?");
		hours = scanner.nextInt();

		System.out.println("How many minutes?");
		minutes = scanner.nextInt();

		System.out.println("How many seconds?");
		seconds = scanner.nextInt();
		
		// Troll check
		if(hours < 0 || hours > 24 ||
				minutes < 0 || minutes > 60 ||
				seconds < 0 || seconds > 60)
			System.out.println("You're a little troll, aren't you?");
		else {
			// The user is serious, so we can compute his sentence
			// Part of the sentence that doesn't change
			System.out.print("It is ");

			// Hour section
			if(hours != 0) {
				if(hours == 1)
					System.out.print(hours + " hour, ");
				else 
					System.out.print(hours + " hours, ");
			}

			// Minute section
			if(minutes != 0) {
				if(minutes == 1)
					System.out.print(minutes + " minute ");
				else 
					System.out.print(minutes + " minutes ");
			}
				
			// Second section
			if(seconds != 0) {
				if(seconds == 1)
					System.out.print("and " + seconds + " second");
				else
					System.out.print("and " + seconds + " seconds");
			}
				

			// End of the sentence
			System.out.print(".");
		}
	}

}
