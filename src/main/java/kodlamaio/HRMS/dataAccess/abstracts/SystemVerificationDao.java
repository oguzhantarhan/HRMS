package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.SystemVerification;

public interface SystemVerificationDao extends JpaRepository<SystemVerification, Integer> {
	SystemVerification findByEmailAndIsVerificated(String email,boolean isVerificated);
}
