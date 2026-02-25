package com.lab23;

import java.util.List;

public class ProductViewService {
    private ProductRepository productRepository;

    public void increaseViewCounts(List<Product> products){
        for(Product p : products){
            p.setViewCount(p.getViewCount() + 1);
        }
        productRepository.saveAll(products);
    }
}
