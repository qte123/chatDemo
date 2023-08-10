package loginView;

import chatView.ChatView;
import common.Common;
import common.UDPBase;
import window.Windows;

import javax.swing.*;

/**
 * 登录界面
 */
public class LoginView extends UDPBase {

    private  JFrame frame=new JFrame();
    private JLabel label=new JLabel();
    public LoginView() {
    }

    public void view() {
        Common common=new Common();
        common.viewCommon(frame,label);
        label.setBounds(204, 115, 147, 25);
        frame.getContentPane().add(label);
        JTextField textField= new JTextField();
        textField.setBounds(188, 188, 182, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        JLabel lblNewLabel = new JLabel("请输入你在聊天室的名称：");
        lblNewLabel.setBounds(204, 163, 166, 15);
        frame.getContentPane().add(lblNewLabel);

        JButton btnNewButton = new JButton("私聊模式");
        btnNewButton.addActionListener(arg0 -> {
            Windows windows = new Windows();
            String name = textField.getText();
            if (!name.equals("")) {
                frame.setVisible(false);
                PrivateView view = new PrivateView();
                view.view(name);
            } else windows.loginError();
        });
        btnNewButton.setBounds(188, 219, 181, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("群聊模式");
        btnNewButton_1.addActionListener(e -> {
            Windows windows = new Windows();
            ip = "255.255.255.255";
            String str = "（群聊模式）";
            String name = textField.getText();
            if (!name.equals("")) {
                ChatView chatView = new ChatView();
                frame.setVisible(false);
                chatView.run(str, name);
                windows.win(ip);
            } else windows.loginError();
        });
        btnNewButton_1.setBounds(188, 252, 181, 23);
        frame.getContentPane().add(btnNewButton_1);
        frame.setVisible(true);
    }
}
