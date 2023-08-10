package chatView;

import client.Client;
import client.clientImpl.ClientImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import window.Windows;
public class ChatView {

    private JFrame frame;
    private static JTextArea textArea = new JTextArea();

    public ChatView() {
    }

    public ChatView(JFrame frame) {
        this.frame = frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public static JTextArea getTextArea() {
        return textArea;
    }

    public static void setTextArea(JTextArea textArea) {
        ChatView.textArea = textArea;
    }

    public void run(String ip, String str, String name) {
        ChatView chatView = new ChatView();
        chatView.chat(ip, str, name);
    }

    public void chat(String ip, String str, String name) {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setTitle("聊天室" + str);
        frame.setBounds(100, 100, 767, 559);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("聊 天 室");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
        lblNewLabel.setBounds(319, 58, 101, 30);
        frame.getContentPane().add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(152, 134, 437, 181);
        frame.getContentPane().add(scrollPane);
        scrollPane.setViewportView(textArea);
        textArea.setLineWrap(true);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(152, 368, 330, 53);
        frame.getContentPane().add(scrollPane_1);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setLineWrap(true);
        textArea_1.setBounds(152, 368, 330, 53);
        frame.getContentPane().add(textArea_1);
        textArea.setEditable(false);
        textArea_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                textArea_1.setText("");
            }
        });
        scrollPane_1.setViewportView(textArea_1);
        JButton button = new JButton("发送消息");
        button.setFont(new Font("宋体", Font.PLAIN, 12));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Windows windows = new Windows();
                if (!textArea_1.getText().equals("")) {
                    try {
                        Client client=new ClientImpl();
                        client.txtClient(ip, textArea_1.getText(), name);
                        textArea_1.setText("");
                    } catch (IOException e) {
                        windows.linkError();
                    }
                } else {
                    windows.txtNull();
                }
            }
        });
        button.setBounds(492, 368, 97, 23);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("发送文件");
        button_1.setFont(new Font("宋体", Font.PLAIN, 12));
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Windows windows = new Windows();
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.showOpenDialog(null);
                File file = fc.getSelectedFile();
                if (file != null) {
                    String path = file.getName();
                    try {
                        Client client=new ClientImpl();
                        client.fileClient(ip, file, path, name);
                        windows.send();
                    } catch (IOException ioException) {
                        windows.linkError();
                    }
                }
            }
        });
        button_1.setBounds(492, 398, 97, 23);
        frame.getContentPane().add(button_1);

        JLabel lblNewLabel_1 = new JLabel("对方的回复");
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(341, 109, 60, 15);
        frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("输入框：");
        lblNewLabel_2.setToolTipText("");
        lblNewLabel_2.setBounds(153, 343, 54, 15);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("接收的文件存放在res/file文件夹中");
        lblNewLabel_3.setBounds(378, 343, 211, 15);
        frame.getContentPane().add(lblNewLabel_3);
        frame.setVisible(true);
    }
}
