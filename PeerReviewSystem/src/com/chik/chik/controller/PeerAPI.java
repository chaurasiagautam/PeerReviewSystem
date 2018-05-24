package com.chik.chik.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/peer")
public class PeerAPI {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Dummy say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
}
