package di.frame.demo;
import com.cloudgarden.layout.AnchorLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class NewJFrame extends javax.swing.JFrame {
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	private JButton jButton1;
	private JButton jButton4;
	private JButton jButton3;
	private JButton jButton2;
	private JRadioButton jRadioButton2;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				NewJFrame inst = new NewJFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public NewJFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setPreferredSize(new java.awt.Dimension(228, 245));
			{
				jRadioButton1 = new JRadioButton();
				getContentPane().add(jRadioButton1);
				FlowLayout jRadioButton1Layout = new FlowLayout();
				jRadioButton1.setText("\u4f60\u597d\u554a");
				jRadioButton1.setBounds(33, 34, 100, 21);
			}
			{
				jRadioButton2 = new JRadioButton();
				getContentPane().add(jRadioButton2);
				jRadioButton2.setText("\u6211\u597d\u554a");
				jRadioButton2.setBounds(33, 74, 100, 21);
			}
			{
				jRadioButton3 = new JRadioButton();
				getContentPane().add(jRadioButton3);
				jRadioButton3.setText("\u5927\u5bb6\u597d");
				jRadioButton3.setBounds(33, 115, 100, 21);
			}
			{
				jRadioButton4 = new JRadioButton();
				getContentPane().add(jRadioButton4);
				jRadioButton4.setText("\u624d\u7b97\u597d");
				jRadioButton4.setBounds(33, 156, 100, 21);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u786e\u5b9a");
				jButton1.setBounds(116, 33, 62, 24);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("\u64a4\u9500");
				jButton2.setBounds(116, 74, 62, 24);
			}
			{
				jButton3 = new JButton();
				getContentPane().add(jButton3);
				jButton3.setText("\u9000\u51fa");
				jButton3.setBounds(116, 115, 62, 24);
			}
			{
				jButton4 = new JButton();
				getContentPane().add(jButton4);
				jButton4.setText("\u5173\u95ed");
				jButton4.setBounds(116, 156, 62, 24);
			}
			pack();
			this.setSize(228, 245);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
