import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientConnection {

    final int PORT = 2000;
    Socket client;
    BufferedReader in;
    PrintWriter out;

    public ClientConnection() {

        try {
            client = new Socket(InetAddress.getLocalHost(), PORT);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch(IOException e) {}

    }

    public void sendOrder(String order) {

        out.write(order);
        out.flush();
    }
    
}
