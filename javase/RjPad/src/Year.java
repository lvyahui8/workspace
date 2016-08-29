//Year.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
@SuppressWarnings({"serial"})
public class Year extends Box implements ActionListener
// ActionListener��Java�й����¼������һ���ӿڣ��̳���EventListener
{
	int year;
	int month;
	JTextField showYear = null;
	JButton ����, ȥ��;// JButton ����swing ������ť�����ã��˴�ӦΪ����
	CalendarPad ����; // ����

	public Year(CalendarPad ����) {
		super(BoxLayout.X_AXIS);
		showYear = new JTextField(4);
		showYear.setForeground(Color.blue);
		showYear.setFont(new Font("TimesRomn", Font.BOLD, 14));
		this.���� = ����;
		year = ����.getYear();
		���� = new JButton("����");
		ȥ�� = new JButton("����");
		add(ȥ��);
		add(showYear);
		add(����);
		showYear.addActionListener(this);
		ȥ��.addActionListener(this);
//		ȥ��.addActionListener(new PreYearBtnListener());
		����.addActionListener(this);
	}

	public void setYear(int year) {
		this.year = year;
		showYear.setText("" + year);
	}

	public int getYear() {
		return year;
	}
//�ص�����
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ȥ��) {
			year = year - 1;
			showYear.setText("" + year);
			����.setYear(year);
			����.����������(year, ����.getMonth());
		} else if (e.getSource() == ����) {
			year = year + 1;
			showYear.setText("" + year);
			����.setYear(year);
			����.����������(year, ����.getMonth());
		} else if (e.getSource() == showYear) {
			try {
				year = Integer.parseInt(showYear.getText());
				showYear.setText("" + year);
				����.setYear(year);
				����.����������(year, ����.getMonth());
			} catch (NumberFormatException ee) {
				showYear.setText("" + year);
				����.setYear(year);
				����.����������(year, ����.getMonth());
			}
		}
	}
	
//	private class PreYearBtnListener implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
}
