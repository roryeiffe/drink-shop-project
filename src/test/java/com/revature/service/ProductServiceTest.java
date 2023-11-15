package com.revature.service;

import com.revature.repository.ProductRepository;
import com.revature.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class ProductServiceTest {
    
    @Mock
    private ProductRepository productRepository;
    
    private ProductService productService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(productRepository);
    }
    
    @Test
    public void testGetProductsByQuery() {
        // Arrange
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", "example");
        List<Product> expectedProducts = Collections.singletonList(new Product("example", 0.0, 0, "example"));
        when(productRepository.findByName("example")).thenReturn(expectedProducts);
        
        // Act
        List<Product> actualProducts = productService.getProductsByQuery(queryParams);
        
        // Assert
        assertEquals(expectedProducts, actualProducts);
    }
    
    @Test
    public void testGetProductsByQueryWithInvalidParams() {
        // Arrange
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("invalid_key", "example");
        
        // Act
        List<Product> actualProducts = productService.getProductsByQuery(queryParams);
        
        // Assert
        assertNull(actualProducts);
    }
    
    @Test
    public void testGetAllProducts() {
        // Arrange
        List<Product> expectedProducts = Arrays.asList( new Product("root beer", 5.10, 250, "soda"), new Product("hot chocolate", 4.00, 500, "hot drinks"));
        when(productRepository.findAll()).thenReturn(expectedProducts);
        
        // Act
        List<Product> actualProducts = productService.getAllProducts();
        
        // Assert
        assertEquals(expectedProducts, actualProducts);
    }
    
    @Test
    public void testCheckParamsWithValidParams() {
        // Arrange
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", "example");
        
        // Act
        boolean result = productService.checkParams(queryParams);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void testCheckParamsWithEmptyParams() {
        // Arrange
        Map<String, String> queryParams = Collections.emptyMap();
        
        // Act
        boolean result = productService.checkParams(queryParams);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void testCheckParamsWithInvalidParams() {
        // Arrange
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("invalid_key", "example");
        
        // Act
        boolean result = productService.checkParams(queryParams);
        
        // Assert
        assertFalse(result);
    }

    @Test
    public void testCheckParamsWithNullValue() {
        // Arrange
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", null);
        
        // Act
        boolean result = productService.checkParams(queryParams);

        // Assert
        assertFalse(result);
    }
}