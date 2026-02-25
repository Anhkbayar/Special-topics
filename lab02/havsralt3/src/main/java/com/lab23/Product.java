package com.lab23;

public class Product {
    private Long id;
    private String category;
    private int viewCount;

    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
