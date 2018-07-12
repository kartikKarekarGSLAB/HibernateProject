package com.gslab.demo.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernetUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private	static SessionFactory sessionFactory;
	static {
		try {
			if(sessionFactory == null) {
				
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure(new File("C:\\Users\\GS-1830\\eclipse-workspace\\hibernet_demo\\src\\main\\resources\\config\\xml\\hibernate.cfg.xml")).build();
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				sessionFactory =  metadata.getSessionFactoryBuilder().build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;		
	}
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
