package com.lab23;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
