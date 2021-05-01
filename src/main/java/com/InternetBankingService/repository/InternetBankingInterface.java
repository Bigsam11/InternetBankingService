package com.InternetBankingService.repository;

import com.InternetBankingService.model.APIResponse;
import com.InternetBankingService.model.VersionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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

}
