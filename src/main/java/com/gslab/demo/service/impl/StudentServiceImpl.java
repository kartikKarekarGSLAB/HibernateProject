package com.gslab.demo.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.gslab.demo.dao.impl.StudentDOAImpl;
import com.gslab.demo.model.Student;
import com.gslab.demo.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDOAImpl studentDOAImplObject;
	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
		this.studentDOAImplObject = new StudentDOAImpl();
	}
	public boolean validateStudentId(int id) {
		final String regexValidId = "[0-9]{3}";         
        Pattern patternValidId = Pattern.compile(regexValidId);         
        Matcher matcherValidId = patternValidId.matcher(""+id);
		if (!matcherValidId.matches()) {			
			return false;
		} else
			return true;
		
	}
	public boolean validateStudentName(String name) {
		final String regexValidName = "^[a-z |A-Z ]{2,24}$";         
        Pattern patternValidName = Pattern.compile(regexValidName);         
        Matcher matcherValidName = patternValidName.matcher(name);
        if (!matcherValidName.matches()) {
			return false;
		} else		
			return true;
	}
	public boolean validateStudentAge(int age) {
		if(age>=0 && age<= 100) {
			return true;
		} else {
			return false;
		}
	}
	public Student create(Student student) {
		// TODO Auto-generated method stub		
		int id = student.getId();
		String name = student.getName();
		int age = student.getAge();
		boolean validStudentData = true;
		if (!this.validateStudentId(id)) {			
			validStudentData = false;
		}		
        if (!this.validateStudentName(name)) {
			validStudentData = false;
		}    
		if (!this.validateStudentAge(age)) {			
			validStudentData = false;
		}		
        if(validStudentData) {
        	return this.studentDOAImplObject.create(student);
        } else {		
			return new Student();
        }        
	}
	public static void main(String[] args) {
		Student studentObject = new Student();
		studentObject.setId(103);
		studentObject.setName("Swapnil Inamdar");
		studentObject.setAge(23);		
	}
//	public static void main(String[] args) {
//		
//		StudentServiceImpl serviceImplObject = new StudentServiceImpl();
//		System.out.println("1.create");
//		System.out.println("2.read");
//		System.out.println("3.update");
//		System.out.println("4.delete");
//		System.out.println("Enter your choice : ");
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int option;
//		try {
//			option = (char)br.read();
//			switch (option) {
//			case '1':
//				System.out.println(br.readLine());
//				Student studObject = new Student();
//				System.out.println("Enter Student ID");
//				studObject.setId(Integer.parseInt(br.readLine()));
//				System.out.println("Enter Student NAME");
//				studObject.setName(br.readLine());
//				System.out.println("Enter Student Age");
//				studObject.setAge(Integer.parseInt(br.readLine()));
//				Student result = serviceImplObject.create(studObject);
//				if (result.getId() != 0) {
//					System.out.println("Student Added.");
//				} else {
//					System.out.println("Fail to add student");
//				}
//				break;
//			case '2':
//				System.out.println("option2");
//				break;
//			case '3':
//				System.out.println("option3");
//				break;
//			case '4':
//				System.out.println("option4");
//				break;				
//			default:
//				System.out.println("default choice");
//				break;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	public Student read(Student student) {
		// TODO Auto-generated method stub
		boolean validStudentData = true;
		String name = student.getName();
        if (!this.validateStudentName(name)) {
			validStudentData = false;
		}
        if(validStudentData) {
        	return this.studentDOAImplObject.read(student);
        } else {
			return new Student();
        }        
	}
	public Student update(Student student) {
		// TODO Auto-generated method stub
		int id = student.getId();
		String name = student.getName();
		int age = student.getAge();
		boolean validStudentData = true;
		if (!this.validateStudentId(id)) {			
			validStudentData = false;
		}		
        if (!this.validateStudentName(name)) {
			validStudentData = false;
		}    
		if (!this.validateStudentAge(age)) {			
			validStudentData = false;
		}		
        if(validStudentData) {
        	Student findStudent = new Student(student.getId(),student.getName(),student.getAge());
        	Student existingStudent = this.studentDOAImplObject.read(findStudent);
        	if(existingStudent.getId() != 0) {
        		student.setId(existingStudent.getId());
        		if(student.getName() == "")
        			student.setName(existingStudent.getName());
        		if(student.getAge() == 1)
        			student.setAge(existingStudent.getAge());
        		return this.studentDOAImplObject.update(student);
        	} else {
        		return new Student();
        	}
        } else {
			return new Student();
        }
	}
	public boolean delete(Student student) {
		// TODO Auto-generated method stub
		int id = student.getId();
    	Student findStudent = new Student();
    	findStudent.setId(id);
    	Student existingStudent = this.studentDOAImplObject.read(findStudent);
    	if(existingStudent.getId() != 0) {
    		boolean result = this.studentDOAImplObject.delete(existingStudent);
    		if (result) {
				System.out.println("Delete success");
			} else {
				System.out.println("Delete Failure");
			}
    	} else {
    		System.out.println("Delete Failure");
    	}
    	return true;
	}
}
