package com.creacodetive.api.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * RESTEasy Public Service
 * 
 * @author Daniel I. Khan Ramiro (di.khan.r@gmail.com)
 */
@Path("/public")
public class PublicService 
{

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg)
	{
		String result = "Restful example: " + msg;
		return Response.status(200).entity(result).build();
	}
	
}
