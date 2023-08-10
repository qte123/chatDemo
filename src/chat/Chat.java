package chat;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Chat {


    public static JTextArea textArea = new JTextArea();

    public void run(String ip) {
        Chat chat = new Chat();
        chat.chat(ip);
    }

    public void chat(String ip) {
        JFrame frame=new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res\\image\\icon.jpg"));
        frame.setTitle("聊天室");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("聊天室");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        lblNewLabel.setBounds(184, 10, 60, 24);
        frame.getContentPane().add(lblNewLabel);
        //textArea.setEditable(false);
        textArea.setBounds(74, 69, 280, 104);
        frame.getContentPane().add(textArea);

        JTextPane textPane_1 = new JTextPane();
        textPane_1.setBounds(74, 191, 170, 53);
        frame.getContentPane().add(textPane_1);

        JButton button = new JButton("发送消息");
        button.setFont(new Font("宋体", Font.PLAIN, 12));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if(!textPane_1.getText().equals("")){
                    try {
                        Client.txtClient(ip, textPane_1.getText());
                        textPane_1.setText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        button.setBounds(257, 191, 97, 23);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("发送文件");
        button_1.setFont(new Font("宋体", Font.PLAIN, 12));
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.showOpenDialog(null);
                File file = fc.getSelectedFile();
                String path = file.getName();
                if (file != null) {
                    try {
                        Client.fileClient(ip, file, path);
                        Send send = new Send();
                        send.send();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        button_1.setBounds(257, 221, 97, 23);
        frame.getContentPane().add(button_1);

        JLabel lblNewLabel_1 = new JLabel("对方的回复");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(184, 44, 60, 15);
        frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("输入框：");
        lblNewLabel_2.setToolTipText("");
        lblNewLabel_2.setBounds(74, 177, 54, 15);
        frame.getContentPane().add(lblNewLabel_2);
        frame.setVisible(true);
    }
}
