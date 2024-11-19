package doan.products;

public abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected String brand;

    public Product(String id, String name, double price, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }
   
    public String get_Id() {
        return id;
    }

    public String get_Name() {
        return name;
    }

    public double get_Price() {
        return price;
    }

    public String get_Brand() {
        return brand;
    }
    
    public abstract void display_info();
    
}

