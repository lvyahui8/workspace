package di.frame.demo;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class FrameDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		final Frame frame = new Frame();
		frame.setSize(300, 200);
//		frame.setLocation(System.getProperty(""), y);
		frame.setLocation(400, 300);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Button bt = new Button("chek");
		frame.setLayout(new FlowLayout());//设置为流式布局
		frame.add(bt);
		
		frame.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO 自动生成的方法存根
//				super.windowClosing(e);
				System.out.println("guanbi");
				System.exit(0);
			}
			
		});
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
//				Button  bt2 = new Button("er");
//				frame.add(bt2);
				System.out.println("按钮被单击");
			}
		});
		frame.setVisible(true);
	}

}
