package com.lab23;

import java.util.List;

public interface CacheService {
    void put(String key, List<Product> products);
}
