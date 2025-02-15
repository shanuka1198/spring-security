package com.shanuka_spring.shanuka_spring_3.dto;

public class ProductDto {
    private String productId;
    private String productName;
    private Integer qty;

    public ProductDto(String productId, String productName, Integer qty) {
        this.productId = productId;
        this.productName = productName;
        this.qty = qty;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
