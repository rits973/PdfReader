package controllers;

import java.util.List;

import models.AdharCardModel;
import play.mvc.Controller;
import play.mvc.Result;

public class AdharGeneratorController extends Controller {
	
	
	public Result practice(){
		return ok(views.html.practice.render());
	}
	
	public Result generateAdhar(){
		List<AdharCardModel> am=AdharCardModel.find.all();
		
		return ok(views.html.persondetail.render(am));
	}

}
