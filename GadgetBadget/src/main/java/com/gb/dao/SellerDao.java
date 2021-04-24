package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Seller;

public interface SellerDao {

	// CRUD OPERATION
	public Seller findById(Integer id) throws DaoException;

	public Seller addSeller(Seller seller) throws DaoException;
	
	public Seller updateSeller(Seller seller) throws DaoException;

	// QUERIES

	public List<Seller> findAll() throws DaoException;

}
