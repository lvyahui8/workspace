package Denglu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Defeated extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Defeated frame = new Defeated();
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
	public Defeated() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 246);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5BF9\u4E0D\u8D77\uFF0C\u60A8\u8F93\u5165\u7684\u4FE1\u606F\u6709\u9519\u8BEF\uFF01 \u8BF7\u91CD\u65B0\u767B\u5F55\uFF0C\u6216\u9000\u51FA\u3002");
		label.setForeground(new Color(72, 61, 139));
		label.setBackground(new Color(72, 61, 139));
		label.setFont(new Font("华文彩云", Font.PLAIN, 18));
		label.setBounds(10, 34, 460, 41);
		contentPane.add(label);
		
		JButton reOnlineBtn = new JButton("\u91CD\u65B0\u767B\u5F55");
		reOnlineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//重新登录
				LoginFraqme chongxin=new LoginFraqme();
				chongxin.setVisible(true);
			}
		});
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//关闭界面按钮
		reOnlineBtn.setBackground(new Color(253, 245, 230));
		reOnlineBtn.setFont(new Font("华文彩云", Font.PLAIN, 18));
		reOnlineBtn.setBounds(181, 129, 165, 50);
		contentPane.add(reOnlineBtn);
	}
}
