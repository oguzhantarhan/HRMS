package kodlamaio.HRMS.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ProfessionService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.Profession;

@RestController
@RequestMapping("/api/professions")
public class ProfessionsController {
	private ProfessionService professionService;
	@Autowired
	public ProfessionsController(ProfessionService professionService) {
		super();
		this.professionService = professionService;
	}
	@GetMapping("/getall")
	public DataResult<List<Profession>> getAll(){
		return this.professionService.getAll();
	}

}
