package client;


import java.io.File;
import java.io.IOException;

/**
 * 客户端
 */
public interface Client{
    //发送消息数据
    public void txtClient(String ip, String str, String name) throws IOException;
    //发送文件数据
    public void fileClient(String ip, File file, String path, String name) throws IOException;
}
