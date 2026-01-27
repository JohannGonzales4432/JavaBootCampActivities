package M5_Activity3;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.Scanner;

public class Main {

	public static final String DB_URL = "jdbc:postgresql://localhost:5432/training_db";
	public static final String USER = "postgres";
	public static final String PASS = "postgres";
	
	public static Connection conn;
	public static ResultSet rs;
	public static Statement stmt;
	public static Scanner input;
	public static PreparedStatement prpStmt;
	
	public static void main(String[] args) throws SQLException{
		
		
		
		try {
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			input = new Scanner(System.in);
			String inputLine;
			char choice = '1';
			
			do {
				
				showMenu();
				
				inputLine = input.nextLine();
				
				if(inputLine == "") {
					choice = '5';
				}
				
				choice = inputLine.charAt(0);
				
				switch (choice) {
				
					case '1' :{
						
						addStudent();
						
						break;
					}
					case '2' :{
						
						addCourse();
						
						break;
					}
					case '3' :{
						
						showAllStudents();
						
						break;
					}
					case '4' :{
						
						showAllCourses();
				
						break;
					}
					case '0':{
						
						System.out.println("Exiting application.");
						
					}
				}
				
			}while(choice != '0');
			
			
		}finally {
			conn.close();
		}
	}
	
	public static void showMenu() {
		System.out.println("==== STUDENT COURSE MANAGEMENT ====");
		System.out.println("1. Add Student");
		System.out.println("2. Add Course");
		System.out.println("3. Show Students");
		System.out.println("4. Show Courses");
		System.out.println("0. Exit");
		System.out.println("Choose an option: ");
		System.out.println();
	}
	
	
	public static void addStudent() throws SQLException{
		
		String name;
		int age;
		String email;
		
		String sqlStatement;
		
		int result;
		
		// Ask for student details
		
		System.out.println("Enter name: ");
		
		name = input.nextLine();
		
		System.out.println("Enter age: ");
		
		age = Integer.valueOf(input.nextLine());
		
		System.out.println("Enter email: ");
			
		email = input.nextLine();
		
		// add to students table
		
		sqlStatement = "INSERT INTO students (name, age, email) VALUES (?, ?, ?);";
		
		prpStmt = conn.prepareStatement(sqlStatement);
		
		prpStmt.setString(1, name);
		prpStmt.setInt(2, age);
		prpStmt.setString(3, email);
		
		result = prpStmt.executeUpdate();
		
		System.out.println("Student added succesfully");
		System.out.println();
	}
	
	public static void addCourse() throws SQLException{
		
		String courseName;
		double grade;
		int studentID;
		
		String sqlStatement;
		
		int result;
		
		//display all sutdents first
		
		showAllStudents();
		
		// ask for course detail
		
		System.out.println("Enter student ID: ");
		
		studentID = Integer.valueOf(input.nextLine());
		
		System.out.println("Enter course name: ");
		
		courseName = input.nextLine();
		
		System.out.println("Enter grade: ");
			
		grade = Double.valueOf(input.nextLine());
		
		
		// store in courses table
		
		sqlStatement = "INSERT INTO courses (student_id, course_name, grade) VALUES (?, ?, ?);";
		
		prpStmt = conn.prepareStatement(sqlStatement);
		
		prpStmt.setInt(1, studentID);
		prpStmt.setString(2, courseName);
		prpStmt.setDouble(3, grade);
		
		result = prpStmt.executeUpdate();
		
		System.out.println("Course added succesfully");
		System.out.println();
		
	}
	
	public static void showAllStudents() throws SQLException {
		
		// display all students -> ID, Name, Age, Email
		
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM students;");
		
		
		int id;
		String name;
		int age;
		String email;
		
		System.out.println("ID | NAME | AGE | EMAIL");
		System.out.println("-------------------------");
		
		while (rs.next()) {
			
			id = rs.getInt("id");
			name = rs.getString("name");
			age = rs.getInt("age");
			email = rs.getString("email");
			
			System.out.printf("%d | %s | %d | %s \n", id,name,age,email);
		}
		System.out.println();
		
	}
	
	public static void showAllCourses() throws SQLException {
		
		//display all courses with student name enrolled
		
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT courses.id, courses.course_name, courses.grade, students.name FROM courses LEFT JOIN students ON courses.student_id = students.id;");
		
		
		int id;
		String courseName;
		int grade;
		String studentName;
		
		System.out.println("ID | COURSE NAME | GRADE | STUDENT");
		System.out.println("--------------------------------------");
		
		while (rs.next()) {
			
			id = rs.getInt("id");
			courseName = rs.getString("course_name");
			grade = rs.getInt("grade");
			studentName = rs.getString("name");
			
			System.out.printf("%d | %s | %d | %s \n", id,courseName,grade,studentName);
		}
		System.out.println();
		
	}

}
