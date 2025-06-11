package com.mercadolibre.productapi.controller;

import com.mercadolibre.productapi.exception.ProductNotFoundException;
import com.mercadolibre.productapi.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getProductById_shouldReturn404IfNotFound() throws Exception {
        when(productService.getProductById("INVALID"))
                .thenThrow(new ProductNotFoundException("INVALID"));

        mockMvc.perform(get("/products/INVALID"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Producto con ID 'INVALID' no encontrado."));
    }
}