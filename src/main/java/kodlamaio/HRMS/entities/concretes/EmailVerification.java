package kodlamaio.HRMS.entities.concretes;

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
@Table(name="email_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class EmailVerification {
	@Id
	@JsonIgnore
	@Column(name="id",insertable = false,updatable = false)
	private int id;
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="verification_code")
	private String verificationCode;
	
	@Column(name="is_verificated")
	private boolean isVerificated;
	
}
