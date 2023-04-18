package usersAndProducts;
import java.util.UUID;

public class Customers {

    private String name;
    private String secondName;
    private String email;
    private String address;
    private UUID id;

    public Customers() {
        this.id = UUID.randomUUID();
    }


    public Customers(String name, String secondName, String email, String address, UUID id) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.address = address;
        this.id = id;
    }

    public Customers(String name, String secondName, String email, String address) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return super.toString();
    }


}
