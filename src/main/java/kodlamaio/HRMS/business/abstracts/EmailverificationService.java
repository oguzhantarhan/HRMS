package kodlamaio.HRMS.business.abstracts;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.EmailVerification;

public interface EmailverificationService {

	Result add(EmailVerification emailVerification);

	Result isVerificated(String email);

	DataResult<EmailVerification> getById(int id);

}
