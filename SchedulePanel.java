import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

final class SchedulePanel extends JPanel {
	JPanel up = new JPanel();
	JPanel mid = new JPanel();
	JPanel down = new JPanel();
	JPanel downPan1 = new JPanel();
	JPanel downPan2 = new JPanel();
	JPanel downPan3 = new JPanel();
	JPanel emptyPan = new JPanel();

	JLabel lab1 = new JLabel("請先選擇時間");
	JLabel lab2 = new JLabel("比賽項目");
	JLabel lab3 = new JLabel("場地");
	JLabel lab4 = new JLabel("時間:");

	DefaultComboBoxModel<Time> boxMod1 = new DefaultComboBoxModel<Time>();
	JComboBox<Time> box1 = new JComboBox<Time>(boxMod1);
	DefaultComboBoxModel<Event> boxMod2 = new DefaultComboBoxModel<Event>();
	JComboBox<Event> box2 = new JComboBox<Event>(boxMod2);
	DefaultComboBoxModel<Venue> boxMod3 = new DefaultComboBoxModel<Venue>();
	JComboBox<Venue> box3 = new JComboBox<Venue>(boxMod3);

	JButton btn1 = new JButton("加入");
	JButton btn2 = new JButton("選擇");
	JButton btn3 = new JButton("移除");
	JButton btn4 = new JButton("移除");

	DefaultListModel<String> model = new DefaultListModel<String>();
	JList<String> list = new JList<String>(model);
	JScrollPane slide = new JScrollPane(list);

	SchedulePanel() {
		setLayout(new BorderLayout());

		up.add(lab1);
		up.add(box1);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mid.setLayout(new BorderLayout());
		mid.setPreferredSize(new Dimension(100, 100));
		mid.add(lab4, BorderLayout.NORTH);
		mid.add(slide);

		down.setLayout(new GridLayout(2, 1));
		down.setPreferredSize(new Dimension(300, 300));
		downPan1.add(lab2);
		downPan1.add(box2);
		downPan1.add(btn1);
		downPan1.add(btn3);

		downPan2.add(lab3);
		downPan2.add(box3);
		downPan3.add(btn2);
		downPan3.add(btn4);
		downPan2.add(downPan3);
		down.add(downPan1);
		down.add(downPan2);

		add(up, BorderLayout.NORTH);
		add(mid);
		add(down, BorderLayout.SOUTH);
		add(emptyPan, BorderLayout.EAST);
	}

	void resetBox1(Time[] timeArray) {
		boxMod1.removeAllElements();
		boxMod1.addElement(new Time());
		for (Time i : timeArray) {
			boxMod1.addElement(i);
		}
	}

	void resetBox2(Event[] eventArray) {
		boxMod2.removeAllElements();
		boxMod2.addElement(new Event());
		for (Event i : eventArray) {
			boxMod2.addElement(i);
		}
	}

	void resetBox3(Venue[] venueArray) {
		boxMod3.removeAllElements();
		boxMod3.addElement(new Venue());
		for (Venue i : venueArray) {
			boxMod3.addElement(i);
		}
	}
}
