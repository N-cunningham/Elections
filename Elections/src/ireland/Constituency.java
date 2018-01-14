package ireland;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Constituency {
	
	private ArrayList<Count> counts = new ArrayList<Count>();
	private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	private int number;
	
	public Constituency(int number, ArrayList<Candidate> candidates){
		
		this.number = number;
		this.candidates = candidates;
		
	}
	
	public String toString(){
		
		String res = "Constituency Number: " + number + "\n";
		
		
		for(int i = 0; i < candidates.size(); i++){
			
			res = res + " " + candidates.get(i).toString() + "\n";
			
		}
		
		
		return res + "\n";
		
	}
	
	
	public ArrayList<Candidate> getCandidates() {
		return candidates;
	}


	public void setCandidates(ArrayList<Candidate> candidates) {
		this.candidates = candidates;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public void createCounts() {

		
		for(int i = 0; i < Count.allCounts.size(); i++){
			
			if(counts.contains(Count.allCounts.get(i).getConstituencyNumber())){
				
				//add data to existing count
				
			}else{
				
				ArrayList<Candidate> candidates = new ArrayList<Candidate>();
				ArrayList<Count> counts = new ArrayList<Count>();
				
				int countNumber = Count.allCounts.get(i).getCountNumber();
				int constituencyNumber =  Count.allCounts.get(i).getConstituencyNumber();
				
				Count c = new Count(candidates, countNumber, constituencyNumber);
				counts.add(c);
				
				//Constituency con = new Constituency(Count.allCounts.get(i).getConstituencyNumber(), counts);
				
				
			}
			
		}
		
		
		
	}

}
