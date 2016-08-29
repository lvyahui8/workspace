import java.util.Calendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Hashtable;

@SuppressWarnings("serial")
public class CalendarPad extends JFrame implements MouseListener {
	int year, month, day;
	@SuppressWarnings("rawtypes")
	Hashtable hashtable;
	File file;
	JTextField showDay[];
	JLabel title[];
	Calendar ����;
	int ���ڼ�;
	NotePad notepad = null;
	Month ����ı���;
	Year ����ı���;
	String ����[] = { "������", "����һ", "���ڶ�", "������", "������", "������", "������" };
	JPanel leftPanel, rightPanel;

	@SuppressWarnings("rawtypes")
	public CalendarPad(int year, int month, int day) {
		leftPanel = new JPanel();//��������
		JPanel leftCenter = new JPanel();
		JPanel leftNorth = new JPanel();
		leftCenter.setLayout(new GridLayout(7, 7));

		rightPanel = new JPanel();
		this.year = year;
		this.month = month;
		this.day = day;
		����ı��� = new Year(this);
		����ı���.setYear(year);
		����ı��� = new Month(this);
		����ı���.setMonth(month);

		title = new JLabel[7];
		showDay = new JTextField[42];
		for (int j = 0; j < 7; j++) {
			title[j] = new JLabel();
			title[j].setText(����[j]);
			title[j].setBorder(BorderFactory.createRaisedBevelBorder());
			leftCenter.add(title[j]);
		}
		title[0].setForeground(Color.red);
		title[6].setForeground(Color.blue);

		for (int i = 0; i < 42; i++) {
			showDay[i] = new JTextField();
			showDay[i].addMouseListener(this);
			showDay[i].setEditable(false);
			leftCenter.add(showDay[i]);
		}

		���� = Calendar.getInstance();
		Box box = Box.createHorizontalBox();
		box.add(����ı���);
		box.add(����ı���);
		leftNorth.add(box);
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(leftNorth, BorderLayout.NORTH);
		leftPanel.add(leftCenter, BorderLayout.CENTER);
		leftPanel.add(new Label("�����������������������(������ʾ��Ԫǰ),���س�ȷ��"),
				BorderLayout.SOUTH);
		leftPanel.validate();//�����ڲ����
		Container con = super.getContentPane();
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				leftPanel, rightPanel);

		con.add(split, BorderLayout.CENTER);
		con.validate();

		hashtable = new Hashtable();
		file = new File("�������±�.txt");
		if (!file.exists()) {
			try {
				FileOutputStream out = new FileOutputStream(file);
				ObjectOutputStream objectOut = new ObjectOutputStream(out);
				objectOut.writeObject(hashtable);
				objectOut.close();
				out.close();
			} catch (IOException e) {
			}
		}

		notepad = new NotePad(this);
		rightPanel.add(notepad);

		����������(year, month);//cc++  ascii  java unicode
		//
		addWindowListener(new WindowAdapter() {//����new��һ�������ڲ���Ķ����丸����windowAdapter
			public void windowClosing(WindowEvent e) {
				System.exit(1);//���������JVM
			}//exception_access_violation
		});
		setVisible(true);
//		setBounds(100, 50, 524, 285);
		super.pack();
		validate();
	
	}

	/**
	 * ������
	 * 
	 * @param year
	 * @param month
	 */
	public void ����������(int year, int month) {
		����.set(year, month - 1, 1);

		���ڼ� = ����.get(Calendar.DAY_OF_WEEK) - 1;
		if (month == 1  || month == 3 || month == 5 || month == 7
				|| month == 8 || month == 10 || month == 12) {
			���к���(���ڼ�, 31);
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			���к���(���ڼ�, 30);
		} else if (month == 2) {
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				���к���(���ڼ�, 29);
			} else {
				���к���(���ڼ�, 28);
			}
		}
	}

	public void ���к���(int ���ڼ�, int ������) {
		for (int i = ���ڼ�, n = 1; i < ���ڼ� + ������; i++) {
			showDay[i].setText("" + n);
			if (n == day) {
				showDay[i].setForeground(Color.green);
				showDay[i].setFont(new Font("TimesRoman", Font.BOLD, 20));
			} else {
				showDay[i].setFont(new Font("TimesRoman", Font.BOLD, 12));
				showDay[i].setForeground(Color.black);
			}
			if (i % 7 == 6) {
				showDay[i].setForeground(Color.blue);
			}
			if (i % 7 == 0) {
				showDay[i].setForeground(Color.red);
			}
			n++;
		}
		for (int i = 0; i < ���ڼ�; i++) {
			showDay[i].setText("");
		}
		for (int i = ���ڼ� + ������; i < 42; i++) {
			showDay[i].setText("");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int y) {
		year = y;
		notepad.setYear(year);
	}

	public int getMonth() {
		return month;
	}



	public void setMonth(int m) {
		month = m;
		notepad.setMonth(month);
	}

	public int getDay() {
		return day;
	}

	public void setDay(int d) {
		day = d;
		notepad.setDay(day);
	}

	@SuppressWarnings("rawtypes")
	public Hashtable getHashtable() {
		return hashtable;
	}

	public File getFile() {
		return file;
	}

	@Override//��ʾ�˷�������д��ʵ�ָ����ӿڵķ���
	public void mousePressed(MouseEvent e) {
		JTextField source = (JTextField) e.getSource();
		try {
			day = Integer.parseInt(source.getText());
			CalendarPad.this.����������(year, month);
			notepad.setDay(day);
			notepad.������Ϣ��(year, month, day);
			notepad.�����ı���(null);
			notepad.��ȡ��־����(year, month, day);
		} catch (Exception ee) {
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) {
		//
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH) + 1;// 0 ������ 11
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		
		
		new CalendarPad(y, m, d);
	}

}
