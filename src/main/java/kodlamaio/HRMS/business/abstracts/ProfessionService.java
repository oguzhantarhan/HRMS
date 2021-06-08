package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Profession;

public interface ProfessionService {
	DataResult<List<Profession>> getAll();
	public Result add(Profession profession);
}
