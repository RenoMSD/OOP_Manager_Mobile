package doan.products;

//Sản phẩm khuyến mãi
public class PromotionalProduct extends ProductItem {
    private double discount;

    public PromotionalProduct(String id, String name, double price, String brand, int quantity, double discount) {
        super(id, name, price, brand, quantity);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Discount: " + discount + "%");
    }
}
