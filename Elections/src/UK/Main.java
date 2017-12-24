package UK;

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

		Nation england = new Nation("England");// Make sure same spelling as in CSV
		ArrayList<Double> newEnglishVote = new ArrayList<Double>();
		System.out.println("\nPlease enter English vote");

		Party EngCon = new Party("Conservatives", 0, 0, 0, 45.4, Nation.ConservateCSVColumn);
		england.parties.add(EngCon);
		Party EngLab = new Party("Labour", 0, 0, 0, 41.9, Nation.LabourCSVColumn);
		england.parties.add(EngLab);
		Party EngLD = new Party("Lib Dems", 0, 0, 0, 7.8, Nation.LibDemCSVColumn);
		england.parties.add(EngLD);
		Party EngUKIP = new Party("UKIP", 0, 0, 0, 2.1, Nation.UKIPCSVColumn);
		england.parties.add(EngUKIP);
		Party EngGreen = new Party("Green", 0, 0, 0, 1.9, Nation.GreenCSVColumn);
		england.parties.add(EngGreen);

		for (int i = 0; i < england.parties.size(); i++) {

			System.out.println(england.parties.get(i).getName() + ": ");
			newEnglishVote.add(scan.nextDouble());

		}

		Nation wales = new Nation("Wales");// Make sure same spelling as in CSV
		ArrayList<Double> newWelshVote = new ArrayList<Double>();
		System.out.println("\nPlease enter Welsh vote");

		Party WelCon = new Party("Conservatives", 0, 0, 0, 33.6, Nation.ConservateCSVColumn);
		wales.parties.add(WelCon);
		Party WelLab = new Party("Labour", 0, 0, 0, 48.9, Nation.LabourCSVColumn);
		wales.parties.add(WelLab);
		Party WelLD = new Party("Lib Dems", 0, 0, 0, 4.5, Nation.LibDemCSVColumn);
		wales.parties.add(WelLD);
		Party WelUKIP = new Party("UKIP", 0, 0, 0, 2.0, Nation.UKIPCSVColumn);
		wales.parties.add(WelUKIP);
		Party WelGreen = new Party("Green", 0, 0, 0, .3, Nation.GreenCSVColumn);
		wales.parties.add(WelGreen);
		Party Plaid = new Party("Plaid Cymru", 0, 0, 0, 10.4, Nation.PlaidCSVColumn);
		wales.parties.add(Plaid);

		for (int i = 0; i < wales.parties.size(); i++) {

			System.out.println(wales.parties.get(i).getName() + ": ");
			newWelshVote.add(scan.nextDouble());

		}

		Nation NorthernIreland = new Nation("Northern Ireland");// Make sure same spelling as in CSV
		ArrayList<Double> newNIrishVote = new ArrayList<Double>();
		System.out.println("\nPlease enter Northern Irish vote");

		Party NICon = new Party("Conservatives", 0, 0, 0, .5, Nation.ConservateCSVColumn);
		NorthernIreland.parties.add(NICon);
		Party DUP = new Party("DUP", 0, 0, 0, 36.0, Nation.DUPCSVColumn);
		NorthernIreland.parties.add(DUP);
		Party SinnFein = new Party("Sinn Féin", 0, 0, 0, 29.4, Nation.SinnFeinCSVColumn);
		NorthernIreland.parties.add(SinnFein);
		Party UUP = new Party("UUP", 0, 0, 0, 10.3, Nation.UUPCSVColumn);
		NorthernIreland.parties.add(UUP);
		Party NIGreen = new Party("Green", 0, 0, 0, .9, Nation.GreenCSVColumn);
		NorthernIreland.parties.add(NIGreen);
		Party SDLP = new Party("SDLP", 0, 0, 0, 11.7, Nation.SDLPCSVColumn);
		NorthernIreland.parties.add(SDLP);
		Party Alliance = new Party("Alliance", 0, 0, 0, 7.9, Nation.AllianceCSVColumn);
		NorthernIreland.parties.add(Alliance);

		for (int i = 0; i < NorthernIreland.parties.size(); i++) {

			System.out.println(NorthernIreland.parties.get(i).getName() + ": ");
			newNIrishVote.add(scan.nextDouble());

		}

		scan.close();

		scotland.setNewNationalVote(newScottishVote);
		scotland.calculate();
		scotland.printResults();
		scotland.printConstituencyResults();

		england.setNewNationalVote(newEnglishVote);
		england.calculate();
		england.printResults();
		england.printConstituencyResults();

		wales.setNewNationalVote(newWelshVote);
		wales.calculate();
		wales.printResults();
		wales.printConstituencyResults();

		NorthernIreland.setNewNationalVote(newNIrishVote);
		NorthernIreland.calculate();
		NorthernIreland.printResults();
		NorthernIreland.printConstituencyResults();

	}

}
