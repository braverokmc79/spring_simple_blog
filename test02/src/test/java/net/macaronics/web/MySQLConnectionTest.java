package net.macaronics.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {

	private static final String DRIVER ="com.mysql.jdbc.Driver";
	
	private static final String URL ="jdbc:mysql://localhost:3305/simpleblog?characterEncoding=utf8&useSSL=false";
	
	private static final String USER ="simpleblog";
	
	private static final String PW="1111";
	
	
	@Test
	public void testConnection() throws Exception{
		
		Class.forName(DRIVER);
		
		try(Connection con =DriverManager.getConnection(URL, USER, PW)){
			System.out.println("test");
			System.out.println(con);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
