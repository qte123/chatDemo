package loginView;

import chatView.ChatView;
import common.Common;
import common.UDPBase;
import window.Windows;

import javax.swing.*;
import java.awt.*;

/**
 * 私聊界面
 */
public class PrivateView extends UDPBase {

    private  JFrame frame=new JFrame();
    private JLabel label=new JLabel();
    public PrivateView() {
    }

    public void view(String name) {
        Common common=new Common();
        common.viewCommon(frame,label);
        label.setFont(new Font("宋体", Font.PLAIN, 21));
        label.setBounds(201, 91, 147, 25);
        frame.getContentPane().add(label);

        JLabel lblip = new JLabel("请输入对方电脑的IP地址或计算机名称：");
        lblip.setFont(new Font("宋体", Font.PLAIN, 15));
        lblip.setBounds(139, 174, 271, 18);
        frame.getContentPane().add(lblip);

        JTextField textField = new JTextField();
        textField.setBounds(196, 241, 163, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.addActionListener(arg0 -> {
            Windows windows = new Windows();
            if (!textField.getText().equals("")) {
                ip = textField.getText();
                ChatView chatView = new ChatView();
                frame.setVisible(false);
                String str = "（私聊模式）";
                chatView.run(str, name);
                windows.win(ip);
            } else windows.error();
        });
        btnNewButton.setBounds(196, 280, 163, 25);
        frame.getContentPane().add(btnNewButton);

        JLabel lblNewLabel = new JLabel("本机本地IP地址：127.0.0.1");
        lblNewLabel.setBounds(201, 203, 209, 15);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }

}
