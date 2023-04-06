import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializedInfo extends Info {

    private File file;
    private Info info;
    private static SerializedInfo instance;


    public static void main(String[] args) {
        //SerializedInfo sinfo = SerializedInfo.getInstance();
        //sinfo.getInfo().setAddress("4800 Keele Street");
        //sinfo.getInfo().setPhoneNumber("416-555-7777");
        //sinfo.saveInfo();
        System.out.println(SerializedInfo.getInstance().getInfo().getAddress());
        System.out.println(SerializedInfo.getInstance().getInfo().getPhoneNumber());
    }

    private SerializedInfo() {

        file = new File("info_data.txt");

        if(file.isFile()) {
            info = loadInfo();
            if (info != null)
                System.out.println("Loaded information!\n");
            else {
            	info = new Info();
            	System.out.println("Created New information!\n");
            }
        }
        else {
            info = new Info();
            System.out.println("Created New information!\n");
        }
    }

    public static SerializedInfo getInstance() {
        if(instance == null)
            instance = new SerializedInfo();

        return instance;
    }

    public void saveInfo() {

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(info);
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

    private Info loadInfo() {

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream oip = new ObjectInputStream(fis);
            info = (Info)oip.readObject();
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

        return info;
    }

    public Info getInfo() {
        return info;
    }
    
}