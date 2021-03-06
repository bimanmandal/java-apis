package com.biman.learning.ch3.rightTypes.s2;


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
        return this.product.getWeight().mult(count);
    }

    public Price getAmount() {
        return this.product.getPrice().mult(count);
    }
}
