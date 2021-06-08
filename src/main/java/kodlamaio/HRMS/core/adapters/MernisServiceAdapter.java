package kodlamaio.HRMS.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisServiceAdapter implements CheckMernisService{

	@Override
	public Result checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean serviceResult=true;
		
		try {
			
			serviceResult = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalId()),
					candidate.getFirstName().toUpperCase(),
					candidate.getLastName().toUpperCase(),
					candidate.getBirthYear());
			
		} catch (Exception e) {
			
			serviceResult=false;
		}
		
		if(serviceResult) {
			return new SuccessResult("Valid Person");
		}else {
			return new ErrorResult("Not a valid person");
		}
		
	}

}

