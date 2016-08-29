package Denglu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import naicha.DishesAdminFrame;
import naicha.OrderFrame;

import com.sldll.cms.dao.GeneralDAO;
import com.sldll.cms.dao.SqlServerInfo;
import com.sldll.cms.vo.Shopowner;
import com.sldll.cms.vo.Waiter;

public class LoginFraqme extends JFrame {
	private static final long serialVersionUID = 1L;

	static{
		
		try {
			Class.forName(SqlServerInfo.DBDRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		
//		
//		
//		
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginFraqme frame = new LoginFraqme();
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
	public LoginFraqme() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setForeground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLable = new JLabel("\u7528\u6237\u540D");
		usernameLable.setFont(new Font("华文彩云", Font.PLAIN, 18));
		usernameLable.setForeground(new Color(255, 105, 180));
		usernameLable.setBounds(91, 63, 87, 30);
		contentPane.add(usernameLable);
		
		JLabel passwordLable = new JLabel("\u5BC6\u7801");
		passwordLable.setFont(new Font("华文彩云", Font.PLAIN, 18));
		passwordLable.setForeground(new Color(255, 105, 180));
		passwordLable.setBounds(91, 142, 72, 30);
		contentPane.add(passwordLable);
		
		username = new JTextField();
		username.setBounds(209, 68, 164, 25);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(209, 147, 164, 25);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton waiterLonginBtn = new JButton("\u670D\u52A1\u5458\u767B\u5F55");
		waiterLonginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 服务员登录

				GeneralDAO gdao = new GeneralDAO();
				Waiter fwy = new Waiter();
				System.out.println(username.getText());
				System.out.println(password.getText());

				String u = username.getText();
				String v = password.getText();
				boolean m = true;
				if (v.equals("") || v == null) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					m = false;
					return;

				}
				if (u.equals("") || u == null) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					m = false;
					return;
				}
				if (m) {
					try {
						Map<Object, Object> reg = new HashMap<Object, Object>();
						// reg.put("id", 1);

						reg.put("username", u);
						reg.put("password", v);

						List<Object> list = gdao.findByNameQuery(fwy, reg,false);

						for (Object obj : list) {
							System.out.println(obj);
						}
						
						if (!list.isEmpty()) {

							JOptionPane.showMessageDialog(null, "登录成功");
							OrderFrame qiantai = new OrderFrame();// 按钮响应
							qiantai.setVisible(true);
							doClose();
							
						} else {
							JOptionPane.showMessageDialog(null, "登录失败");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
			}

			
		});
		waiterLonginBtn.setForeground(new Color(255, 105, 180));
		waiterLonginBtn.setFont(new Font("华文彩云", Font.PLAIN, 18));
		waiterLonginBtn.setBounds(91, 206, 140, 39);
		contentPane.add(waiterLonginBtn);
		
		JButton shopownerLoginBtn = new JButton("\u5E97\u957F\u767B\u5F55");
		shopownerLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//店长登录
				
				GeneralDAO gdao = new GeneralDAO();
				Shopowner fwy = new Shopowner();
				System.out.println(username.getText());
				System.out.println(password.getText());

				String u = username.getText();
				String v = password.getText();
				boolean m = true;
				if (v.equals("") || v == null) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					m = false;
					return;

				}
				if (u.equals("") || u == null) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					m = false;
					return;
				}
				if (m) {
					try {
						Map<Object, Object> reg = new HashMap<Object, Object>();
						// reg.put("id", 1);

						reg.put("username", u);
						reg.put("password", v);

						List<Object> list = gdao.findByNameQuery(fwy, reg ,false);

						for (Object obj : list) {
							System.out.println(obj);
						}
						
						if (!list.isEmpty()) {

							JOptionPane.showMessageDialog(null, "登录成功");
							DishesAdminFrame houtai = new DishesAdminFrame();// 按钮响应
							houtai.setVisible(true);
							doClose();
						} else {
							JOptionPane.showMessageDialog(null, "登录失败");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
			}

		});
	
		shopownerLoginBtn.setForeground(new Color(255, 105, 180));
		shopownerLoginBtn.setFont(new Font("华文彩云", Font.PLAIN, 18));
		shopownerLoginBtn.setBounds(292, 206, 140, 39);
		contentPane.add(shopownerLoginBtn);
	}





	protected void doClose() {
		// TODO Auto-generated method stub
		
	}
}
