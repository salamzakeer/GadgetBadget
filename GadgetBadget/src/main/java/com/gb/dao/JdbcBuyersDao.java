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

	//deletebuyer

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
