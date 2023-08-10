package server;

import javax.swing.*;
import java.io.IOException;

/**
 * 服务器端
 */
public interface Server {
    //接收信息
    void imageServer(JTextArea textArea) throws IOException;
}
