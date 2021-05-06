package com.biman.makingJavaMoreFunc.m3_4usngRightTyps;

public class OrderLine {
  private Product product;
  private int count;

  public OrderLine(Product product, int count) {
    super();
    this.product = product;
    this.count = count;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public double getWeight() {
    return product.getWeight() * count;
  }

  public double getAmount() {
    return product.getPrice() * count;
  }
}
