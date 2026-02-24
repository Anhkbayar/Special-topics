package com.lab23;

public class ProductViewService {
    private ProductRepository productRepository;

    public void increaseViewCounts(List<Product> products){
        for(Product p : products){
            p.setView(p.getViewCount + 1);
        }
        productRepository.saveAll(products);
    }
}
