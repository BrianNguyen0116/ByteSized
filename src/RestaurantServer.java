import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RestaurantServer {
        
    final int PORT = 2000;
    Socket clientSocket;

    public void server() {

        String order = "";
        
        try {
            while(true) {
                ServerSocket serverSocket = new ServerSocket(PORT);
                clientSocket = serverSocket.accept();
                HandleClient handleClient = new HandleClient(clientSocket);
                handleClient.start();
            }
        } catch(IOException e) {}    
    }
}