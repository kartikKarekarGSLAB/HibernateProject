package com.gslab.demo.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.SetSimpleValueTypeSecondPass;

import com.gslab.demo.model.Student;
import com.gslab.demo.util.HibernetUtil;
import com.gslab.demo.util.HibernetWithoutCfgUtil;

public class HibernetDAOImpl {

	public static void main(String[] args) {
		try {
			Session session = HibernetWithoutCfgUtil.getSessionFactory().openSession();
			String SQL = "SELECT VERSION();";
			String result = (String) session.createNativeQuery(SQL).getSingleResult();
			System.out.println("SQL VERSION : "+result);
//			Transaction tr = session.beginTransaction();
//			
//			Student studentObject = new Student();
//			studentObject.setId(105);
//			studentObject.setName("Bhushan Chikhalikar");
//			studentObject.setAge(24);			
//			
//			session.save(studentObject);
//			session.getTransaction().commit();
//			session.close();
			HibernetWithoutCfgUtil.closeSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
