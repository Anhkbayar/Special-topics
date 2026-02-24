package com.lab23;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;
    private ProductViewService productViewService;
    private PopularityService popularityService;
    private CacheService cacheService;
    private SearchHistoryService searchHistoryService;

    public List<Product> getProductsByCategory(String category) {

        List<Product> products =
                productRepository.findByCategory(category);

        productViewService.increaseViewCounts(products);

        popularityService.update(category, products);

        cacheService.cacheProducts(category, products);

        searchHistoryService.record(category, products.size());

        return products;
    }
}
