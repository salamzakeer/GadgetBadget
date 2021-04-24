package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Seller;

public interface SellerDao {

	// CRUD OPERATION
	

	// QUERIES

	public List<Seller> findAll() throws DaoException;

}
