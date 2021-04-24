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

import com.gb.dao.PaymentsDao;
import com.gb.dao.DaoException;
import com.gb.dao.daoFactory;
import com.gb.entitiy.Payment;

@Path("/payments")
public class PaymentsResource {
	
	private PaymentsDao dao;
	
	public PaymentsResource() throws DaoException {
		dao = daoFactory.getPaymentsDao();
		}
	
	@GET
	@Produces({"application/json", "text/csv"})
	public Response getAllPayments() throws DaoException {
		return Response.ok(dao.findAll()).build();
	}
	
	@Path("/{payment_id}")
	@Produces({"application/json", "text/csv"})
	@GET
	public Response getOnePayment(@PathParam("payment_id") Integer id) throws DaoException {
		return Response.ok(dao.findById(id)).build();
	}
	
	@POST
	@Produces({"application/json", "text/csv"})
	@Consumes({"application/json", "text/csv"})
	public Response addNewPayment(Payment payment) throws DaoException {
		payment = dao.addPayment(payment);
		return Response.ok(payment).build();
	}
	
	@Path("/{payment_id}")
	@PUT
	@Produces({"application/json"})
	@Consumes({"application/json"})
	public Response updatePayment(@PathParam("payment_id") Integer id, Payment payment) throws DaoException {
		payment.setId(id);
		payment = dao.updatePayment(payment);
		return Response.ok(payment).build();
	}
	
	
	
	

}








