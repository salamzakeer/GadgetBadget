package com.gb.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class helloResources {
	@GET
	@Produces({"text/plain"})
	public String greet() {
		return "hello from baloon";
	}
	
	@Produces({"application/xml"})
	public String greetxml() {
		return "<?xml version=\"1.0\" ?>\r\n" + 
				"<greeting>\r\n" + 
				"	<message>hello, world</message>\r\n" + 
				"	<from>salam</from>\r\n" + 
				"</greeting>";
	}
	@Produces({"application/json"})
	public String greetjson() {
		return "\"message\": \"hello, world\";\r\n" + 
				"\"from\": \"salam\"";
	}

}
