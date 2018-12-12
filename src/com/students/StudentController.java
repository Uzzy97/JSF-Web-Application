package com.students;

import java.sql.SQLException;
import java.util.ArrayList;
import com.students.DAO;
import com.students.Student;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.courses.Course;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@ManagedBean
@SessionScoped
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
	
	public String addStudent(Student student) {
		if (dao != null) {
			try {
				dao.addStudent(student);
				return "student";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Student ID " + student.getSid() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Student " + student.getCid());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
	public String deleteStudent(Student student) {
		
		try {
			dao.deleteStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "student";
		
	
}
	
	
	

}

