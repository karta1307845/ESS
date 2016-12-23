import java.util.ArrayList;
import java.util.List;

public class Venue {
	private String venueName;
	private String venueSize;
	private List<Facility> facility = new ArrayList<Facility>();

	public Venue(String venueName, String venueSize) {
		this.venueName = venueName;
		this.venueSize = venueSize;
	}

	public void changeVenueName(String venueName) {
		this.venueName = venueName;
	}

	public void changeVenueSize(String venueSize) {
		this.venueSize = venueSize;
	}

	public void getFacility(Facility facilityName) {
		facility.add(facilityName);
	}
}
