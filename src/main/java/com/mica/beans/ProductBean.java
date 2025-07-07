package com.mica.beans;

import java.util.List;

import com.mica.models.Product;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProductBean implements IProductBeanRemote {


  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Product> getProducts() throws Exception {

    try {

      List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();

      return products;
      
    } catch (Exception e) {

      throw new Exception("Error retrieving products: " + e.getMessage(), e);

    }

  }

  @Override
  public void createProduct(String name, String description, double price, int quantity) throws Exception {

    try {

      Product product = new Product();
      product.setName(name);
      product.setDescription(description);
      product.setPrice(price);
      product.setQuantity(quantity);
      entityManager.persist(product);
      entityManager.flush();

    } catch (Exception e) {

      throw new Exception("Error creating product: " + e.getMessage(), e);

    }

  }

  @Override
  public Product getProductById(String id) throws Exception {
    try {
      Product product = entityManager.find(Product.class, id);

      if (product == null) {

        throw new Exception("Product not found with ID: " + id);

      }

      return product;

    } catch (Exception e) {

      throw new Exception("Error retrieving product by ID: " + e.getMessage(), e);
      
    }
  }

  @Override
  public void updateProduct(String id, String name, String description, double price, int quantity)
      throws Exception {
        try {

        Product product = entityManager.find(Product.class, id);

        if (product == null) {

          throw new Exception("Product not found with ID: " + id);

        }

        product.setName(name != null ? name : product.getName());
        product.setDescription(description != null ? description : product.getDescription());
        product.setPrice(price > 0 ? price : product.getPrice());
        product.setQuantity(quantity > 0 ? quantity : product.getQuantity());
        entityManager.merge(product);
        entityManager.flush();

        } catch (Exception e) {

          throw new Exception("Error updating product: " + e.getMessage(), e);

        }
  }

  @Override
  public void deleteProduct(String id) throws Exception {

    try {

      Product product = entityManager.find(Product.class, id);

      if (product == null) {

        throw new Exception("Product not found with ID: " + id);

      }

      entityManager.remove(product);
      entityManager.flush();

    } catch (Exception e) {

      throw new Exception("Error deleting product: " + e.getMessage(), e);

    }

  }
  
}
