package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;
import com.example.repositories.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductController {

	private ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping("/products")
	public String getProducts() {

		List<Product> products = productRepository.getProducts();
		products.forEach(p -> System.out.println(p));

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(products);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
