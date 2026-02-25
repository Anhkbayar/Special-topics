package com.lab23;

import java.util.List;

public interface ProductRepository {
    List<Product> findByCategory(String catergory);

    void saveAll(List<Product> products);
}
