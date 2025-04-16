package com.hexaware.oms.presentation;

import com.hexaware.oms.entity.*;
import com.hexaware.oms.service.IOrderManagementRepository;
import com.hexaware.oms.dao.OrderProcessor;
import com.hexaware.oms.exception.*;

import java.util.*;

public class OrderManagementMain {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IOrderManagementRepository service = new OrderProcessor();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Order Management System ---");
            System.out.println("1. Create User");
            System.out.println("2. Create Product");
            System.out.println("3. Place Order");
            System.out.println("4. Cancel Order");
            System.out.println("5. View All Products");
            System.out.println("6. View Orders by User");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        createUser();
                        break;
                    case 2:
                        createProduct();
                        break;
                    case 3:
                        createOrder();
                        break;
                    case 4:
                        cancelOrder();
                        break;
                    case 5:
                        viewAllProducts();
                        break;
                    case 6:
                        viewOrdersByUser();
                        break;
                    case 7:
                        System.out.println("Thank you! Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void createUser() throws Exception {
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Role (Admin/User): ");
        String role = scanner.nextLine();

        User user = new User(userId, username, password, role);
        service.createUser(user);
        System.out.println("User created successfully.");
    }

    private static void createProduct() throws Exception {
        System.out.print("Admin User ID: ");
        int adminId = Integer.parseInt(scanner.nextLine());
        // dummy fetch
        User admin = new User(adminId, "admin", "adminpass", "Admin");

        System.out.print("Product ID: ");
        int productId = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Type (Electronics/Clothing): ");
        String type = scanner.nextLine();

        Product product;
        if (type.equalsIgnoreCase("Electronics")) {
            System.out.print("Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Warranty (months): ");
            int warranty = Integer.parseInt(scanner.nextLine());
            product = new Electronics(productId, name, desc, price, qty, type, brand, warranty);
        } else {
            System.out.print("Size: ");
            String size = scanner.nextLine();
            System.out.print("Color: ");
            String color = scanner.nextLine();
            product = new Clothing(productId, name, desc, price, qty, type, size, color);
        }

        service.createProduct(admin, product);
        System.out.println("Product added successfully.");
    }

    private static void createOrder() throws Exception {
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        // Dummy user creation
        User user = new User(userId, "dummy", "pass", "User");

        List<Product> products = new ArrayList<>();
        System.out.print("Number of products to order: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Product ID: ");
            int pid = Integer.parseInt(scanner.nextLine());
            Product product = new Product(); // we just need the ID
            product.setProductId(pid);
            products.add(product);
        }

//        service.createOrder(user, products);
        int orderId = service.createOrder(user, products); System.out.println("Order placed successfully. Order ID: " + orderId);
        System.out.println("Order placed successfully.");
    }

    private static void cancelOrder() throws Exception {
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Order ID: ");
        int orderId = Integer.parseInt(scanner.nextLine());
        service.cancelOrder(userId, orderId);
        System.out.println("Order cancelled.");
    }

    private static void viewAllProducts() throws Exception {
        List<Product> productList = service.getAllProducts();
        System.out.println("Products:");
        for (Product p : productList) {
            System.out.println(p.getProductId() + " - " + p.getProductName() + " - " + p.getPrice());
        }
    }

    private static void viewOrdersByUser() throws Exception {
        System.out.print("User ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        User user = new User(userId, "", "", "");
        List<Product> orders = service.getOrderByUser(user);
        System.out.println("Ordered Products:");
        for (Product p : orders) {
            System.out.println(p.getProductName() + " - " + p.getPrice());
        }
    }
    }