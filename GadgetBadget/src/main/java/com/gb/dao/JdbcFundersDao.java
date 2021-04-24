package com.gb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

import com.gb.entitiy.Buyer;
import com.gb.entitiy.Funder;
import com.gb.utils.DbUtil;

public class JdbcFundersDao implements FunderDao {

	@Override
	public Funder addFunder(Funder funder) throws DaoException {
			String sql = "insert into funder(funderName,funderPnumber,projID,fundAmount,description) values (?,?,?,?,?)";
			
			try(
					Connection conn= DbUtil.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			){
				stmt.setString(1, funder.getFunderName());
				stmt.setString(2, funder.getFunderPnumber());
				stmt.setInt(3, funder.getProjID());
				stmt.setInt(4, funder.getFundAmount());
				stmt.setString(5, funder.getDescription());
				
				stmt.executeUpdate();
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next();
				funder.setfId(keys.getInt(1));
				
				return funder;
			}
			catch (Exception ex) {
				throw new DaoException(ex);
			
		}
	}

	@Override
	public Funder findByIdFunder(Integer fId) throws DaoException {
	String sql =  "select * from funder where fId = ?";
		
		
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
		){
			
			stmt.setInt(1, fId);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				Funder f = toFunder(rs);
				rs.close();
				return f; 
				
			}
			rs.close();
		}
		
		catch (Exception ex) {
			throw new DaoException(ex);
			
		}
		return null;
	}

	private Funder toFunder(ResultSet rs) throws SQLException {
		Funder f = new Funder();
		f.setfId(rs.getInt("fId"));
		f.setFunderName(rs.getString("funderName"));
		f.setFunderPnumber(rs.getString("funderPnumber"));
		f.setProjID(rs.getInt("projID"));
		f.setFundAmount(rs.getInt("fundAmount"));
		f.setDescription(rs.getString("description"));
		return f;
	}


	@Override
	public Funder updateFunder(Funder funder) throws DaoException {
		String sql = "update funder set funderName=?, funderPnumber =?, projID=? ,fundAmount=?, description = ? where fId=?";
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
		){
			
			stmt.setString(1, funder.getFunderName());
			stmt.setString(2, funder.getFunderPnumber());
			stmt.setInt(3, funder.getProjID());
			stmt.setInt(4, funder.getFundAmount());
			stmt.setString(5, funder.getDescription());
			stmt.setInt(6, funder.getfId());
			
			int count = stmt.executeUpdate();
			if(count ==0) {
				throw new DaoException("No records updated ! invalid funder id is supplied - " + funder.getfId());
			}
		}
		catch (Exception ex) {
			throw new DaoException(ex);
		}
	return funder;
	}

	@Override
	public void deleteFunder(Integer fId) throws DaoException {
		String sql = "delete from funder where fId=?";
		
		try(
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);	
		){
			stmt.setInt(1, fId);
			int count = stmt.executeUpdate();
			if(count ==0) {
				throw new DaoException("No records deleted ! invalid funder id is supplied - " + fId);
			}
		}
		catch(Exception ex) {
			
			throw new DaoException(ex);
		}

	}

	@Override
	public List<Funder> findAll() throws DaoException {
		String sql = "select * from funder";
		
		List<Funder> list = new ArrayList<>();
		
		try (
				Connection conn = DbUtil.getConnection();
				PreparedStatement stmt =  conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
			){
				while(rs.next()) {
					
					Funder f = toFunder(rs);
					list.add(f);
				}
		}
		
		catch (Exception ex) {
			
			throw new DaoException(ex);
		}
		return list;
	}

}
