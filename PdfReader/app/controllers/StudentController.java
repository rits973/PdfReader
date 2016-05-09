package controllers;

import java.util.List;

import models.CourseModel;
import models.StudentModel;
import play.mvc.Controller;
import play.mvc.Result;

public class StudentController extends Controller{
	
	public Result studentIndex(){
		return ok(views.html.studentform.render());
		
	}
	
	public void addStudent(){
		
	}
	public void saveStudent(){
		
	}
	public Result showStudent(){
		
		StudentModel st=new StudentModel();
		st.setSname("rahul");st.setBranch("ece");
		st.save();
		CourseModel cs=CourseModel.find().byId(2l);
		
		cs.studentList.add(st);
		cs.update();
		List<StudentModel> sm=StudentModel.find().all();
		return ok(views.html.studentdetails.render(sm));
	}

}
