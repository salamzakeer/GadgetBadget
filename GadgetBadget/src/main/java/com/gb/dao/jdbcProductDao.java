package com.gb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gb.entitiy.Product;
import com.gb.utils.DbUtil;

public class jdbcProductDao implements productDao {

	//insert deleted here
	

//find by id deleted here

	private Product toProduct(ResultSet rs) throws SQLException {
		Product p = new Product();
		p.setProjID(rs.getInt("projID"));
		p.setProjName(rs.getString("projName"));
		p.setDescription(rs.getString("description"));
		p.setArea(rs.getString("area"));
		p.setResID(rs.getString("resID"));
		p.setResName(rs.getString("resName"));
		p.setPrice(rs.getFloat("price"));
		return p;
	}

//update and  deleted here


	@Override
	public List<Product> findAll() throws DaoException {
		String sql = "SELECT * FROM product";
		List<Product> list = new ArrayList<>();
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				){
			while(rs.next()) {
				Product p = toProduct(rs);
				list.add(p);
			}
		}catch(Exception ex) {
			throw new DaoException(ex);
		}
		
		return list;
	}
}//methana semi call akk add kara

	// find by name and id deleted here