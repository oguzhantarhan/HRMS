package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.business.abstracts.EmailverificationService;
import kodlamaio.HRMS.core.adapters.CheckMernisService;
import kodlamaio.HRMS.core.utilities.businessHelper.BusinessRules;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CandidateDao;
import kodlamaio.HRMS.entities.concretes.Candidate;
import java.util.Objects;

@Service
public class CandidateManager implements CandidateService {
private CandidateDao candidateDao;
private CheckMernisService checkMernisService;
private EmailverificationService emailverificationService;

@Autowired
	public CandidateManager(CandidateDao candidateDao, CheckMernisService checkMernisService,EmailverificationService emailverificationService) {
	super();
	this.candidateDao = candidateDao;
	this.checkMernisService = checkMernisService;
	this.emailverificationService=emailverificationService;
}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"all candidates listed");
	}

	@Override
	public Result add(Candidate candidate,String password) {
		Result result=BusinessRules.run(isNull(candidate),
				isCandidateExist(candidate),
				isPasswordValid(candidate, password),emailverificationService.isVerificated(candidate.getEmail()),
				checkMernisService.checkIfRealPerson(candidate)
				);
		if(result.isSuccess()) {
			candidateDao.save(candidate);
			return new SuccessResult(candidate.getFirstName()+" eklendi");
		}
		return new ErrorResult(result.getMessage());
	}
private Result isNull(Candidate candidate) {
	if(Objects.isNull(candidate.getBirthYear()) || 
			Objects.isNull(candidate.getFirstName()) || 
			Objects.isNull(candidate.getLastName()) ||
			Objects.isNull(candidate.getNationalId())
			) {
		return new ErrorResult("All fields not be empty!");		
	}
	return new SuccessResult();
}
private Result isCandidateExist(Candidate candidate) {
	
	if(candidateDao.findByEmail(candidate.getEmail()) == null && candidateDao.findByNationalId(candidate.getNationalId()) == null) {
		return new SuccessResult();
	}
	return new ErrorResult("Email or National Identitiy already exist");
}

private Result isPasswordValid(Candidate candidate,String password) {
	
	String pass = candidate.getPassword();
	if(pass.equals(password)) {
		return new SuccessResult();
	}
	return new ErrorResult("Passwords is not match");
}
}   
