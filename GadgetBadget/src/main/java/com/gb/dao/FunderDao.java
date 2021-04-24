package com.gb.dao;

import java.util.List;

import com.gb.entitiy.Funder;

public interface FunderDao {

	// crud operation 
	
	public Funder addFunder(Funder funder) throws DaoException;
	
	public Funder findByIdFunder(Integer fId) throws DaoException;
	
	public Funder updateFunder(Funder funder) throws DaoException;
	
	public void deleteFunder(Integer fId) throws DaoException;
	
	
	//Queries
	
	public List<Funder> findAll() throws DaoException;
	
	
}
