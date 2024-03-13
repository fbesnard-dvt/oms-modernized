package com.oms.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oms.entity.Product;
import com.oms.repository.ProductRepository;
import com.oms.util.Logger;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@Mock
	ProductRepository productRepository;

	ProductService productService = new ProductService();

	@Before
	public void setUp() {
		productService.productRepository = productRepository;
		productService.setLogger(new Logger());
	}

	@Test
	public void testRegisterProduct() {
		Product p1 = new Product();
		p1.setProductId("1");
		p1.setName("Samsung Note 9");
		p1.setDescription("A nice big phone");
		p1.setManuf("Samsung");

		Mockito.when(productRepository.save(p1)).thenReturn(p1);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			System.out.println(objectMapper.writeValueAsString(p1));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		assertNotNull(productService.registerProduct(p1));

	}
}
