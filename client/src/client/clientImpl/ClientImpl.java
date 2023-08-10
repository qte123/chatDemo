package client.clientImpl;

import client.Client;
import common.UDPBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class ClientImpl extends UDPBase implements Client {

    public ClientImpl() {
    }

    @Override
    public void txtClient(String ip, String str, String name) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] bytes = str.getBytes();
        String s = "T" + new String(bytes, 0, bytes.length);
        byte[] bytes1 = s.getBytes();
        byte[] namebyte = name.getBytes();
        int port = 10000;
        InetAddress address = InetAddress.getByName(ip);
        DatagramPacket dp = new DatagramPacket(bytes1, bytes1.length, address, port);
        DatagramPacket dp1 = new DatagramPacket(namebyte, namebyte.length, address, port);
        ds.send(dp);
        ds.send(dp1);
        ds.close();
    }

    @Override
    public void fileClient(String ip, File file, String path, String name) throws IOException {
        byte[] namebyte = name.getBytes();
        DatagramSocket ds = new DatagramSocket();
        InputStream is = new FileInputStream(file);
        int len;
        int length = 0;
        byte[] bytes = new byte[MAX];
        while ((len = is.read(bytes)) != -1) {
            length = len;
        }
        byte[] pb = ("F" + path).getBytes();
        int port = 10000;
        InetAddress address = InetAddress.getByName(ip);
        DatagramPacket dp = new DatagramPacket(pb, pb.length, address, port);
        DatagramPacket dp2 = new DatagramPacket(bytes, length, address, port);
        DatagramPacket dp3 = new DatagramPacket(namebyte, namebyte.length, address, port);
        ds.send(dp);//path
        ds.send(dp2);//file
        ds.send(dp3);//name
        ds.close();
    }
}

