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

//deletebuy

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
