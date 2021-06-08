package kodlamaio.HRMS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CandidateService;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Candidate;


@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;
	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}
	@GetMapping("/getall")
	public Result getAll() {
		return candidateService.getAll();
	}
	@PostMapping("/register")
	public Result register(@RequestBody Candidate candidate,String passwordConfirm) {
		return candidateService.add(candidate, passwordConfirm);

}
}
