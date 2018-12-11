package com.courses;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.courses.Course;

@SessionScoped
@ManagedBean
public class DAO {
	
	private DataSource mysqlDS;
	
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/studentdb";
		mysqlDS = (DataSource) context.lookup(jndiName);
	
}
	public ArrayList<Course> loadCourses() throws SQLException{
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();
		String query = "select * from course";
		ResultSet rs = myStmt.executeQuery(query);
		ArrayList<Course> courses = new ArrayList<Course>();
		
		while( rs.next() ) {
			String cid = rs.getString("cID");
			String desc = rs.getString("cNAME");
			int dur = rs.getInt("duration");
			
			Course course = new Course(cid, desc, dur);
			courses.add(course);
		}
		return courses;
	


	}
	
	public void addCourse(Course course) throws Exception {
		Connection conn = null;
		PreparedStatement myStmt = null;
		ResultSet rs = null;
		
		conn = mysqlDS.getConnection();
		String sql = "insert into course values (?, ?, ?)";
		myStmt = conn.prepareStatement(sql);
		myStmt.setString(1, course.getCid());
		myStmt.setString(2, course.getDesc());
		myStmt.setInt(3, course.getDur());
		myStmt.execute();			
	}
	public void deleteCourse(Course course) throws SQLException {
		
		Connection conn = null;
		PreparedStatement myStmt = null;
		ResultSet rs = null;
		
		conn = mysqlDS.getConnection();
		String sql = "delete from course where cID like ?";
		myStmt = conn.prepareStatement(sql);
		myStmt.setString(1, course.getCid());
		myStmt.execute();			
	}
		
		
		
	}
	


