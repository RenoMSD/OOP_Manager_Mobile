package doan.products;

public class Accessory extends Product {
    private String type;
    private String compatible_devices;

    public Accessory(String id, String name, double price, String brand, String type, String compatible_devices) {
        super(id, name, price, brand);
        this.type = type;
        this.compatible_devices = compatible_devices;
    }
    
    @Override
    public void display_info() {
        System.out.println("Accessrory [ID: " + get_Id() + 
                           ", Name: " + get_Name() + 
                           ", Price: " + get_Price() +
                           ", Brand: " + get_Brand() +
                           ", Type: " + type +
                           ", Compatible Devices: " + compatible_devices + "]");
    }
}
