
package doan.products;

/*
Chinh sua gan nhat: 14/10/24 8:33 
vi tri chinh sua: bien quantity, phuong thuc setPrice va setQuantiy
noi dung: kiem tra du lieu price va quantity nhap vao, neu <0 thi dat la 0;
*/
public class ProductItem {
    protected String id;
    protected String name;
    protected double price;
    protected String brand;
    protected int Quantity;

    public ProductItem(String id, String name, double price, String brand, int quantity) {
        this.id = id;
        this.name = name;
        setPrice(price);
        this.brand = brand;
        setQuantity(quantity); 
    }

    public ProductItem() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
    public int getQuantity(){
        return Quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) this.price = 0;
        else this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setQuantity(int Quantity){
        if (Quantity < 0) Quantity = 0;
        else this.Quantity = Quantity;
    }

    public void displayInfo() {
        System.out.println("Id cua san pham la : " + id);
        System.out.println("Ten cua san pham la : " + name);
        System.out.println("Gia cua san pham la : " + price);
        System.out.println("Thuong hieu cua san pham la : " + brand);
        System.out.println("Số lượng của sản phẩm là : " + Quantity);
    }
}