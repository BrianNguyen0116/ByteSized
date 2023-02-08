import java.io.*;
import java.net.Socket;

public class HandleClient extends Thread{

    private Socket client;
    private BufferedReader in;
    
    public HandleClient(Socket socket) {
        
        this.client = socket;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch(IOException e) {}
    }

    public void run() {

        String order = null, newLine;

        try {
            while((newLine = in.readLine()) != null)
                order += newLine;
        } catch(IOException e) {}

        System.out.println(order);
        System.out.println("Thank you for your order!\n");
    }
    
}
