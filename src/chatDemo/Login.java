package chatDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Login {

    private JFrame frame;

    public static void main(String[] args) throws IOException {
        Login login=new Login();
        login.view();
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
        label.setBounds(203, 112, 147, 25);
        frame.getContentPane().add(label);

        JButton btnNewButton = new JButton("私聊模式");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                View view=new View();
                view.view();
            }
        });
        btnNewButton.setBounds(189, 170, 181, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("群聊模式");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Chat chat=new Chat();
                frame.setVisible(false);
                Window window=new Window();
                String ip="255.255.255.255";
                String str="（群聊模式）";
                chat.run(ip,str);
                window.win(ip);
            }
        });
        btnNewButton_1.setBounds(189, 220, 181, 23);
        frame.getContentPane().add(btnNewButton_1);
        frame.setVisible(true);
    }
}
