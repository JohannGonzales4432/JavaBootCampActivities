package M5_Activity2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnection {
	
	
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/training_db";
	public static final String USER = "postgres";
	public static final String PASS = "postgres";
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS)){
			System.out.println("Connected to db");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			
			/*
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			*/
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

}
