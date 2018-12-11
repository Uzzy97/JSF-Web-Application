package com.courses;

import java.sql.SQLException;
import java.util.ArrayList;
import com.courses.DAO;
import com.courses.Course;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

@ManagedBean
@SessionScoped
public class CourseController {
	
	DAO dao;
	ArrayList<Course> courses;
	
	public CourseController() throws Exception{
		super();
		dao = new DAO();
		courses = new ArrayList<Course>();
	}
	
	public void loadCourses() throws SQLException{
		courses = dao.loadCourses();
		//System.out.println("p size = " + products.size());
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	
	public String addCourse(Course course) {
		if (dao != null) {
			try {
				dao.addCourse(course);
				return "course";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Course ID " + course.getCid() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert Course " + course.getCid());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	
	public String deleteCourse(Course course) {
	
			try {
				dao.deleteCourse(course);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "course";
			
		
	}
	
	
	

}
