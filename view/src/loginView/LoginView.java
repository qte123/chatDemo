package loginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import chatView.ChatView;
import window.Windows;
public class LoginView {

    private JFrame frame;
    private JTextField textField;

    public LoginView() {
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

    public void view() {
        frame = new JFrame();
        frame.setTitle("聊天室登录");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 574, 403);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("欢迎使用聊天室");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("宋体", Font.PLAIN, 21));
        label.setBounds(204, 115, 147, 25);
        frame.getContentPane().add(label);
        textField = new JTextField();
        textField.setBounds(188, 188, 182, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        JButton btnNewButton = new JButton("私聊模式");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Windows windows =new Windows();
                String name = textField.getText();
                if(!name.equals("")){
                    frame.setVisible(false);
                    PrivateView view = new PrivateView();
                    view.view(name);
                }else {
                    windows.loginError();
                }
            }
        });
        btnNewButton.setBounds(189, 219, 181, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("群聊模式");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Windows windows = new Windows();
                String ip = "255.255.255.255";
                String str = "（群聊模式）";
                String name = textField.getText();
                if (!name.equals("")) {
                    ChatView chatView = new ChatView();
                    frame.setVisible(false);
                    chatView.run(ip, str, name);
                    windows.win(ip);
                } else {
                    windows.loginError();
                }

            }
        });
        btnNewButton_1.setBounds(189, 252, 181, 23);
        frame.getContentPane().add(btnNewButton_1);
        JLabel lblNewLabel = new JLabel("请输入你在聊天室的名称：");
        lblNewLabel.setBounds(204, 163, 166, 15);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
}
