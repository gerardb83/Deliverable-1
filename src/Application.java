import java.util.Scanner;

public class Application {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String eventType = "";
		String mealSuggestion = "";
		String prepSuggestion = "";
		String result = "";
		String participants = "participants";
		int partySize = -1;
		int i = 0;

		System.out.println("This program helps you plan your next dinner event.");

		// Standardizes eventType input for spaces and capitals
		do {
			if (i > 0) {
				System.out.println("Sorry, the options are (causual, semi-formal, or formal): ");
			}
			System.out.println("\nPlease enter the event type below (causual, semi-formal, or formal): ");
			eventType = input.nextLine();
			eventType = eventType.toLowerCase();
			while (eventType.indexOf(" ") != -1) {
				eventType = eventType.replace(" ", "");
			}
			++i;
		} while ((!eventType.equals("casual")) && (!eventType.equals("semi-formal")) && (!eventType.equals("formal")));

		// Checks for positive partySize integer input
		do {
			System.out.println("How many guests are you expecting? ");
			if (input.hasNextInt()) {
				partySize = input.nextInt();
			}
			else {
				System.out.println("\nPlease enter a positive number: ");
				input.nextLine();
			}
		} while (partySize < 1);

		// Conditionals determining mealSuggestion
		if (eventType.equals("casual")) {
			mealSuggestion = "sandwhiches";
		} else if (eventType.equals("semi-formal")) {
			mealSuggestion = "fried chicken";
		} else {
			mealSuggestion = "chicken parmesan";
		}

		// Conditionals determining participants plurality and prepSuggestion
		if (partySize < 2) {
			prepSuggestion = "in the microwave";
			participants = "participant";
		} else if (partySize < 13) {
			prepSuggestion = "in your kitchen";
		} else {
			prepSuggestion = "by a caterer";
		}

		// Outputs final result
		result = ("Since you're hosting a " + eventType + " event for " + partySize + " " + participants
				+ ", you should serve " + mealSuggestion + " prepared " + prepSuggestion + ".");
		System.out.println(result);

		input.close();
	}
}
