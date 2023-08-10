package window;

<<<<<<< HEAD
import common.Common;

=======
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
import javax.swing.*;
import java.awt.*;

public class Windows {
    private JFrame frame=new JFrame();

    public Windows() {
    }

<<<<<<< HEAD
=======
    public Windows(JFrame frame) {
        this.frame = frame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
    public void send() {
        frame.setTitle("发送成功");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 261, 117);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("发送成功！");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(90, 29, 75, 18);
<<<<<<< HEAD
        Common common=new Common();
        common.windowCommon(frame,lblNewLabel);
=======
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
    }

    public void error() {
        frame.setTitle("警告！");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 398, 212);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("没有输入电脑IP地址或计算机名称");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(85, 76, 226, 18);
<<<<<<< HEAD
        Common common=new Common();
        common.windowCommon(frame,lblNewLabel);
=======
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
    }

    public void txtNull() {
        frame.setTitle("警告！");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 398, 212);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("发送的消息不能为空！");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(122, 77, 150, 18);
<<<<<<< HEAD
        Common common=new Common();
        common.windowCommon(frame,lblNewLabel);
=======
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
    }

    public void win(String ip) {
        frame.setTitle("欢迎！");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 398, 212);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel;
        if (ip.equals("127.0.0.1")) {
            lblNewLabel = new JLabel("正在使用本地连接");
        } else {
            lblNewLabel = new JLabel("正在使用网络连接");
        }
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(135, 77, 150, 18);
<<<<<<< HEAD
        Common common=new Common();
        common.windowCommon(frame,lblNewLabel);
=======
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
    }

    public void linkError() {
        frame = new JFrame();
        frame.setTitle("错误！");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 398, 212);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("输入的电脑IP地址或计算机名称错误！连接中断");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(36, 78, 316, 18);
<<<<<<< HEAD
        Common common=new Common();
        common.windowCommon(frame,lblNewLabel);
=======
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
    }

    public void loginError() {
        frame = new JFrame();
        frame.setTitle("警告！");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("view\\res\\image\\icon.jpg"));
        frame.setBounds(100, 100, 398, 212);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("请输入用户名称！");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
        lblNewLabel.setBounds(137, 75, 120, 18);
<<<<<<< HEAD
        Common common=new Common();
        common.windowCommon(frame,lblNewLabel);
=======
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
    }
}
