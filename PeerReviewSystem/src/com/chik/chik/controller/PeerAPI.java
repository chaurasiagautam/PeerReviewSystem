package com.chik.chik.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.chik.chik.bean.PeerMSTBean;
import com.chik.chik.bean.PeerReviewsBean;
import com.chik.chik.service.PeerService;
import com.chik.chik.service.ReviewService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mysql.cj.log.Log;

@Path("/peer")
public class PeerAPI {

	private static final Logger log = Logger.getLogger(PeerAPI.class);
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Dummy say : " + msg;
		PeerService pService = new PeerService();
		List<PeerMSTBean> list = pService.getAllPeersFromSystem();
		
		/*for(PeerMSTBean pBn : list){
			log.info(pBn.toString());
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
	
	@POST
	@Path("/review")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response submitReview(String jsonReviewObject) {
		log.info("json value::"+jsonReviewObject);
		//JsonObject json = new JsonParser().parse(jsonReviewObject).getAsJsonObject();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		PeerReviewsBean peer = gson.fromJson(jsonReviewObject, PeerReviewsBean.class);
		log.info(peer.toString());
		/*log.info("json:"+json);
		String peerId= json.get("peerId").toString();
		log.info("json:"+json+"|peerId:"+peerId);*/
		ReviewService rService = new ReviewService();
		log.info("bean value::"+peer.toString());
		String response = rService.submitReview(peer);
		log.info(response);
		return Response.status(200).entity(String.valueOf(0)).build();
		
	}
	
}
