package server.serverImpl;

import common.UDPBase;
import server.Server;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Calendar;

public class ServerImpl extends UDPBase implements Server {

    public ServerImpl() {
    }

    public void imageServer(JTextArea textArea) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);
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
            String hours = hour < 9 ? "0" + hour : "" + hour;
            String minutes = minute < 9 ? "0" + minute : "" + minute;
            String seconds = second < 9 ? "0" + second : "" + second;
            String time = year + "/" + month + "/" + day + " " + hours + ":" + minutes + ":" + seconds;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);//txt
            DatagramPacket dp2 = new DatagramPacket(bytes1, bytes1.length);//file
            DatagramPacket dp3 = new DatagramPacket(bytes2, bytes2.length);//name
            ds.receive(dp);
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
                ds.receive(dp2);
                byte[] data2 = dp2.getData();
                int length2 = dp2.getLength();
                os = new FileOutputStream("res//file//" + path);
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
