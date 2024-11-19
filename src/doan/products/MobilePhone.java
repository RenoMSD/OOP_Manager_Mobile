package doan.products;

public class MobilePhone extends Product {
    private String ram;
    private String storage;
    private String battery;
    private String camera;

    public MobilePhone(String id, String name, double price, String brand, String ram, String storage, String battery, String camera) {
        super(id, name, price, brand);
        this.ram = ram;
        this.storage = storage;
        this.battery = battery;
        this.camera = camera;
    }
    
    @Override
    public void display_info() {
        System.out.println("MobilePhone [ID: " + get_Id() +
                           ", Name: " + get_Name() +
                           ", Price: " + get_Price() +
                           ", Brand: " + get_Brand() +
                           ", RAM: " + ram +
                           ", Storage: " + storage +
                           ", Battery: " + battery +
                           ", Camera: " + camera + "]");
    }
}
