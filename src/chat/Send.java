package chat;

import javax.swing.*;
import java.awt.*;

public class Send {
    public void send() {
        JFrame frame;
        frame = new JFrame();
        frame.setTitle("发送成功");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 261, 117);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("发送成功！");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(90, 29, 75, 18);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
}
