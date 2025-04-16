package com.hexaware.oms.service;

import com.hexaware.oms.entity.Product;
import com.hexaware.oms.entity.User;
import java.util.List;

public interface IOrderManagementRepository {

    void createUser(User user) throws Exception;

    void createProduct(User user, Product product) throws Exception;

    public int createOrder(User user, List<Product> products) throws Exception;

    void cancelOrder(int userId, int orderId) throws Exception;

    public List<Product> getAllProducts() throws Exception;

    List<Product> getOrderByUser(User user) throws Exception;
}
