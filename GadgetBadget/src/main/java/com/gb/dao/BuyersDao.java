package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Buyer;

public interface BuyersDao {

	// Crud operation
	public Buyer addBuyer(Buyer buyer) throws DaoException;
	
	public Buyer updateBuyer(Buyer buyer) throws DaoException;

	// QUERIES

	public List<Buyer> findAll() throws DaoException;

	

}
