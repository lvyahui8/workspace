package di.frame.demo;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseKeyDemo {

	private Frame f;
	private TextField tf;
	private Button bt;
	private int count = 0;
	public MouseKeyDemo(Frame f, TextField tf) {
		super();
		init(f, tf);
	}

	/**
	 * @param f
	 * @param tf
	 */
	private void init(Frame f, TextField tf) {
		this.f = f;
		this.tf = tf;
		f.setLayout(new FlowLayout());
		f.add(tf);
		bt = new Button("anni");
		f.add(bt);
		f.setVisible(true);
		
	}
	static boolean flag = false;

	private void myEvent(){
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO �Զ����ɵķ������
				System.exit(0);
			}
			
		});
	/*	new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
				while(true){
					try {
						Thread.sleep(700);
						flag = false;
//						System.out.println("���óɹ�");
					} catch (InterruptedException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
				}
			}
		}).start();*/
		bt.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������
//				super.mouseClicked(e);
		/*		if(!flag){
					flag =true;
					tf.setText("");
				}
				else{
					flag = false;
					System.out.println("���˫��");
				}*/
				
//				count++;
//				if(count %2 ==  0){
////					tf.setText("���˫��");
//					System.out.println("���˫��");
//				}
				
				if(e.getClickCount() == 2){
					System.out.println("���˫��");
				}
			}

//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO �Զ����ɵķ������
//				count++;
//				tf.setText("anl"+count);
//			}
			
			
		});
		
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO �Զ����ɵķ������
//				super.keyPressed(e);
//				System.out.print(e.getKeyChar());
				System.out.print(KeyEvent.getKeyText(e.getKeyCode()));
			}
			
		});
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Frame f = new Frame("shubiaojianp");
		TextField tf = new TextField(15);
		f.setBounds(200, 300, 400, 400);
		MouseKeyDemo  mkd = new MouseKeyDemo(f, tf);
		mkd.myEvent();
	}

}
