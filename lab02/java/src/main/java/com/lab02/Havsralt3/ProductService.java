package com.lab02.Havsralt3;

public class ProductService {
    public List<Product> getProductsByCategory(String category){
        // 1. Database ees tatah
        List<Product> products = productRepository.findByCategory(category);

        // 2. Uzsen toog nemeh
        for(Product p: products){
            p.setViewCount(p.getViewCount()+1);
        }

        productRepository.saveAll(products);

        // 3. Popular baraa shinechleh
        updatePopularProducts(category, products);

        // 4. Cache d hadgalah
        cacheService.put("products_" + category, products);

        //5  Hailtiin tuuhend nemeh
        searchHistoryService.recordSearch(category, products.size());

        return products;
    }

    private void updatePopularProducts(String category, List<Product> products){
        PopularityData data = new PopularityData();
        data.setCategory(category);
        data.setProductCount(products.size());
        data.setLastAccessed(new Date());
        popularityRepository.save(data);
    }
}
