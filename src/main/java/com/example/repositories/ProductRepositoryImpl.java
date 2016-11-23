package com.example.repositories;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.db.Database;
import com.example.db.DbOperations;
import com.example.domain.Product;

@Transactional(readOnly = true)
public class ProductRepositoryImpl implements ProductRepositoryCustom {

	private final Database database;

	@Autowired
	public ProductRepositoryImpl(Database database) {
		this.database = database;
	}

	@Override
	public List<Product> getProducts() {

		try (Handle h = database.handle()) {
			DbOperations db = h.attach(DbOperations.class);
			return db.getProducts();
		}
	}

}
