
package doan.products;

import java.util.Scanner;
import java.io.*;

public class ProductList {
    private final ProductItem[] products;
    private int count;
    private final ProductCategory[] categories;
    private int categoryCount;
    private final PromotionalProduct[] promotionalProducts;
    private int promoCount;
    private final Distributor[] distributors;
    private int distributorCount;

    public ProductList(int size) {
        products = new ProductItem[size];
        count = 0;
        categories = new ProductCategory[size];
        categoryCount = 0;
        promotionalProducts = new PromotionalProduct[size];
        promoCount = 0;
        distributors = new Distributor[size];
        distributorCount = 0;
    }
//moi sua

    public void inputProducts() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhap so san pham : ");
            int n = scanner.nextInt();
            scanner.nextLine(); 

            for (int i = 0; i < n && count < products.length; i++) {
            System.out.println("Nhap thong tin san pham " + (count + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Ten san pham: ");
            String name = scanner.nextLine();
            System.out.print("Gia cua san pham: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Tiêu thụ ký tự newline
            System.out.print("Thuong hieu cua san pham: ");
            String brand = scanner.nextLine();
            System.out.print("Nhap so luong san pham: ");
            int Quantity = scanner.nextInt();
            scanner.nextLine(); // Tiêu thụ ký tự newline

                ProductItem product = new ProductItem(id, name, price, brand,Quantity);
                addProduct(product);
            }
        }
    }

    public void displayProducts() {
        if (count == 0) {
            System.out.println("Khong co san pham nao de hien thi.");
        } else {
            for (int i = 0; i < count; i++) {
                products[i].displayInfo();
                System.out.println("-------------------------");
            }
        }
    }

    public void addNewProduct() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (count >= products.length) {
                System.out.println("Danh sach san pham da day. Khong the nhap them.");
                return;
            }

            System.out.println("Them cac thong tin cho san pham moi:");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Ten san pham moi: ");
            String name = scanner.nextLine();
            System.out.print("Gia san pham moi: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.print("Thuong hieu san pham moi: ");
            String brand = scanner.nextLine();
            System.out.println("Nhap so luong san pham: ");
            int Quantity = scanner.nextInt();

            ProductItem newProduct = new ProductItem(id, name, price, brand, Quantity);
            addProduct(newProduct);
        }

        System.out.println("San pham moi duoc them hoan tat.");
    }

    public void addProduct(ProductItem product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Product list is full.");
        }
    }

    public void editProductById(String id) {
        try (Scanner scanner = new Scanner(System.in)) {
            int index = findProductById(id);

            if (index != -1) {
                System.out.println("Chinh sua thong tin san pham co ma : " + id);
                System.out.print("Ten moi cua san pham la: ");
                String newName = scanner.nextLine();
                System.out.print("Gia moi cua san pham la: ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.print("Thuong hieu moi cua san pham la: ");
                String newBrand = scanner.nextLine();

                products[index].setName(newName);
                products[index].setPrice(newPrice);
                products[index].setBrand(newBrand);

                System.out.println("San pham da duoc cap nhat hoan tat.");
            } else {
                System.out.println("San pham voi id  " + id + " khong duoc tim thay.");
            }
        }
    }

    public void deleteProductById(String id) {
        int index = findProductById(id);

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                products[i] = products[i + 1];
            }
            products[count - 1] = null; 
            count--;
            System.out.println("San pham voi id " + id + " da xoa hoan tat.");
        } else {
            System.out.println("San pham voi id " + id + " khong duoc tim thay.");
        }
    }

    public int findProductById(String id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId().equals(id)) {
                return i;
            }
        }
        return -1; 
    }

    public ProductItem getProduct(int index) {
        if (index >= 0 && index < count) {
            return products[index];
        }
        return null;
    }
    // Phương thưc tìm kiếm theo tên với khả năng gần nhất
    public void searchByName(String keyword){
        boolean found = false;
        keyword = keyword.toLowerCase();
        for(int i = 0; i<= count ; i++){
            if(products[i] != null && products[i].getName().toLowerCase().contains(keyword) ){  //moi sua ngay 16/11
                products[i].displayInfo();
                found = true;
            }
        }
        if(!found){
            System.out.println("Khong tim thay san pham voi ten gan dung!" + keyword +"'.");
        }
    }
    //Thong ke tong so luong san pham
    public int totalProductCount(){
        return count;
    }
    //Thống kê tổng giá trị sản phẩm
    public double totalProductValue(){
        double totalValue = 0;
        for(int i = 0; i < count; i++){
            totalValue += products[i].getPrice()*products[i].getQuantity();
        }
        return totalValue;
    }
    // Thống  kê sản phẩm theo khoảng giá
    public void productsInPriceRange(double minPrice, double maxPrice){
        boolean found = false;
        for(int i = 0; i< count ; i++){
            if(products[i].getPrice() >= minPrice && products[i].getPrice() <= maxPrice){
                products[i].displayInfo();
                found = true;
            }
        }
        if(!found){
            System.out.println("Khong co san pham nao trong khoang gia nay");
        }
    }
    // Sắp xếp sản phẩm theo giá
    public void sortByPrice(){
        for(int i =0; i< count; i++){
            for(int j = i +1; j< count;j++){
                if(products[i].getPrice() > products[j].getPrice()){
                    ProductItem  temp = products[i];
                    products[i]= products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("San pham da duoc sap xep theo gia.");
    }
    // Sắp xếp sản phẩm theo  tên( tăng dần thoe bản chữ cái)
    public void sortByName(){
        for(int i =0; i< count; i++){
            for(int j = i +1; j< count;j++){
                if(products[i].getName().compareToIgnoreCase(products[j].getName()) > 0){
                    ProductItem temp =products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        System.out.println("San pham da duoc sap xep theo ten. ");
    }
    // Tìm kiếm sản phẩm với nhiều từ khóa 
    public void searchbyKeywords(String [] keywords){
        boolean found = false;
        for(int i = 0; i< count; i++ ){
            boolean match = true;
            for (String keyword : keywords ){
                if(!products[i].getName().toLowerCase().contains(keyword.toLowerCase())){
                match = false;
                break;
                }
            }
            if(match){
                products[i].displayInfo();
                found = true;
            }
        }
        if(!found){
            System.out.println("Khong tim thay san pham phu hop voi tu khoa.");
        }
    }
//moi sua
    public void addProductCategory(ProductCategory category) {
        if (categoryCount < categories.length) {
            categories[categoryCount] = category;
            categoryCount++;
        } else {
            System.out.println("Category list is full.");
        }
    }

    public void addPromotionalProduct(PromotionalProduct product) {
        if (promoCount < promotionalProducts.length) {
            promotionalProducts[promoCount] = product;
            promoCount++;
        } else {
            System.out.println("Promotional product list is full.");
        }
    }

    public void addDistributor(Distributor distributor) {
        if (distributorCount < distributors.length) {
            distributors[distributorCount] = distributor;
            distributorCount++;
        } else {
            System.out.println("Distributor list is full.");
        }
    }

    public void displayCategories() {
        System.out.println("Product Categories:");
        for (int i = 0; i < categoryCount; i++) {
            categories[i].displayInfo();
        }
    }

    public void displayPromotionalProducts() {
        System.out.println("Promotional Products:");
        for (int i = 0; i < promoCount; i++) {
            promotionalProducts[i].displayInfo();
        }
    }

    public void displayDistributors() {
        System.out.println("Distributors:");
        for (int i = 0; i < distributorCount; i++) {
            distributors[i].displayInfo();
        }
    }
//moi sua

   // Load products from a file
    public void loadProductsFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) {
                    String id = data[0];
                    String name = data[1];
                    double price = Double.parseDouble(data[2]);
                    String brand = data[3];
                    int quantity = Integer.parseInt(data[4]);
                    ProductItem product = new ProductItem(id, name, price, brand, quantity);
                    addProduct(product);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    // Save all products to a new file
    public void saveProductsToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < count; i++) {
                ProductItem product = products[i];
                String line = product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getBrand() + "," + product.getQuantity();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    

}   



