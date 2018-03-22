package fifaChampionship;

import java.util.Scanner;

public class UserInteraction {

	Scanner ui = new Scanner(System.in);

	protected void showMessage(String message) {
		System.out.print(message + "\n");
	}

	protected int showIntegerMessage(String message) {
		System.out.print(message);
		int returnInt = ui.nextInt();
		return returnInt;
	}

	protected String showStringMessage(String message) {
		System.out.print(message);
		String returnString = ui.next();
		return returnString;
	}

}
