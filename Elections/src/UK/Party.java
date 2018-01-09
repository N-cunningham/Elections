package UK;

public class Party {

	private String name;
	private double oldVote;
	private double newVote;
	private double oldNationalVote;
	private int seats;
	private int CSVColumn;

	public Party(String name, double oldVote, double newVote, int seats, double oldNationalVote, int CSVColumn) {

		this.name = name;
		this.setOldVote(oldVote);
		this.setNewVote(newVote);
		this.setSeats(seats);
		this.oldNationalVote = oldNationalVote;
		this.CSVColumn = CSVColumn;

	}

	public int getCSVColumn() {
		return CSVColumn;
	}

	public void setCSVColumn(int cSVColumn) {
		CSVColumn = cSVColumn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getNewVote() {
		return newVote;
	}

	public void setNewVote(double newVote) {
		this.newVote = newVote;
	}

	public double getOldVote() {
		return oldVote;
	}

	public void setOldVote(double oldVote) {
		this.oldVote = oldVote;
	}

	public double getOldNationalVote() {
		return oldNationalVote;
	}

	public void setOldNationalVote(double oldNationalVote) {
		this.oldNationalVote = oldNationalVote;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void incSeats() {

		seats++;

	}
	



	

}
