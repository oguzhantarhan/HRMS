package kodlamaio.HRMS.business.concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.EmailverificationService;
import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.business.abstracts.SystemVerificationService;
import kodlamaio.HRMS.core.utilities.businessHelper.BusinessRules;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.EmployerDao;
import kodlamaio.HRMS.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerdao;
	private EmailverificationService emailverificationService;
	private SystemVerificationService systemVerificationService;
	@Autowired
	public EmployerManager(EmployerDao employerdao, EmailverificationService emailverificationService,
			SystemVerificationService systemVerificationService) {
		super();
		this.employerdao = employerdao;
		this.emailverificationService = emailverificationService;
		this.systemVerificationService = systemVerificationService;
	}
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerdao.findAll(),"all employer listed");
	}
	@Override
	public Result add(Employer employer, String password) {
		Result result=BusinessRules.run(isNull(employer),
				isPasswordValid(employer, password),
				isDomainEqual(employer),
				isEmailExist(employer),
				systemVerificationService.isVerificated(employer.getEmail()),
				emailverificationService.isVerificated(employer.getEmail()));
		if (result.isSuccess()) {
			employerdao.save(employer);
			return new SuccessResult(employer.getCompanyName()+" added");
		}
		return new ErrorResult(result.getMessage());
	}
private Result isNull(Employer employer) {
	if(Objects.isNull(employer.getCompanyName())||
			Objects.isNull(employer.getPhoneNumber())||
					Objects.isNull(employer.getWebsite())) {
		return new ErrorResult("All fields not be empty!");
	}
	return new SuccessResult();
}
private Result isPasswordValid(Employer employer,String password) {
	
	String pass = employer.getPassword();
	if(pass.equals(password)) {
		return new SuccessResult();
	}
	return new ErrorResult("Passwords is not match");
}
private Result isDomainEqual(Employer employer) {
	String[] emailDomain = employer.getEmail().split("@");
	if(employer.getWebsite().equals(emailDomain[1])) {
		return new SuccessResult();
	}
	return new ErrorResult("Email domain not match your website");
}
private Result isEmailExist(Employer employer) {
	if(employerdao.findByEmail(employer.getEmail()) == null) {
		return new SuccessResult();
	}
	return new ErrorResult("this email already exist");
}

}
