package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.avaje.ebean.Model;

@Entity
public class AdharCardModel extends Model{
	@Id
	public long adharNo;
	public String country;
	public String details;
	@OneToOne(cascade=CascadeType.ALL)
	public PersonModel person;
	
	
	
	
	@Override
	public String toString() {
		return "AdharCardModel [adharNo=" + adharNo + ", country=" + country
				+ ", details=" + details + ", person=" + person + "]";
	}




	public static Model.Finder<Long, AdharCardModel> find=new Finder<Long,AdharCardModel>(AdharCardModel.class);

}
