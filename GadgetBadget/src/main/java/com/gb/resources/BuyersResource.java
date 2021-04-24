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

import com.gb.dao.BuyersDao;
import com.gb.dao.DaoException;
import com.gb.dao.daoFactory;
import com.gb.entitiy.Buyer;

@Path("/buyers")
public class BuyersResource {
	
	private BuyersDao dao;
	
	public BuyersResource() throws DaoException {
		dao = daoFactory.getBuyersDao();
	}
	
	@GET
	@Produces({"application/json"})
	public Response getAllBuyers() throws DaoException{
	return Response.ok(dao.findAll()).build();
	}
	
	//getOneBuyer
	
	@Path("/{buyer_id}")
	@Produces({"application/json"})
	@GET
	public Response getOneBuyer(@PathParam("buyer_id") Integer bId) throws DaoException {
		
		return Response.ok(dao.findById(bId)).build();
	}
	
	//add
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response addNewBuyer(Buyer buyer) throws DaoException {
		buyer = dao.addBuyer(buyer);
		return Response.ok(buyer).build();
	}
	
	
	//update 
	
	@Path("/{buyer_id}")
	@PUT
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response updateBuyer(@PathParam("buyer_id")Integer bId, Buyer buyer) throws DaoException {
		buyer.setbId(bId);
		buyer = dao.updateBuyer(buyer);
		return Response.ok(buyer).build();
	}
		
	///delete
	
	}