package fifaChampionship;

import java.util.ArrayList;
import java.util.Collections;

public class Control {

	// League mode for even number of players; 4,6,8,10..
	public static void main(String[] args) {

		UserInteraction ui = new UserInteraction();
		Calculus calculate = new Calculus();

		String firstPlace = null;

		int numberOfPlayers = ui.showIntegerMessage("Insert number of players: ");
		
		Player[] player = new Player[numberOfPlayers];
		

		for (int i = 0; i < player.length; i++) {
			String playerName = ui.showStringMessage("Insert player's name: ");
			playerName = calculate.expandNameTo12(playerName);
			player[i] = new Player(playerName);
		}

		// Match Ups;
		int round = 0; // 0 to 5
		String gamesString = "";
		String s = "";

		ArrayList<Player> pl = new ArrayList<>();
		for (int i = 0; i < calculate.calculateNumberOfGames(numberOfPlayers); i++) {

			ui.showMessage("        ROUND " + (i + 1) + "        ");

			calculate.chooseMatch(i);
			int x = calculate.team1id();
			int y = calculate.team2id();

			ui.showMessage(player[x].getName() + "  x  " + player[y].getName());

			player[x].setGoalsFor(ui.showIntegerMessage("Goals made by "+player[x].getName()+"-> "));
			player[y].setGoalsFor(ui.showIntegerMessage("Goals made by "+player[y].getName()+"-> "));
			player[x].setGoalsAgainst(player[y].getGoalsFromTheRound(round));
			player[y].setGoalsAgainst(player[x].getGoalsFromTheRound(round));
			player[x].setGamesPlayed();
			player[y].setGamesPlayed();

			
			if (player[x].getGoalsFromTheRound(round) > player[y].getGoalsFromTheRound(round)) {
				player[x].setVictories(3); // This 3 is the points the player won by winning
				player[y].setDefeats(); // 0 by losing;
			} else if (player[x].getGoalsFromTheRound(round) == player[y].getGoalsFromTheRound(round)) {
				player[x].setDraws(1); // 1 point by drawing
				player[y].setDraws(1);
			} else {
				player[y].setVictories(3);
				player[x].setDefeats();
			}
 
			s += player[x].getName() + " " + player[x].getGoalsFromTheRound(round) + " x" + " "
					+ player[y].getGoalsFromTheRound(round) + " " + player[y].getName() + "\n";

			
			/*
			 * As you increase the number of players by +2, add +1 on both sides; 
			 *  8 : players (i%4 == 3)
			 *  10: player (i%5 == 4)
			 */
			
			if (i % ((numberOfPlayers) / 2) == 2) {
				// ShowResults
				ui.showMessage("\nROUND " + (round + 1) + " GAMES \n" + s);
				gamesString += s + "\n"; // String for the end
				s = "";
				round++;
				
				for (int j = 0; j < player.length; j++) {
					pl.add(player[j]);
				}
			
				//Classification
				Collections.sort(pl);
				ui.showMessage("CLASSIFICATION");
				ui.showMessage("G = GAMES, F = GOALS FOR, A = GOALS AGAINST");
				ui.showMessage("    NAME       | G | V | D | L | F | A | PTS ");
				for (int k = 0; k < pl.size(); k++) {
					ui.showMessage((k + 1) + "|" + pl.get(k).getName() + "| " + pl.get(k).getGamesPlayed() + " | "
							 + pl.get(k).getVictories() + " | " + pl.get(k).getDraws() + " | "
							+ pl.get(k).getDefeats() + " | " + pl.get(k).getGoalsFor() + " | " + pl.get(k).getGoalsAgainst()
							+ " |  " +pl.get(k).getPoints() + " ");
				}
				firstPlace = pl.get(0).getName();
				pl.clear();
			}
		}

	
		calculate.getTotalGoals(player);

		// Return All the Matches Results;
		ui.showMessage("\nRESULTS\n" + gamesString);
		// Return Champion
		ui.showMessage("THE CHAMPION IS: " + firstPlace);
		
		ui.showMessage("NUMBER OF GOALS SCORED: " + calculate.getTotalNumberOfGoals());

	}

}
