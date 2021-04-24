package com.gb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gb.entitiy.Seller;
import com.gb.utils.DbUtil;

public class JdbcSellerDao implements SellerDao {

	
	
	//addSeller
	

	//findById
	@Override
	public Seller findById(Integer id) throws DaoException {

		String sql = "select *from researcher_details where id = ?";

		try (Connection conn = DbUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Seller s = toSeller(rs);
				rs.close();
				return s;

			}
			
			rs.close();

		} catch (Exception ex) {
			throw new DaoException(ex);
		}

		return null;
	}

	private Seller toSeller(ResultSet rs) throws SQLException {
		Seller s = new Seller();
		s.setId(rs.getInt("id"));
		s.setFirstname(rs.getString("firstname"));
		s.setLastname(rs.getString("lastname"));
		s.setGender(rs.getString("gender"));
		s.setEmail(rs.getString("email"));
		s.setPassword(rs.getString("password"));
		return s;
	}

	
	//updateSeller
	
	
	//deleteSeller

	

	@Override
	public List<Seller> findAll() throws DaoException {
		String sql = "select *from researcher_details";
		
		List<Seller> list = new ArrayList<>();
		
		try(
				Connection conn = DbUtil.getConnection(); 
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				
		){
			while(rs.next()) {
				Seller s = toSeller(rs);
				list.add(s);
			}
		}
			
		catch(Exception ex) {
			throw new DaoException(ex);
		}
		return list;
	}

}
