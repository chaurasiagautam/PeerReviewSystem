package com.chik.chik.Test;

import java.util.List;

import org.apache.log4j.Logger;

import com.chik.chik.bean.PeerMSTBean;
import com.chik.chik.service.PeerService;

public class DryRun {
	public static final Logger log = Logger.getLogger(PeerService.class);
	public static void main(String[] args) {

		PeerMSTBean pBean = new PeerMSTBean();
		PeerService pService = new PeerService();
		
		pBean.setFirstName("Dummy");
		pBean.setLastName("Tesrt");
		pBean.setGender("M");
		pBean.setPeerID(124536);
		pBean.setPassword("DummyTest");
		pBean.setSeq1("1");
		pBean.setSeq2("1");
		
//		pService.addPeerToSystem(pBean);
		List<PeerMSTBean> list = pService.getAllPeersFromSystem();
		
		for(PeerMSTBean pBn : list){
			log.info(pBn.toString());
		}
	}

}
