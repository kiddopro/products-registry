package com.mica.beans;

import java.util.List;

import com.mica.models.Product;

import jakarta.ejb.Remote;

@Remote
public interface IProductBeanRemote {

  List<Product> getProducts() throws Exception;
  void createProduct(String name, String description, double price, int quantity) throws Exception;
  Product getProductById(String id) throws Exception;
  void updateProduct(String id, String name, String description, double price, int quantity) throws Exception;
  void deleteProduct(String id) throws Exception;

}
