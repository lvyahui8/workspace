package naicha;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DishesAdminFrame extends JFrame {
	private static final long serialVersionUID = 3467490192164119908L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CanPinGuanLi frame = new CanPinGuanLi();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DishesAdminFrame() {
		setBounds(100, 100, 883, 632);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B22      \u8FCE      \u5149      \u4E34      \u9910      \u8C0B      \u5929      \u4E0B");
		label.setForeground(new Color(51, 51, 153));
		label.setFont(new Font("»ªÎÄ²ÊÔÆ", Font.PLAIN, 36));
		label.setBounds(67, 26, 740, 53);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F9B");
		label_1.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_1.setBounds(143, 308, 48, 35);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u82E6");
		label_2.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_2.setBounds(79, 335, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5DE5");
		label_3.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_3.setBounds(67, 375, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u4F5C");
		label_4.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_4.setBounds(93, 418, 54, 15);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\u4E86");
		label_5.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_5.setBounds(143, 458, 54, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u4E00");
		label_6.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_6.setBounds(196, 488, 54, 15);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u5929");
		label_7.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_7.setBounds(253, 458, 54, 15);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("\u8BA9");
		label_8.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_8.setBounds(282, 418, 54, 15);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("\u6211");
		label_9.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_9.setBounds(308, 375, 54, 15);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("\u4EEC");
		label_10.setForeground(new Color(0, 0, 0));
		label_10.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_10.setBounds(294, 328, 54, 15);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("\u770B");
		label_11.setForeground(new Color(0, 0, 0));
		label_11.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_11.setBounds(186, 353, 37, 15);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("\u770B");
		label_12.setForeground(new Color(0, 0, 0));
		label_12.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_12.setBounds(230, 318, 54, 15);
		contentPane.add(label_12);
		
		JButton solutionBtn = new JButton("\u4EA7\u54C1\u9500\u552E\u60C5\u51B5");
		solutionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//²úÆ·ÏúÊÛÇé¿ö²éÑ¯
			}
		});
		solutionBtn.setBackground(new Color(255, 240, 245));
		solutionBtn.setForeground(new Color(255, 20, 147));
		solutionBtn.setFont(new Font("Ó×Ô²", Font.PLAIN, 14));
		solutionBtn.setBounds(145, 392, 127, 46);
		contentPane.add(solutionBtn);
		
		JLabel label_13 = new JLabel("\u6CE8\u610F\u5566\uFF01\uFF01 \u4EA7\u54C1\u53C8\u51FA\u65B0\u53E3\u5473\u5566\uFF01");
		label_13.setForeground(new Color(128, 0, 0));
		label_13.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		label_13.setBounds(552, 161, 292, 40);
		contentPane.add(label_13);
		
		JButton refreshBtn = new JButton("\u66F4   \u65B0   ing");
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//Ôö¼Ó²úÆ·
			}
		});
		refreshBtn.setBackground(new Color(240, 255, 255));
		refreshBtn.setForeground(new Color(255, 20, 147));
		refreshBtn.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		refreshBtn.setBounds(527, 256, 178, 53);
		contentPane.add(refreshBtn);
		
		JLabel label_14 = new JLabel("\u6211\u4EEC\u5BB6\u90FD\u6709\u4EC0\u4E48\u597D\u5403\u7684\u5450\uFF1F\uFF1F ");
		label_14.setForeground(new Color(255, 105, 180));
		label_14.setFont(new Font("Ó×Ô²", Font.PLAIN, 17));
		label_14.setBounds(93, 127, 243, 35);
		contentPane.add(label_14);
		
		JButton checkInformationBtn = new JButton("\u4FE1  \u606F  \u67E5  \u8BE2");
		checkInformationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//ÐÅÏ¢²éÑ¯
			}
		});
		checkInformationBtn.setBackground(new Color(250, 250, 210));
		checkInformationBtn.setForeground(new Color(255, 20, 147));
		checkInformationBtn.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		checkInformationBtn.setBounds(196, 190, 178, 53);
		contentPane.add(checkInformationBtn);
		
		JLabel label_15 = new JLabel("\u597D");
		label_15.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_15.setBounds(537, 548, 54, 15);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel("\u5403");
		label_16.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_16.setBounds(556, 498, 54, 15);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel("\u7684");
		label_17.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_17.setBounds(600, 458, 54, 15);
		contentPane.add(label_17);
		
		JLabel label_18 = new JLabel("\u88AB");
		label_18.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_18.setBounds(651, 418, 54, 15);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel("\u4FEE");
		label_19.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_19.setBounds(715, 407, 54, 15);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel("\u6539");
		label_20.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_20.setBounds(774, 436, 54, 15);
		contentPane.add(label_20);
		
		JLabel label_21 = new JLabel("\u55BD");
		label_21.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		label_21.setBounds(811, 498, 54, 15);
		contentPane.add(label_21);
		
		JButton changeBtn = new JButton("\u4FEE  \u6539  \u4EA7  \u54C1");
		changeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//ÐÞ¸Ä²úÆ·
			}
		});
		changeBtn.setBackground(new Color(255, 250, 205));
		changeBtn.setForeground(new Color(255, 20, 147));
		changeBtn.setFont(new Font("Ó×Ô²", Font.PLAIN, 15));
		changeBtn.setBounds(650, 513, 143, 50);
		contentPane.add(changeBtn);
	}
}
