package fifaChampionship;

import java.util.ArrayList;

public class Player implements Comparable<Player> {

	private String name;
	private int victories = 0, draws = 0, defeats = 0, points = 0, goalsFor = 0, goalsAgainst = 0,
			goalsDif = 0, gamesPlayed=0;

	private ArrayList<Integer> goalsFromTheRound = new ArrayList<>();

	public Player(String name) {
		super();
		this.name = name;
	}

	public Player(int goalsFor, int goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
		this.goalsFor = goalsFor;
	}

	public Player() {
		// Constructor for Last Calculus Methods.
	}

	public String getName() {
		return name;
	}

	public int getVictories() {
		return victories;
	}

	public void setVictories(int pointsReceived) {
		victories++;
		points += pointsReceived;
	}

	public int getDraws() {
		return draws;
	}

	public void setDraws(int pointsReceived) {
		draws++;
		points += pointsReceived;
	}

	public int getDefeats() {
		return defeats;
	}

	public void setDefeats() {
		defeats++;
	}

	public int getPoints() {
		return points;
	}


	public int getGoalsFor() {
		return goalsFor;
	}

	public void setGoalsFor(int goalsForReceived) {
		goalsFor += goalsForReceived;
		goalsFromTheRound.add(goalsForReceived);

	}

	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	public void setGoalsAgainst(int goalsAgainstReceived) {
		goalsAgainst += goalsAgainstReceived;
	}

	public int getGoalsDif() {
		goalsDif = goalsFor - goalsAgainst;

		return goalsDif;
	}

	public int getGoalsFromTheRound(int round) {

		return goalsFromTheRound.get(round);
	}

	
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed() {
		gamesPlayed++;
	}

	@Override
	//OrdenateClassification
	public int compareTo(Player player) {

		if(this.points > player.points) {
			return -1;
		}
		else if(this.points < player.points) {
			return 1;
		}
		else {
			
			if (this.victories > player.victories) {
				return -1;
			}
			else if (this.victories < player.victories) {
				return 1;
			}
			else {
					if (this.goalsDif > player.goalsDif) {
					return -1;
					}
					else if (this.goalsDif < player.goalsDif) {
						return 1;
					}
					else {
					if (this.goalsFor > player.goalsFor) {
					return -1;
					}
					else if (this.goalsFor < player.goalsFor) {
						return 1;
					}
					else {			
							if (this.goalsAgainst > player.goalsAgainst) {
							return 1;
						}
						else if (this.goalsAgainst < player.goalsAgainst) {
							return -1;
						}
						else {
							if (this.defeats > player.defeats) {
								return 1;
							}
							else if (this.defeats > player.defeats) {
								return -1;
							}
							else {

							return 0;
						}
							
							
						
					}
					
				}
				
			}
			
		}
		
	}

	
	
	
	
	}
	
	
	
}
