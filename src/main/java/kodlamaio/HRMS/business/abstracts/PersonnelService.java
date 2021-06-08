package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Personnel;

public interface PersonnelService {
public DataResult<List<Personnel>> getAll();
public Result add(Personnel personnel,String password);
}
