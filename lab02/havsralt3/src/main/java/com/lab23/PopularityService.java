package com.lab23;

public class PopularityService {
    private PopularityService popularityService;

    public void update(String category, List<Product> products){
        PopularityData data = new PopularityData();
        data.setCategory(category);
        data.setProductCount(products.size());
        data.setLastAccessed(new Date());

        popularityService.save(data);
    }
}
