package common;

import javax.swing.*;
import java.awt.*;

public class Common {
    public void viewCommon(JFrame frame,JLabel label){
        frame.setTitle("聊天室登录");
<<<<<<< HEAD
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res//img//icon.jpg"));
=======
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
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
