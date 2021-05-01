package com.InternetBankingService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIRequest {


    public  String password;
    public  String hexParam;
    public Date currentDate;

}
