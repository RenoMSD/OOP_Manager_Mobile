package doan.customers;

public class Customer {
    private String id;
    private String name;
    private String address;

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String get_Id() {
        return id;
    }

    public String get_Name() {
        return name;
    }

    public String get_Address() {
        return address;
    }
}