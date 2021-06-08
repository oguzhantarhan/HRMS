package kodlamaio.HRMS.core.utilities.VerificationHelper;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationCodeSenderManager implements VerificationCodeSenderService {
	@Override
	public String sendVerificationCode(String email) {
		UUID uuid = UUID.randomUUID();
		String code = uuid.toString();
			System.out.println(email + " Verification code sent. Verification code: " + code);
		return code;
	}
}
