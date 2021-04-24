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

	//=======================Retrieve all==============
	@GET
	@Produces({"application/json"})
	public Response getAllProducts() throws DaoException {
		return Response.ok(dao.findAll()).build();
	}
	
	//=====================insert==========
	@POST
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response addProduct(Product product) throws DaoException {
		product = dao.addProduct(product);
		return Response.ok(product).build();
	}
	
	//=============findByID-Profile====================================
	@Path("/{id}") 
	@Produces({"application/json"})
	@GET
	public Response getOneProducts(@PathParam("id") Integer projID) throws DaoException {
		return Response.ok(dao.findById(projID)).build();
	}
	
	//===============update==========================
	
	@Path("/{_id}")
	@PUT
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response updateProduct(@PathParam("_id") Integer projID, Product product) throws DaoException {
		product.setProjID(projID);
		product = dao.updateProduct(product);
		return Response.ok(product).build();
	}
}
