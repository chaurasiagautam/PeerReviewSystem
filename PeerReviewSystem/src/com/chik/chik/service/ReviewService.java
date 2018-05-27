package com.chik.chik.service;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.chik.chik.bean.PeerReviewsBean;
import com.chik.chik.utility.HibernateConfiguration;

public class ReviewService implements ReviewInterface{
	
	private static final Logger log = Logger.getLogger(ReviewService.class);
	//private static final SessionFactory sessionFactory = new HibernateConfiguration().getPeerReviewsBeanFactory();
	//private Session session;
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILURE = "FAILURE";


	@Override
	public String submitReview(PeerReviewsBean reviewBean) {
		// TODO Auto-generated method stub
		log.info("submitReview starts.."+reviewBean.toString());
		Session session = new HibernateConfiguration().getPeerReviewsBeanFactory().openSession();
		log.info("session starts.."+session);
		Transaction tx = null;

		String returnMsg;
		try {
			tx = session.beginTransaction();
			log.info("tx starts.."+tx);
			log.info(session.save(reviewBean));
			tx.commit();
			log.info("tx commits..");
			returnMsg = SUCCESS;
		} catch (ConstraintViolationException e){
			if (tx != null)
				tx.rollback();
			System.err.println("Error occured, Review already in system:: " + e);
			returnMsg = FAILURE;
		}
		catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			System.err.println("Error occured: " + e);
			returnMsg = FAILURE;
		} 
		catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.err.println("Error occured: " + e);
			returnMsg = FAILURE;
		} finally {
			session.close();
		}

		return returnMsg;
	}
	
	/*public Session getSession() {
		return sessionFactory.openSession();
	}

	public void setSession(Session session) {
		this.session = session;
	}*/
}
