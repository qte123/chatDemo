package chatDemo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Chat {

    public JFrame frame;
    public static JTextArea textArea = new JTextArea();

    public void run(String ip) {
        Chat chat = new Chat();
        chat.chat(ip);
    }

    public void chat(String ip) {
        frame=new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("res\\image\\icon.jpg"));
        frame.setTitle("聊天室");
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

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(152, 368, 330, 53);
        frame.getContentPane().add(scrollPane_1);

        JTextPane textPane_1 = new JTextPane();
        textPane_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                textPane_1.setText("");
            }
        });
        scrollPane_1.setViewportView(textPane_1);

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
                }else {
                    Window window=new Window();
                    window.txtNull();
                }
            }
        });
        button.setBounds(492, 368, 97, 23);
        frame.getContentPane().add(button);

        JButton button_1 = new JButton("发送文件");
        button_1.setFont(new Font("宋体", Font.PLAIN, 12));
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.showOpenDialog(null);
                File file = fc.getSelectedFile();
                if (file != null) {
                    String path = file.getName();
                    try {
                        Client.fileClient(ip, file, path);
                        Window send = new Window();
                        send.send();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
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
