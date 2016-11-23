package com.example.configure;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.example.domain.Product;

public class ProductMapper implements ResultSetMapper<Product> {
	@Override
	public Product map(int index, ResultSet r, StatementContext ctx) throws SQLException {

		return new Product(r.getInt("id"), r.getInt("version"), r.getString("product_id"), r.getString("description"),
				r.getString("image_url"), new BigDecimal(r.getFloat("price")));
	}
}