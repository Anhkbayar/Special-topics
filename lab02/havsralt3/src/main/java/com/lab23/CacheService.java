package com.lab23;

public class CacheService {
    private CacheService cacheService;

    private static final String PRODUCT_CACHE_PREFIX = "products_";

    public void cacheProducts(String category, List<Product> products){
        cacheService.put(PRODUCT_CACHE_PREFIX + category, products);
    }
}
