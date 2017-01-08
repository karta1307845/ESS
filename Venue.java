
final class Venue {
	String venueName;

	Venue() {
		venueName = "尚未選擇";
	}

	Venue(String venueName) {
		this.venueName = venueName;
	}

	public String toString() {
		return venueName;
	}
}
