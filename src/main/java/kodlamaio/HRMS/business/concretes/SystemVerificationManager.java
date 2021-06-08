package kodlamaio.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.SystemVerificationService;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SystemVerificationDao;
@Service
public class SystemVerificationManager implements SystemVerificationService {
private SystemVerificationDao systemVerificationDao;
@Autowired
	public SystemVerificationManager(SystemVerificationDao systemVerificationDao) {
	super();
	this.systemVerificationDao = systemVerificationDao;
}
	@Override
	public Result isVerificated(String email) {
		if(systemVerificationDao.findByEmailAndIsVerificated(email, true)!=null) {
			return new SuccessResult();
		}
		return new ErrorResult("");
	}

}
