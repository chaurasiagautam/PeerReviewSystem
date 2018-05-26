package com.chik.chik.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.chik.chik.bean.PeerMSTBean;
import com.chik.chik.service.PeerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserRegistered(String jsonObject) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		PeerMSTBean[] peer = gson.fromJson(jsonObject, PeerMSTBean[].class);
		
		PeerService pService = new PeerService();
		String response = pService.addPeerToSystem(peer[0]);
		System.out.println(response);
		return Response.status(200).entity(String.valueOf(response)).build();
	}
}
