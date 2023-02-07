import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class RestaurantServer {
        
    final int PORT = 2000;
    Socket clientSocket;

    public void createServer() {

        String order = "";
        
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(true) {
                clientSocket = serverSocket.accept();
                HandleClient handleClient = new HandleClient(clientSocket);
                handleClient.start();
            }
        } catch(IOException e) {System.out.println("ERROR!\n" + e);}    
    }

    public static void main(String args[]) {

        RestaurantServer rs = new RestaurantServer();
        rs.createServer();
    }
}