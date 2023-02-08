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

    public ClientConnection(int port) {

        try {
            client = new Socket(InetAddress.getLocalHost(), 2000);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        } catch(IOException e) {System.out.println("FAILED!\n");}

    }

    public void sendOrder(String order) {

        out.write(order);
        out.flush();
    }

    public void close() {
        
        try {
            out.close();
            in.close();
            client.close();
        } catch(IOException e) {}
    }

    public static void main(String args[]) {

        ClientConnection cc = new ClientConnection(Integer.parseInt(args[0]));
        //cc.sendOrder("PIZZA!\n");
        cc.close();
    }
}