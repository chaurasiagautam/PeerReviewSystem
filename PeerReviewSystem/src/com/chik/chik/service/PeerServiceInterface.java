package com.chik.chik.service;

import java.util.List;
import java.util.Map;

import com.chik.chik.bean.PeerMSTBean;


public interface PeerServiceInterface<K,V> {

public String addPeerToSystem(PeerMSTBean pBean);
	
	public boolean addPeerReview();
	
	public Map<K,V> getPeerReview();
	
	public List<PeerMSTBean> getAllPeersFromSystem();
}
