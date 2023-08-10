package loginView;

import chatView.ChatView;
import window.Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrivateView {

    private JFrame frame;
    private JTextField textField;

    public PrivateView() {
    }

    public PrivateView(JFrame frame, JTextField textField) {
        this.frame = frame;
        this.textField = textField;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public void view(String name) {
        frame = new JFrame();
        frame.setTitle("聊天室登录");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 574, 403);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("欢迎使用聊天室");
        label.setFont(new Font("宋体", Font.PLAIN, 21));
        label.setBounds(201, 91, 147, 25);
        frame.getContentPane().add(label);

        JLabel lblip = new JLabel("请输入对方电脑的IP地址或计算机名称：");
        lblip.setFont(new Font("宋体", Font.PLAIN, 15));
        lblip.setBounds(139, 174, 271, 18);
        frame.getContentPane().add(lblip);

        textField = new JTextField();
        textField.setBounds(196, 241, 163, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Windows windows = new Windows();
                if (!textField.getText().equals("")) {
                    String ip = textField.getText();
                    ChatView chatView = new ChatView();
                    frame.setVisible(false);
                    String str = "（私聊模式）";
                    chatView.run(ip, str, name);
                    windows.win(ip);
                } else {

                    windows.error();
                }
            }
        });
        btnNewButton.setBounds(196, 280, 163, 25);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel = new JLabel("本机本地IP地址：127.0.0.1");
        lblNewLabel.setBounds(201, 203, 209, 15);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
}
