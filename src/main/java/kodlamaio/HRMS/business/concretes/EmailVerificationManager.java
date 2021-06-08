package kodlamaio.HRMS.business.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmailverificationService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmailVerificationDao;
import kodlamaio.HRMS.entities.concretes.EmailVerification;
@Service
public class EmailVerificationManager implements EmailverificationService{

	private EmailVerificationDao emailVerificationDao;
	
	
	@Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		super();
		this.emailVerificationDao = emailVerificationDao;

	}

	@Override
	public DataResult<EmailVerification> getById(int id) {
		
		return new SuccessDataResult<EmailVerification>(this.emailVerificationDao.getById(id), "Email verification Listed By Id");
	}

	@Override
	public Result add(EmailVerification emailVerification) {
		this.emailVerificationDao.save(emailVerification);
		return new SuccessResult("Email Verification Added");
	}

	@Override
	public Result isVerificated(String email) {
		if(emailVerificationDao.findByEmailAndIsVerificated(email,true) == null) {
			return new ErrorResult("Email Verification required");
		}
		return new SuccessResult();
	}


}