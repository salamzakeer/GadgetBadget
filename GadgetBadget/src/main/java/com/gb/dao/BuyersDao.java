package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Buyer;

public interface BuyersDao {

	// Crud operation
	
	public Buyer addBuyer(Buyer buyer) throws DaoException; //to insert
	
	public Buyer findById(Integer bId) throws DaoException;  //to  view by buyer id
	
	public Buyer updateBuyer(Buyer buyer) throws DaoException; // to edit

	public void deleteBuyer(Integer bId) throws DaoException; // to delete
	
	// QUERIES

	public List<Buyer> findAll() throws DaoException; //to view 

	

}
