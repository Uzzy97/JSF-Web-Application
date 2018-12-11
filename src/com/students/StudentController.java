package com.students;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

import com.students.DAO;
import com.students.Student;

@ManagedBean
public class StudentController {
	DAO dao;
	ArrayList<Student> students;
	
	public StudentController() throws Exception{
		super();
		dao = new DAO();
		students = new ArrayList<Student>();
	}
	
	public void loadStudents() throws SQLException{
		students = dao.loadStudents();
		//System.out.println("p size = " + products.size());
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	
	

}

