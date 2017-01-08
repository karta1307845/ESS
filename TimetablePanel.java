import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

final class TimetablePanel extends JPanel {
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel emptyPan = new JPanel();

	JLabel lab1 = new JLabel("請選擇比賽項目:");
	JLabel lab2 = new JLabel("時間表:");

	DefaultComboBoxModel<Event> boxMod = new DefaultComboBoxModel<Event>();
	JComboBox<Event> box = new JComboBox<Event>(boxMod);
	JButton btn = new JButton("顯示");
	JButton saveBtn = new JButton("儲存");
	DefaultListModel<String> model = new DefaultListModel<String>();
	JList<String> list = new JList<String>(model);
	JScrollPane slide = new JScrollPane(list);

	TimetablePanel() {
		setLayout(new BorderLayout());

		pan1.add(lab1);
		pan1.add(box);
		pan1.add(btn);
		saveBtn.setVisible(false);
		pan1.add(saveBtn);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pan2.setLayout(new BorderLayout());
		pan2.add(lab2, BorderLayout.NORTH);
		pan2.add(slide);

		add(pan1, BorderLayout.NORTH);
		add(pan2);
		add(emptyPan, BorderLayout.WEST);
	}
}
