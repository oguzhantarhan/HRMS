package kodlamaio.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="system_verification_for_employers")
@AllArgsConstructor
@NoArgsConstructor
public class SystemVerification{
	@Id
	@JsonIgnore
	@Column(name="id",insertable = false,updatable = false)
	private int id;
	
	@Column(name="personnal_id")
	private int staffId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="verification_date")
	private LocalDate verificationDate;
	
	@Column(name="is_verificated")
	private boolean isVerificated;

}
