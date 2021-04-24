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

	
	
	//AddPayment
	@Override
	public Payment addPayment(Payment payment) throws DaoException {
		String sql = "insert into payments(name, product_name, product_id, amount, payment_type, card_no) values(?, ?, ?, ?, ?, ?)";
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
			){
				stmt.setString(1, payment.getName());
				stmt.setString(2, payment.getProduct_name());
				stmt.setString(3, payment.getProduct_id());
				stmt.setString(4, payment.getAmount());
				stmt.setString(5, payment.getPayment_type());
				stmt.setString(6, payment.getCard_no());
				
				stmt.executeUpdate();
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next();
				payment.setId(keys.getInt(1));
				
				return payment;
				
			
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
		
		
	}



	
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
	@Override
	public Payment updatePayment(Payment payment) throws DaoException {
		String sql = "update payments set name=?, product_name=?, product_id=?, amount=?, payment_type=?, card_no=? where id=?";
		
		try(
				Connection conn=DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				
			){
			stmt.setString(1, payment.getName());
			stmt.setString(2, payment.getProduct_name());
			stmt.setString(3, payment.getProduct_id());
			stmt.setString(4, payment.getAmount());
			stmt.setString(5, payment.getPayment_type());
			stmt.setString(6, payment.getCard_no());
			stmt.setInt(7, payment.getId());
			
			int count= stmt.executeUpdate();
			if(count==0) {
				throw new DaoException("No records updated; invalid id supplied -"+payment.getId());
			}
			
			
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
		
		return payment;
	}


	
	
	//deletePayment
	
	@Override
	public void deletePayment(Integer id) throws DaoException {
		String sql = "delete from payments where id =?";
		
		try(
				Connection conn=DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				
			){
			stmt.setInt(1, id);

			int count= stmt.executeUpdate();
			if(count==0) {
				throw new DaoException("No records deleted; invalid id supplied -"+ id);
			
			}
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}

	}
	
	
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

	
	

}
