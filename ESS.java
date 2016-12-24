import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class ESS {
	private static String[] fileName = { "時間表.txt", "比賽項目.txt", "場地.txt", "設備.txt", "選手.txt", "工作人員.txt" };
	private static String[] timeString;
	private static String[] eventString;
	private static String[] athleteString;
	private static String[] staffString;
	private static String[] venueString;
	private static String[] facilityString;

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

		JList<String> list1 = new JList<String>(timeString);
		list1.setBounds(40, 50, 120, 500);
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

		JButton button1 = new JButton("加入");
		button1.setBounds(350, 600, 100, 50);
		frame.getContentPane().add(button1);

		JButton button2 = new JButton("取消");
		button2.setBounds(550, 600, 100, 50);
		frame.getContentPane().add(button2);

		frame.setVisible(true);
		// frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	public static void getData() throws FileNotFoundException {
		for (int i = 0; i < fileName.length; i++) {
			File f = new File(fileName[i]);
			Scanner file = new Scanner(f);
			switch (i) {
			case 0:
				timeString = readFile(file);
				break;
			case 1:
				eventString = readFile(file);
				break;
			case 2:
				venueString = readFile(file);
				break;
			case 3:
				facilityString = readFile(file);
				break;
			case 4:
				athleteString = readFile(file);
				break;
			case 5:
				staffString = readFile(file);
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
