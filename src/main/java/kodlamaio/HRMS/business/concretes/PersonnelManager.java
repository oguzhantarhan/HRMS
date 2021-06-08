package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.PersonnelService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.PersonnelDao;
import kodlamaio.HRMS.entities.concretes.Personnel;
@Service
public class PersonnelManager implements PersonnelService {
private PersonnelDao personnelDao;
@Autowired
	public PersonnelManager(PersonnelDao personnelDao) {
	super();
	this.personnelDao = personnelDao;
}

	@Override
	public DataResult<List<Personnel>> getAll() {
		
		return new SuccessDataResult<List<Personnel>>(personnelDao.findAll(),"all personnels listed");
	}

	@Override
	public Result add(Personnel personnel,String password) {
		personnelDao.save(personnel);
		return new SuccessResult(personnel.getFirstName()+" added");
	}

}
