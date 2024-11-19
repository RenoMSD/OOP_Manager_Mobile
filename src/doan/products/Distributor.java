package doan.products;
//nhà cung cấp
public class Distributor {
    private String id;
    private String name;
    private String address;

    public Distributor(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void displayInfo() {
        System.out.println("Distributor [ID: " + id + ", Name: " + name + ", Address: " + address + "]");
    }
}
