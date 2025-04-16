package com.hexaware.oms.dao;

import com.hexaware.oms.entity.*;
import com.hexaware.oms.service.IOrderManagementRepository;
import com.hexaware.oms.exception.*;

import java.sql.*;
import java.util.*;

public class OrderProcessor implements IOrderManagementRepository {

    @Override
    public void createUser(User user) throws SQLException {
        Connection conn = DBUtil.getDBConn();
        String sql = "INSERT INTO users (user_id, username, password, role) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, user.getUserId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getRole());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

  
    
    @Override
    public void createProduct(User user, Product product) throws Exception { if (!"Admin".equalsIgnoreCase(user.getRole())) { throw new Exception("Only Admins can add products."); }

   
    String sql = "INSERT INTO products (product_id, product_name, description, price, quantity, product_type, brand, warranty, size, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = DBUtil.getDBConn();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, product.getProductId());
        ps.setString(2, product.getProductName());
        ps.setString(3, product.getDescription());
        ps.setDouble(4, product.getPrice());
        ps.setInt(5, product.getQuantityInStock());
        ps.setString(6, product.getType());

        if (product instanceof Electronics) {
            Electronics e = (Electronics) product;
            ps.setString(7, e.getBrand());
            ps.setInt(8, e.getWarrantyPeriod());
            ps.setNull(9, Types.VARCHAR);
            ps.setNull(10, Types.VARCHAR);
        } else if (product instanceof Clothing) {
            Clothing c = (Clothing) product;
            ps.setNull(7, Types.VARCHAR);
            ps.setNull(8, Types.INTEGER);
            ps.setString(9, c.getSize());
            ps.setString(10, c.getColor());
        } else {
            throw new Exception("Invalid product type");
        }

        ps.executeUpdate();
    }
    }

   
    @Override
    public int createOrder(User user, List<Product> products) throws Exception { 
    	int generatedOrderId = -1; 
    	try (Connection conn = DBUtil.getDBConn()) { conn.setAutoCommit(false);

        String orderSQL = "INSERT INTO orders (user_id) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(orderSQL, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, user.getUserId());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            generatedOrderId = rs.getInt(1);
        }

        String itemSQL = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement itemPS = conn.prepareStatement(itemSQL);

        for (Product product : products) {
            itemPS.setInt(1, generatedOrderId);
            itemPS.setInt(2, product.getProductId());
            itemPS.setInt(3, 1); // default quantity
            itemPS.addBatch();
        }

        itemPS.executeBatch();
        conn.commit();
    }
    return generatedOrderId;
    }

    @Override
    public void cancelOrder(int userId, int orderId) throws Exception { try (Connection conn = DBUtil.getDBConn()) { String checkOrder = "SELECT * FROM orders WHERE order_id = ? AND user_id = ?"; PreparedStatement checkStmt = conn.prepareStatement(checkOrder); checkStmt.setInt(1, orderId); checkStmt.setInt(2, userId); ResultSet rs = checkStmt.executeQuery();
    if (!rs.next()) {
        throw new OrderNotFoundException("Order not found for this user.");
    }

    
    String deleteItems = "DELETE FROM order_items WHERE order_id = ?";
    String deleteOrder = "DELETE FROM orders WHERE order_id = ?";

    PreparedStatement itemStmt = conn.prepareStatement(deleteItems);
    itemStmt.setInt(1, orderId);
    itemStmt.executeUpdate();

    PreparedStatement orderStmt = conn.prepareStatement(deleteOrder);
    orderStmt.setInt(1, orderId);
    orderStmt.executeUpdate();
}

    }

    @Override
    public List<Product> getAllProducts() throws SQLException { List<Product> products = new ArrayList<>(); try (Connection conn = DBUtil.getDBConn()) { String sql = "SELECT * FROM products"; PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery(); while (rs.next()) { String type = rs.getString("product_type"); Product p; if ("Electronics".equalsIgnoreCase(type)) { p = new Electronics( rs.getInt("product_id"), rs.getString("product_name"), rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity"), type, rs.getString("brand"), rs.getInt("warranty") ); } else { p = new Clothing( rs.getInt("product_id"), rs.getString("product_name"), rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity"), type, rs.getString("size"), rs.getString("color") ); } products.add(p); } } return products; }
    @Override
    public List<Product> getOrderByUser(User user) throws Exception { List<Product> orderedProducts = new ArrayList<>();
    
    String sql = "SELECT p.* FROM products p " +
            "JOIN order_items oi ON p.product_id = oi.product_id " +
            "JOIN orders o ON oi.order_id = o.order_id " +
            "WHERE o.user_id = ?";

try (Connection conn = DBUtil.getDBConn();  
    PreparedStatement ps = conn.prepareStatement(sql)) {

   ps.setInt(1, user.getUserId());
   ResultSet rs = ps.executeQuery();

   while (rs.next()) {
       String type = rs.getString("product_type");
       Product p;
       if ("Electronics".equalsIgnoreCase(type)) {
           p = new Electronics(
               rs.getInt("product_id"),
               rs.getString("product_name"),
               rs.getString("description"),
               rs.getDouble("price"),
               rs.getInt("quantity"),
               type,
               rs.getString("brand"),
               rs.getInt("warranty")
           );
       } else {
           p = new Clothing(
               rs.getInt("product_id"),
               rs.getString("product_name"),
               rs.getString("description"),
               rs.getDouble("price"),
               rs.getInt("quantity"),
               type,
               rs.getString("size"),
               rs.getString("color")
           );
       }
       orderedProducts.add(p);
   }
}

if (orderedProducts.isEmpty()) {
    System.out.println("You didn’t place any orders.");
}

return orderedProducts;
    }
}
