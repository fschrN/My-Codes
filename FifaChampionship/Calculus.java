package fifaChampionship;

public class Calculus  {

	public Calculus() {
	}

	private int teamA, teamB;
	private int totalNumberOfGoals = 0;


	public String expandNameTo12 (String name) {
		
		for(int i = name.length(); i <= 12; i++) {
			name += " ";
		}
		
		return name;
	}
	
	
	public int calculateNumberOfGames(int playersQty) {
		int numerator = factorial(playersQty);
		int denominator = factorial(playersQty - 2);

		return (numerator / (2 * denominator));
	}

	public int factorial(int number) {
		int factorial = 1;
		for (int i = 1; i <= number; i++)
			factorial *= i;

		return factorial;
	}

	public void chooseMatch(int i /* Received from for */) {
		/*
		 * This logic is made manually using the number of games
		 * ==(numerator/(2*denominator); In this case, 15 matches (6 people)
		 */

		switch (i) {

		case 0:
			teamA = 5;
			teamB = 4;
			break;
		case 1:
			teamA = 3;
			teamB = 2;
			break;
		case 2:
			teamA = 0;
			teamB = 1;
			break;

		case 3:
			teamA = 1;
			teamB = 4;
			break;
		case 4:
			teamA = 3;
			teamB = 5;
			break;
		case 5:
			teamA = 2;
			teamB = 0;
			break;

		case 6:
			teamA = 5;
			teamB = 1;
			break;
		case 7:
			teamA = 2;
			teamB = 4;
			break;
		case 8:
			teamA = 0;
			teamB = 3;
			break;

		case 9:
			teamA = 2;
			teamB = 5;
			break;
		case 10:
			teamA = 4;
			teamB = 0;
			break;
		case 11:
			teamA = 1;
			teamB = 3;
			break;

		case 12:
			teamA = 0;
			teamB = 5;
			break;
		case 13:
			teamA = 2;
			teamB = 1;
			break;
		case 14:
			teamA = 4;
			teamB = 3;
			break;

		}

	}

	public int team1id() {
		return teamA;
	}

	public int team2id() {
		return teamB;
	}

	
	
	public void getTotalGoals(Player [] player) {

		for (int i = 0; i < player.length; i++) 
			
						
			totalNumberOfGoals += player[i].getGoalsFor();
		
		
	}


	public int getTotalNumberOfGoals() {
		return totalNumberOfGoals;
	}

	

	
	
	

}
