package com.example.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import com.example.configure.ProductMapper;
import com.example.domain.Product;

public interface DbOperations {

	@SqlQuery("SELECT p.id, p.version, p.product_id, p.description, p.image_url, p.price " //
			+ "FROM product p " //
	)
	@Mapper(ProductMapper.class)
	List<Product> getProducts();
}
