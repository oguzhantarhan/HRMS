package kodlamaio.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="professions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"}) 
public class Profession {
	
	@Id
	@GeneratedValue
	@Column(name="profession_id")
	private int id;
	
	@Column(name="profession_name")
	private String name;
	
	@OneToMany(mappedBy = "profession")
	private List<JobAdvertisement> jobAdvertisements;
		
	}

	
