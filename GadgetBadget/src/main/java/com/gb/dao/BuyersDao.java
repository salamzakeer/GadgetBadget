package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Buyer;

public interface BuyersDao {

	// Crud operation

	

	// QUERIES

	public List<Buyer> findAll() throws DaoException;

	

}
