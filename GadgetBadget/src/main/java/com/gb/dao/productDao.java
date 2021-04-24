package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Product;

public interface productDao {
	
	//CURD deleted
	public Product addProduct(Product product) throws DaoException;
	public Product findById(Integer projID) throws DaoException;
	public Product updateProduct(Product product) throws DaoException;

	
	//QUERIES
	public List<Product> findAll() throws DaoException;
	//here also deleted
	
}
