package doan;

import java.util.Scanner;

import doan.accounts.LoginManager;
import doan.management.ProductManager;
import doan.products.ProductItem;
import doan.products.ProductList;

public class Main {
    public static void main(String[] args) {
        ProductList productList = new ProductList(100);
        ProductManager productManager = new ProductManager(productList);
        LoginManager loginManager = new LoginManager();

        // Đọc dữ liệu từ file
        productList.loadProductsFromFile("product.txt");

        Scanner scanner = new Scanner(System.in);
        boolean isAuthenticated = false;
        boolean isAdmin = false;

        // Đăng nhập
        while (!isAuthenticated) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            System.out.print("Are you an admin? (yes/no): ");
            String adminResponse = scanner.nextLine();
            isAdmin = adminResponse.equalsIgnoreCase("yes");

            isAuthenticated = loginManager.authenticate(username, password, isAdmin);
            if (!isAuthenticated) {
                System.out.println("Invalid credentials. Please try again.");
            }
        }

        int choice;
        do {
            System.out.println("1. Display Products");
            System.out.println("2. Search Product by ID");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Search Product by Keywords");
            System.out.println("5. Sort Products by Price");
            System.out.println("6. Sort Products by Name");
            System.out.println("7. Display Promotional Products");

            if (isAdmin) {
                System.out.println("8. Add New Product");
                System.out.println("9. Edit Product by ID");
                System.out.println("10. Delete Product by ID");
                System.out.println("11. Total Product Count");
                System.out.println("12. Total Product Value");
                System.out.println("13. Display Products in Price Range");
                System.out.println("14. Display Product Categories");
                System.out.println("15. Display Distributors");
                System.out.println("16. Save and Exit");
            } else {
                System.out.println("8. Save and Exit");
            }

            System.out.print("Enter your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    productManager.displayProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    String id = scanner.nextLine();
                    int index = productManager.findProductById(id);
                    if (index != -1) {
                        productList.getProduct(index).displayInfo();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    productManager.searchByName(name);
                    break;
                case 4:
                    System.out.print("Enter Keywords (comma separated): ");
                    String[] keywords = scanner.nextLine().split(",");
                    productManager.searchbyKeywords(keywords);
                    break;
                case 5:
                    productManager.sortByPrice();
                    break;
                case 6:
                    productManager.sortByName();
                    break;
                case 7:
                    productManager.displayPromotionalProducts();
                    break;
                case 8:
                    if (isAdmin) {
                        System.out.print("Enter Product ID: ");
                        String newId = scanner.nextLine();
                        System.out.print("Enter Product Name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter Product Price: ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // Consume invalid input
                        }
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Product Brand: ");
                        String newBrand = scanner.nextLine();
                        System.out.print("Enter Product Quantity: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // Consume invalid input
                        }
                        int newQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        ProductItem newProduct = new ProductItem(newId, newName, newPrice, newBrand, newQuantity);
                        productManager.addProduct(newProduct);
                    } else {
                        productList.saveProductsToFile("product.txt");
                        System.out.println("Data saved. Exiting...");
                        choice = 16; // Exit loop
                    }
                    break;
                case 9:
                    if (isAdmin) {
                        System.out.print("Enter Product ID to edit: ");
                        String editId = scanner.nextLine();
                        productManager.editProductById(editId);
                    }
                    break;
                case 10:
                    if (isAdmin) {
                        System.out.print("Enter Product ID to delete: ");
                        String deleteId = scanner.nextLine();
                        productManager.deleteProductById(deleteId);
                    }
                    break;
                case 11:
                    if (isAdmin) {
                        System.out.println("Total Product Count: " + productManager.totalProductCount());
                    }
                    break;
                case 12:
                    if (isAdmin) {
                        System.out.println("Total Product Value: " + productManager.totalProductValue());
                    }
                    break;
                case 13:
                if (isAdmin) {
                    double minPrice = 0, maxPrice = 0;
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            System.out.print("Enter Min Price: ");
                            minPrice = Double.parseDouble(scanner.nextLine());
                            System.out.print("Enter Max Price: ");
                            maxPrice = Double.parseDouble(scanner.nextLine());

                            validInput = true; //cả hai giá trị là số thì validInput mới là true
                            
                            if (minPrice < 0 || maxPrice < 0) {
                                System.out.println("Gia san pham phai lon hon 0! Vui long nhap lai");
                                validInput = false;
                            }

                            //nếu minPrice > maxPrice
                            if (minPrice > maxPrice) {
                                System.out.println("Min Price khong duoc lon hon Max Price! Vui long nhap lai");
                                validInput = false; 
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Gia tri khong hop le! Vui long nhap lai");
                        }
                    }
                    productManager.productsInPriceRange(minPrice, maxPrice);
                }
                break;
                case 14:
                    if (isAdmin) {
                        productManager.displayCategories();
                    }
                    break;
                case 15:
                    if (isAdmin) {
                        productManager.displayDistributors();
                    }
                    break;
                case 16:
                    if (isAdmin) {
                        productList.saveProductsToFile("product.txt");
                        System.out.println("Data saved. Exiting...");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 16);

        scanner.close();
    }
}
