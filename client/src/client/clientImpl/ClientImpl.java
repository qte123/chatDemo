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
    public void txtClient(String str, String name) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] bytes = str.getBytes();
        String s = "T" + new String(bytes, 0, bytes.length);
        byte[] bytes1 = s.getBytes();
        byte[] namebyte = name.getBytes();
        InetAddress address = InetAddress.getByName(ip);
        DatagramPacket dp = new DatagramPacket(bytes1, bytes1.length, address, CLIENT_PORT);
        DatagramPacket dp1 = new DatagramPacket(namebyte, namebyte.length, address, CLIENT_PORT);
        ds.send(dp);
        ds.send(dp1);
        ds.close();
    }

    @Override
    public void fileClient(File file, String path, String name) throws IOException {
        byte[] namebyte = name.getBytes();
        DatagramSocket ds = new DatagramSocket();
        InputStream is = new FileInputStream(file);
        int len,length = 0;
        byte[] bytes = new byte[MAX];
        while ((len = is.read(bytes)) != -1) length = len;
        byte[] pb = ("F" + path).getBytes();
        InetAddress address = InetAddress.getByName(ip);
        DatagramPacket dp = new DatagramPacket(pb, pb.length, address, CLIENT_PORT);
        DatagramPacket dp2 = new DatagramPacket(bytes, length, address, CLIENT_PORT);
        DatagramPacket dp3 = new DatagramPacket(namebyte, namebyte.length, address, CLIENT_PORT);
        ds.send(dp);//path
        ds.send(dp2);//file
        ds.send(dp3);//name
        ds.close();
    }
}

