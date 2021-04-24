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

import com.gb.dao.FunderDao;
import com.gb.entitiy.Buyer;
import com.gb.entitiy.Funder;
import com.gb.dao.DaoException;
import com.gb.dao.daoFactory;
import com.gb.dao.FunderDao;

@Path("/funders")
public class FundersResource {
private FunderDao dao;
	
	public FundersResource() throws DaoException {
		dao = daoFactory.getFunderDao();
	}
	
	@GET
	@Produces({"application/json"})
	public Response getAllFunders() throws DaoException{
	return Response.ok(dao.findAll()).build();
	}
	
	@Path("/{funder_id}")
	@Produces({"application/json"})
	@GET
	public Response getOneFunder(@PathParam("funder_id") Integer fId) throws DaoException {
		
		return Response.ok(dao.findByIdFunder(fId)).build();
	}
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response addNewFunder(Funder funder) throws DaoException {
		funder = dao.addFunder(funder);
		return Response.ok(funder).build();
	}
	
	@Path("/{funder_id}")
	@PUT
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response updateFunder(@PathParam("funder_id")Integer fId, Funder funder) throws DaoException {
		funder.setfId(fId);
		funder = dao.updateFunder(funder);
		return Response.ok(funder).build();
	}
		
	
	@DELETE
	@Path("/{funder_id}")
	@Produces({"application/json"})
	public Response deleteFunder(@PathParam("funder_id")Integer fId) throws DaoException {
		dao.deleteFunder(fId);
		return Response.ok().build();
		
	}

}
