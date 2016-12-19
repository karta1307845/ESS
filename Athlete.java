
public class Athlete {
	private String athleteName;
	private int athleteAge;
	private String athleteID;
	private String eventName;

	public Athlete(String athleteName, int athleteAge, String athleteID, String eventName) {
		this.athleteName = athleteName;
		this.athleteAge = athleteAge;
		this.athleteID = athleteID;
		this.eventName = eventName;
	}

	public void changeAthleteName(String altheteName) {
		this.athleteName = altheteName;
	}

	public void changeAthleteAge(int athleteAge) {
		this.athleteAge = athleteAge;
	}

	public void changeAthleteID(String athleteID) {
		this.athleteID = athleteID;
	}

	public void changeEventName(String eventName) {
		this.eventName = eventName;
	}
}