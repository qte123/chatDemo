package chat;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Client extends Thread {
    private static final int MAX = 65536;

    public static void txtClient(String ip,String str) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] bytes = str.getBytes();
        String s = "T" + new String(bytes, 0, bytes.length);
        byte[] bytes1 = s.getBytes();
        InetAddress address = InetAddress.getByName(ip);
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes1, bytes1.length, address, port);
        ds.send(dp);
        ds.close();
    }

    public static void fileClient(String ip,File file, String path) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        InputStream is = new FileInputStream(file);
        int len;
        int length = 0;
        byte[] bytes = new byte[MAX];
        while ((len = is.read(bytes)) != -1) {
            length = len;
        }
        byte[] pb = ("F"+path).getBytes();
        InetAddress address = InetAddress.getByName(ip);
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(pb, pb.length, address, port);
        DatagramPacket dp2 = new DatagramPacket(bytes, length, address, port);
        ds.send(dp);
        ds.send(dp2);
        ds.close();
    }
}

