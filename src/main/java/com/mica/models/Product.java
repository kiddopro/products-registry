package com.mica.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "producto")
public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private UUID id;

  @Column(name = "nombre", nullable = false, length = 100)
  private String name;

  @Column(name = "descripcion", length = 255)
  private String description;

  @Column(name = "precio", nullable = false)
  private double price;

  @Column(name = "cantidad", nullable = false)
  private int quantity;


  public Product() {
    this.id = UUID.randomUUID();
  }

  public Product(String name, String description, double price, int quantity) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity + "]";
  }

  



  
}
