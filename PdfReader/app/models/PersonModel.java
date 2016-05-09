package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.avaje.ebean.Model;
import com.avaje.ebean.Model.Finder;

@Entity
public class PersonModel extends Model{
	@Id 
	public long personId;
	public String personName;
	public int age;
	
	
	
	
	
	@Override
	public String toString() {
		return "PersonModel [personId=" + personId + ", personName="
				+ personName + ", age=" + age + "]";
	}





	public static Model.Finder<Long, PersonModel> find=new Finder<Long,PersonModel>(PersonModel.class);
}
