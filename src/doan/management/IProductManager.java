
package doan.management;

import doan.products.ProductItem;

public interface IProductManager {
     
    public void inputProducts();
    public void displayProducts();
    public void addNewProduct();
    public void addProduct(ProductItem product);
    public void editProductById(String id);
    public void deleteProductById(String id);
    public int findProductById(String id);
    public void searchByName(String keyword);
    public int totalProductCount();
    public double totalProductValue();
    public void productsInPriceRange(double minPrice, double maxPrice);
    public void sortByPrice();
    public void sortByName();
    public void searchbyKeywords(String [] keywords);


}
