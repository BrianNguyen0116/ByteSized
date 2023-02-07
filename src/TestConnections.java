public class TestConnections {

    public static void main(String args[]) {

        RestaurantServer rs = new RestaurantServer();
        rs.createServer();

        ClientConnection cc = new ClientConnection();
        cc.sendOrder("PIZZA!\n");
    }
    
}
