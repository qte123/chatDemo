package server;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Calendar;

/**
 * 服务器端
 */
public interface Server {
    //接收信息
    public void imageServer(JTextArea textArea) throws IOException;
}
