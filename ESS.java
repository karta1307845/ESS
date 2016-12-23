import javax.swing.*;

public class ESS{
	public static void main(String[] args){
		new ESS();
	}
	
	public ESS(){
		JFrame frame = new JFrame("賽程安排系統");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,700);
		frame.setLayout(null);
		
		JLabel label1 = new JLabel("時間");
		label1.setBounds(90, 0, 200, 50);
		frame.getContentPane().add(label1);
		
		JLabel label2 = new JLabel("比賽項目");
		label2.setBounds(240,0,200,50);
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
		
		JList<String> list1 = new JList<String>();
		list1.setBounds(40, 50, 120, 500);
		frame.getContentPane().add(list1);
		
		JList<String> list2 = new JList<String>();
		list2.setBounds(200, 50, 120, 500);
		frame.getContentPane().add(list2);
		
		JList<String> list3 = new JList<String>();
		list3.setBounds(360, 50, 120, 500);
		frame.getContentPane().add(list3);
		
		JList<String> list4 = new JList<String>();
		list4.setBounds(520, 50, 120, 500);
		frame.getContentPane().add(list4);
		
		JList<String> list5 = new JList<String>();
		list5.setBounds(680, 50, 120, 500);
		frame.getContentPane().add(list5);
		
		JList<String> list6 = new JList<String>();
		list6.setBounds(840, 50, 120, 500);
		frame.getContentPane().add(list6);
		
		frame.setVisible(true);
		//frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	}
}
