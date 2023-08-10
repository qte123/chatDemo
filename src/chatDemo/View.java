package chatDemo;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class View {

    private JFrame frame;
    private JTextField textField;
    public static void main(String[] args) throws IOException {
        View view=new View();
        view.view();
        Server.txtServer(Chat.textArea);
    }
    public void view() {
        frame = new JFrame();
        frame.setTitle("聊天室登录");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res\\image\\icon.jpg"));
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
                Window window=new Window();
                if(!textField.getText().equals("")) {
                    String ip=textField.getText();
                    Chat chat=new Chat();
                    frame.setVisible(false);
<<<<<<< HEAD
                    String str="（私聊模式）";
                    chat.run(ip,str);
=======
                    chat.run(ip);
>>>>>>> d0433f480452fc68ea6e3c8821fc885412a107d4
                    window.win(ip);
                }
                else {

                    window.error();
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
