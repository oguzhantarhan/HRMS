package kodlamaio.HRMS.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.PersonnelService;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Personnel;

@RestController
@RequestMapping("/api/personnel")
public class PersonnelController {
PersonnelService personnelService;
@Autowired
public PersonnelController(PersonnelService personnelService) {
	super();
	this.personnelService = personnelService;
}

@GetMapping("/getall")
public Result getAll() {
	return personnelService.getAll();
}

@PostMapping("/register")
public Result register(@RequestBody Personnel personnel,String passwordConfirm) {
	return personnelService.add(personnel, passwordConfirm);
}
}
