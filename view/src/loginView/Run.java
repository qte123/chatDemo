package loginView;

import chatView.ChatView;
import server.Server;
import server.serverImpl.ServerImpl;

import java.io.IOException;
public class Run {
    public static void main(String[] args) throws IOException {
        LoginView login = new LoginView();
        login.view();
        Server server = new ServerImpl();
        server.imageServer(ChatView.getTextArea());
    }
}
