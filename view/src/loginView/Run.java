package loginView;

import chatView.ChatView;
import server.Server;
import server.serverImpl.ServerImpl;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
import java.io.IOException;

/**
 * 启动程序
 */
<<<<<<< HEAD
=======
=======

import java.io.IOException;
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
public class Run {
    public static void main(String[] args) throws IOException {
        LoginView login = new LoginView();
        login.view();
        Server server = new ServerImpl();
<<<<<<< HEAD
        server.imageServer(ChatView.textArea);
=======
<<<<<<< HEAD
        server.imageServer(ChatView.textArea);
=======
        server.imageServer(ChatView.getTextArea());
>>>>>>> 2bd25d2ceddba32748c567f018eee38767cce85c
>>>>>>> bc71a16a46c233ee9f24daf0d986e0959b53c158
    }
}
