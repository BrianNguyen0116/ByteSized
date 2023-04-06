import java.io.Serializable;

public class Info implements Serializable{
    String address;
    String phoneNumber;
    String name;
    String moto;

    protected Info() {
        address = "";
        phoneNumber = "";
        name = "";
        moto = "";
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }
}
