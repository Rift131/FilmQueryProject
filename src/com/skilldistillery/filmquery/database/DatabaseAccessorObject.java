package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	public DatabaseAccessorObject() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	  }

	@Override
	public Film findFilmById(int filmId) {
		// Log in to the DB
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);
		String sqltext;
		
		//Querry Code
		sqltext="SELECT id, first_name, last_name, email, last_update FROM customer ORDER BY last_name"; /////
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setXXX(columnName, somethingHere); 
		
		ResultSet rs = stmt.executeQuery();
		
		// set up a string builder
		
		// iterate over the rs (query data) and append the columns to the string builder sysout the string builder on each iteration and erase its contents for the next iteration 
		
	}

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		String sqltext;
		sqltext="SELECT id, first_name, last_name, email, last_update FROM customer ORDER BY last_name"; /////
		
		PreparedStatement stmt = conn.prepareStatement(sqltext);
		stmt.setXXX(columnName, somethingHere); 
		
		ResultSet rs = stmt.executeQuery();
		
		
		
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		
		String user = "student";
		String pass = "student";
		Connection conn = DriverManager.getConnection(url, user, pass);
		
		String sqltext;
		sqltext="SELECT id, first_name, last_name, email, last_update FROM customer ORDER BY last_name";
		
		PreparedStatement stmt;
		stmt.setXXX(columnName, somethingHere); 
		
		ResultSet rs = stmt.executeQuery();
		
		return null;
	}
	
	// close statements

}
