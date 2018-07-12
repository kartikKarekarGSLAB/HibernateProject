package com.gslab.demo.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.SetSimpleValueTypeSecondPass;

import com.gslab.demo.model.Employee;
import com.gslab.demo.model.Student;
import com.gslab.demo.util.HibernetUtil;
import com.gslab.demo.util.HibernetWithoutCfgUtil;

public class HibernetDAOImpl {

	public static void main(String[] args) {
		try {
			Session session = HibernetUtil.getSessionFactory().openSession();
			String SQL = "SELECT VERSION();";
			String result = (String) session.createNativeQuery(SQL).getSingleResult();
			System.out.println("SQL VERSION : "+result);

			Transaction tr = session.beginTransaction();
			Employee empObject = new Employee("kartik karekar","software engineer",3500.65f);
			session.save(empObject);
//			Student studentObject = new Student();
//			studentObject.setId(105);
//			studentObject.setName("Bhushan Chikhalikar");
//			studentObject.setAge(24);			
//			
//			session.save(studentObject);
			session.getTransaction().commit();
			session.close();
			HibernetUtil.closeSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
