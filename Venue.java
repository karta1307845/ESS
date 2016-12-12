
public class Venue {
	private String venueName;
	private String venueSize;

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

	public Facility getFacility(String facilityName) {
		Facility obj = new Facility(facilityName);
		return obj;
	}
}
