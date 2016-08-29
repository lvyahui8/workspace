package Denglu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -2559356337600834368L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBounds(100, 100, 783, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tittleLabel = new JLabel("\u6B22  \u8FCE  \u5149  \u4E34  \u9910  \u8C0B  \u5929  \u4E0B");
		tittleLabel.setFont(new Font("»ªÎÄ²ÊÔÆ", Font.PLAIN, 36));
		tittleLabel.setBounds(193, 32, 466, 51);
		contentPane.add(tittleLabel);
		
		textField = new JTextField();
		textField.setForeground(new Color(139, 0, 139));
		textField.setBackground(new Color(175, 238, 238));
		textField.setFont(new Font("Ó×Ô²", Font.PLAIN, 16));
		textField.setText("\u670D\u52A1\u5458\u767B\u9646\u8BF7\u8FDB\u5165\u524D\u53F0\u767B\u9646\u533A\uFF0C\u5E97\u957F\u767B\u9646\u8BF7\u8FDB\u5165\u540E\u53F0\u767B\u9646\u533A");
		textField.setBounds(208, 139, 425, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton waiterOnlineBtn = new JButton("\u524D\u53F0\u767B\u9646");
		waiterOnlineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//Ç°Ì¨µÇÂ½
				LoginFraqme qiantai=new LoginFraqme();
				qiantai.setVisible(true);
				doClose();
				
				
				
			}
		});
		waiterOnlineBtn.setForeground(new Color(255, 20, 147));
		waiterOnlineBtn.setBackground(new Color(152, 251, 152));
		waiterOnlineBtn.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		waiterOnlineBtn.setBounds(117, 227, 174, 109);
		contentPane.add(waiterOnlineBtn);
		
		JButton shopownerOnlineBtn = new JButton("\u540E\u53F0\u767B\u9646 ");
		shopownerOnlineBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//ºóÌ¨µÇÂ½
				LoginFraqme houtai=new LoginFraqme();
				houtai.setVisible(true);
				doClose();
			}
		});
		shopownerOnlineBtn.setForeground(new Color(255, 20, 147));
		shopownerOnlineBtn.setBackground(new Color(152, 251, 152));
		shopownerOnlineBtn.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		shopownerOnlineBtn.setBounds(483, 227, 169, 109);
		contentPane.add(shopownerOnlineBtn);
		
		super.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
	}

	protected void doClose() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

}
