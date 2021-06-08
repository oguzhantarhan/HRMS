package kodlamaio.HRMS.core.adapters;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;


public interface CheckMernisService {
	Result checkIfRealPerson(Candidate candidate);

}
