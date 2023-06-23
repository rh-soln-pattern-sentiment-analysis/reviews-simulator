package org.acme.retail.order.simulator.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDto {
    
    
    private String product_id;
    
    private String product_name;
    private String category;

    // Getters and setters

    @JsonProperty("product_id")
    public String getProduct_id() {
        return product_id;
    }

    @JsonProperty("itemId")
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    @JsonProperty("product_name")    
    public String getProduct_name() {
        return product_name;
    }

    @JsonProperty("name")    
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}