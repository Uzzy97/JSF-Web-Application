package com.students;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.students.Student;

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
			
			Student s = new Student(sid, cid, name, add);
			students.add(s);
		}
		//System.out.println("SIZE = " + products.size());
		return students;
	


	}
	
}