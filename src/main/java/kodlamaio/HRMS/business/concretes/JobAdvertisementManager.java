package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.dtos.JobAdvertisementDto;
@Service
public class JobAdvertisementManager implements JobAdvertisementService{
private JobAdvertisementDao jobAdvertisementDao;
@Autowired
public JobAdvertisementManager(kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao jobAdvertisementDao) {
	super();
	this.jobAdvertisementDao = jobAdvertisementDao;
}
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"data listed");
	}

	@Override
	public Result add(JobAdvertisement advertisement) {
		this.jobAdvertisementDao.save(advertisement);
		return new SuccessResult("data added to db");
	}
	@Override
	public DataResult<List<JobAdvertisementDto>> getAllByActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getAllActive());
	}
	@Override
	public DataResult<List<JobAdvertisementDto>> getAllByActiveOrderByDate() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByAndSort(Sort.by("adsPublishDate")));
	}
	@Override
	public DataResult<List<JobAdvertisementDto>> getAllActiveByEmployer(int employerId) {
		List<JobAdvertisementDto> jobAdvertisement=this.jobAdvertisementDao.getAllActiveByEmployer(employerId);
		if (jobAdvertisement.size()==0) {
			return new ErrorDataResult<List<JobAdvertisementDto>>("employer, id="+employerId+" doesnt exist");
		}
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(jobAdvertisement);
	}
	@Override
	public Result passiveAdvertisement(int advertisementId) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementDao.getById(advertisementId);
		jobAdvertisement.setActive(false);
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("advertisement made passive");
	}

	

}
