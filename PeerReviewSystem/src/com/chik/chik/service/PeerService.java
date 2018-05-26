package com.chik.chik.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.chik.chik.bean.PeerMSTBean;
import com.chik.chik.utility.HibernateConfiguration;


public class PeerService implements PeerServiceInterface<PeerMSTBean, Map<String, Integer>> {

	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE = "FAILURE";
	public static final Logger log = Logger.getLogger(PeerService.class);

	/* Method to CREATE an peers in the database */
	/* (non-Javadoc)
	 * @see com.chik.chik.Service.PeerServices#addPeerToSystem(com.chik.chik.dao.PeerMSTBean)
	 */
	public String addPeerToSystem(PeerMSTBean pBean) {
		log.info("Adding user to system");
		String returnMsg = null;
		Session session = new HibernateConfiguration().getPeerMSTBeanFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(pBean);
			tx.commit();
			returnMsg = SUCCESS;
		} catch (ConstraintViolationException e){
			if (tx != null)
				tx.rollback();
			System.err.println("Error occured, User already in system:: " + e);
			returnMsg = FAILURE;
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.err.println("Error occured: " + e);
			returnMsg = FAILURE;
		} finally {
			session.close();
		}

		return returnMsg;
	}

	public boolean addPeerReview() {
		// TODO Auto-generated method stub
		return false;
	}


	/* Method to READ all the peerss */
	/* (non-Javadoc)
	 * @see com.chik.chik.Service.PeerServices#getAllPeersFromSystem()
	 */
	public List<PeerMSTBean> getAllPeersFromSystem() {

		Session session = new HibernateConfiguration().getPeerMSTBeanFactory().openSession();
		Transaction tx = null;
		List<PeerMSTBean>  peersList = null;

		try {
			tx = session.beginTransaction();
			peersList = session.createQuery("FROM PeerMSTBean").list();
			for (Iterator iterator = peersList.iterator(); iterator.hasNext();) {
				PeerMSTBean peers = (PeerMSTBean) iterator.next();
				log.info("First Name: " + peers.getFirstName());
				log.info("  Last Name: " + peers.getLastName());
			}
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return peersList;
	}

	@Override
	public Map<PeerMSTBean, Map<String, Integer>> getPeerReview() {
		// TODO Auto-generated method stub
		return null;
	}

}
