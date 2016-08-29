/*Year.java
 Month.java
 Note.java


 Month.java*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Month extends Box implements ActionListener {
	int month;
	JTextField showMonth = null;
	JButton ����, ����;
	CalendarPad ����;

	public Month(CalendarPad ����) {
		super(BoxLayout.X_AXIS);
		this.���� = ����;
		showMonth = new JTextField(2);
		month = ����.getMonth();
		showMonth.setEditable(false);
		showMonth.setForeground(Color.blue);
		showMonth.setFont(new Font("TimesRomn", Font.BOLD, 16));
		���� = new JButton("����");
		���� = new JButton("����");
		add(����);
		add(showMonth);
		add(����);
		����.addActionListener(this);
		����.addActionListener(this);
		showMonth.setText("" + month);
	}

	public void setMonth(int month) {
		if (month <= 12 && month >= 1) {
			this.month = month;
		} else {
			this.month = 1;
		}
		showMonth.setText("" + month);
	}

	public int getMonth() {
		return month;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ����) {
			if (month >= 2) {
				month = month - 1;
				����.setMonth(month);
				����.����������(����.getYear(), month);
			} else if (month == 1) {
				month = 12;
				����.setMonth(month);
				����.����������(����.getYear(), month);
			}
			showMonth.setText("" + month);
		} else if (e.getSource() == ����) {
			if (month < 12) {
				month = month + 1;
				����.setMonth(month);
				����.����������(����.getYear(), month);
			} else if (month == 12) {
				month = 1;
				����.setMonth(month);
				����.����������(����.getYear(), month);
			}
			showMonth.setText("" + month);
		}
	}

}
