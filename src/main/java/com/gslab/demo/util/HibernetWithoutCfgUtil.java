package com.gslab.demo.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.fasterxml.classmate.AnnotationConfiguration;

public class HibernetWithoutCfgUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		Map<String, String> dbSettings = new HashMap<String, String>();
		dbSettings.put(Environment.URL, "jdbc:postgresql://localhost:5432/gs_1830");
		dbSettings.put(Environment.USER, "gs_1830");
		dbSettings.put(Environment.PASS, "test@123");
		dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
		dbSettings.put(Environment.DRIVER, "org.postgresql.Driver");
		standardServiceRegistryBuilder.applySettings(dbSettings);
		standardServiceRegistry = standardServiceRegistryBuilder.build();
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata metadata = metadataSources.getMetadataBuilder().build();
		sessionFactory =  metadata.getSessionFactoryBuilder().build();		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
