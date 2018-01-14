package ireland;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Count {

	public static ArrayList<Candidate> allCounts = new ArrayList<Candidate>();
	public static ArrayList<Constituency> allConstituencies = new ArrayList<Constituency>();
	static ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	private int countNumber;
	private int constituencyID;

	public Count(ArrayList<Candidate> candidates, int countNumber, int constituencyID) {

		this.countNumber = countNumber;
		this.candidates = candidates;
		this.constituencyID = constituencyID;

	}

	public int getCountNumber() {
		return countNumber;
	}

	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}

	public static void createCandidates() {

		String csvFile = "/Users/Niall_cunningham/Desktop/ExelSheets/GenEle2016CountDetails.csv";
		BufferedReader br = null;
		String line = "	";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));

			String header = br.readLine();
			ArrayList<Integer> IDs = new ArrayList<Integer>();

			while ((line = br.readLine()) != null) {

				String[] candidateDetails = line.split(cvsSplitBy);

				String candidateName = candidateDetails[2] + " " + candidateDetails[1];
				String partyName = findCandidateParty(candidateName);
				int candidateID = Integer.parseInt(candidateDetails[13]);
				int votes = Integer.parseInt(candidateDetails[11]);
				int constituencyID = Integer.parseInt(candidateDetails[12]);
				int conuntNumber = Integer.parseInt(candidateDetails[4]);

				Candidate c = new Candidate(candidateName, partyName, votes, candidateID, constituencyID, conuntNumber);
				allCounts.add(c);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String findCandidateParty(String candidateName) {

		for (int i = 0; i < Candidate.allCandidates.size(); i++) {

			if (Candidate.allCandidates.get(i).getName().contains(candidateName)) {

				return Candidate.allCandidates.get(i).getParty();

			}

		}

		return null;

	}

	public static void printCandidates() {

		for (int i = 0; i < allCounts.size(); i++) {

			System.out.println(allCounts.get(i).toString());

		}

	}

	public static void groupCounts() {

		for (int i = 0; i < allCounts.size(); i++) {

			int ConsNum = allCounts.get(i).getConstituencyNumber();

			if (i == 0) {
				ArrayList<Candidate> can = new ArrayList<Candidate>();
				can.add(allCounts.get(i));
				Constituency con = new Constituency(ConsNum, can);
				allConstituencies.add(con);

			} else {

				int numberOfFailuers = 0;

				for (int j = 0; j < allConstituencies.size(); j++) {

					if (allConstituencies.get(j).getNumber() == ConsNum) {

						allConstituencies.get(j).getCandidates().add(allCounts.get(i));
						break;

					} else {

						numberOfFailuers++;

					}

				}

				if (numberOfFailuers == allConstituencies.size()) {

					ArrayList<Candidate> can = new ArrayList<Candidate>();
					can.add(allCounts.get(i));
					Constituency con = new Constituency(ConsNum, can);
					allConstituencies.add(con);

				}

			}

			allCounts.get(i);

		}

	}
	
	public static void printAllConstituencies(){
		
		for(int i = 0; i < allConstituencies.size(); i++){
			
			System.out.println(allConstituencies.get(i).toString() + "\n");
			
		}
		
	}
	
	

	public int getConstituencyID() {
		return constituencyID;
	}

}
