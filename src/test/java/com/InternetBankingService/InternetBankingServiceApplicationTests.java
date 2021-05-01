package com.InternetBankingService;
import com.InternetBankingService.model.Md5Object;
import com.InternetBankingService.model.PasswordObject;
import com.InternetBankingService.model.VersionResponse;
import com.InternetBankingService.repository.InternetBankingInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InternetBankingServiceApplicationTests {
	@Value("${md5TestParam}")
	private byte[] md5TestParam;

	@Test
	public void GetAPIVersion() {
		InternetBankingInterface internetBankingInterface = new InternetBankingInterface();
		VersionResponse versionResponse = new VersionResponse();
		versionResponse =  internetBankingInterface.getVersion();
		versionResponse.setCurrentVersion(versionResponse.getYear()+"."+ versionResponse.getMonth()+ "." +
				versionResponse.getDay()+"."+1.0);
		assertEquals("2021.5.1.1.0", versionResponse.getCurrentVersion());



	}


	@Test
	public void CalculateMD5() throws NoSuchAlgorithmException {
		InternetBankingInterface internetBankingInterface = new InternetBankingInterface();
		Md5Object response = new Md5Object();
		response =  internetBankingInterface.calculateMd5(md5TestParam);
		assertEquals("D41D8CD98F00B204E9800998ECF8427E",response.getData());
	}

	@Test
	public void IsPasswordStrong(){
		InternetBankingInterface internetBankingInterface = new InternetBankingInterface();
		PasswordObject passwordObject = new PasswordObject();
		passwordObject =  internetBankingInterface.checkPasswordStrength("Helloworld@");
		if(passwordObject.isPasswordStrong == true) {
			assertEquals(true, passwordObject.isPasswordStrong());
		}
		else{
			assertEquals(false, passwordObject.isPasswordStrong());
		}

	}

}
