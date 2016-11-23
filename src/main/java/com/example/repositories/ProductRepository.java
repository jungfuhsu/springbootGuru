package com.example.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Product;

@Repository
@Transactional(readOnly = true)
public interface ProductRepository extends CrudRepository<Product, Integer>, ProductRepositoryCustom {

	@Override
	public List<Product> findAll();
}
