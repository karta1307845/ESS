
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

final class Frame extends JFrame {
	private SchedulePanel left = new SchedulePanel();
	private TimetablePanel right = new TimetablePanel();
	static private Time[] timeArray;
	static private Event[] eventArray;
	static private Venue[] venueArray;
	static private Country[] countryArray;

	Frame() {
		getData();
		left.resetBox1(timeArray);
		left.resetBox2(eventArray);
		left.resetBox3(venueArray);

		right.box.addItem(new Event());
		for (Event i : eventArray) {
			right.box.addItem(i);
		}
		setLayout(new GridLayout(1, 2));
		add(left);
		add(right);

		left.box1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Time timeObj = (Time) left.boxMod1.getSelectedItem();
				left.lab4.setText("時間 : " + timeObj.timeString);
				left.resetBox2(eventArray);
				left.resetBox3(venueArray);
				left.model.clear();
				for (int i = 0; i < timeObj.eventList.size(); i++) {
					Event eventObj = timeObj.eventList.get(i);
					int timeIndex = eventObj.timeList.indexOf(timeObj);
					left.model.addElement(eventObj.eventName + "  " + eventObj.venueList.get(timeIndex).venueName);
					left.boxMod3.removeElement(eventObj.venueList.get(timeIndex));
					left.boxMod2.removeElement(eventObj);
				}
			}
		});

		left.btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Time timeObj = (Time) left.boxMod1.getSelectedItem();
				Event eventObj = (Event) left.boxMod2.getSelectedItem();

				if (!timeObj.timeString.equals("尚未選擇") && !eventObj.eventName.equals("尚未選擇")) {
					timeObj.eventList.add(eventObj);
					eventObj.timeList.add(timeObj);
					eventObj.venueList.add(new Venue("尚未選擇"));
					int timeIndex = eventObj.timeList.indexOf(timeObj);
					left.model.addElement(eventObj.eventName + "  " + eventObj.venueList.get(timeIndex).venueName);
					left.boxMod2.removeElement(eventObj);
					left.box2.setSelectedIndex(0);
				}
			}

		});

		left.btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Time timeObj = (Time) left.boxMod1.getSelectedItem();
				Venue venueObj = (Venue) left.boxMod3.getSelectedItem();
				int listIndex = left.list.getSelectedIndex();

				if (listIndex != -1 && !venueObj.venueName.equals("尚未選擇")) {
					Event eventObj = timeObj.eventList.get(listIndex);
					int timeIndex = eventObj.timeList.indexOf(timeObj);
					if (eventObj.venueList.size() > timeIndex) {
						eventObj.venueList.set(timeIndex, venueObj);
					} else {
						for (int i = eventObj.venueList.size(); i < timeIndex; i++) {
							eventObj.venueList.add(new Venue("尚未選擇"));
						}
						eventObj.venueList.add(venueObj);
					}
					left.model.set(listIndex, eventObj.eventName + "  " + venueObj.venueName);
					left.resetBox3(venueArray);
					for (int i = 0; i < left.model.size(); i++) {
						int index = timeObj.eventList.get(i).timeList.indexOf(timeObj);
						Venue obj = timeObj.eventList.get(i).venueList.get(index);
						left.boxMod3.removeElement(obj);
					}
				}
			}
		});

		left.btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int listIndex = left.list.getSelectedIndex();
				if (listIndex != -1) {
					Time timeObj = (Time) left.boxMod1.getSelectedItem();
					Event eventObj = timeObj.eventList.get(listIndex);
					int timeIndex = eventObj.timeList.indexOf(timeObj);
					timeObj.eventList.remove(eventObj);
					eventObj.timeList.remove(timeObj);
					eventObj.venueList.remove(timeIndex);
					left.model.clear();

					left.resetBox2(eventArray);
					left.resetBox3(venueArray);
					for (int i = 0; i < timeObj.eventList.size(); i++) {
						Event obj = timeObj.eventList.get(i);
						int timeIndex2 = obj.timeList.indexOf(timeObj);
						left.model.addElement(obj.eventName + "  " + obj.venueList.get(timeIndex).venueName);
						left.boxMod2.removeElement(obj);
						left.boxMod3.removeElement(obj.venueList.get(timeIndex2));
					}
				}
			}
		});

		left.btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int listIndex = left.list.getSelectedIndex();
				if (listIndex != -1) {
					Time timeObj = (Time) left.boxMod1.getSelectedItem();
					Event eventObj = timeObj.eventList.get(listIndex);
					int timeIndex = eventObj.timeList.indexOf(timeObj);
					eventObj.venueList.set(timeIndex, new Venue("尚未選擇"));
					left.model.set(listIndex, eventObj.eventName + "  " + eventObj.venueList.get(timeIndex));
					left.resetBox3(venueArray);
					for (int i = 0; i < eventObj.venueList.size(); i++) {
						Venue obj = eventObj.venueList.get(i);
						left.boxMod3.removeElement(obj);
					}
				}
			}
		});

		right.box.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				right.saveBtn.setVisible(false);
			}
		});
		right.btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Event eventObj = (Event) right.boxMod.getSelectedItem();
				int size = eventObj.timeList.size();
				Time[] order = eventObj.sortTime(timeArray);

				if (!eventObj.eventName.equals("尚未選擇")) {
					right.lab2.setText(eventObj.eventName + " 時間表:");
					right.model.removeAllElements();

					int game = countryArray.length / 2;
					if (countryArray.length % 2 != 0) {
						game++;
					}
					RandomSystem rds = new RandomSystem(countryArray, game);
					String[] result = rds.getResult();
					int gameIndex = 0;
					int group = game;
					if (size != 0) {
						group = game / size;
					}
					int count = 0;
					for (int i = 0; i < order.length; i++) {
						Time timeObj = order[i];
						if (!timeObj.timeString.equals("尚未選擇")) {
							right.model.addElement(timeObj.timeString);
							right.model.addElement("-----------");
							int timeIndex = eventObj.timeList.indexOf(timeObj);
							right.model.addElement(eventObj.venueList.get(timeIndex).venueName);
							right.model.addElement("-----------");
							for (int j = 0; j < group; j++) {
								right.model.addElement(result[gameIndex]);
								gameIndex++;
							}
							if (count == size - 1) {
								for (int j = gameIndex; j < game; j++) {
									right.model.addElement(result[gameIndex]);
									gameIndex++;
								}
							} else {
								right.model.addElement("-----------");
							}
							count++;
						}
					}
					if (eventObj.timeList.size() != 0) {
						right.saveBtn.setVisible(true);
					}
				} else {
					right.lab2.setText("時間表:");
				}
			}
		});

		right.saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Event eventObj = (Event) right.boxMod.getSelectedItem();
					String str = eventObj.eventName;
					if (!str.equals("尚未選擇") && eventObj.timeList.size() != 0) {
						str += "時間表";
						FileWriter fw = new FileWriter(str + ".txt");
						for (int i = 0; i < right.model.size(); i++) {
							fw.write(right.model.getElementAt(i) + "\r\n");
						}
						fw.flush();
						fw.close();
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "儲存失敗");
					e1.printStackTrace();
				}
			}
		});
	}

	static void getData() {
		File f1 = new File("比賽項目.txt");
		File f2 = new File("場地.txt");
		File f3 = new File("時間表.txt");
		File f4 = new File("國家.txt");
		try {
			Scanner sc = new Scanner(f1, "utf-8");
			List<Event> list = new ArrayList<Event>();
			while (sc.hasNext()) {
				String str = sc.nextLine();
				list.add(new Event(str));
			}
			eventArray = new Event[list.size()];
			list.toArray(eventArray);
			sc.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "找不到\"比賽項目.txt\"");
			e.printStackTrace();
		}
		try {
			Scanner sc = new Scanner(f2, "utf-8");
			List<Venue> list = new ArrayList<Venue>();
			while (sc.hasNext()) {
				String str = sc.nextLine();
				list.add(new Venue(str));
			}
			venueArray = new Venue[list.size()];
			list.toArray(venueArray);
			sc.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "找不到\"場地.txt\"");
			e.printStackTrace();
		}
		try {
			Scanner sc = new Scanner(f3, "utf-8");
			List<Time> list = new ArrayList<Time>();
			while (sc.hasNext()) {
				String str = sc.nextLine();
				list.add(new Time(str));
			}
			timeArray = new Time[list.size()];
			list.toArray(timeArray);
			sc.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "找不到\"時間表.txt\"");
			e.printStackTrace();
		}
		try {
			Scanner sc = new Scanner(f4, "utf-8");
			List<Country> list = new ArrayList<Country>();
			while (sc.hasNext()) {
				String str = sc.nextLine();
				list.add(new Country(str));
			}
			countryArray = new Country[list.size()];
			list.toArray(countryArray);
			sc.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "找不到\"國家.txt\"");
			e.printStackTrace();
		}
	}
}
