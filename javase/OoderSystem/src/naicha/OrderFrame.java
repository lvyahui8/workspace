package naicha;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sldll.cms.dao.GeneralDAO;
import com.sldll.cms.vo.Dishes;

public class OrderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;
	int k = 1;
	int i = 0, count = 0;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	//
	//
	//
	//
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// DianDan frame = new DianDan();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public OrderFrame() {
		setBounds(100, 100, 872, 615);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// private void jTableMouseClick(java.awt.event.MouseEvent e);
		// int flag=JOptionPane.showConfirmDialog(null,"是否确定删除")；
		// System.out.println(flag);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);// 关闭界面按钮
		JButton VipsettleAccountBtn = new JButton("\u4F1A\u5458\u7ED3\u8D26");
		VipsettleAccountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 会员结账
			}
		});
		VipsettleAccountBtn.setForeground(new Color(148, 0, 211));
		VipsettleAccountBtn.setFont(new Font("幼圆", Font.PLAIN, 14));
		VipsettleAccountBtn.setBounds(190, 526, 91, 37);
		contentPane.add(VipsettleAccountBtn);

		JButton settleAccountBtn = new JButton("\u7ED3\u8D26");
		settleAccountBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 结账
			}
		});
		settleAccountBtn.setForeground(new Color(75, 0, 130));
		settleAccountBtn.setFont(new Font("幼圆", Font.PLAIN, 14));
		settleAccountBtn.setBounds(22, 526, 91, 37);
		contentPane.add(settleAccountBtn);

		JButton addBtn = new JButton("+");// 数量增加按钮
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dishes dishes = new Dishes();

				Integer c = dishes.getCategory();
				System.out.println(c);
				if (c != null) {
					c++;

				}
			}
		});
		addBtn.setFont(new Font("华文中宋", Font.PLAIN, 45));
		addBtn.setBounds(279, 75, 82, 37);
		contentPane.add(addBtn);

		JButton reduceBtn = new JButton("-");// 数量减少按钮
		reduceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Object> list = new GeneralDAO().findAll(new Dishes());
					System.out.println(list);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		reduceBtn.setFont(new Font("华文中宋", Font.PLAIN, 45));
		reduceBtn.setBounds(279, 111, 82, 42);
		contentPane.add(reduceBtn);

		JButton deleteBtn = new JButton("\u5220\u83DC");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 删菜按钮

			}
		});
		deleteBtn.setFont(new Font("华文中宋", Font.PLAIN, 18));
		deleteBtn.setBounds(279, 151, 82, 42);
		contentPane.add(deleteBtn);

		JButton Btn2 = new JButton("2");
		Btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 数量2
			}
		});
		Btn2.setForeground(new Color(148, 0, 211));
		Btn2.setBounds(371, 533, 69, 23);
		contentPane.add(Btn2);

		JButton Btn3 = new JButton("3");
		Btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 数量3
			}
		});
		Btn3.setForeground(new Color(148, 0, 211));
		Btn3.setBounds(439, 533, 69, 23);
		contentPane.add(Btn3);

		JButton Btn4 = new JButton("4");
		Btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 数量4
			}
		});
		Btn4.setForeground(new Color(148, 0, 211));
		Btn4.setBounds(507, 533, 69, 23);
		contentPane.add(Btn4);

		JButton Btn5 = new JButton("5");
		Btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 数量5
			}
		});
		Btn5.setForeground(new Color(148, 0, 211));
		Btn5.setBounds(573, 533, 69, 23);
		contentPane.add(Btn5);

		JLabel label = new JLabel(
				"\u6B22  \u8FCE  \u5149  \u4E34  \u9910  \u8C0B  \u5929  \u4E0B");
		label.setForeground(new Color(75, 0, 130));
		label.setFont(new Font("华文彩云", Font.PLAIN, 36));
		label.setBounds(191, 10, 466, 38);
		contentPane.add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(268, 478, -249, -385);
		contentPane.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 75, 253, 441);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		table_1.setModel(new DefaultTableModel(new Object[][] {
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null },
				{ null, null, null }, { null, null, null }, }, new String[] {
				"\u83DC\u540D", "\u6570\u91CF", "\u4EF7\u683C" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			Class[] columnTypes = new Class[] { String.class, Integer.class,
					Double.class };

			@SuppressWarnings("unchecked")
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(0).setMinWidth(25);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(51);
		table_1.getColumnModel().getColumn(1).setMinWidth(25);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(69);
		table_1.getColumnModel().getColumn(2).setMinWidth(25);
		scrollPane_1.setViewportView(table_1);

		JLabel label_1 = new JLabel("\u7F8E \u5473 \u4F73 \u80B4");
		label_1.setBounds(723, 56, 122, 37);
		contentPane.add(label_1);
		label_1.setForeground(Color.MAGENTA);
		label_1.setFont(new Font("华文行楷", Font.PLAIN, 26));

		JTabbedPane allDishesJPane = new JTabbedPane(JTabbedPane.TOP);
		allDishesJPane.setBackground(Color.LIGHT_GRAY);
		allDishesJPane.setBounds(371, 73, 474, 448);
		contentPane.add(allDishesJPane);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setLayout(new GridLayout(7, 8));
		for (int i = 0; i < 56; i++) {
			tabbedPane_1.add(new JButton("哈哈"));
		}
		allDishesJPane.addTab("New tab", null, tabbedPane_1, null);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		allDishesJPane.addTab("New tab", null, tabbedPane_2, null);

		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		allDishesJPane.addTab("New tab", null, tabbedPane_3, null);

		JButton button = new JButton("5");
		button.setForeground(new Color(148, 0, 211));
		button.setBounds(642, 533, 69, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("5");
		button_1.setForeground(new Color(148, 0, 211));
		button_1.setBounds(708, 533, 69, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("5");
		button_2.setForeground(new Color(148, 0, 211));
		button_2.setBounds(776, 533, 69, 23);
		contentPane.add(button_2);
	}
}
