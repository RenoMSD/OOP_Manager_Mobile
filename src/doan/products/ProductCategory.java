package doan.products;

//Quản lý loại sản phẩm
public class ProductCategory {
    private String id;
    private String name;

    public ProductCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void displayInfo() {
        System.out.println("Category [ID: " + id + ", Name: " + name + "]");
    }
}
