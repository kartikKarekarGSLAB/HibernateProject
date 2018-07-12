package com.gslab.demo.service;

import com.gslab.demo.model.Student;

public interface StudentService {
	public Student create(Student student);
	public Student read(Student student);
	public Student update(Student student);
	public boolean delete(Student student);	
}
