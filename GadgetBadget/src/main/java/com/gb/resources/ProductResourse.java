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
import com.gb.dao.productDao;
import com.gb.entitiy.Product;

@Path("/products")
public class ProductResourse {
	
	private productDao dao;
	
	public ProductResourse() throws DaoException {
		dao = daoFactory.getProductDao();
	}
	
	@GET
	@Produces({"application/json"})
	public Response getAllProducts() throws DaoException {
		return Response.ok(dao.findAll()).build();
	}
	
	

}
