package Canada;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Nation scotland = new Nation("Scotland");// Make sure same spelling as in CSV file
		ArrayList<Double> newScottishVote = new ArrayList<Double>();
		System.out.println("\nPlease enter Scottish vote");

		Party ScotCon = new Party("Conservatives", 0, 0, 0, 28.6, Nation.ConservateCSVColumn);
		scotland.parties.add(ScotCon);
		Party ScotLab = new Party("Labour", 0, 0, 0, 27.1, Nation.LabourCSVColumn);
		scotland.parties.add(ScotLab);
		Party ScotLD = new Party("Lib Dems", 0, 0, 0, 6.8, Nation.LibDemCSVColumn);
		scotland.parties.add(ScotLD);
		Party SNP = new Party("SNP", 0, 0, 0, 36.9, Nation.SNPCSVColumn);
		scotland.parties.add(SNP);

		for (int i = 0; i < scotland.parties.size(); i++) {

			System.out.println(scotland.parties.get(i).getName() + ": ");
			newScottishVote.add(scan.nextDouble());

		}

		
		scan.close();

		scotland.setNewNationalVote(newScottishVote);
		scotland.calculate();
		scotland.printResults();
		scotland.printConstituencyResults();

		

	}

}
