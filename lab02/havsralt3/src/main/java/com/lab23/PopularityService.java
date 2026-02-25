package com.lab23;

import java.util.List;
import java.util.Date;

public class PopularityService {
    private PopularityRepository popularityRepository;

    public void update(String category, List<Product> products){
        PopularityData data = new PopularityData();
        data.setCategory(category);
        data.setProductCount(products.size());
        data.setLastAccessed(new Date());

        popularityRepository.save(data);
    }
}
