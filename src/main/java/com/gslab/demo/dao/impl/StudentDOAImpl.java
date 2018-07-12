package com.gslab.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.gslab.demo.dao.StudentDAO;
import com.gslab.demo.model.Student;
import com.gslab.demo.util.Database;

public class StudentDOAImpl implements StudentDAO{

	Database database;
	public StudentDOAImpl() {
		// TODO Auto-generated constructor stub
		this.database = new Database();
		this.database.loadDriver("org.postgresql.Driver");
		this.database.setConnection("jdbc:postgresql://localhost:5432/gs_1830", "gs_1830", "test@123"); 
		this.database.setStatement();
	}
	public Student create(Student student) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = this.database.getConnection();
			PreparedStatement statement = conn.prepareStatement("insert into student(id,name,age) values (?,?,?)");
			statement.setInt(1,student.getId());
			statement.setString(2,student.getName());
			statement.setInt(3, student.getAge());
			
			result = statement.executeUpdate();
 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result != 1) {
			student.setId(0);
			student.setName(null);
			student.setAge(1);
			return student;
		} else {
			return student;
		}		
	}

	public Student read(Student student) {
		// TODO Auto-generated method stub
		try {
			Connection conn = this.database.getConnection();
			String query = "select * from student";
			ResultSet result =null;
			if (student.getName() != null) {
				query += " where name ilike ?";
				if(student.getId() != 0)
					query+=" and id ="+student.getId();				
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1,"%"+student.getName()+"%");				
				result = statement.executeQuery();
			} else {
				query+=" where id = "+student.getId();
				System.out.println(query);
				result = this.database.getStatement().executeQuery(query);
			}
			if (result.next()) {
				student.setId(result.getInt(1));
				student.setName(result.getString(2));
				student.setAge(result.getInt(3));
				return student;
			} 
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		student.setId(0);
		student.setName(null);
		student.setAge(1);		
		return student;
	}

	public Student update(Student student) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = this.database.getConnection();
			PreparedStatement statement = conn.prepareStatement("update student set name = ? , age = ? where id = ?");
			statement.setString(1,student.getName());
			statement.setInt(2,student.getAge());
			statement.setInt(3,student.getId());
			result = statement.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result != 1) {
			student.setId(0);
			student.setName(null);
			student.setAge(1);
			return student;
		} else {
			return student;
		}
	}

	public boolean delete(Student student) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = this.database.getConnection();
			PreparedStatement statement = conn.prepareStatement("delete from student where id = ?");
			statement.setInt(1,student.getId());
			result = statement.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result != 1) {
			student.setId(0);
			student.setName(null);
			student.setAge(1);
			return false;
		} else {
			return true;
		}
	}

}
