package com.gb.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.gb.dao.DaoException;
import com.gb.dao.daoFactory;
import com.gb.dao.SellerDao;
import com.gb.entitiy.Seller;

@Path("/seller")
public class SellerResource {
	
	private SellerDao dao;
	
	public SellerResource() throws DaoException {
		dao = daoFactory.getSellerDao();
	}
	
	
	//find All
	@GET
	@Produces({"application/json"})
	public Response getAllSeller() throws DaoException {
		return Response.ok(dao.findAll()).build();
	}
	
	
	//find byID
	@GET
	@Path("/{seller_id}")
	@Produces({"application/json"})
	public Response getOneSeller(@PathParam("seller_id")Integer id) throws DaoException {
		return Response.ok(dao.findById(id)).build();
	}
	
	
	//Add seller
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response addNewSeller(Seller seller) throws DaoException {
		seller = dao.addSeller(seller);
		return Response.ok(seller).build();
	}
	
	
	//Update seller
	@PUT
	@Path("/{seller_id}")
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response updateSeller(@PathParam("seller_id")Integer id, Seller seller) throws DaoException {
		seller.setId(id);
		seller = dao.updateSeller(seller);
		return Response.ok(seller).build();
	}
}
	
