package ireland;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Candidate.createAllCandidates();
		//Candidate.printAllCan();
		
		Count.createCandidates();
		///Count.printCandidates();
		Count.groupCounts();
		Count.printAllConstituencies();
		
		
		
	}

}
