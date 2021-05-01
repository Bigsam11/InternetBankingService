package com.InternetBankingService.repository;

import com.InternetBankingService.model.Md5Object;
import com.InternetBankingService.model.PasswordObject;
import com.InternetBankingService.model.VersionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;


@Repository
public class InternetBankingInterface {

    @Value("${version}")
    private String version;

    @PostConstruct
    public VersionResponse getVersion(){

        LocalDate getdate = LocalDate.now();
        VersionResponse response = new VersionResponse();
        response.setDay(getdate.getDayOfMonth());
        response.setMonth(getdate.getMonthValue());
        response.setYear(getdate.getYear());
        response.setCurrentVersion(""+response.getYear()+'.'+ response.getMonth()+'.'+response.getDay()+'.'+version);
        return response;

    }

    public Md5Object calculateMd5(byte[] hexString) throws NoSuchAlgorithmException {

        Md5Object md5Object = new Md5Object();
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        hexString = messageDigest.digest();
        md5Object.setHexString(hexString);
        md5Object.data = DatatypeConverter.printHexBinary(md5Object.hexString);

        return md5Object;
    }

    public PasswordObject checkPasswordStrength(String password){

        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        PasswordObject passwordObject = new PasswordObject();
        passwordObject.setPassword(password);

        if(password.matches(pattern) == true){
            passwordObject.isPasswordStrong = true;
        }
        else {
            passwordObject.isPasswordStrong = false;
        }
        return passwordObject;


    }

}
