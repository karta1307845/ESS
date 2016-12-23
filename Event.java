import java.util.ArrayList;
import java.util.List;

public class Event {
	private String eventName;
	private Venue venue;
	private List<Athlete> athlete = new ArrayList<Athlete>();
	private List<Staff> staff = new ArrayList<Staff>();

	public Event(String eventName) {
		this.eventName = eventName;
	}

	public void getVenue(Venue venueName) {
		venue = venueName;
	}

	public void getAthlete(Athlete athleteName) {
		athlete.add(athleteName);
	}

	public void getStaff(Staff staffName) {
		staff.add(staffName);
	}
}
