package chatDemo;

import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame frame;
    public void send() {
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
    public void error() {
        frame = new JFrame();
        frame.setTitle("警告！");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 398, 212);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("没有输入电脑IP地址或计算机名称");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(85, 76, 226, 18);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
    public void txtNull() {
        frame = new JFrame();
        frame.setTitle("警告！");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 398, 212);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("发送的消息不能为空！");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(122, 77, 150, 18);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
    public void win(String ip) {
        frame = new JFrame();
        frame.setTitle("欢迎！");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 398, 212);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel;
        if(ip.equals("127.0.0.1")) {
            lblNewLabel = new JLabel("正在使用本地连接");
        }else {
            lblNewLabel = new JLabel("正在使用网络连接");
        }
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(135, 77, 150, 18);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
}
