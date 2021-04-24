package com.gb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gb.entitiy.Buyer;
import com.gb.utils.DbUtil;

public class JdbcBuyersDao implements BuyersDao {

//add buyer

	@Override
	public Buyer addBuyer(Buyer buyer) throws DaoException {
		String sql = "insert into buyers(fname,lname,pnumber,email,password) values (?,?,?,?,?)";
		
		try(
				Connection conn= DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		){
			stmt.setString(1, buyer.getFname());
			stmt.setString(2, buyer.getLname());
			stmt.setString(3, buyer.getPnumber());
			stmt.setString(4, buyer.getEmail());
			stmt.setString(5, buyer.getPassword());
			
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			keys.next();
			keys.getInt(1);
			buyer.setbId(keys.getInt(1));
			
			return buyer;
		}
		catch (Exception ex) {
			throw new DaoException(ex);
		}
		
	
	}
	

//findviewbyid
	

	@Override
	public Buyer findById(Integer bId) throws DaoException {
		String sql =  "select * from buyers where bId = ?";
		
		
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
		){
			
			stmt.setInt(1, bId);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				Buyer b = toBuyer(rs);
				
				rs.close();
				return b;
			}
			
			
			rs.close();
		}
		
		catch (Exception ex) {
			throw new DaoException(ex);
			
		}
		return null;
	}

	private Buyer toBuyer(ResultSet rs) throws SQLException {
		Buyer b = new Buyer();
		b.setbId(rs.getInt("bId"));
		b.setFname(rs.getString("fname"));
		b.setLname(rs.getString("lname"));
		b.setPnumber(rs.getString("pnumber"));
		b.setEmail(rs.getString("email"));
		b.setPassword(rs.getString("password"));
		return b;
	}

	//updatebuyer
	
	@Override
	public Buyer updateBuyer(Buyer buyer) throws DaoException {
		String sql = "update buyers set fname=?, lname =?, pnumber=? ,email=?, password = ? where bId=?";
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
		){
			
			stmt.setString(1, buyer.getFname());
			stmt.setString(2, buyer.getLname());
			stmt.setString(3, buyer.getPnumber());
			stmt.setString(4, buyer.getEmail());
			stmt.setString(5, buyer.getPassword());
			stmt.setInt(6, buyer.getbId());
			
			int count = stmt.executeUpdate();
			if(count ==0) {
				throw new DaoException("No records updated ! invalid buyer id is supplied - " + buyer.getbId());
			}
		}
		catch (Exception ex) {
			throw new DaoException(ex);
		}
	return buyer;
	}

	//deletebuyer
	@Override
	public void deleteBuyer(Integer bId) throws DaoException {
		String sql = "delete from buyers where bId=?";
		
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);	
		){
			stmt.setInt(1, bId);
			int count = stmt.executeUpdate();
			if(count ==0) {
				throw new DaoException("No records deleted ! invalid buyer id is supplied - " + bId);
			}
		}
		catch(Exception ex) {
			
			throw new DaoException(ex);
		}
		

	}

	@Override
	public List<Buyer> findAll() throws DaoException {
		String sql = "select * from buyers";
		
		List<Buyer> list = new ArrayList<>();
		
		try (
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt =  conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
			){
				while(rs.next()) {
					
					Buyer b = toBuyer(rs);
					list.add(b);
				}
		}
		
		catch (Exception ex) {
			
			throw new DaoException(ex);
		}
		return list;
	}

//findbylastname
	

//findbypnumber

}
