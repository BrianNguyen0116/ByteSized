import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializedInventory extends Inventory {

    private File file;
    private Inventory inventory;
    private static SerializedInventory instance;

    /*public static void main(String[] args) {
        SerializedInventory sinv = SerializedInventory.getInstance();
        System.out.println(sinv.getInventory().getItem("Tomato Sauce").toString());
        System.out.println(sinv.getInventory().getItem("Tomato Sauce").getTotal());

        sinv.getInventory().getItem("Tomato Sauce").setTotal(75);
        System.out.println(sinv.getInventory().getItem("Tomato Sauce").getTotal());
        sinv.saveInventory();
    }*/

    private SerializedInventory() {

        file = new File("objectdata.txt");

        if(file.isFile()) {
            inventory = loadInventory();
            System.out.println("Loaded Inventory!\n");
        }
        else {
            inventory = new Inventory();
            System.out.println("Created New Inventory!\n");
        }
    }

    public static SerializedInventory getInstance() {
        if(instance == null)
            instance = new SerializedInventory();

        return instance;
    }

    public void saveInventory() {

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inventory);
            oos.flush();
            oos.close();
            fos.close();
        }
        catch(FileNotFoundException e) {
            //
        }
        catch(IOException e) {
            //
        }
    }

    private Inventory loadInventory() {

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream oip = new ObjectInputStream(fis);
            inventory = (Inventory)oip.readObject();
            oip.close();
            fis.close();
        }
        catch(FileNotFoundException e) {
            //
        }
        catch(IOException e) {
            System.out.println("ERROR!\n");
        }
        catch(ClassNotFoundException e) {
            System.out.println("ERROR!\n");
        }

        return inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }
    
}
