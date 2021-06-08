package kodlamaio.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="professions")
@Data
public class Profession {
	
	@Id
	@GeneratedValue
	@Column(name="profession_id")
	private int id;
	
	@Column(name="profession_name")
	private String name;
	

	public Profession() {
		super();
	}
		
	}

	
