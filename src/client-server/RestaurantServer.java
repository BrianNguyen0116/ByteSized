import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RestaurantServer {
        
    private final int PORT = 2000;
    private Socket clientSocket;

    public void createServer() {

        try (ServerSocket serverSocket = new ServerSocket(PORT)){
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