package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;

public interface CandidateService {
public DataResult<List<Candidate>> getAll();
public Result add(Candidate candidate,String password);
}
