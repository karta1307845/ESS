import java.util.ArrayList;
import java.util.List;

final class Time {
	String timeString;
	List<Event> eventList = new ArrayList<Event>();

	Time() {
		timeString = "尚未選擇";
	}

	Time(String time) {
		this.timeString = time;
	}

	public String toString() {
		return timeString;
	}
}
