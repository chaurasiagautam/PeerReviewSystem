package com.chik.chik.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.chik.chik.bean.PeerMSTBean;
import com.chik.chik.service.PeerService;
import com.google.gson.Gson;

@Path("/peer")
public class PeerAPI {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Dummy say : " + msg;
		PeerService pService = new PeerService();
		List<PeerMSTBean> list = pService.getAllPeersFromSystem();
		
		/*for(PeerMSTBean pBn : list){
			System.out.println(pBn.toString());
		}*/
		
		String json = new Gson().toJson(list);
 
		return Response.status(200).entity(output).entity(json).build();
 
	}
}
