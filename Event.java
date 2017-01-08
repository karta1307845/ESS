import java.util.ArrayList;
import java.util.List;

final class Event {
	String eventName;
	List<Venue> venueList = new ArrayList<Venue>();
	List<Time> timeList = new ArrayList<Time>();

	Event() {
		eventName = "尚未選擇";
	}

	Event(String eventName) {
		this.eventName = eventName;
	}

	public String toString() {
		return eventName;
	}

	Time[] sortTime(Time[] timeArray) {
		Time[] result = new Time[timeArray.length];
		for (int i = 0; i < timeList.size(); i++) {
			Time timeObj = timeList.get(i);
			for (int j = 0; j < timeArray.length; j++) {
				if (timeObj.equals(timeArray[j])) {
					result[j] = timeObj;
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			if (result[i] == null) {
				result[i] = new Time("尚未選擇");
			}
		}
		return result;
	}
}
