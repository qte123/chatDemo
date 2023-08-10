package server.serverImpl;

import common.UDPBase;
import server.Server;

import javax.swing.*;
import java.awt.*;
<<<<<<< HEAD
import java.io.File;
=======
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Calendar;

public class ServerImpl extends UDPBase implements Server {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
    public ServerImpl() {
    }

    public void imageServer(JTextArea textArea) throws IOException {
<<<<<<< HEAD
        DatagramSocket ds = new DatagramSocket(SERVER_PORT);
=======
<<<<<<< HEAD
        DatagramSocket ds = new DatagramSocket(SERVER_PORT);
=======
        DatagramSocket ds = new DatagramSocket(10000);
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
        OutputStream os;
        byte[] bytes = new byte[MAX];
        byte[] bytes1 = new byte[MAX];
        byte[] bytes2 = new byte[MAX];
        while (true) {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DATE);
            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);
            int second = calendar.get(Calendar.SECOND);
<<<<<<< HEAD
            String hours = hour <= 9 ? "0" + hour : "" + hour;
            String minutes = minute <= 9 ? "0" + minute : "" + minute;
            String seconds = second <= 9 ? "0" + second : "" + second;
=======
<<<<<<< HEAD
            String hours = hour <= 9 ? "0" + hour : "" + hour;
            String minutes = minute <= 9 ? "0" + minute : "" + minute;
            String seconds = second <= 9 ? "0" + second : "" + second;
=======
            String hours = hour < 9 ? "0" + hour : "" + hour;
            String minutes = minute < 9 ? "0" + minute : "" + minute;
            String seconds = second < 9 ? "0" + second : "" + second;
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
            String time = year + "/" + month + "/" + day + " " + hours + ":" + minutes + ":" + seconds;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);//txt
            DatagramPacket dp2 = new DatagramPacket(bytes1, bytes1.length);//file
            DatagramPacket dp3 = new DatagramPacket(bytes2, bytes2.length);//name
            ds.receive(dp);
<<<<<<< HEAD

=======
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
            byte[] data = dp.getData();
            int length = dp.getLength();
            textArea.setForeground(Color.BLUE);
            if (data[0] == 84) {
                //说明是消息
                ds.receive(dp3);
                byte[] name = dp3.getData();
                int nameLength = dp3.getLength();
                String txt = new String(data, 0, length).substring(1);
                String adminName = new String(name, 0, nameLength);
                textArea.append("用户" + adminName + "：\n  " + txt + "\n");
                textArea.append("\t\t" + time + "\n");
            }
            if (data[0] == 70) {
                //说明是文件
                String path = new String(data, 0, length).substring(1);
<<<<<<< HEAD
                File file=new File("res//file");
                file.mkdirs();
                ds.receive(dp2);
                byte[] data2 = dp2.getData();
                int length2 = dp2.getLength();
                os = new FileOutputStream("res//file//" + path);
=======
                ds.receive(dp2);
                byte[] data2 = dp2.getData();
                int length2 = dp2.getLength();
<<<<<<< HEAD
                os = new FileOutputStream("view//res//file//" + path);
=======
                os = new FileOutputStream("res//file//" + path);
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
                os.write(data2, 0, length2);
                os.close();
                ds.receive(dp3);
                byte[] name = dp3.getData();
                int nameLength = dp3.getLength();
                String adminName = new String(name, 0, nameLength);
                textArea.append("用户" + adminName + "：\n  向你发送了" + path + "文件\n");
                textArea.append("\t\t" + time + "\n");
            }
        }

        //ds.close();
    }
}
