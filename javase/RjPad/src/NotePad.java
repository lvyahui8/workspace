//NotePad.java
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings({"serial","rawtypes"})
public class NotePad extends JPanel implements ActionListener /*, Serializable*/{//对象序列化
//	private static final long serialVersionUID = -5208603104456897694L;
	JTextArea text;
	JButton 保存日志, 删除日志;

	Hashtable table;
	JLabel 信息条;
	int year, month, day;
	File file;
	CalendarPad calendar;

	public NotePad(CalendarPad calendar) {
		this.calendar = calendar;
		year = calendar.getYear();
		month = calendar.getMonth();
		day = calendar.getDay();
		;
		table = calendar.getHashtable();
		file = calendar.getFile();
		信息条 = new JLabel("" + year + "年" + month + "月" + day + "日",
				JLabel.CENTER);
		信息条.setFont(new Font("TimesRoman", Font.BOLD, 16));
		信息条.setForeground(Color.blue);
		text = new JTextArea(10, 10);
		保存日志 = new JButton("保存日志");
		删除日志 = new JButton("删除日志");
		保存日志.addActionListener(this);
		删除日志.addActionListener(this);
		setLayout(new BorderLayout());
		JPanel pSouth = new JPanel();
		add(信息条, BorderLayout.NORTH);
		add(new JScrollPane(text), BorderLayout.CENTER);
		pSouth.add(保存日志);
		pSouth.add(删除日志);
		add(pSouth, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == 保存日志) {
			保存日志(year, month, day);
		} else if (e.getSource() == 删除日志) {
			删除日志(year, month, day);
		}
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getMonth() {
		return month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public void 设置信息条(int year, int month, int day) {
		信息条.setText("" + year + "年" + month + "月" + day + "日");
	}

	public void 设置文本区(String s) {
		text.setText(s);
	}

	public void 获取日志内容(int year, int month, int day) {
		String key = "" + year + "" + month + "" + day;
		try {
			FileInputStream inOne = new FileInputStream(file);
			ObjectInputStream inTwo = new ObjectInputStream(inOne);
			table = (Hashtable) inTwo.readObject();
			inOne.close();
			inTwo.close();
		} catch (Exception ee) {
		}
		if (table.containsKey(key)) {
			String m = "" + year + "年" + month + "月" + day + "这一天有日志记载,想看吗?";
			int ok = JOptionPane.showConfirmDialog(this, m, "询问",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (ok == JOptionPane.YES_OPTION) {
				text.setText((String) table.get(key));
			} else {
				text.setText("");
			}
		} else {
			text.setText("无记录");
		}
	}

	@SuppressWarnings("unchecked")
	public void 保存日志(int year, int month, int day) {
		String 日志内容 = text.getText();
		String key = "" + year + "" + month + "" + day;

		String m = "" + year + "年" + month + "月" + day + "保存日志吗?";
		int ok = JOptionPane.showConfirmDialog(this, m, "询问",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (ok == JOptionPane.YES_OPTION) {
			try {
				FileInputStream inOne = new FileInputStream(file);
				ObjectInputStream inTwo = new ObjectInputStream(inOne);
				table = (Hashtable) inTwo.readObject();
				inOne.close();
				inTwo.close();
				table.put(key, 日志内容);
				FileOutputStream out = new FileOutputStream(file);
				ObjectOutputStream objectOut = new ObjectOutputStream(out);
				objectOut.writeObject(table);
				objectOut.close();
				out.close();
			} catch (Exception ee) {
			}
		}
	}

	public void 删除日志(int year, int month, int day) {
		String key = "" + year + "" + month + "" + day;
		if (table.containsKey(key)) {
			String m = "删除" + year + "年" + month + "月" + day + "日的日志吗?";
			int ok = JOptionPane.showConfirmDialog(this, m, "询问",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (ok == JOptionPane.YES_OPTION) {
				try {
					FileInputStream inOne = new FileInputStream(file);
					ObjectInputStream inTwo = new ObjectInputStream(inOne);
					table = (Hashtable) inTwo.readObject();
					inOne.close();
					inTwo.close();
					table.remove(key);
					FileOutputStream out = new FileOutputStream(file);
					ObjectOutputStream objectOut = new ObjectOutputStream(out);
					objectOut.writeObject(table);
					objectOut.close();
					out.close();
					text.setText(null);
				} catch (Exception ee) {
				}
			}
		} else {

			String m = "" + year + "年" + month + "月" + day + "无日志记录";
			JOptionPane.showMessageDialog(this, m, "提示",
					JOptionPane.WARNING_MESSAGE);
		}
	}

}
