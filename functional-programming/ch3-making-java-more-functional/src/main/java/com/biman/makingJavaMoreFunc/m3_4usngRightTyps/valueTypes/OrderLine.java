package com.biman.makingJavaMoreFunc.m3_4usngRightTyps.valueTypes;

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

  public Weight getWeight() {
    return product.getWeight().mult(count);
  }

  public Price getAmount() {
    return product.getPrice().mult(count);
  }
}
