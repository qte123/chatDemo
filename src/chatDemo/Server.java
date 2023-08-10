package chatDemo;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    private static final int MAX=65536;
    public  static void txtServer(JTextArea textArea) throws IOException {
        DatagramSocket ds=new DatagramSocket(10000);
        OutputStream os;
        byte[] bytes=new byte[MAX];
        while (true){
            DatagramPacket dp=new DatagramPacket(bytes, bytes.length);
            DatagramPacket dp2=new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            byte[] data=dp.getData();
            int length = dp.getLength();
            if(data[0]==84){
                //说明是消息
                textArea.append("对方："+new String(data,1,length)+"\n");
            }
            if (data[0]==70){
                //说明是文件
                String path=new String(data,0,length).substring(1);
                ds.receive(dp2);
                byte[] data2=dp2.getData();
                int length2 = dp2.getLength();
                os=new FileOutputStream("res//file//"+path);
                os.write(data2,0,length2);
                os.close();
            }
        }

        //ds.close();
    }

}
