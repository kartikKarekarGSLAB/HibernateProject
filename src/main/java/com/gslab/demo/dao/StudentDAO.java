package com.gslab.demo.dao;

import com.gslab.demo.model.Student;

public interface StudentDAO {
	public Student create(Student student);
	public Student read(Student student);
	public Student update(Student student);
	public boolean delete(Student student);
}
