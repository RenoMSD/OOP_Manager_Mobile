package doan.orders;


import doan.customers.Customer;
import doan.products.Product;

// quantity: số lượng

public class Order {
    private String id; // Mã đơn hàng
    private Customer customer; // Khách hàng liên quan đến đơn hàng
    private Product product; // Sản phẩm trong đơn hàng
    private int quantity; // Số lượng sản phẩm

    public Order(String id, Customer customer, Product product, int quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;  
    }

    public String get_Id() {
        return id; // Trả về mã đơn hàng
    }

    public Customer get_Customer() {
        return customer; // Trả về khách hàng
    }

    public Product get_Product() {
        return product; // Trả về sản phẩm
    }

    public int get_Quantity() {
        return quantity; // Trả về số lượng
    }
}
