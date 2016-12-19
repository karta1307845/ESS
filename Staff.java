
public class Staff {
	private String staffName;
	private String staffID;
	private String staffDuty;

	public Staff(String staffName, String staffID, String staffDuty) {
		this.staffName = staffName;
		this.staffID = staffID;
		this.staffDuty = staffDuty;
	}

	public void changeStaffDuty(String Duty) {
		staffDuty = Duty;
	}
}