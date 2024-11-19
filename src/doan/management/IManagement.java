package doan.management;

import doan.products.ProductCategory;
import doan.products.PromotionalProduct;
import doan.products.Distributor;
//interface của Category, Promotion, Distributor
public interface IManagement {
    void addCategory(ProductCategory category);
    void addPromotionalProduct(PromotionalProduct product);
    void addDistributor(Distributor distributor);
    void displayCategories();
    void displayPromotionalProducts();
    void displayDistributors();
}