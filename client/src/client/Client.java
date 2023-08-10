package client;


import java.io.File;
import java.io.IOException;

/**
 * 客户端
 */
public interface Client{
    //发送消息数据
    void txtClient(String str, String name) throws IOException;
    //发送文件数据
    void fileClient(File file, String path, String name) throws IOException;
}
