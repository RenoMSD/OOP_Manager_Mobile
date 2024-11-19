
package doan.management;

import doan.products.ProductList;
import doan.products.ProductItem;
import doan.products.ProductCategory;
import doan.products.PromotionalProduct;
import doan.products.Distributor;

public class ProductManager implements IProductManager, IManagement {
    private final ProductList productlist;

    public ProductManager(ProductList productlist) {
        this.productlist = productlist;
    }

    @Override
     public void inputProducts(){
        productlist.inputProducts();
     }
    @Override
    public void displayProducts(){
        productlist.displayProducts();
    }
    @Override
    public void addNewProduct(){
        productlist.addNewProduct();
    }
    @Override
    public void addProduct(ProductItem product){
        productlist.addProduct(product);
    }
    @Override
    public void editProductById(String id){
        productlist.editProductById(id);
    }
    @Override
    public void deleteProductById(String id){
        productlist.deleteProductById(id);
    }
    @Override
    public int findProductById(String id){
        return productlist.findProductById(id);
    }
    @Override
    public void searchByName(String keyword){
        productlist.searchByName(keyword);
    }
    @Override
    public int totalProductCount(){
        return productlist.totalProductCount();
    }
    @Override
    public double totalProductValue(){
        return productlist.totalProductValue();
    }
    @Override
    public void productsInPriceRange(double minPrice, double maxPrice){
        productlist.productsInPriceRange(minPrice, maxPrice);
    }
    @Override
    public void sortByPrice(){
        productlist.sortByPrice();
    }
    @Override
    public void sortByName(){
        productlist.sortByName();
    }
    @Override
    public void searchbyKeywords(String [] keywords){
        productlist.searchbyKeywords(keywords);
    }

    @Override
    public void addCategory(ProductCategory category) {
        productlist.addProductCategory(category);
    }

    @Override
    public void addPromotionalProduct(PromotionalProduct product) {
        productlist.addPromotionalProduct(product);
    }

    @Override
    public void addDistributor(Distributor distributor) {
        productlist.addDistributor(distributor);
    }

    @Override
    public void displayCategories() {
        productlist.displayCategories();
    }

    @Override
    public void displayPromotionalProducts() {
        productlist.displayPromotionalProducts();
    }

    @Override
    public void displayDistributors() {
        productlist.displayDistributors();
    }

    
}

   


   






