import java.util.ArrayList;
import java.util.List;

public class Timetable {
	private String[] date;
	private String[] time;
	private List<Event> event = new ArrayList<Event>();

	public Timetable(String[] date, String[] time) {
		this.date = date;
		this.time = time;
	}

	public void changeDate(String date, int index) {
		this.date[index] = date;
	}

	public void changeTime(String time, int index) {
		this.time[index] = time;
	}

	public void getEvent(Event eventName) {
		event.add(eventName);
	}
}
