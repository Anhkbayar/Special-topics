package com.lab23;

import java.util.Date;

public class PopularityData {
    private String category;
    private int productCount;
    private Date lastAccessed;

    public String getCategory() {
        return category;
    }

    public int getProductCount() {
        return productCount;
    }

    public Date getLastAccessed() {
        return lastAccessed;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public void setLastAccessed(Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

}
