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
public class StudentModel extends Model {

	@Id
	private long sid;
	private String sname;
	private String branch;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course")
    public List<CourseModel> courseList=new ArrayList<>();

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch){
		this.branch = branch;
	}
	
	public static Finder<Long,StudentModel> find(){
		return new Finder<>(StudentModel.class);
	}

	@Override
	public String toString() {
		return "StudentModel [sid=" + sid + ", sname=" + sname + ", branch="
				+ branch + ", courseList=" + courseList + "]";
	}
	
	

}
