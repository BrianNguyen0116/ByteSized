import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RestaurantServer {
    public static void main(String[] args) throws Exception {
        
        final int PORT = 2000;
        Socket clientSocket;
        String order = "";

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            clientSocket = serverSocket.accept();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String newLine;
            while((newLine = in.readLine()) != null) {
                order += newLine;
            }

            out.write("Thank you for your order!\n");
            out.flush();
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch(IOException e) {}

        System.out.println(order);
    }
}
