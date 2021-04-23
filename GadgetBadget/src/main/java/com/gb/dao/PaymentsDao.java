package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Payment;

public interface PaymentsDao {

	// CRUD OPERATION
	
	
	// QUERIES

	public List<Payment> findAll() throws DaoException;

	
}
