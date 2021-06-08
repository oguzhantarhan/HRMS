package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.EmailVerification;


public interface EmailVerificationDao extends JpaRepository<EmailVerification, Integer> {

	EmailVerification findByEmailAndIsVerificated(String email,boolean isVerificated);
}
