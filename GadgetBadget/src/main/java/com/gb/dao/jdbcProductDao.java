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

	//=====================insert==============
	@Override
	public Product addProduct(Product product) throws DaoException {
		String sql = "INSERT INTO product (projID, projName, description, area, resID, resName, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
			){
			
				stmt.setInt(1, product.getProjID());
				stmt.setString(2, product.getProjName());
				stmt.setString(3, product.getDescription());
				stmt.setString(4, product.getArea());
				stmt.setString(5, product.getResID());
				stmt.setString(6, product.getResName());
				stmt.setFloat(7, product.getPrice());
				
				stmt.executeUpdate();
			
		}catch(Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}
	

//find by id 
	@Override
	public Product findById(Integer projID) throws DaoException {
		String sql = "SELECT * FROM product WHERE projID=?";
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				){
			stmt.setInt(1, projID);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Product p = toProduct(rs);
				
				rs.close();
				
				return p;
				
			}
			rs.close();
			
		}catch(Exception ex) {
			throw new DaoException(ex);
		}
		return null;
	}
	
	/////

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

//update
	@Override
	public Product updateProduct(Product product) throws DaoException {
		String sql = "UPDATE product SET  projName=?, description=?, area=?, resID=?, resName=?, price=? WHERE projID=?";
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
			){
			
				stmt.setString(1, product.getProjName());
				stmt.setString(2, product.getDescription());
				stmt.setString(3, product.getArea());
				stmt.setString(4, product.getResID());
				stmt.setString(5, product.getResName());
				stmt.setFloat(6, product.getPrice());
				stmt.setInt(7, product.getProjID());
				
				
				int count = stmt.executeUpdate();
				if(count==0) {
					throw new DaoException("No record updated invalid id :"+product.getProjID());
				}
			
		}catch(Exception ex) {
			throw new DaoException(ex);
		}
		return product;
	}
//////

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