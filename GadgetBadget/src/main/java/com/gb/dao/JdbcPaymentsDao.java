package com.gb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.gb.entitiy.Payment;
import com.gb.utils.DbUtil;

public class JdbcPaymentsDao implements PaymentsDao {

	
	
	//Addpayment
	


	
	//findById
	@Override
	public Payment findById(Integer id) throws DaoException {
		String sql = "select * from payments where id =?";
		
		try(
				Connection conn=DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				
			){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Payment p = toPayment(rs);
				rs.close();
				return p;
				
			}
			rs.close();
			
			
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}
	

	private Payment toPayment(ResultSet rs) throws SQLException {
		Payment p = new Payment();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setProduct_name(rs.getString("product_name"));
		p.setProduct_id(rs.getString("Product_id"));
		p.setAmount(rs.getString("amount"));
		p.setPayment_type(rs.getString("payment_type"));
		p.setCard_no(rs.getString("card_no"));
		return p;
	}

	
	
	//updatePayment
	

	
	
	//deletePayment
	
	
	//findAll
	@Override
	public List<Payment> findAll() throws DaoException {
		String sql = "select * from payments";
		List<Payment> list = new ArrayList<>();
		
		
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
			){
				while(rs.next()) {
					Payment p = toPayment(rs);
					list.add(p);
				}
			
			
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
		return list;
	}

	
	//findByProduct_id
	

	
	
	//findByAmount
	

}
