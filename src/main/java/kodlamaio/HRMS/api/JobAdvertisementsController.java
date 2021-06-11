package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	@Autowired
public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
@GetMapping("getallbyactive")
public DataResult<?> getAllByActive() {
	return jobAdvertisementService.getAllByActive();
}
@GetMapping("getallbyactiveorderbydate")
public DataResult<?> getAllByActiveOrderByDate() {
	return jobAdvertisementService.getAllByActiveOrderByDate();
	}
@GetMapping("getallbyactiveandemployer")
public DataResult<?> getAllByActiveAndEmployer(int employerId) {
	return jobAdvertisementService.getAllActiveByEmployer(employerId);
	}
@PostMapping("passiveads")
public Result passiveAdvertisement(@RequestParam int advertisementId) {
	return jobAdvertisementService.passiveAdvertisement(advertisementId);
}
@PostMapping("add")
public Result addAdvertisement(@RequestParam JobAdvertisement advertisement) {
	return jobAdvertisementService.add(advertisement);
}
}
