package chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class View {

    private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) throws IOException {
       View view=new View();
        view.view();
        Server.txtServer(Chat.textArea);
    }
    public void view() {
        frame = new JFrame();
        frame.setTitle("聊天室登录");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("欢迎使用聊天室");
        label.setFont(new Font("宋体", Font.PLAIN, 21));
        label.setBounds(140, 49, 147, 25);
        frame.getContentPane().add(label);

        JLabel lblip = new JLabel("请输入对方电脑的IP地址或计算机名称：");
        lblip.setFont(new Font("宋体", Font.PLAIN, 15));
        lblip.setBounds(89, 112, 271, 18);
        frame.getContentPane().add(lblip);

        textField = new JTextField();
        textField.setBounds(140, 158, 163, 21);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String ip=textField.getText();
                Chat chat=new Chat();
                frame.setVisible(false);
                chat.run(ip);
            }
        });
        btnNewButton.setBounds(140, 203, 163, 25);
        frame.getContentPane().add(btnNewButton);
        frame.setVisible(true);
    }
}
