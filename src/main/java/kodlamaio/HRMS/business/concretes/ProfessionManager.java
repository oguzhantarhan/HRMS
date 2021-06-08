package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ProfessionService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ProfessionDao;
import kodlamaio.HRMS.entities.concretes.Profession;

@Service
public class ProfessionManager implements ProfessionService{
	ProfessionDao professionDao;
	@Autowired
	public ProfessionManager(ProfessionDao professionDao) {
		super();
		this.professionDao = professionDao;
	}
	@Override
	public DataResult<List<Profession>> getAll() {
		return new SuccessDataResult<List<Profession>>(this.professionDao.findAll());
	}
	public Result add(Profession profession) {
		this.professionDao.save(profession);
		return new SuccessResult("Profession added");
	}
}