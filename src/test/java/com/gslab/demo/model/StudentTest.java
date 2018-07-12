package com.gslab.demo.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {
	@Test
	public void testCanGetAndSetAttributes() {
		Student stuObject = new Student();
		stuObject.setId(101);
		stuObject.setName("Kartik");
		stuObject.setAge(22);
		assertEquals(101, stuObject.getId());
		assertEquals("Kartik", stuObject.getName());
		assertEquals(22, stuObject.getAge());
	}
	@Test
	public void testCanCreateObjectUsingParametrizeContructor() {
		// TODO Auto-generated method stub
		Student stuObject = new Student(101, "Kartik", 22);
		assertEquals(101, stuObject.getId());
		assertEquals("Kartik", stuObject.getName());
		assertEquals(22, stuObject.getAge());		
	}

}
