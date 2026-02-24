package com.lab23;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductViewService productViewService;
    
    @Mock
    PopularityService popularityService;

    @Mock
    CacheService cacheService;

    @Mock
    SearchHistoryService searchHistoryService;
    
    @InjectMocks
    ProductService productService;
    
    @Test
    void shouldReturnProductsAndTriggerAllServices() {

        String category = "electronics";

        Product p = new Product();
        List<Product> products = List.of(p);

        when(productRepository.findByCategory(category))
                .thenReturn(products);

        List<Product> result =
                productService.getProductsByCategory(category);

        assertEquals(1, result.size());

        verify(productViewService)
                .increaseViewCounts(products);

        verify(popularityService)
                .update(category, products);

        verify(cacheService)
                .cacheProducts(category, products);

        verify(searchHistoryService)
                .record(category, 1);
    }
}
