package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisementDto>> getAllByActive();
	DataResult<List<JobAdvertisementDto>> getAllByActiveOrderByDate();
	DataResult<List<JobAdvertisementDto>> getAllActiveByEmployer(int employerId);
	
	Result passiveAdvertisement(int advertisementId);
	Result add(JobAdvertisement advertisement);
}
