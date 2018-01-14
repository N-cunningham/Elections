package ireland;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Candidate {
	
	public static ArrayList<Candidate> allCandidates = new  ArrayList<Candidate>();
	private String name;
	private String party;
	private int vote;
	private int candidateID;
	private int constituencyNumber;
	private int countNumber;
	
	
	public int getConstituencyNumber() {
		return constituencyNumber;
	}



	public void setConstituencyNumber(int constituencyNumber) {
		this.constituencyNumber = constituencyNumber;
	}



	Candidate(String name, String party, int vote, int candidateID, int constituencyNumber, int countNumber){
		
		this.name = name; 
		this.party = party;		
		this.vote = vote;
		this.candidateID = candidateID;
		this.constituencyNumber = constituencyNumber;
		this.countNumber = countNumber;
		
	}



	public int getCountNumber() {
		return countNumber;
	}



	public void setCountNumber(int countNumber) {
		this.countNumber = countNumber;
	}



	public String getName() {
		return name;
	}
	
	
	
	public String getParty() {
		return party;
	}



	public void setParty(String party) {
		this.party = party;
	}



	public int getVote() {
		return vote;
	}



	public void setVote(int vote) {
		this.vote = vote;
	}
	
	
	
	
		
		
	public static void createAllCandidates(){
		
		String csvFile = "/Users/Niall_cunningham/Desktop/ExelSheets/GenEle2016CandidateDetails.csv";
		BufferedReader br = null;
		String line = "	";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(csvFile));

			String header = br.readLine();
			ArrayList<Integer> IDs = new ArrayList<Integer>();

			while ((line = br.readLine()) != null) {

				String[] candidateDetails = line.split(cvsSplitBy);
				
					Candidate c = new Candidate(candidateDetails[2] + " " + candidateDetails[1], candidateDetails[4], 0, Integer.parseInt(candidateDetails[11]),Integer.parseInt(candidateDetails[12]), 0 );
					allCandidates.add(c);
					
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void printAllCan(){
		
		
		for(int i = 0; i < allCandidates.size(); i++){
			
			System.out.println(allCandidates.get(i).toString());
			
		}
		
		
	}
	
	public String toString(){
		
		
		String res = candidateID + " " + name + " " + party + " " + vote + " " +/*constituencyNumber + " "*/ + countNumber;
		
		
		return res;
		
		
		
	}
		
	
	
	
}
