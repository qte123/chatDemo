package common;

import javax.swing.*;
import java.awt.*;

public class Common {
    public void viewCommon(JFrame frame,JLabel label){
        frame.setTitle("聊天室登录");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 574, 403);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        label.setText("欢迎使用聊天室");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("宋体", Font.PLAIN, 21));
    }
    public void windowCommon(JFrame frame,JLabel lblNewLabel){
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
}
