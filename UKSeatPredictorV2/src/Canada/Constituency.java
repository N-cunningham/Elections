package Canada;

import java.util.ArrayList;

public class Constituency {

	private ArrayList<Double> oldVote;
	private ArrayList<Double> newVote;
	private String nation;
	private String name;
	private String winner;
	private int winnerIndex;
	private double majority;
	ArrayList<Party> parties = new ArrayList<Party>();

	public Constituency(ArrayList<Double> oldVote, ArrayList<Double> newVote, String nation, String name, String winner,
			int winnerIndex, ArrayList<Party> parties, double majority) {

		this.oldVote = oldVote;
		this.newVote = newVote;
		this.nation = nation;
		this.name = name;
		this.winner = winner;
		this.winnerIndex = winnerIndex;
		this.parties = parties;

	}

	public ArrayList<Double> getNewVote() {
		return newVote;
	}

	public void setNewVote(ArrayList<Double> newVote) {
		this.newVote = newVote;
	}

	public String toString() {

		String res = "";
		int winningVote = newVote.get(winnerIndex).intValue();

		for (int i = 0; i < newVote.size(); i++) {

			if (newVote.get(i) != newVote.get(winnerIndex)) {
				
				

				res = res + parties.get(i).getName() + ": " + newVote.get(i).intValue() + "\t";//again name and vote mirror each others order but not explicitly linked

			}

		}

		return winner + " won " + name + "with " + winningVote + "votes and a majority of" +  majority  + "\n" + res;

	}
}
