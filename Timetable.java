import java.util.ArrayList;
import java.util.List;

public class Timetable {
	String date;
	String[] time;
	private List<Event> event = new ArrayList<Event>();

	public Timetable(String[] time) {
		this.time = time;
		date = time[0];
	}

	public void changeDate(String date) {
		this.date = date;
	}

	public void changeTime(String time, int index) {
		this.time[index] = time;
	}

	public void getEvent(Event eventName) {
		event.add(eventName);
	}
}
