package kodlamaio.HRMS.core.utilities.businessHelper;

import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;

public class BusinessRules {
	public static Result run(Result... results) {
		String errorMessage = "";
		int flag = 0;
		for(Result result: results) {
			
			if(!result.isSuccess()) {
				flag +=1;
				errorMessage = errorMessage + result.getMessage() + " * ";
			}
		}
		if(flag == 0) {
			return new SuccessResult("methot worked");
		}else {
			return new ErrorResult(errorMessage);
		}
	}
}
