package org.lyh.app.window.regist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Administrator on 2015/11/26.
 */
public class AppFrame extends JFrame {

    private static boolean isRegist = false;
    private static String registCode = "000000000";
    public AppFrame() throws HeadlessException {
        this(null);
    }

    public AppFrame(String title) throws HeadlessException {
        super(title);
        this.setBounds(100, 100, 600, 400);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
        if(!isRegist){
            this.showRegistDialog();
        }
    }

    private void showRegistDialog() {
        String inputStr ;
        do{
            inputStr = JOptionPane.showInputDialog("输入注册码!");
            if(inputStr == null){
                System.exit(0);
            }
        }while (!registCode.equals(inputStr));
        isRegist = true;
    }

    public static void main(String[] args) {
        AppFrame appFrame = new AppFrame();
    }
}
