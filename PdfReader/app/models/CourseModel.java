package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.avaje.ebean.Model;

@Entity
public class CourseModel extends Model{
	
	@Id
	private long courseId;
	private String courseName;
	private double courseFee;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course")
	public List<StudentModel> studentList=new ArrayList<>();

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}


	
	public static Finder<Long,CourseModel> find(){
		return new Finder<Long,CourseModel>(CourseModel.class);
	}

}
