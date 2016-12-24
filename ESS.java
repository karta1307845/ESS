import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class ESS {
	private static String[] fileName = { "時間表.txt", "比賽項目.txt", "場地.txt", "設備.txt", "選手.txt", "工作人員.txt" };
	private static Timetable timetableObj;
	private static Event[] eventObj;
	private static Athlete[] athleteObj;
	private static Staff[] staffObj;
	private static Venue[] venueObj;
	private static Facility[] facilityObj;
	private static String[] timeString;
	private static String[] eventString;
	private static String[] venueString;
	private static String[] facilityString;
	private static String[] athleteString;
	private static String[] staffString;
	private static boolean[] eventRepeat;
	private static boolean[] venueRepeat;
	private static boolean[] facilityRepeat;
	private static boolean[] athleteRepeat;
	private static boolean[] staffRepeat;

	public static void main(String[] args) throws FileNotFoundException {
		getData();
		new ESS();
	}

	public ESS() {
		JFrame frame = new JFrame("賽程安排系統");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLayout(null);

		JLabel label1 = new JLabel("時間");
		label1.setBounds(90, 0, 200, 50);
		frame.getContentPane().add(label1);

		JLabel label2 = new JLabel("比賽項目");
		label2.setBounds(240, 0, 200, 50);
		frame.getContentPane().add(label2);

		JLabel label3 = new JLabel("場地");
		label3.setBounds(410, 0, 200, 50);
		frame.getContentPane().add(label3);

		JLabel label4 = new JLabel("設備");
		label4.setBounds(570, 0, 200, 50);
		frame.getContentPane().add(label4);

		JLabel label5 = new JLabel("選手");
		label5.setBounds(730, 0, 200, 50);
		frame.getContentPane().add(label5);

		JLabel label6 = new JLabel("工作人員");
		label6.setBounds(870, 0, 200, 50);
		frame.getContentPane().add(label6);

		JList<String> list1 = new JList<String>(timetableObj.time);
		list1.setBounds(40, 50, 120, 500);
		list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(list1);

		JList<String> list2 = new JList<String>(eventString);
		list2.setBounds(200, 50, 120, 500);
		frame.getContentPane().add(list2);

		JList<String> list3 = new JList<String>(venueString);
		list3.setBounds(360, 50, 120, 500);
		frame.getContentPane().add(list3);

		JList<String> list4 = new JList<String>(facilityString);
		list4.setBounds(520, 50, 120, 500);
		frame.getContentPane().add(list4);

		JList<String> list5 = new JList<String>(athleteString);
		list5.setBounds(680, 50, 120, 500);
		frame.getContentPane().add(list5);

		JList<String> list6 = new JList<String>(staffString);
		list6.setBounds(840, 50, 120, 500);
		frame.getContentPane().add(list6);

		JButton eventBtn1 = new JButton("加入");
		eventBtn1.setBounds(200, 550, 60, 30);
		frame.getContentPane().add(eventBtn1);

		JButton eventBtn2 = new JButton("取消");
		eventBtn2.setBounds(260, 550, 60, 30);
		frame.getContentPane().add(eventBtn2);

		JButton venueBtn1 = new JButton("加入");
		venueBtn1.setBounds(360, 550, 60, 30);
		frame.getContentPane().add(venueBtn1);

		JButton venueBtn2 = new JButton("取消");
		venueBtn2.setBounds(420, 550, 60, 30);
		frame.getContentPane().add(venueBtn2);

		JButton facilityBtn1 = new JButton("加入");
		facilityBtn1.setBounds(520, 550, 60, 30);
		frame.getContentPane().add(facilityBtn1);

		JButton facilityBtn2 = new JButton("取消");
		facilityBtn2.setBounds(580, 550, 60, 30);
		frame.getContentPane().add(facilityBtn2);

		JButton athleteBtn1 = new JButton("加入");
		athleteBtn1.setBounds(680, 550, 60, 30);
		frame.getContentPane().add(athleteBtn1);

		JButton athleteBtn2 = new JButton("取消");
		athleteBtn2.setBounds(740, 550, 60, 30);
		frame.getContentPane().add(athleteBtn2);

		JButton staffBtn1 = new JButton("加入");
		staffBtn1.setBounds(840, 550, 60, 30);
		frame.getContentPane().add(staffBtn1);

		JButton staffBtn2 = new JButton("取消");
		staffBtn2.setBounds(900, 550, 60, 30);
		frame.getContentPane().add(staffBtn2);

		eventBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = list1.getSelectedIndex();
				int index = list2.getSelectedIndex();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "請選擇比賽項目");
				} else if (number == -1 || number == 0) {
					JOptionPane.showMessageDialog(null, "請選擇時間");
				} else if (eventRepeat[index] == true) {
					JOptionPane.showMessageDialog(null, "該比賽項目已被選擇");
				} else {
					eventString[index] += "(" + number + ")";
					eventRepeat[index] = true;
				}
			}
		});

		eventBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list2.getSelectedIndex();
				if (eventRepeat[index] == true) {
					int length = eventString[index].length();
					eventString[index] = eventString[index].substring(0, length - 3);
				}
			}
		});

		venueBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = list1.getSelectedIndex();
				int index = list3.getSelectedIndex();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "請選擇場地");
				} else if (number == -1 || number == 0) {
					JOptionPane.showMessageDialog(null, "請選擇時間");
				} else if (venueRepeat[index] == true) {
					JOptionPane.showMessageDialog(null, "該場地已被選擇");
				} else {
					venueString[index] += "(" + number + ")";
					venueRepeat[index] = true;
				}
			}
		});

		venueBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list3.getSelectedIndex();
				if (venueRepeat[index] == true) {
					int length = venueString[index].length();
					venueString[index] = venueString[index].substring(0, length - 3);
				}
			}
		});

		facilityBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = list1.getSelectedIndex();
				int index = list4.getSelectedIndex();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "請選擇設備");
				} else if (number == -1 || number == 0) {
					JOptionPane.showMessageDialog(null, "請選擇時間");
				} else if (facilityRepeat[index] == true) {
					JOptionPane.showMessageDialog(null, "該設備已被選擇");
				} else {
					facilityString[index] += "(" + number + ")";
					facilityRepeat[index] = true;
				}
			}
		});

		facilityBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list4.getSelectedIndex();
				if (facilityRepeat[index] == true) {
					int length = facilityString[index].length();
					facilityString[index] = facilityString[index].substring(0, length - 3);
				}
			}
		});

		athleteBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = list1.getSelectedIndex();
				int index = list5.getSelectedIndex();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "請選擇選手");
				} else if (number == -1 || number == 0) {
					JOptionPane.showMessageDialog(null, "請選擇時間");
				} else if (athleteRepeat[index] == true) {
					JOptionPane.showMessageDialog(null, "該選手已被選擇");
				} else {
					athleteString[index] += "(" + number + ")";
					athleteRepeat[index] = true;
				}
			}
		});

		athleteBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list5.getSelectedIndex();
				if (athleteRepeat[index] == true) {
					int length = athleteString[index].length();
					athleteString[index] = athleteString[index].substring(0, length - 3);
				}
			}
		});

		staffBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = list1.getSelectedIndex();
				int index = list6.getSelectedIndex();
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "請選擇工作人員");
				} else if (number == -1 || number == 0) {
					JOptionPane.showMessageDialog(null, "請選擇時間");
				} else if (staffRepeat[index] == true) {
					JOptionPane.showMessageDialog(null, "該工作人員已被選擇");
				} else {
					staffString[index] += "(" + number + ")";
					staffRepeat[index] = true;
				}
			}
		});

		staffBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = list6.getSelectedIndex();
				if (staffRepeat[index] == true) {
					int length = staffString[index].length();
					staffString[index] = staffString[index].substring(0, length - 3);
				}
			}
		});

		frame.setVisible(true);
	}

	public static void getData() throws FileNotFoundException {
		for (int i = 0; i < fileName.length; i++) {
			File f = new File(fileName[i]);
			Scanner file = new Scanner(f);
			List<Object> obj = new ArrayList<Object>();
			switch (i) {
			case 0:
				timeString = readFile(file);
				for (int j = 1; j < timeString.length; j++) {
					timeString[j] += " (" + j + ")";
				}
				timetableObj = new Timetable(timeString);
				break;
			case 1:
				eventString = readFile(file);
				eventRepeat = new boolean[eventString.length];
				for (int j = 0; j < eventString.length; j++) {
					obj.add(new Event(eventString[j]));
				}
				eventObj = new Event[obj.size()];
				obj.toArray(eventObj);
				break;
			case 2:
				venueString = readFile(file);
				venueRepeat = new boolean[venueString.length];
				for (int j = 0; j < venueString.length; j++) {
					obj.add(new Venue(venueString[j]));
				}
				venueObj = new Venue[obj.size()];
				obj.toArray(venueObj);
				break;
			case 3:
				facilityString = readFile(file);
				facilityRepeat = new boolean[facilityString.length];
				for (int j = 0; j < facilityString.length; j++) {
					obj.add(new Facility(facilityString[j]));
				}
				facilityObj = new Facility[obj.size()];
				obj.toArray(facilityObj);
				break;
			case 4:
				athleteString = readFile(file);
				athleteRepeat = new boolean[athleteString.length];
				for (int j = 0; j < athleteString.length; j++) {
					obj.add(new Athlete(athleteString[j]));
				}
				athleteObj = new Athlete[obj.size()];
				obj.toArray(athleteObj);
				break;
			case 5:
				staffString = readFile(file);
				staffRepeat = new boolean[staffString.length];
				for (int j = 0; j < staffString.length; j++) {
					obj.add(new Staff(staffString[j]));
				}
				staffObj = new Staff[obj.size()];
				obj.toArray(staffObj);
				break;
			}
		}
	}

	private static String[] readFile(Scanner file) {
		List<String> list = new ArrayList<String>();
		while (file.hasNext()) {
			list.add(file.nextLine());
		}
		String[] str = new String[list.size()];
		list.toArray(str);
		return str;
	}
}
