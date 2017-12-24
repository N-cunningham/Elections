package UK;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Nation {

	protected static final int ConservateCSVColumn = 15;
	protected static final int LabourCSVColumn = 16;
	protected static final int LibDemCSVColumn = 17;
	protected static final int SNPCSVColumn = 20;
	protected static final int UKIPCSVColumn = 18;
	protected static final int GreenCSVColumn = 19;
	protected static final int PlaidCSVColumn = 21;
	protected static final int DUPCSVColumn = 22;
	protected static final int SinnFeinCSVColumn = 23;
	protected static final int UUPCSVColumn = 25;
	protected static final int SDLPCSVColumn = 24;
	protected static final int AllianceCSVColumn = 26;
	protected static final int independeantCSVColumn = 27;
	private String name;

	ArrayList<Party> parties = new ArrayList<Party>();
	ArrayList<Constituency> Constituencies = new ArrayList<Constituency>();
	ArrayList<Double> newNationalVote;

	public ArrayList<Double> getNewNationalVote() {
		return newNationalVote;
	}

	public void setNewNationalVote(ArrayList<Double> newNationalVote) {
		this.newNationalVote = newNationalVote;
	}

	public Nation(String name) {

		this.name = name;
	}

	public void calculate() {

		String csvFile = "/Users/Niall_cunningham/Downloads/HoC-GE2017-constituency-results.csv";
		BufferedReader br = null;
		String line = "	";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));

			while ((line = br.readLine()) != null) {

				ArrayList<Double> oldVote = new ArrayList<Double>(parties.size());
				ArrayList<Double> newVote = new ArrayList<Double>(parties.size());

				String[] vote = line.split(cvsSplitBy);

				if (vote[5].contains(name) && (!vote[9].contains("Spk"))) {//prevents Speakers seat being calculated, Uncontested by major parties

					for (int i = 0; i < parties.size(); i++) {

						parties.get(i).setOldVote(Integer.parseInt(vote[parties.get(i).getCSVColumn()]));
						oldVote.add(parties.get(i).getOldVote());
						newVote.add(((parties.get(i).getOldVote())
								* ((newNationalVote.get(i) / parties.get(i).getOldNationalVote()))));
						parties.get(i).setNewVote(newVote.get(i));//This assumes noting in newVote before first add called, .get(i) mirrors the .add process but are not explicitly link, this may lead to errors in weird circumstances but shouldn't so keep an eye on this

					}

					int maxIndex = getMax();
					int secondIndex = getSecond();					
					parties.get(maxIndex).incSeats();
					String winnerName = parties.get(maxIndex).getName();
					double majority = ((parties.get(maxIndex).getNewVote()) - (parties.get(secondIndex).getNewVote()));				
					Constituency c = new Constituency(oldVote, newVote, name, vote[2], winnerName, maxIndex, parties, majority);
					Constituencies.add(c);

				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void printResults() {

		System.out.println("\n" + name + " Results:");

		for (int i = 0; i < parties.size(); i++) {

			System.out.println(parties.get(i).getName() + " " + parties.get(i).getSeats());

		}

	}

	void printConstituencyResults() {

		System.out.println(name + " Constituency Results\n");

		for (int i = 0; i < Constituencies.size(); i++) {

			System.out.println(Constituencies.get(i).toString() + "\n");

		}

	}

	int getMax() {

		double currentMax = 0;
		int indexMax = 0;

		for (int i = 0; i < parties.size(); i++) {

			if (parties.get(i).getNewVote() > currentMax) {
				currentMax = parties.get(i).getNewVote();
				indexMax = i;
			}

		}

		return indexMax;

	}
	
	int getSecond() {

		double currentMax = 0;
		double currentSecond = 0;
		int SecondIndex = 0;		

		for (int i = 0; i < parties.size(); i++) {

			if (parties.get(i).getNewVote() > currentMax) {
				currentMax = parties.get(i).getNewVote();
				
			}

		}
				
		for (int i = 0; i < parties.size(); i++) {

			if(parties.get(i).getNewVote() < currentMax && parties.get(i).getNewVote() > currentSecond){
				
				currentSecond = parties.get(i).getNewVote();
				SecondIndex = i; 
				
			}

		}

		return SecondIndex;

	}

}
