package loginView;

import chatView.ChatView;
import server.Server;
import server.serverImpl.ServerImpl;
<<<<<<< HEAD
import java.io.IOException;

/**
 * 启动程序
 */
=======

import java.io.IOException;
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
public class Run {
    public static void main(String[] args) throws IOException {
        LoginView login = new LoginView();
        login.view();
        Server server = new ServerImpl();
<<<<<<< HEAD
        server.imageServer(ChatView.textArea);
=======
        server.imageServer(ChatView.getTextArea());
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
    }
}
