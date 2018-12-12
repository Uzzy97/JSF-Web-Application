package com.students;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.courses.Course;
import com.students.Student;

@SessionScoped
@ManagedBean
public class DAO {
private DataSource mysqlDS;
	
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/studentdb";
		mysqlDS = (DataSource) context.lookup(jndiName);
	
}
	public ArrayList<Student> loadStudents() throws SQLException{
		Connection conn = mysqlDS.getConnection();
		Statement myStmt = conn.createStatement();
		String query = "select * from student";
		ResultSet rs = myStmt.executeQuery(query);
		ArrayList<Student> students = new ArrayList<Student>();
		
		while( rs.next() ) {
			String sid = rs.getString("sid");
			String cid = rs.getString("cID");
			String name = rs.getString("name");
			String add = rs.getString("address");
			
			Student student = new Student(sid, cid, name, add);
			students.add(student);
		}
		//System.out.println("SIZE = " + products.size());
		return students;

	}
	
	public void addStudent(Student student) throws Exception {
		Connection conn = null;
		PreparedStatement myStmt = null;
		ResultSet rs = null;
		
		conn = mysqlDS.getConnection();
		String sql = "insert into student values (?, ?, ?, ?)";
		myStmt = conn.prepareStatement(sql);
		myStmt.setString(1, student.getSid());
		myStmt.setString(2, student.getCid());
		myStmt.setString(3, student.getName());
		myStmt.setString(4, student.getAdd());
		myStmt.execute();			
	}
	
public void deleteStudent(Student student) throws SQLException {
		
		Connection conn = null;
		PreparedStatement myStmt = null;
		ResultSet rs = null;
		
		conn = mysqlDS.getConnection();
		String sql = "delete from student where sid like ?";
		myStmt = conn.prepareStatement(sql);
		myStmt.setString(1, student.getSid());
		myStmt.execute();			
	}
	
}