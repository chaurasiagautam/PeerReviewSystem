package com.chik.chik.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


@SuppressWarnings("deprecation")
public class HibernateConfiguration {

	public SessionFactory getPeerMSTBeanFactory(){
		SessionFactory factory;
		try {
			factory = new AnnotationConfiguration().configure().addAnnotatedClass(com.chik.chik.bean.PeerMSTBean.class).buildSessionFactory();
			// addPackage("com.xyz") //add package if used.
					
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		return factory;
	}
}
