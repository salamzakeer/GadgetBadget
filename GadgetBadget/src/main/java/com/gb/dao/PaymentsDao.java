package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Payment;

public interface PaymentsDao {

	// CRUD OPERATION
	public Payment findById(Integer id) throws DaoException;
	
	public Payment addPayment(Payment payment) throws DaoException;
	
	public Payment updatePayment(Payment payment) throws DaoException;
	
	public void deletePayment(Integer id) throws DaoException;
	
	
	// QUERIES

	public List<Payment> findAll() throws DaoException;

	
}
