/**
 * 
 */
package com.gslab.demo.util;

import static org.junit.Assert.*;

import java.lang.System.Logger;

import org.junit.Test;

/**
 * @author GS-1830
 *
 */
public class DatabaseTest {

	@Test
	public void testCanLoadDriver() {
		Database db = new Database();
		boolean result = db.loadDriver("org.postgresql.Driver");
		assertEquals(true, result);
	}
	@Test
	public void testCanGetConnection() {
		Database db = new Database();
		db.loadDriver("org.postgresql.Driver");
		boolean result = db.setConnection("jdbc:postgresql://localhost:5432/gs_1830", "gs_1830", "test@123");
		assertEquals(true, result);
	}
	@Test
	public void testCanGetStatement() {
		Database db = new Database();
		db.loadDriver("org.postgresql.Driver");
		db.setConnection("jdbc:postgresql://localhost:5432/gs_1830", "gs_1830", "test@123");
		boolean result = db.setStatement();
		assertEquals(true, result);
	}	
}
