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

			//create Employee
//			Transaction tr = session.beginTransaction();
//			Employee empObject = new Employee("Mandar dharurkar","Sr. software manager",85000.65f);
//			session.save(empObject);
//			session.getTransaction().commit();
			
			//read Employee
			Employee s = readEmployee(session,1);
			System.out.println(s);

			//update Employee
			//updateEmployee(session,new Employee());
			
			//delete Employee
			//deleteEmployee(session,1);

			session.close();
			HibernetUtil.closeSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Employee readEmployee(Session session,int foundId) {
		// TODO Auto-generated method stub
		Employee foundEmployee = session.get(Employee.class, foundId);
		if (foundEmployee != null) {
				return foundEmployee;
		} else {
			return null;
		}
	}

	private static boolean updateEmployee(Session session,Employee updateDataEmployee) {
		// TODO Auto-generated method stub
		Employee foundEmployee = session.get(Employee.class, 1);
		if (foundEmployee != null) {
			if (updateDataEmployee != null) {
				if (updateDataEmployee.getName() != null) {
					foundEmployee.setName(updateDataEmployee.getName());					
				}
				if (updateDataEmployee.getDesignation() != null) {
					foundEmployee.setDesignation(updateDataEmployee.getDesignation());
				}
				if (updateDataEmployee.getSalary() != 0.0f) {
					foundEmployee.setSalary(updateDataEmployee.getSalary());
				}
				session.beginTransaction();
				session.update(foundEmployee);
				session.getTransaction().commit();
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	private static void deleteEmployee(Session session,int deleteEmpId) {
		// TODO Auto-generated method stub
		Employee foundEmployee = session.get(Employee.class, deleteEmpId);
		if (foundEmployee != null) {
			session.beginTransaction();
			session.delete(foundEmployee);
			session.getTransaction().commit();
			System.out.println("Employee Deleted successfully");
		} else {
			System.out.println("Employee doesn't exists");
		}		
	}

}
